package Acceso_Secuencial_02;

import java.io.*;
import java.util.*;


public class $_08_Serializacion {

	public static void main(String[] args) 
	{
		
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		
		System.out.println("Nombre del Archivo :");
		String nombre = ent.nextLine();
		
		File Archivo = new File(nombre);
		if(Archivo.exists()) {
			System.out.println("Quieres Sobrescribir el Archivo");
			resp = ent.nextLine();
			
		}
		if(resp.equalsIgnoreCase("si")) {
			CrearArchivo(nombre);
		}
		System.out.println("Lista de Contactos :");

		LeerObjetos(nombre);
		System.out.println("  ");
		System.out.println(" Fin del programa ");

	}
	public static void CrearArchivo(String nombre){
			Scanner ent = new Scanner(System.in);
			ObjectOutputStream Archivo_Nuevo = null;
		try {
			Archivo_Nuevo = new ObjectOutputStream(new FileOutputStream(nombre));
			String resp = "si";
			
			while(resp.equalsIgnoreCase("si"))
			{
				System.out.println("Nombre :");
				String nombreC = LeerDatos();
				
				System.out.println("Telefono :");
				String Telefono = LeerDatos();
				
				System.out.println("Direccion :");
				String Direccion = LeerDatos();
				
				Contacto contacto = new Contacto(nombreC, Telefono, Direccion);
				
				
				Archivo_Nuevo.writeObject(contacto);
				System.out.println("Quieres Añadir Otro Contacto :");
				resp = ent.nextLine();
			}
			
			Archivo_Nuevo.close();
			
		}catch(IOException err) {
			System.out.println("No se puede Crear el archivo: ");
		}
	}
	
	public static void LeerObjetos(String nombre) 
	{
		
			ObjectInputStream Recu_Archivo = null;
			
		try 
		{
			Recu_Archivo =new ObjectInputStream(new FileInputStream(nombre));
			while(true) {
				Contacto contacto2 = (Contacto) Recu_Archivo.readObject();
				System.out.println(contacto2);
			}
			
		}catch(EOFException err) {
			System.out.println("Has llegado al final de la lista ");		

		}catch(IOException e) {
			System.out.println("No se puede abrir el archivo ");
			}
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	public static String LeerDatos() {
		Scanner ent = new Scanner(System.in);
		String dato = ent.nextLine();
		return dato;
}

}
class ErrorArgumentos extends Exception {
	
	public ErrorArgumentos (){
		super();
		
	}
}
