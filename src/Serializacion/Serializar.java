package Serializacion;


import java.io.*;
import java.util.*;


public class Serializar 
{

	public static void main(String[] args) 
	{
		LeerFichero();
	}
	
	

			
	public static void Crearfichero() {		
			try 
	{
				
				ObjectOutputStream fichero_nuevo = new ObjectOutputStream(new FileOutputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Contacto.jpg"));
				
				{
					fichero_nuevo.writeObject(Pedir_Datos());
				}
				
				fichero_nuevo.close();
				
			}catch(IOException Error){
				System.out.println("No se pudo Crear el ARchivo");
			}
			
	
		}
	
	public static void LeerFichero()
	{
		
		try {
			ObjectInputStream recuperar_fichero = new ObjectInputStream(new FileInputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Contacto.jpg"));
			Contacto Contacto_recu = (Contacto) recuperar_fichero.readObject();
			recuperar_fichero.close();
		
			System.out.println(Contacto_recu);
			
		
	
		}catch(Exception Error) {
			System.out.println("No se pudo abrir el Archivo");
		}
		
	}
	
	public static Contacto Pedir_Datos() 
	{
		Scanner ent = new Scanner(System.in);
		System.out.println("Introduce El nombre del contacto :");
		String nombre = ent.nextLine();
		
		System.out.println("Introduce El nombre del Telefono :");
		String Telefono = ent.nextLine();
	
		System.out.println("Introduce El nombre del Direccion :");
		String Direccion = ent.nextLine();
		
		return new Contacto(nombre, Telefono, Direccion);
		
	}
		
	}
	



