package Pre_Examen;

import java.io.*;
import java.util.Scanner;


/**
 * Copia un fichero original en otro de destino pasando los nombre de los archivos como parametros
 */
public class $_05_CopiarArchivos {

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		boolean copiado = false;
		
		try {
			//Comprueba si existen 2 argumentos
			if(args.length != 2) {
				throw new ErrorNumeroArgumentos();
			}
			else {
				File Origen = new File(args[0]);
				File destino = new File(args[1]);
				//Comprueba si existe el fichero de origen
				if(!Origen.exists()) {
					throw new FileNotFoundException() ;
				}else {
					CopiarArchivo(args);
					copiado = true;
					
					if(copiado) {
						System.out.println("Archivo copiado con existo");
					}else {
						System.out.println("no se ha copiado el archivo");
					}
					
				}
			}
		}catch(ErrorNumeroArgumentos error) {
			System.out.println("Faltan Argumentos :");
		}catch(FileNotFoundException e1) {
			System.out.println();
		}
		System.out.println("Fin del programa");
	}
	public static void CopiarArchivo(String[] args) {
		
		BufferedReader Lectura = null;
		BufferedWriter Escritura = null;
		
		try {
			Lectura = new BufferedReader(new FileReader(args[0]));
			Escritura = new BufferedWriter(new FileWriter("copia de" + args[1]));
			String linea = Lectura.readLine();
			 while (linea != null) {
				 Escritura.write(linea+"\n");
				 linea = Lectura.readLine();
			 }
			 
			 Lectura.close();
			 Escritura.close();
			 
		
		}catch(IOException e) {
			System.out.println("Error al Abrir el archivo :");
		}
	}

}

class ErrorNumeroArgumentos extends Exception

{
	public ErrorNumeroArgumentos() {
		super();
	}
}
