package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_21_Mayuscula_Minusculas {

	
	/**
	 * crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que queramos a escribir en el fichero.
	 *  Deberás mostrar por pantalla el mismo texto pero variando entre mayúsculas y minúsculas, es decir, 
	 * si escribo “Bienvenido” deberá devolver “bIENVENIDO”. Si se escribe cualquier otro carácter, se quedara tal y como se escribió
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File archivo = new File(args[0]);
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					//Metodos
					escribirFichero(args);
					leerFichero(args);
				}
			}
		}catch(ErrorNumeroArgumentos er1) {
			System.out.println("Faltan argumentos :");
		}catch(FileNotFoundException er2) {
			
		}

	}
	//Este metodo Crea el fichero e introduce el texto
	 public static void escribirFichero(String[] args){
		 Scanner ent = new Scanner(System.in);
		 System.out.println("Introduce Un texto");
		 String texto = ent.nextLine();
		 
		 try{
	        	FileWriter archivo1=new FileWriter(args[0]);
	            //Escribimos el texto en el fichero
	        	archivo1.write(texto);
	            archivo1.close();
	        }catch(IOException e){
	            System.out.println("Problemas en la escritura E/S "+e);
	        }
	    }
	 //Lee el fichero e y transforma myusculas a minusculas
	 public static void leerFichero(String[] args){
		 try{
			 FileReader archivo1=new FileReader(args[0]);
	            int valor=archivo1.read();
	 
	            while(valor!=-1){
	 
	                //Solo cambiara el caracter si es una minuscula o una mayuscula
	                char caracter=(char)valor;
	                if(caracter>=97 && caracter<=122){
	                    caracter-=32;
	                }else if(caracter>=65 && caracter<=90){
	                    caracter+=32;
	                }
	                System.out.print(caracter);
	                valor=archivo1.read();
	            }
	 
	        }catch(IOException e){
	            System.out.println("Problema con la E/S "+e);
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
