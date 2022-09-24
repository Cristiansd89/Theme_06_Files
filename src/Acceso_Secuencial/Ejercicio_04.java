package Acceso_Secuencial;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;




public class Ejercicio_04 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		FileWriter ficheroSobrescrito;
		String opcion = "si";
		
		try 
		{
			if(args.length != 1)
			{
				throw new ErrorArgumentos();
			
			}else {
				File nombreFichero = new File(args [0]);
			}
			
			
		} catch(ErrorArgumentos errorArgumentos) {
			System.err.println("Error en el numero de argumentos");
			System.err.println("Systaxis del comando : java CrearFichero nombre");
		}
		
		

	}
	
	
	}
class ErrorArgumentos extends Exception{
	public ErrorArgumentos() {
		super();
	}

}
