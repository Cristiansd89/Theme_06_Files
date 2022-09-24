package Pre_Examen;

import java.io.*;
/**
 * Realiza un programa que lea un fichero de texto llamado carta tenemos que contar 
 * los crates. las lineas y la palabras para falicilitar el procesaamiento supondremos que da
 * palabra está separada ede otra por único espacio en blanco
 * @author cristian
 *
 */

public class $_01_Contar {

	public static void main(String[] args) 
	
	{
		try {
			//Comprobamos que el numero de argumentos es correcto si no el programa 
			//Lanzara una execepcion
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File Archivo = new File(args[0]);
				if(!Archivo.exists()) {
					
					//Depues de introducir el nombre como parametro el programa comprueba si 
					//el fichero existe si no lo hiciera  saltari la excepcion
					throw new FileNotFoundException();
					
				}else {
					Contar_Archivo(args);
				}
			}
			
		}catch(ErrorNumeroArgumentos error) {
			System.out.println("faltan Argumentos ");
		}catch(FileNotFoundException e) {
			System.out.println("Archivo de lectura no encontrado");
		}

	}
	/**
	 * Metodo que utilizamos para contar los carcteres, palabras o letras le pasamos como 
	 * perametro la posicon del array donde guardamos el nombre del fichero
	 * @param Archivo
	 */
	public static void Contar_Archivo(String[] args) {
		/*
		 * Abrimo el flujo de lectura del archivo de texto y lo declaramos en null
		 */
			BufferedReader Recu_archivo = null;
		try {
			
			Recu_archivo = new BufferedReader(new FileReader(args[0]));
			int contCar = 0;
			int contPal = 0;
			int ContLinea = 0;
			/*
			 * Leemos caracter a caracter cuando se llegue al final del archivo se lanzara un -1
			 */
			int c = Recu_archivo.read();
			while (c != -1) {
				/*
				 * Cada vez que haya un espacio en blanco en el texto el programa lo contara como caracter y  como 
				 * palabra
				 */
				if(c == ' ') {
					contCar++; 
		              contPal++; 
				}else {
					/*
					 *cada vez que el progra ma encuentre un salto de linea contara un caracter,una palabra y  una linea
					 */
				}if(c == '\n') {
					contPal++; 
	                ContLinea++;
	                contCar++; 
				}else {
					contCar++;
				}
				c = Recu_archivo.read();
			}
			Recu_archivo.close();
			if(contPal > 0) {
				contPal++;
			}
			if(ContLinea > 0) {
				ContLinea++;
			}
			System.out.println("Caracteres: " + (contCar - 1)); 
	        System.out.println("Palabras: " + contPal);
	        System.out.println("Líneas: " + ContLinea);
			
		}catch(IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}
		
		
	}

}
class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos() {
		super();
	}
}
