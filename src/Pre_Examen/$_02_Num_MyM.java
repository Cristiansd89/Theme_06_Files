package Pre_Examen;

import java.io.*;
import java.util.*;

/**
 * En el archivo Numeros.txt dismonemos de una serie denumero (uno por cada linea).
 * Diseña un programa que cosece el fichero y nos muestre el menor y el mayor introducido
 * @author cristian
 *
 */

public class $_02_Num_MyM {

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		String resp = "si";
			try {
				//Comprobamos que el numero de argumentos es correcto si no el programa 
				//Lanzara una execepcion
				if(args.length < 1) {
				
					throw new ErrorNumeroArgumentos();
					
				}else {
					File Archivo = new File (args[0]);
					if (Archivo.exists()) {
						System.out.println("Quieres Sobre escribir el  archivo : Si/ no");
						resp = ent.nextLine();
					}
					if(resp.equalsIgnoreCase("si")) {
						escribir_Numeros(args);
						Leer_Numero(args);
					}
				}
				
			}catch(ErrorNumeroArgumentos e) {
				System.out.println("Faltan Argumentos ");
			}
			System.out.println(" ");
			System.out.println(" Fin del programa");
	}
	/**
	 * Este metodo va escribir en un archivo Binario los numeros que vallamos introduciendo
	 * hasta que introduzcamo un -99
	 * @param args
	 */
	public static void escribir_Numeros(String[] args) {
		Scanner ent = new Scanner(System.in);
		boolean salir = false;
		/*
		 * Abrimos flujo deescritura del archivo Binario
		 */
		ObjectOutputStream escArchi = null;
		
		int num;
		try {
			
			/*
			 * Pasamo la posicion del Array donde esta el nombre del archivo
			 */
			escArchi = new ObjectOutputStream(new FileOutputStream(args[0]));
			
			System.out.println("Numeros :");
			num = ent.nextInt();
			while (num > 0) 
			{
				if(num > 0) {
					escArchi.writeInt(num);
				}
					System.out.println("Numero :");
					num = ent.nextInt();
			}
				
			
			escArchi.close();
			
		}catch(IOException e) {
			System.out.println("Error en el flujo de escritura");
		}
	}
	
	public static void Leer_Numero(String[] args) {
	
		
		try {
			
			ObjectInputStream Recu_archivo = new  ObjectInputStream(new FileInputStream(args[0]));
			int num =0;
			int max,min;
			max = num;
			min = num;

			num =Recu_archivo.readInt();
			
			while(num != -1) 
			{
				if(num > max) {
					max = num;
				}
				if(min < max) {
					min = num;
				}
				num =Recu_archivo.readInt();
			}
			
			System.out.println("Mayor : " +max);
			System.out.println("Menor : " +min);
			Recu_archivo.close();
		}catch(IOException e) 
		{
			System.out.println("No se ha podido abrir el archivo");
		}
		
	}
}

class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos() 
	{
		super();
	
	}
}
