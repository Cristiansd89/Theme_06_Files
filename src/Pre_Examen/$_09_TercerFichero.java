package Pre_Examen;


import java.util.*;
import java.io.*;

public class $_09_TercerFichero {
/**
 * Disponemos de dos ficheros con nombre de personas (ambos ya ordenados).Realiza un programa que lea ambos ficheros 
 * y que cree un tercer ficherocon todos los nombres ordenanos
 * @param args
 */
	public static void main(String[] args) {
		
		/*
		 * Comprobamos si se han introducido todos los argumentos
		 */
		try {
			if(args.length !=2) {
				throw new ErrorNumeroArgumentos();
				
			}else {
				//Comprobacion de existencia del primer archivo
				File archivo = new File(args[0]);
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					//Comprobacion de existencia del segundo archivo
					File archivo2 = new File(args[1]);
					if(!archivo2.exists()) {
						throw new FileNotFoundException();
					}else {
						//Lectura de Metodo
						LeerArchivos(args);	
						
					}			
				}
			}
			
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan Argumentos ");
		}catch(FileNotFoundException e1) {
			System.out.println("El fichero no existe");
		}
		System.out.println("");
		System.out.println("Fin del Programa");
	}
	public static void LeerArchivos(String[] args) 
	{
		try {
			

			BufferedReader Lectura1 = new BufferedReader(new FileReader(args[0]));///Flujo de elctura del primer fichero
			BufferedReader Lectura2 = new BufferedReader(new FileReader(args[1]));//flujo de lectura del segundo fichero
			BufferedWriter Ambos = new BufferedWriter(new FileWriter("Todo.txt"));//Flujo de escritura
			
			
			String Contenido1 = Lectura1.readLine();
			String Contenido2 = Lectura2.readLine();
			
			//Mientras no se llegue alfinal en alguno de los 2 archivos
			//Seguira dentro del bucle
			
			while(Contenido1 != null && Contenido2 != null) 
			{
				//ira comparando que cadena va antes alfabeticamente y lo ira introduciendo
				if(Contenido1.compareToIgnoreCase(Contenido2)< 0){//si Contenido es menor se guarda primero
					Ambos.write(Contenido1);
					Ambos.newLine();
					Contenido1 = Lectura1.readLine();
					
				}else {
					Ambos.write(Contenido2);
					Ambos.newLine();
					Contenido2 = Lectura2.readLine();
				}
			}
			///si el Primer archivo es null habra copiado el primer archivo completamente
			if(Contenido1 == null) {//Faltando copiar el resto del segundo archivo
				while(Contenido2 != null) 
				{
					Ambos.write(Contenido2);
					Ambos.newLine();
					Contenido2 = Lectura2.readLine();
				}
				
			}else 
			{
				while(Contenido1 != null) {//Falta copiar el resto de Lectura1
					Ambos.write(Contenido1);
					Ambos.newLine();
					Contenido1 = Lectura1.readLine();
					
				}
				
			}
			Lectura1.close();//Cerramos Los flujooos
			Lectura2.close();
			Ambos.close();
			
			
		}catch(Exception er) {
			System.out.println("Error al leer el archivo");
		}
	}
}



class ErrorNumeroArgumentos extends  Exception 
{
	public ErrorNumeroArgumentos() {
		super();
	}
}
