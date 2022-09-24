package Ficheros_Texto;


import java.util.*;
import java.io.*;


public class Copiar_Fichero {

	public static void main(String[] args) 
	{
		String  texto = Solicitar_Texto();
		Crear_Fichero(texto);
		Copiar_fichero();
		Leer_Ficheros();
		
		

	}
	
	
	public static String Solicitar_Texto() 
	{
		Scanner ent = new Scanner(System.in);
		
		System.out.println("introduce un texto :");
		String texto = ent.nextLine();
		
		
		return texto;
	}
	public static void Crear_Fichero(String texto)
	{
		
		try 
		{
			BufferedWriter fichero_nuevo = new BufferedWriter(new FileWriter("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/texto.txt"));
			fichero_nuevo.write(texto);
			fichero_nuevo.close();
			
		}catch(IOException Error) 
		{
			System.out.println("no se pudo abrir el Archivo");
		}
	}
	public static void Copiar_fichero() 
	{
		 try 
		 {
			 BufferedReader Recuperar_fichero = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/texto.txt"));
			 BufferedWriter Copia_Fichero = new BufferedWriter(new FileWriter("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/copia.txt"));
			 int c  = Recuperar_fichero.read();
			 
			 while (c != -1)
			 {
				 Copia_Fichero.write(c);
				 c = Recuperar_fichero.read();
			 }
			 Recuperar_fichero.close();
			 Copia_Fichero.close();
		 }catch(IOException Error) {
			 System.out.println("No se pudo abrir el Archivo");
		 }
			 
				
	}
	public static void Leer_Ficheros() {
		try {
			BufferedReader Fichero_original = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/texto.txt"));
			BufferedReader Fichero_copia = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/copia.txt"));
			
			String Original = Fichero_original.readLine();
			
			String Copia = Fichero_copia.readLine();
			
			Fichero_original.close();
			Fichero_copia.close();
			
			System.out.println(Original);
			System.out.println("-------Copia-----------");
			System.out.println(Copia);
			
			
		}catch(IOException Error) 
		{
			 System.out.println("No se pudo abrir el Archivo");
		}
		
		
	}
	
		
		

}
