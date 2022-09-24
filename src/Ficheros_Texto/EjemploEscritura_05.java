package Ficheros_Texto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EjemploEscritura_05 {

	public static void main(String[] args) 
	{
		Escribiendo escribir = new Escribiendo();
		escribir.Escribir();
		

	}

}


class Escribiendo {
	public void Escribir() {
		String Frase = "Esto es una prueba de escritura";
		try {
			FileWriter salida= new FileWriter("/home/cristian/eclipse-workspace/EntradaySalidaLibro/Nuevo_Texto.txt");
			
			for (int i = 0; i < Frase.length();i++) {
				salida.write(Frase.charAt(i));///Escribe en el archivo de texto caracter a caracter
				
			}
			salida.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	
}
