package Pre_Examen;


import java.io.*;
import java.util.*;

public class $_14_Leer_Tabla {

	public static void main(String[] args) {
		
		ObjectInputStream Leer_Arch =null;
		try {
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
				
			}else {
				File archivo = new File(args[0]);
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					leer_Archivos(args);
				}
			}
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan argumentos ");
		}catch(FileNotFoundException err2) {
			System.err.println("El fichero origen no existe.");		
		}catch(IOException err3) {
			System.out.println("Error en el flujo de datos");
		}

	}
	/*Metodo para Para leeer el fichero binario e introducir los datos en la tabla
	 * @param args
	 */
	public static void leer_Archivos(String[] args)   {
		ObjectInputStream lectura = null;
		
		try {
			lectura = new ObjectInputStream(new FileInputStream(args[0]));
			double tabla[] = (double[]) lectura.readObject();/*
			Este cast indica al compilador la clase de objeto que va ser leido, se arroja una exception
			ClassNotFoundException
			*/
			System.out.println(Arrays.toString(tabla));
			//Con este metodo mostramos el array
			
		}catch(IOException err) {
			System.out.println("Error en el flujo de datos 2");
			
		}catch(ClassNotFoundException err) {
			System.out.println("No encuentra la clase");
		}
		
		
		
			
	}
}

class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos (){
		super();
	}
}
