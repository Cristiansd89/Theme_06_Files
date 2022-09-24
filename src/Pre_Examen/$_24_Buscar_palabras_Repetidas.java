package Pre_Examen;

import java.util.*;
import java.io.*;

public class $_24_Buscar_palabras_Repetidas {

	public static void main(String[] args) {
			
		try {
			if(args.length != 2) {
				throw new ErrorNumeroArgumentos();
			}else {
				File archivo = new File(args[0]);
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					//Metodo
					String palabras =pedir_Palabra();
				}
			}
		}catch(ErrorNumeroArgumentos er) {
			System.out.println("Faltan argumentos ");
		}catch(FileNotFoundException er2) {
			System.out.println("Archivo no encontrado :");
		}
	}
	public void buscarPalabra(String[] args, String palabra) 
	{
		try {
			BufferedReader archivo = new BufferedReader(new FileReader(args[0]));
			String linealeida;
			int lineastotales =0;
			int totalCoincidencias = 0;
			while((linealeida= archivo.readLine())!= null) {
				//Aumenta el contador de lineas
				lineastotales = lineastotales +1;
			}
			//separamos la linea en un Array
			String[] palabras = linealeida.split(" ");
			
			//Recorremos el Array de palabras
			
			for (int i = 0; i<palabras.length ;i++) {
				if(palabras[i].equals(palabra)) {
					//Aumenta el contador de coincidencias
					totalCoincidencias = totalCoincidencias+1;
					
					System.out.println(linealeida);
					System.out.println("En la linea  " +lineastotales +"Se encontro la palabra" +totalCoincidencias + "veces");
				}
			}
			System.out.println("En total la palabra se encontro "+ palabra + " , "+totalCoincidencias );
		}catch(IOException e) {
			System.out.println("");
		}
	}
	public static String pedir_Palabra() {
		Scanner ent = new Scanner(System.in);
		System.out.println("Que palabras estas Buscando :");
		String palabra = ent.nextLine();
		return palabra;
	}
}

class ErrorNumeroArgumentos extends Exception {
	public ErrorNumeroArgumentos() {
		super();
			
		
	}
}
