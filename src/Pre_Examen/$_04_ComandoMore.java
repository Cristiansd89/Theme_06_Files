package Pre_Examen;

import java.io.*;
import java.util.Scanner;


public class $_04_ComandoMore {
	
	/***
	 * Comamdo more, al que se le pasa  un fichero y lo muestra poco a poco : cada 24 lineas.
	 * @param args
	 */

	public static void main(String[] args)
	{
		
			Scanner ent = new Scanner(System.in);
		try {
			//Comprobamos que los argumentos estan introducidos
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				
				File archivo = new File(args[0]);
				//si el archivo no existe lanzara una excepcion
				if (!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					leer_More(args);
				}
			}
		}catch(ErrorNumeroArgumentos e){
			System.out.println("Faltan Argumentos");
		}catch(FileNotFoundException e1) {
			System.out.println("No existe el archivo :");
		}
		System.out.println("");
		System.out.println("----Fin del Archivo----");
	}
	/*
	 * Metodo de lectura este metodo leera cada 24 lineas
	 */
	public static void leer_More(String args []) 
	{
		Scanner ent = new Scanner(System.in);
		final int parar_Cada = 10; //numero de lineas en la que hace la pausa
		int contador = 0 ; //contador de lineas mostradas
		
		BufferedReader Recu_archivo = null;
		try {
			Recu_archivo = new BufferedReader(new FileReader(args[0]));
			String linea = Recu_archivo.readLine();
			
			while (linea != null) {
				System.out.println(linea);
				contador++; ///Incrementamos el contador 
				if(contador == parar_Cada) 
				{
					System.out.println();
					System.out.println(" Pulse Intro....");
					ent.nextLine();
					
					System.out.println();
					contador = 0;//Volvemos a iniciar el contador
				}
				linea = Recu_archivo.readLine();
			}
			Recu_archivo.close();
			
			
	
		}catch(Exception e) {
			System.out.println(" no se pudo abrir el archivo");
		
		}
	}

	}

class ErrorNumeroArgumentos extends Exception

{
	public ErrorNumeroArgumentos() {
		super();
	}
}

