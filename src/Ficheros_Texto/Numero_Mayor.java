package Ficheros_Texto;

import java.util.*;
import java.io.*;

public class Numero_Mayor {

	public static void main(String[] args) throws Exception 
	{
		leer_Numeros();

	}
	
	  public static void leer_Numeros() {
		
		
		try {
			BufferedReader LecturaNumeros = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Textos/numeros.txt"));
			int numElm = 0;
			int[] Array = new int [numElm];
			
			int cifra = (char) LecturaNumeros.read();
			
			cifra = LecturaNumeros.read();
			while (cifra != -1)
			{
				int i = numElm;
				Array[i] = cifra;

				while(i > 0 && Array[i-1] > Array[i])
				{
					int aux = Array[i-1];
					Array[i-1] = Array[i];
					Array[i] = aux;
					i--;
				}
				
				numElm++;
				cifra = LecturaNumeros.read();
			}	
			LecturaNumeros.close();
	
			
		}catch(Exception Error) {
			System.out.println("No se pudo ver el archivo");
		}
		
	  }
	
		
		
		
	

}
