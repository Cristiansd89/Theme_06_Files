package Acceso_Secuencial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio_05 
{

	public static void main(String[] args) 
	{
		
		Scanner ent = new Scanner(System.in);
		String texto = " ";
		
		
		try {
			BufferedReader Archivo =new BufferedReader(new FileReader("/home/cristian/eclipse-workspace/EntradaySalidaLibro/Periodico.txt"));
			
			String linea = Archivo.readLine();
			
			while (linea != null) {
				texto = texto + linea + "\n";
				linea = Archivo.readLine();
			}
			Archivo.close();

	}catch(IOException fallo)
		{
		System.out.println("El Archivo no se pudo Abrir");
	}
	System.out.println(texto);

	}
}
