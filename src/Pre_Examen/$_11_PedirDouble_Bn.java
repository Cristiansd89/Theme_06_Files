package Pre_Examen;


import java.io.*;
import java.util.*;

/**
 *Programa que pide un numero double lo introduce en un fichero binario y posteriormente lo lee
 * @author cristian
 *
 */
public class $_11_PedirDouble_Bn {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		
		try {
			//Comprobamos que el numero de parametros es correcto
			
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				//Comprobamos si el fichero existe en el caso de existir 
				//preguntara si queremos sobreescribir el archivo
				File archivoB = new File(args[0]);
				if(archivoB.exists()) {
					System.out.println("Quieres sobre escribirlo: ");
					resp = ent.nextLine();
				}
				if (resp.equalsIgnoreCase("si")) {
					CrearArchivo(args);
					LeerArchivo(args);
				}
				
			}
		}catch(ErrorNumeroArgumentos err) {
			System.out.println("Faltan argumentos");
		}
		
	}
	//Metodo para crear un archivo Binario
	public static void CrearArchivo(String [] args) {
		
		double num =PedirDouble();
		try {
			//Flujo de apertura 
			ObjectOutputStream archivoNuevo = new ObjectOutputStream(new FileOutputStream(args[0]));
			//funcion que escribe el numero en el fichero binario
			archivoNuevo.writeDouble(num);
			archivoNuevo.close();
			
		}catch(IOException err) {
			System.out.println("Error al Crear el Archivo :");
		}
	}
	//Metodo de lectura archivo binario
	public static void LeerArchivo(String [] args) {
		
		try {
			//apertura del flujo binario
			ObjectInputStream LeerArch = new ObjectInputStream(new FileInputStream(args[0]));
			//introducimos el dato binario en una variable de tipo double para posteriormente 
			//Mostrarlo
			double num = LeerArch.readDouble();
			
			System.out.println("El numero Guardado :" +num);
			
			LeerArch.close();

		}catch(IOException err) {
			System.out.println("Error al leer el archivo");
		}
		
		
	}
	//Metodo que pide el double
	public static double PedirDouble() {
		Scanner ent = new Scanner(System.in);
		System.out.println("Numero decimal :");
		double numero = ent.nextDouble();
		return numero;
	}
	
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
		
	}
	
}
