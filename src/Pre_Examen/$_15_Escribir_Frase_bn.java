package Pre_Examen;


import java.util.*;
import java.io.*;

/**
 * Metodo para escribir  por teclado una frase y guardarla en un archivo binario.
 * A continuacion recuperarla en del archivo y mostrarla por pantalla
 * @author cristian
 *
 */
public class $_15_Escribir_Frase_bn {

	public static void main(String[] args) {
		Scanner ent =new  Scanner(System.in);
		String resp = "si";
		//Comprobando el numero de argumentos
		try {
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File archivo = new File(args[0]);
				if(archivo.exists()) {
					System.out.println("quieres Sobre escribirlo :");
					resp = ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					Escribir_Frase(args);
					leer_Frase(args);
				}else {
					System.out.println("Fin del programa ");
				}
			}
			}catch(ErrorNumeroArgumentos err) {
				System.out.println("faltan argumentos");
			}
		
		}
	
	/**
	 * Metodo para pedir e introducir la frase en el fichero binario
	 * @param args
	 */
	public static void Escribir_Frase(String[] args) 
	{
		
		ObjectOutputStream archivo = null;
		Scanner ent =new  Scanner(System.in);
		
		try 
		{
			System.out.println("Introduce una frase :");
			String frase = ent.nextLine();
			archivo = new ObjectOutputStream(new FileOutputStream(args[0]));
			archivo.writeObject(frase);
			
			archivo.close();
			
		}catch(IOException e) 
		{
			System.out.println("Erro en el flujo de datos ");
			
		}
			
	}
	
	/**
	 * Metodo para recuperar el archivo de lectura
	 * @param args
	 */
	public static void leer_Frase(String[] args) 
	{
		
		ObjectInputStream lectura = null;
		
		try {
			//Flujo de lectura
			lectura = new ObjectInputStream(new FileInputStream(args[0]));
			//la funcion va leyendo he introduciendo  los datos en la variable
			String Cont =(String) lectura.readObject();
			System.out.println(Cont);
			
			lectura.close();
			
		}catch(ClassNotFoundException err) {
			System.out.println("No encuentra la clase");	
		}catch(IOException Err2) {
			System.out.println("Error al leer el archivo");	

		}
		
	}
}

class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		
	}
}
