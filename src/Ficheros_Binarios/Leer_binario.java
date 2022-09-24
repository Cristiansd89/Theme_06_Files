package Ficheros_Binarios;

import java.io.*;

public class Leer_binario {

	public static void main(String[] args) {
		ObjectInputStream Recuperar_Archivo = null;
		try {
			 Recuperar_Archivo = new ObjectInputStream(new FileInputStream("PruebaBinaria2.dat"));
			double numerito = Recuperar_Archivo.readDouble();
			
			System.out.println(numerito);
			
		}catch(IOException Error) {
			System.out.println("No se pudo ver el archivo");
		}finally
		{
			try
			{
				if(Recuperar_Archivo != null) {
					Recuperar_Archivo.close();
				}
			} catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
