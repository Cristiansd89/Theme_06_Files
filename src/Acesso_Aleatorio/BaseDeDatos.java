package Acesso_Aleatorio;


import java.io.*;

public class BaseDeDatos {
	private File fichero;
	private RandomAccessFile flujo;
	private int numRegistros;
	private long tamRegistro = 60;
	
	public BaseDeDatos(File fichero) 
	{
		this.fichero = fichero;
		try 
		{
			flujo = new RandomAccessFile(fichero, "rw");
			long numBytes = flujo.length();
			numRegistros =(int)Math.ceil((double)numBytes/(double)tamRegistro);
		}catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	////////////////////////////////////////////////////////////
	public  Registro leerRegistro(int posicion)
	{
		if (posicion >= 0 && posicion < numRegistros) 
		{
			try
			{
				//Nos situamos en la posicion
				flujo.seek(posicion*60);
				//leer
				return new Registro(flujo.readUTF(), flujo.readUTF(), flujo.readDouble());
			}catch(IOException e) {
				System.out.println(e.getMessage());
				return null;
			}
			
		}
		return null;
	}///////////////////////////////////////////////////////////////////
	
	public  boolean escribirRegistro(int posicion, Registro registro) {
		if(posicion >=0 && posicion == numRegistros) {
			try {
				flujo.seek(posicion*60);
				flujo.writeUTF(registro.getCod_Producto());
				flujo.writeUTF(registro.getDesc_Producto());
				flujo.writeDouble(registro.getPrecio());
				return true;
				
			}catch(IOException e) {
				System.out.println(e.getMessage());
				return false;
			}	
		}
		return false;
	}
	
	////////////////////////////////////////////////////
	public boolean anadir(Registro registro) 
	{
		if(escribirRegistro(numRegistros, registro)) 
		{
			numRegistros++;
			return true;
		}
		return false;
	}
	////////////////////////////////////////
	public void cerrarFlujo() {
		try {
			if(flujo != null) {
				flujo.close();
			}
			
		}catch(IOException error) {
			System.out.println(error.getMessage());
		}

	}
	////////////////////////////////////////////////////////
	public boolean basesDedatosVacio(){
		return(numRegistros ==0);
		}
	
	
	/////////////////////////////////////////////////////
	
	
	public int Busqueda(String buscar) 
	{
		for(int i = 0; i< numRegistros;i++)
		{
			Registro registro = leerRegistro(i);
			if(buscar.equals(registro.getCod_Producto())) {
				return i;
			}
				
		}
		return -1;
	}
	public boolean marcar (int posicion) {
		Registro registro = leerRegistro(posicion);
		registro.setCod_Producto("borrado");
		if(escribirRegistro(posicion, registro)) 
		{
			
			return true;
		}
		return false;
		
	}
	public void actualizar() {
		File ficheroAux =new File("Actualizado");//Fichero auxiliar 
		BaseDeDatos bdAux = new BaseDeDatos(ficheroAux); //Base de datos auxiliar para copiar info
		
		for(int i =0;i<numRegistros;i++) {
			Registro registro = leerRegistro(i);
			if(!registro.getCod_Producto().equals("borrado")) {
				bdAux.anadir(registro);
			}
		}
		bdAux.cerrarFlujo();
		cerrarFlujo();
		fichero.delete();
		ficheroAux.renameTo(fichero);
		
		
		
	}
	
	
	
}






