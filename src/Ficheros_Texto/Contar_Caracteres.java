package Ficheros_Texto;
import java.io.*;

public class Contar_Caracteres
{

	public static void main(String[] args) 
	{
		leer_Archivo();

	}
	
	public static void leer_Archivo()
	{
		try {
			BufferedReader Recuperar_Archivo = new BufferedReader(new FileReader("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Carta.txt"));
			
			int ContLetras =0;
			int ContPalabras = 0;
			int ContaLinea = 0;
			
			
			 int c = Recuperar_Archivo.read();
			 while (c != -1) 
			 {
					 if ((char) c == ' ')
					{
						ContLetras++;
						ContPalabras++;
					 }else 
					 {
						 if((char)c == '\n')
						 {
							 ContLetras++;
							 ContPalabras++;
							 ContaLinea++;
						 }else {
							 ContLetras++;
						 }	 
					 }
					 c = Recuperar_Archivo.read();
			 }
			Recuperar_Archivo.close();
			System.out.println("Numero de Caracteres : " +ContLetras);
			System.out.println("Numero de Palabras : " +ContPalabras);
			System.out.println("Numero de lineas :" +ContaLinea);
		
		}catch(Exception Error) {
			System.out.println("El archivo No pudo abrirse");
		}
		
		
	}
	
}
