 package Acesso_Aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAlea {
	
	private static RandomAccessFile flujo; 
	private static  int numeroRegistros ;
	private static int tamañoRegistros = 80;
	
	public static void main(String[] args) {
		

	}
	
	public static void CrearArchivosPersona(File archivo) {
		
		try {
			if(archivo.exists()) {
				flujo = new RandomAccessFile(archivo, "rw");//Utilizamos RamdomAcces para crear una puerta hacia el archivo
				numeroRegistros = (int)Math.ceil((double) flujo.length() /(double)tamañoRegistros);
				/* --Math.ceil redondea el double hacia el entero mas proximo
				 * flujo.length nos devuelve la longitud en bytes del archivo si lo dividimos  por el tamaño del registro
				 * sabremos cuantos registros hay 
				 */
				
				
			}
		}catch(IOException err) {
			System.out.println("Error en el flujo de datos ");
		}
		
	}
	public static void Cerrar() {
		try {
			flujo.close();
		}catch(IOException err) {
			System.out.println("Error al cerrar el flujo");
		}
		
		
	}/**
	El metodo Escribir persona  recibe la la posicion(la ultima posicion) y el objeto tipo persona
	que debe añadir
	**/
	public static boolean EscribirPersona(int posicion, Persona persona) 
	{
		try {/*
		comprobamos que la poscion en la que queremos escribir  esta dento del tamaño 
		de la base de datos
		con seek posicionamos donde queremos crear el objeto tipo persona
		*/
			if (posicion >= 0 && posicion <=numeroRegistros) 
			{	//Siempre va ser la misma formula par posicionarse
				flujo.seek(posicion*tamañoRegistros);
				flujo.writeUTF(persona.getNombre());
				flujo.writeInt(persona.getEdad());
				return true;
			}else {
				System.out.println("El numero del registro esta fuera de los limites");
			}
			
		}catch(IOException err) {
			
		}
		return false;
	}
	public static void AñadirPersona(Persona persona) {
		/*
		 * con este metodo añadimos una nueva persona y  aumentamos el numero de registros
		 */
		if(EscribirPersona(numeroRegistros, persona)) {
			numeroRegistros++;
		}
	}
	/**
	 * Este metodo va devolver el numero de registros
	 * @return
	 */
	public static int numeroRegitros() {
		return numeroRegistros;
	}
	
	public static Persona mostrarPersona(int posicion) {
		try {
			if(posicion >= 0 && posicion <= numeroRegistros)
			{
				flujo.seek(posicion *tamañoRegistros);
				return new Persona(flujo.readUTF(), flujo.readInt());
			}
		}catch(IOException err) {
			System.out.println("Error en el flujo de datos");
		}
		//Si estuviera fuera de los limites retornaria null
		return null;
	}

}
