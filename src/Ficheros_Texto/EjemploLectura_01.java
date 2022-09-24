package Ficheros_Texto;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class EjemploLectura_01 {

	public static void main(String[] args) throws IOException {
		
		Scanner ent = new Scanner(System.in);
		
		String nombre;
		System.out.println("Introduce el nombre del archivo");
		nombre = ent.nextLine();
	
		String texto = " ";
		try 
		{
			FileReader leer = new FileReader(nombre);// Archivo que queremos abrir
			 // Variable para concatenar
			int c = leer.read(); // Entero leido Caracter a caracter
			while (c != -1){
				texto = texto +(char) c;
				c = leer.read();
			}
			leer.close();
			
			
		}catch(Exception fallo) {
			System.out.println("No se pudo abrir el Archivo");
			System.out.println(" ");
			System.out.println(fallo.getMessage());
		}
		System.out.println(texto);
		

			

	}

}
