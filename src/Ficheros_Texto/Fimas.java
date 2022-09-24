package Ficheros_Texto;


import java.io.*;
import java.util.*;


public class Fimas {

	public static void main(String[] args) 
	{

		Scanner ent = new Scanner (System.in);
		
		System.out.println("1. Mostrar el libro de firmas");
		System.out.println("2. Añadir nombre ");
		
		System.out.println("Que desea hacer ");
		int opcion = ent.nextInt();
		
		ent.nextLine();//Para limpiar el buffer
		
		
		switch(opcion) {
			case 1:
				muestraFicheroFirmas();
				break;
				
			case 2:
				System.out.println("Introduzca el nombre que desea insertar : ");
				String nombre = ent.nextLine();
				insertarNuevaFirma(); //Va insertar el nombre si no esta repetido
		}
	}
	
	private static void insertarNuevaFirma() {
		// TODO Auto-generated method stub
		
	}

	public static void muestraFicheroFirmas(){
		
		try{
			BufferedReader Archivo = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Textos/numeros.txt"));
			String linea = Archivo.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = Archivo.readLine();
			}
			Archivo.close();
			
		}catch(IOException Error) {
			System.out.println("No se pudo abrir el Archivo ");
			
		}
		/**
		 * Falta el siguiente metodo Ejercicio 10.6 
		 */
	}

}
