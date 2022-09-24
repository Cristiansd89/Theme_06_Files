package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_07_ComparaTextos_2 {

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		System.out.println("Nombre del 1º Archivo :");
		String nombre1= ent.nextLine();
		
		
		System.out.println("Nombre del Segundo archivo");
		String nombre2 = ent.nextLine();
	
		
		
		try 
		{
			File archivo = new File(nombre1);
			File archivo2 = new File(nombre2);
			if(archivo.exists()) {
				
				if(archivo2.exists()) {
					LeerArchivos(nombre1, nombre2);
				}else {
					System.out.println("EL Segundo Archivo no existe");
				}
			}else {
				throw new ErrorNumeroArgumentos();
			}
			
			
		}catch(ErrorNumeroArgumentos E) {
			System.out.println("no esta el archivo");
		}

	}
	public static void LeerArchivos(String nombre1,String nombre2) 
	{
		
		
		int contLinea = 1, 
	              contCar = 1; 

	      try 
	      {
	         BufferedReader entr1 = new BufferedReader(new FileReader(nombre1));
	         BufferedReader entr2 = new BufferedReader(new FileReader(nombre2));

	         int c1 = entr1.read(); 
	         int c2 = entr2.read();

	         while (c1 != -1 && c2 != -1 && c1 == c2)
	         { 
	            contCar++; 
	            if ((char) c1 == '\n') 
	            {
	               contLinea++;
	               contCar = 1;   
	            }
	            c1 = entr1.read();
	            c2 = entr2.read();
	         }

	         
	         if (c1 != c2) 
	         { 
	            System.out.println("Distinto:");
	            System.out.println("Línea: " + contLinea);
	            System.out.println("Caracter: " + contCar);
	         } else 
	         {
	            System.out.println("Los ficheros son iguales.");
	         }

	         entr1.close();  
	         entr2.close();
	      } catch (IOException eof) {
	         System.out.println("Error de fichero");
	      }
	}
}
class ErrorNumeroArgumentos extends Exception {
	
	public ErrorNumeroArgumentos(){
		super();
	}
}