package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_25_Buscar_Palabra {
	
	
	private static final char Linea_Break = '\n';
	private static Integer Linea = 0;
	private static Integer Columna = 0;
	private static int charArt_index = 0;
	private static char Primer_caracter;
	

	public static void main(String[] args) {
		try {//Comprobacion de argumentos
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				
				File archivo = new File(args[0]);
				//Comprobacion si el fichero existe
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					///Metodo
					Buscar(args);
				}
			}
		}catch(ErrorNumeroArgumentos er1) {
			System.out.println("Faltan Argumentos");
		}catch(FileNotFoundException er2 ) {
			System.out.println("No se encontro el archivo");
		}
		
	}
	//Metodo de Buscar 
	public static void Buscar(String[] args) {
		Scanner ent = new Scanner(System.in);
		BufferedReader archivo = null;
	
		
		try {
			boolean encontrado = false;
			//Flujo de apertura
			 archivo =new BufferedReader(new FileReader(args[0]));
			 System.out.println("Introduce la palabra :");
			 String palabra = ent.nextLine();
			//Lectura
			String leer = " ";
			int i = 0;
			//Hay que introducirlo dentro del  while para que no salte la excepion
			//como valor nulo
			while ((leer = archivo.readLine())!= null && !encontrado) {
				i++;
				//Esta funcion nos va decir si el texto contiene la palabra
				if(leer.equals(palabra)) {
					System.out.println("El fichero Contiene la palabra :" +palabra +  " en  la linea "+i);
					encontrado = true;
				}
				
			}
			if (!encontrado) {
				System.out.println("La palabra no esta en el fichero ");
			}
		}catch(IOException e) {
			System.out.println("Error en el flujo de datos :");
		}
		
	}

}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos () {
		super();
	}
}
