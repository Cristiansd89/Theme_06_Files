package Acceso_Secuencial_02;

import java.util.*;
import java.io.*;

public class $_06_Leer_y_Escribir 
{

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		System.out.println("Introduce nombre de el Archivo :");
		String nombre = ent.nextLine();
		
		File Archivo = new File(nombre);///Objeto de tipo fichero
		if (Archivo.exists()) 
		{///Comprobamos si existe 
			System.out.println("El fichero existe deseas Sobrescribirlo :");
			resp = ent.nextLine();	
		}
		if(resp.equalsIgnoreCase("si")) 
		{
			Escribir_Archivo(nombre);
		}	
				
		System.out.println("\n Esta es tu lista de contactos");
		System.out.println(" ");
		Leer_Fichero(nombre);
		System.out.println(" ");
				
		System.out.println("Fin del programa");
		
	}
	/**
	 * Datos para introcir los datos por teclado
	 * @param Archivo
	 */
	public static void Escribir_Archivo(String nombre)
	{
		Scanner ent = new Scanner (System.in);
		DataOutputStream Archivo_Nuevo = null;
		
		try {
			//Creamos un flujo de escritura hacia el fichero para escribir los datos
			Archivo_Nuevo = new DataOutputStream(new FileOutputStream(nombre));
			String opcion = "si";
			do {
				System.out.println("Nombre :");
				String nombreC = LeerDatos();
				Archivo_Nuevo.writeUTF(nombreC);
				
				System.out.println("Telefono :");
				String telefono = LeerDatos();
				Archivo_Nuevo.writeUTF(telefono);
				
				
				System.out.println("Email :");
				String email = LeerDatos();
				Archivo_Nuevo.writeUTF(email);
				
				
				System.out.println("Quieres introducir otro contacto : si/no");
				opcion = ent.nextLine();
				

			}while(opcion.equalsIgnoreCase("si"));
			
			
			
			Archivo_Nuevo.close();
			
		}catch(IOException err) {
			System.err.println("Error de escritura." + err.getMessage());
		}
	}
	/**
	 * Metodo para leer datos primitivos  del fichero
	 * @param Archivo
	 */
	public static void Leer_Fichero(String nombre)
	{
		DataInputStream Recu_Archivo = null;
		
		try {
			Recu_Archivo = new DataInputStream(new FileInputStream(nombre));
			while(true) {
				System.out.println("Nombre:"+ Recu_Archivo.readUTF());
				System.out.println("Teléfono:"+ Recu_Archivo.readUTF());
				System.out.println("Dirección:"+ Recu_Archivo.readUTF());
				System.out.println(" ");
			 
			}
			
		}catch(EOFException error) {
			System.out.println("Has llegado al final de tu lista de contactos.");
		}catch(IOException e) {
			System.err.println("Error de escritura." + e.getMessage());
		}
		
	}
	/**
	 * Metodo para introducir los datos  por teclado
	 *
	 */
	public static String LeerDatos()
	{
		Scanner ent = new Scanner(System.in);
		String Dato =ent.nextLine();
		return Dato;
	}
}	
	

class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos () 
	{
		super();
	}
}