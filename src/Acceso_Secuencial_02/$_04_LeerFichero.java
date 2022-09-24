package Acceso_Secuencial_02;


import java.util.*;
import java.io.*;


public class $_04_LeerFichero {

	public static void main(String[] args) {
		
		
		try
		{
			if(args.length < 1) 
			{
				throw new ErrorNumeroArgumentos();
			}else 
			{
				File Archivo = new File(args[0]);
				if(Archivo.exists()) 
				{
					LeerFichero(Archivo);
					//Aqui vamos a introducir el metodo a llamar
						
				}else {
					System.out.println("El archivo no existe ");
				}
			}
		}catch(ErrorNumeroArgumentos Error) {
			System.out.println("Faltan Argumentos ");
		}
	
	}


	public static void LeerFichero(File Archivo)
	{
		FileReader Recuperando_arch = null;
		String texto = " ";
		try {
			Recuperando_arch = new FileReader(Archivo);
			int c = Recuperando_arch.read();
			while (c != -1) {
				texto = texto + (char) c;
				c= Recuperando_arch.read();
			}
			
			System.out.println("El contenido del Archivo es :");
			System.out.println(texto);
			
		}catch(IOException Error) {
			System.out.println("No Se ha podido Leer el Archivo");
	}

	}
}
class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos() {
		super();
	}
}
