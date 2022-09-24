package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_03_InsertarFirma 
{

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		/**
		 * En el metodo Main comprobamos que los argumentos son los necesarios
		 */
		try 
		{
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File Archivo = new File(args[0]);
				if(Archivo.exists()) {
					boolean fin = false;
					
					 do{
						Menu(args);
						System.out.println("Quieres continuar si/no");
						String opcion = ent.nextLine();
						if(opcion.equalsIgnoreCase("no")){
							fin = true;
						}
					}while(!fin);
						
				}else {
					System.out.println("Fichero no existe");
				}
			}

		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan Argumentos ");
		}
		System.out.println("Fin del programa");
	}
		/**
		 * Menu para ver que realizar
		 * @return
		 */
	public static void Menu(String[] args) 
	{
		
		Scanner ent = new Scanner (System.in);
		System.out.println(" 1. Mostar libro de firmas ");
		System.out.println("2. Añadir firma");
		int opc = ent.nextInt();
		
		switch (opc) {
			
		case 1 :
			MostrarFirmas(args);
			break;
		case 2:
			InsertaFirma(args);
			break;
		}
		
		
	}
	/**
	 * Metodo para mostrar todas las  firmas
	 * @param args
	 */
	public static void MostrarFirmas(String [] args) 
	{
			BufferedReader Fichero = null;
		try {
			/*
			 * El programa ira Leyendo lineas hasta que sea null
			 */
			Fichero = new BufferedReader(new FileReader(args [0]));
			String Firma = Fichero.readLine();
			while(Firma != null) 
			{
				System.out.println(Firma);
				Firma = Fichero.readLine();
			}
			Fichero.close();
			
		}catch(EOFException e) {
			System.out.println("No se ha podido abrir el Archivo ");
		}catch(FileNotFoundException err) {
			System.out.println("No se encuentra el fichero ");
		}catch(IOException E){
			
		}
	}	
	public static void InsertaFirma(String [] args) 
	{
		/*
		 * Se abre 2 flujo uno de escritura y otro de lectura
		 * llamanos al metodo pedirNombre() para que el programa compruebe si existe ya o no la firma
		 * iremos leyendo el archivo y comprobando linea por linea si  la firma no esta el prorama la introducira
		 */
		BufferedReader NuevaFirma = null;
		BufferedWriter EscribirFirma = null;
		String nuevo = PedirNombre();
		try{
			NuevaFirma = new BufferedReader(new FileReader(args[0]));
			String  nombre = NuevaFirma.readLine();
			boolean encontrado = false;
			/*
			 * Mientras no se llegue al final del archivo y no encuentre el nombre seguira 
			 * dentro del bucle
			 */
			while (nombre != null && encontrado == false) 
			{
				//Comprador de cadenas
				if(nombre.equals(nuevo)) {
					encontrado = true;
				}
				//Lectura Linea-linea
				nombre = NuevaFirma.readLine();
			}
			NuevaFirma.close();
			//SI encontrado es false quiere decir que el programa no ha encontrado el nombre introducido
			//entonce añadira el nobmre
			if(encontrado == false) {//Si el nombre nueov no esta e el fichero 
				 EscribirFirma = new BufferedWriter(new FileWriter(args[0],true));
				 EscribirFirma.newLine();//Insertamos una nueva linea 
				 EscribirFirma.write(nuevo);//insertamos nuevo nombre
				 System.out.println("\nNuevo nombre insertado");
				 EscribirFirma.close();
			}else {
				System.out.println("El nombre ya esta en la lista");
			}
			
			
		}catch(IOException err) 
		{
			System.out.println("Error en el Fichero");
		///Te falta acabar el de las firmas
		}
	}
		//Programa para pedir el nombre
	public static String PedirNombre () 
	{
		
		Scanner ent = new Scanner(System.in);
		System.out.println("Que nombre quieres introducir");
		String nombre =  ent.nextLine();
		return nombre;
	}
		

	
}
class ErrorNumeroArgumentos extends Exception

{
	public ErrorNumeroArgumentos() {
		super();
	}
}
