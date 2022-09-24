package Ficheros_Texto;

import java.io.*;

import java.util.Scanner;
/**
 * Vamos a leer el fichero caracter a caracter , Mientras no alcancemos 
 * el final iremos mostrando y leyendo
 * 
 * 
 */

public class Solicita_Nombre_01 {

	public static void main(String[] args) throws IOException {
		
		Scanner ent = new Scanner(System.in);
		final String Por_defecto = "prueba.txt"; //Constante con el fichero por defecto
		
		System.out.println("Escriba el nombre del fichero (por defecto prueba.txt): ");
		String NombreFichero = ent.nextLine();
		
		if(NombreFichero.isEmpty()) {//Si esl nombre esta vacio
			NombreFichero = Por_defecto;
		}
		
		try {
			BufferedReader f = new BufferedReader(new FileReader(NombreFichero));
			
			int c = f.read(); //Leemos un caracter
			while( c != -1) { // Mientras no lleguemos al final del fichero
				System.out.println((char)c); //Muestra
				c = f.read();
				
			}
			f.close();//Una vez utilizado el fichero lo cerramos
			
		}catch(EOFException eof) {
			System.out.println("Fichero no se pudo abrir ");
		}
		
		
		
		

	}

}
