package Acceso_Secuencial_02;

import java.io.*;
import java.util.*;

public class $_01_PropiedadesFichero {

	public static void main(String[] args) 
	{
		//Comprobamos si el numero de argumentos es correcto.
		
		try {
			if(args.length ==0) {
				throw new ErrorNumeroArgumentos();
			}
			else 
			{	
				for(int i = 0; i <args.length; i++) 
				{
					File fichero = new File(args[i]);
					
					if(fichero.exists()) 
					{
						propiedades(fichero);
						
					}else {
						throw new FileNotFoundException();
					}
				}
			}
		}catch(ErrorNumeroArgumentos error) {
			System.err.println("Faltan argumentos");
			System.err.println("Sintaxis :");
			System.err.println("java PropiedadesFichero nomFich1... nomFichx ");
		}
		catch(FileNotFoundException error) {
			System.out.println("El fichero no existe");
		}

	}
	
	private static void propiedades (File fichero) 
	{
		System.out.println("--------------------------------");
		//Comprobamos si es un fichero ordinario
		if(fichero.isFile()) {
			System.out.println("Es un fichero ordinario, " +"con nombre : " +fichero.getName());
			
			
			if(fichero.canExecute()) {
				System.out.println("El fichero se pude ejecuta");
				
			}else {
				System.out.println("El fichero no se puede Ejecutar");
			}
			if(fichero.canRead()) {
				System.out.println("El fichero se puede leer");
			}else {
				System.out.println("El fichero no puede leer");
			}
			if(fichero.canWrite()) {
				System.out.println("El fichero se puede escribir");
			}else {
				System.out.println("El fichero no se puede escribir");
			}
		}else if (fichero.isDirectory())
		{
			System.out.println("Es un directorio ");
			String nombreDirectorio[] = fichero.list();
			System.out.println("Ficheros dentro del directorio : " +fichero.getName());
			
			for(int i =0; i< nombreDirectorio.length; i++) 
			{
				
				System.out.println(i + " : " +nombreDirectorio[i]);
			}
		}
	}
}
 class ErrorNumeroArgumentos extends Exception
{
	public ErrorNumeroArgumentos() {
		super();
	}
}
