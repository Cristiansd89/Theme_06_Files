package Ficheros_Texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjemploLectura_03 {

	public static void main(String[] args) {
		Scanner ent = new  Scanner(System.in);
		String NombreArchivo;
		
		System.out.println("Introduce Nombre : ");
		NombreArchivo = ent.nextLine();
		
		
		System.out.println("Introduce un nombre: ");
		String nombre = ent.nextLine();
		
		System.out.println("Introduce edad :");
		int edad = ent.nextInt();
		
		try {
			BufferedWriter Archivo = new BufferedWriter(new FileWriter(NombreArchivo));
			
			Archivo.write(nombre);
			Archivo.newLine();
			Archivo.write(edad);
			
			
			Archivo.close();
			
			
		}catch(IOException fallo) {
			System.out.println("No se pudo crear el archivo :");
		}
		

	}

}
