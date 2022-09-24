package Pre_Examen;


import java.util.*;
import java.io.*;

public class $_17_Ordenar_numeros {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		try {
			if(args.length<1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File Archivo =new File(args[0]);
				if (Archivo.exists()) {
					System.out.println("quieres sobre escribir el archivo ");
					resp = ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					Escribir_Tabla(args);
					LeerArchivo(args);
				}
				
			}
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan argumentos");
		}
		
	}
	public static void Escribir_Tabla(String[] args) {
		Scanner ent = new Scanner(System.in);
		int tabla [] = new int [10];
		
		ObjectOutputStream Archivo = null;
		try {
			Archivo = new ObjectOutputStream(new FileOutputStream(args[0]));
			for(int i = 0;i < tabla.length; i++) {
				tabla[i] = (int)(Math.random()*100);
				/*
				 * Generamos numeros entero aleatoriamente comprendidos entre 0 y 99 y lo guardamos en una tabla 	
				 */
				}
			Arrays.sort(tabla);//Este metodo se utiliza para ordenar la tabla
			Archivo.writeObject(tabla);//Escribimos en el archivo binario
			Archivo.close();
			
		}catch(IOException Err1) {
			System.out.println("Error en el flujo de datos :");
		}
	}
	public static void LeerArchivo(String[] args) {
		ObjectInputStream LeerArchivo = null;
		try 
		{
			LeerArchivo = new ObjectInputStream(new FileInputStream(args[0]));
			int tabla [] = (int[]) LeerArchivo.readObject();
			
			System.out.println(Arrays.toString(tabla));
			
			LeerArchivo.close();
			
		}catch(ClassNotFoundException err) {
			System.out.println(err.getMessage());
		
		}catch(IOException e) {
			System.out.println("Error en el flujo de datos :");

			
		}
		
	}
	

}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
		
	}
	
}
