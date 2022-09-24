package Pre_Examen;


import java.util.*;
import java.io.*;


/**
 * Pedir un numero entero n por consola .Despues , pedir n  veces un numero double , que iremos guardando en una tabla
 * la tabala la guardaremos en un archivo binario 
 * @author cristian
 *
 */
public class $_13_Pedir_N_Veces 
{

	public static void main(String[] args) 
	{
		Scanner ent = new Scanner(System.in);
		String resp = "si";
	
		//Comprobamos si se ha pasado el numero correcto de argumentos
		try {
			if (args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				
				//Comprobando si el fichero existe
				File Archivo = new File(args[0]);
				if(Archivo.exists()) 
				{
					System.out.println("Quieres sobre Escribir el fichero ?");
					resp= ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					Pedir_Numeros(args);
				}else {
					System.out.println("Fin del programa");
				}
			}
			
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan argumentos ");
			System.out.println("Syntaxis: java $_13_Pedir_N_Veces ficheroOrigen ");
		}

	}
	/*
	 * Metodo para introducir numeros en la tabla
	 */
	public static void Pedir_Numeros(String[] args) {
		Scanner ent = new Scanner(System.in);
		
		ent.useLocale(Locale.US);//Para utilizar (.) en los decimales
		ObjectOutputStream Esc_archivo = null;
		
		try {
			//Pedimos una cantidad de elementos
			System.out.println("Numero de elementos :");
			int n = ent.nextInt();
			
			double tabla[]= new double [n];//Creamos la tabla con el tamaño que le indicamos arriba
			Esc_archivo = new ObjectOutputStream(new FileOutputStream(args[0]));
			
			for(int i = 0;i<tabla.length; i++) {
				System.out.println("Introduce un numero decimal "+" ["+i+"]");
				tabla[i]=ent.nextDouble();
			}
			Esc_archivo.writeObject(tabla);
			
				
		}catch(IOException error) {
			System.err.println("Error en el flujo de datos");
		}finally {
			try {
				if(Esc_archivo != null) 
				{
					Esc_archivo.close();
				}
				}catch(IOException err) {
				}
			}
		}
		
}
	
class ErrorNumeroArgumentos extends Exception 
{
	public ErrorNumeroArgumentos() {
		super();
	}
}
