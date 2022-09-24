package Ficheros_Texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploLectura_02 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		
		String texto = " ";
		String nombre;
		System.out.println("Nombre del archivo : ");
		nombre = ent.nextLine();
		
		
		try {
			BufferedReader leer = new BufferedReader(new FileReader(nombre));
			
			String linea = leer.readLine();
			
			while (linea != null) {
				
				texto = texto + linea +"\n";
				linea = leer.readLine();
			}
			leer.close();
		}catch(IOException fallo) {
			System.out.println("No se pudo abrir el Archivo ");
			System.out.println(" ");
			System.out.println(fallo.getMessage());
			
		}
		System.out.println(texto);
		

	}

}
