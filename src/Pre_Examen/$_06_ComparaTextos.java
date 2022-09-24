package Pre_Examen;


import java.io.*;
import java.util.Scanner;


/**
 * Programa que compra 2 archivos nos dice si son iguales o distintos
 * Diseñar par que tambie nno diga en que linea  y caracter seencuetra ladiferencia 
 * @author cristian
 *BUENO
 */
public class $_06_ComparaTextos {

	public static void main(String[] args) {

		/*
		 *Comprueba que el numero de parametros es correcto se van a introducir 2 archivos(parametros)
		 */
		try {
			if(args.length != 2) {
				//Comprobando numero de argumentos
				throw new ErrorNumeroArgumentos();
			}else {
				//comprobando si el primer fichero existe
				File archivo1 = new File(args[0]);
				if(!archivo1.exists()) {
					
					throw new FileNotFoundException();
					
				}else {
					//Comprobando que el segundo fichero existe
					File archivo2 = new File (args[1]);
					if(!archivo2.exists()) {
						throw new FileNotFoundException();
					}else {
						LeerArchivos(args);
					}
				}
			}
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan argumentos");
		}catch(FileNotFoundException er1) {
			System.out.println("No existe el archivo :");
		}
	}
	/*
	 * Metodo que lee ambos archivos y va comparando caracter a caracter
	 */
	public static void LeerArchivos(String[] args) 
	{
		int contLinea = 1, 
	              contCar = 1; 
		
			 try 
		      {
				 //Flujos de lectura
		         BufferedReader entr1 = new BufferedReader(new FileReader(args[0]));
		         BufferedReader entr2 = new BufferedReader(new FileReader(args[1]));
		         
		         //Lectura de caracteres
		         int c1 = entr1.read(); 
		         int c2 = entr2.read();
		         //Mientras no se llegue alfinal de uno de los 2 archivos  y mientras sean igual
		         //se mantendra dentro del bucle
		         while (c1 != -1 && c2 != -1 && c1 == c2)
		         { 
		        	//Si el carecter encontrado es un salto de linea aumentara el contador en una
		            contCar++; 
		            if ((char) c1 == '\n') 
		            {
		               contLinea++;
		               contCar = 1;   
		            }
		            c1 = entr1.read();
		            c2 = entr2.read();
		         }

		         //Si en algun momentos los carcteres no coinciden el programa 
		         //Mostrara donde apararecio la primera diferencia
		         if (c1 != c2) 
		         { 
		            System.out.println("Distinto:");
		            System.out.println("Línea: " + contLinea);
		            System.out.println("Caracter: " + contCar);
		         } else 
		         {
		            System.out.println("Los ficheros son iguales.");
		         }

		         entr1.close();  
		         entr2.close();
		      } catch (IOException eof) {
		         System.out.println("Error de fichero");
		      }	
	}
}
class ErrorNumeroArgumentos extends Exception {
	
	public ErrorNumeroArgumentos(){
		super();
	}
}




