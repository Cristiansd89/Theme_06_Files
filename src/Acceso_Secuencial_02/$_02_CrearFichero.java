package Acceso_Secuencial_02;

import java.io.*;
import java.util.*;

public class $_02_CrearFichero {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		FileWriter ficheroSobrescrito;
		String opcion = "si";
		
		try {
			
			if(args.length != 1) {
				throw new ErrorArgumentos();
			}else {
				
				File Archivo = new File(args[0]);
				if(Archivo.exists()) 
				{
					System.out.println("El archivo ya Existe quieres Sobre escribirlo : s/n ");
					opcion = ent.nextLine();
				}
				if(opcion.equalsIgnoreCase("si")) {
					ficheroSobrescrito = new FileWriter(Archivo);
					System.out.println("Introduce el contenido : Pulsa enter y Control D para finalizar ");
					CrearFichero(ficheroSobrescrito);
				}
				System.out.println("Fin de programa :");
			}
			
		}catch(ErrorArgumentos Error) {
			 System.err.println("Error en el numero de argumentos.");
	            System.err.println("Syntaxis del comando: java CrearFicheroTexto nombreFichero");
		}catch(IOException Error) {
			System.out.println(Error);
		}
}

public static void CrearFichero(FileWriter ficheroNuevo)
{	
		
		try {
			char caracter;
			final char eof = (char) -1;
			caracter = (char) System.in.read();
			while (caracter != -1) 
			{
				ficheroNuevo.write(caracter);
				caracter = (char) System.in.read();
			}
			
			
		}catch(IOException Error) {
			
		}finally {
			try {
				if(ficheroNuevo == null) {
					ficheroNuevo.close();
				}
			}catch(IOException error) {
				System.out.println("Error al cerrar el flujo");
			}
		}
		
		
	}
}

class ErrorArgumentos extends Exception
{
	
	public ErrorArgumentos()
	{
		super();
	}
	
	
}
