package Ficheros_Binarios;


import java.io.*;
import java.util.*;

public class Pedir_Double {

	public static void main(String[] args)
	{
		
		double	num = Pedir_double();
		Guardar_numero(num);
		Leer_archivo();
		
		
	}
	
	public static double Pedir_double() {
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Introduce un numero decimal");
		double num= ent.nextDouble();
		return num;
	}
	
	public static void Guardar_numero(double num) {
		try {
			ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("PruebaBinaria2.dat"));
			archivo.writeDouble(num);
			archivo.close();
		}catch(IOException Error) {
			System.out.println("No se pudo crear el archivo");
			
		}finally {
			System.out.println("fin del programa");
			
		}
	}
	public static void Leer_archivo() {
		ObjectInputStream Recuperar_Archivo ;
		try {
			 Recuperar_Archivo = new ObjectInputStream(new FileInputStream("PruebaBinaria2.dat"));
			double numerito = Recuperar_Archivo.readDouble();
			
			System.out.println(numerito);
			Recuperar_Archivo.close();
		}catch(IOException Error) {
			System.out.println("No se pudo ver el archivo");
			System.out.println(Error.getMessage());
		
		
		
	}

	}
}