package Pre_Examen;


import java.util.*;
import java.io.*;
/**
 * Pedimos nuemros enteros positivos por consla y los guardamos en un fichero binario hasta que 
 * se introduzca un numero negativo.
 * Leer del fichero todos los enteros guardados y mostralos por pantalla
 * @author cristian
 *
 */

public class $_12_NumeroPositivos {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		
		///Comprobacion de que el numero de argumentos es correcto
		try {
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File archivo = new File(args[0]);
				if(archivo.exists()) {
					System.out.println("Quieres sobre escribir el archivo :");
					resp = ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					CrearArchivo(args);
					LeerBinario(args);
				}
			}
			
		}catch(ErrorNumeroArgumentos err) {
			System.out.println("Faltan argumentos ");
		}
	}
	//Metodo crea el archivo  e introduce numeros enteros hasta que introduzcamos un numero negativo
	public static void CrearArchivo(String[] args) {
		
		try {
			//flujo de escritura binario
			ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(args[0]));
			
			System.out.println("introduce un numero : (Numero negativo /para salir)");
			int num = PedirNumero();
			while (num > 0) {
				archivo.writeInt(num);
				num = PedirNumero();
			}
			archivo.close();
			
			
		}catch(IOException err) {
			System.out.println("No se pudo crear el archivo :");
		}
	}
	//Metodo para Leer un fichero Binario
	public static void LeerBinario(String[] args) {
		
		try {
			//Flujo de lectura 
			ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(args[0]));
			//con cada lectura introduce en la variable un numero entero
			int num = lectura.readInt();
			while (num != -1) {
				System.out.println(num);
				num = lectura.readInt();
			}
			lectura.close();
		}catch(IOException err) {
			System.out.println("Error al abrir el archivo :");
			
		}
		
	}
	
	//Metodo que pide un numero
	public static int PedirNumero() {
		Scanner ent = new Scanner(System.in);
		int num = ent.nextInt();
		return num;
	}
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
		
	}
	
}

