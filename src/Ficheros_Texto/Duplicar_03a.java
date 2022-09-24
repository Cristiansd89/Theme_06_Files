package Ficheros_Texto;


import java.io.*;


public class Duplicar_03a {

	public static void main(String[] args) throws IOException {
		/**
		 * leeremos, caracter a caracter, del fichero original y escribiremos en el fichero de destino.
		 * Utilizaremos. dos flujos, uno de entrada y otro de salida.
		 */
		

		try {//abrir los ficheros (de entrada y salida)
			BufferedReader Original = new BufferedReader(new FileReader("Periodico.txt"));
			BufferedWriter Nuevo = new BufferedWriter(new FileWriter("NuevoPeriodico.txt"));
			
			int c = Original.read();
			while(c != -1) {
				Nuevo.write(c);
				c = Original.read();
			}
			Original.close();
			Nuevo.close();
		
		
			
		}catch(EOFException fallo){
			System.out.println("Error :No se pudo abrir el Archivo ");
		}
		
		

	}

}
