package Ficheros_Texto;
import java.io.*;

import java.util.Scanner;

public class Guardar_Crear {
	/**
	 * Par  sobressscribir o  crear el fichero, si no existieste, utilizariamos el constructior 
	 * adecuado de fileWriter
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException 
	{
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Escriba su Nombre :");
		String nombre = ent.nextLine();
		
		System.out.println("Edad : ");
		int edad = ent.nextInt();
		
		
		
		try 
		{
			BufferedWriter f = new BufferedWriter(new FileWriter("datos.txt"));
			f.write("Nombre " +nombre); //Escribimos los datos 
			f.newLine(); ///Escribimos en el fichero una nueva linea
			f.write("Edad " +edad);
			
			f.close();
			
			
		}catch(EOFException eof) {
			System.out.println("El fichero no se pudo abrir");
		}
		

	}

}
