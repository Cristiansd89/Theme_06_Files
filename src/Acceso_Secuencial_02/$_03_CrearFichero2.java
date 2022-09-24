package Acceso_Secuencial_02;

import java.io.*;

import java.util.*;

public class $_03_CrearFichero2 
{

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		String respuesta = "si";
		try 
		{
			if(args.length < 1) {
				throw new ErrorArgumentos();
			}else {
				File archivo = new File(args[0]);
				if(archivo.exists()) 
				{
					System.out.println("El archivo ya existe quieres sobrescrirlo : si/no");
					respuesta = ent.nextLine();
					if(respuesta.equalsIgnoreCase("si")) {
						
						File Sobrescribir = new File(args[0]);
						CrearFichero(Sobrescribir);
						
					}else {
						System.out.println("Fin del Programa");
					}
				}else {
					System.out.println("El fichero no existe vas a crear uno nuevo");
					CrearFichero(archivo);
					System.out.println("fin del programa");
				}
			}
		}catch(ErrorArgumentos error) {
			System.out.println("Faltan argumentos :");
		}
	}	
	public static void CrearFichero(File archivo) 
	{
		FileWriter Archivo_nuevo = null;
		String texto = IntroducirTexto();
		
		try {
			
			
			Archivo_nuevo = new FileWriter(archivo);
			for(int i = 0; i < texto.length();i++) {
				Archivo_nuevo.write(texto.charAt(i));
			}
			Archivo_nuevo.close();
			
		
			
		}catch(IOException error) {
			System.out.println("El archivo no se ha creado");
			
		}
	}
	public static String IntroducirTexto() {
		Scanner ent = new Scanner(System.in);
		System.out.println("Introduce un texto: ");
		String texto = ent.nextLine();
		return texto;
	}
	
	
}



class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos() 
	{
		super();
	
	}
	
	public ErrorNumeroArgumentos(String message)
	{
		super(message);
	}
	
}

