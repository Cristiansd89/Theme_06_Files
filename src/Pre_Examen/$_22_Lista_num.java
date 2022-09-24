package Pre_Examen;
import java.util.*;
import java.io.*;

/**
 * Crea una aplicación que pida por teclado un número de números aleatorios enteros positivos y la ruta de un fichero.
 * Este fichero contendrá la cantidad de números aleatorios enteros positivos que se ha pedido por teclado.
 * @author cristian
 *
 */
public class $_22_Lista_num {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		
		try {//Comprobando argumentos
			if(args.length <1) {
				throw new ErrorNumeroArgumentos();
			}else {
				//Comprobando si el fichero existe
				File archivo = new File(args[0]);
				if (archivo.exists()) {
					System.out.println("quieres sobre escribirlo :");
					resp = ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					//Metodos
					System.out.println("Cantidad de numeros aleatorios");
					int numeros = ent.nextInt();
					Escribir_archivo(args,numeros);
					leer_fichero(args);
				}
			}
		}catch(ErrorNumeroArgumentos er1 ) {
			System.out.println("Faltan argumentos");
		}
	}
	/*
	 * Metodo para escribrir en fichero de introducimos datos primitivos Y traves de ellos un flijo de bytes
	 */
	public static void Escribir_archivo(String []args,int numeros) {
		
		int numNumerosAleatorios=numeros;
		try {
			
			//Flujo de datos primitivos 
			DataOutputStream archivo = new DataOutputStream(new FileOutputStream(args[0]));
			for (int i = 0;i<numNumerosAleatorios;i++) {
				//Funcion para añadir numeros aleatorios
				int num = generaNumerosAleatorios();
				//Escribimos los numeros
				archivo.writeInt(num);
				
			}
			archivo.writeChars("\n");
			archivo.flush();
			archivo.close();
		
		}catch(IOException e) {
			System.out.println("Error en el flujo de datos");
			
		}
	}
	public static void leer_fichero(String []args) {
		
		try {
			DataInputStream archivo = new DataInputStream(new FileInputStream(args[0]));
			int num = archivo.readInt();
			while(true) {
				 num = archivo.readInt();
				System.out.println(num);
			}
			
		}catch(EOFException e) {
			System.out.println("Fin del fichero:");
		}catch(IOException er1) {
			System.out.println("Error en el flujo de datos ");
		}
	
	}
	//Metodo para crear los numeros aleatorios
	 public static int generaNumerosAleatorios(){
	        int numero=(int)Math.floor(Math.random()*101);
	        return numero;
	    }
	
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
	}
}
