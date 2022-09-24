package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_10_Codificador 
{
/**
 * NO tengo ni puta de hacerlo funcionar
 * @param args
 */
	public static void main(String[] args)
	{
		
		//Commprobamos que el numero de argumentos es correcto
		try {
				
				if (args.length < 1) {
					throw new ErrorNumeroArgumentos();
				}else {
					//Comprobacion de si el fichero existe
					File arhivo = new File(args[0]);
					if(!arhivo.exists()) {
						throw new FileNotFoundException();
					}else {
						Codificar(args);
					}			
				}
		}catch(ErrorNumeroArgumentos e1){
			System.out.println("Faltan argumentos :");
		}catch(FileNotFoundException e1) {
		System.out.println("No se encuentra el archivo ");
		}
		
	}
	
	
	
	
	public static void Codificar(String[] args) {
		String cad;
		char codigo [][] = null;
		/**
		 * tabla bidimensional con el alfabeto
		 */
		
		int c; //funcion que devuelve el carácter com un entero;
		try 
		{
			
			BufferedReader leerArchivo = new BufferedReader(new FileReader(args[0]));
			codigo =new char [2][26];
			cad = leerArchivo.readLine();
			
			codigo [0] = cad.toCharArray();//Letras sin codificar
			cad = leerArchivo.readLine();
			
			codigo[1] = cad.toCharArray();//letras codificadas
			leerArchivo.close();
		
		
				
		}catch(IOException Error) {
			System.out.println("Error en el fichero ");
		}
		/**
		 * ahora abrimos  el texto a codificar y el resultado
		 * iremos  leyendo carácter a caracter, codificando y escribiendo
		 */
		try {
			BufferedReader leerTexto = new BufferedReader(new FileReader(args[0]));
			BufferedWriter EscribirCod = new BufferedWriter(new FileWriter("codificado.txt"));
			
			c = leerTexto.read();//Leeemos caracter a caracter
			while (c != -1) {//mientras no escribamos
				EscribirCod.write(Traducir((char) c, codigo));
				c = leerTexto.read();
			}
			leerTexto.close();
			EscribirCod.close();
			
		}catch(IOException err) {
			System.out.println("Error en el fichero de codificacion");
		}
	}
	
	public static char Traducir(char c, char codigo [][]) {
		char cod;
		int i = 0;
		
		while(i < codigo[0].length && c != codigo[0][i]) {
			i++;
		}
		if(i<codigo[0].length) {
			cod =codigo[i][i];
		}else {
			cod = c;
		}
		return cod;
	}

}
class ErrorNumeroArgumentos extends Exception {
	public ErrorNumeroArgumentos() {
		super();
			
		
	}
}
