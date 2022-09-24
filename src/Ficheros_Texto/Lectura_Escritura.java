package Ficheros_Texto;

import java.io.*;

public class Lectura_Escritura {

	public static void main(String[] args) {
		
		
		int contador = 0;
		int datos_entrada[] = new int [32471];
		
		try {
			FileInputStream Archivo_lectura = new FileInputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/ChuletaAccesoSecuencial.jpg");
			
			 boolean finalAr = false;
			 
			 while (!finalAr ) 
			 {
				 int Byte_entrada = Archivo_lectura.read();
				 if (Byte_entrada != -1) {
					 datos_entrada[contador] = Byte_entrada;
				 }
				 
				 else
				 {
					 finalAr = true;
					 
				 }
				System.out.println(datos_entrada[contador]); 
				contador++;
			 }
			 Archivo_lectura.close();
			 
		}catch (IOException fallo) {
			System.out.println("No se pudo abrir el archivo");
			
		}
		
		System.out.println(contador);
		
		crear_fichero(datos_entrada);
	}
	public static void crear_fichero(int datos_fichero  []) {
		try {
			FileOutputStream fichero_nuevo = new FileOutputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/ChuletaAccesoSecuencialCopia.jpg");
		
			for(int i = 0; i< datos_fichero.length;i++) {
				fichero_nuevo.write(datos_fichero[i]);
				
			}
			fichero_nuevo.close();
		}catch(IOException fallo) {
			System.out.println("No se pudo abrir el archivo");
			
			
			
			
		}
	}

}
