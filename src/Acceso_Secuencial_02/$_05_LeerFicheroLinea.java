package Acceso_Secuencial_02;

import java.util.*;
import java.io.*;


public class $_05_LeerFicheroLinea 
{

	public static void main(String[] args) 
	{
		
		try {
			if(args.length < 1) {
				throw new ErrorArgumentos();
			}else {
				File Archivo = new File (args[0]);
				if(Archivo.exists()) {
					LeerFichero(Archivo);
				}else {
					System.out.println("El archivo no existe: ");
				}
				
				
			}
		}catch(ErrorArgumentos error) {
			System.out.println("Faltan Argumentos  ");
		}
	}



	public static void LeerFichero(File Archivo) 
	{
		BufferedReader Recuperacion = null;
		String Texto = " ";
		try 
		{
			Recuperacion = new BufferedReader(new FileReader(Archivo));
			String Linea = Recuperacion.readLine();
			while (Linea != null) {
				Texto = Texto + Linea + "\n";
				Linea = Recuperacion.readLine();
				
				
			}
			Recuperacion.close();
		
		}catch(IOException Error) {
			System.out.println("No se pudo abrir el Archivo :");
		}
	System.out.println(Texto);
	}
	
}
class ErrorArgumentos extends Exception{
	
	public ErrorArgumentos() {
		super();
	}
}
