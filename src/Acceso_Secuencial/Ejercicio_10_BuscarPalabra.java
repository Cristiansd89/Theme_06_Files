package Acceso_Secuencial;

import java.io.*;
import java.util.*;

public class Ejercicio_10_BuscarPalabra
{

	public static void main(String[] args)///En Args Almacenamos la cantidad de argumentos que tiene el programa
	{
		try {
			if(args.length < 2)
				throw new ErrorNumeroArgumentos();
			else {
				for(int i = 1; i < args.length;i++) {
					File fichero = new File(args[i]);
					if(fichero.exists()) 
					{
						Buscar_palabra(args[0],args[i]);
					}else {
						System.out.println("No Existe el fichero " +args[i]);
					}
			
			
		}catch(ErrorNumeroArgumentos Error) {
			
		}
			
	}
	

	
	public static String Pedir_Palabra() {
		Scanner ent =new Scanner(System.in);
		String Buscar = ent.nextLine();
		return Buscar;
		
	}
	public static void Buscar_palabra(String Buscar) {
		try{
		BufferedReader Archivo = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Textos"));
		Buscar = "";
		String palabra = Archivo.readLine();
		while(palabra != null) 
		{
			palabra = Archivo.readLine();
			if(palabra == '\n') {
				ContLinea++;
			}
			
		}
		
		
		
	}catch(IOException Error) 
	{
		System.out.println("No se pudo abrir el archivo");
		System.out.println(Error.getMessage());
	}
	}
	
	
}

class ErrorNumeroArgumentos extends Exception
	{
		public ErrorNumeroArgumentos() 
		{
			
			super();
		}
	}	

