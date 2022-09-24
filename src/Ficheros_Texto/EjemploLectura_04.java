package Ficheros_Texto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLectura_04 {

	public static void main(String[] args) {
		
		leer_Fichero acceder = new leer_Fichero();
		acceder.leer();

	}
	
	

}
class leer_Fichero{
	public void leer() {
		try {
			FileReader entrada = new FileReader("/home/cristian/eclipse-workspace/EntradaySalidaLibro/Periodico.txt");
			
			int c = entrada.read();
			while(c != -1) {
				
				c = entrada.read(); //le caracter a caracter e introduce en la variable su codigo ASCI
				char letra = (char) c; //Transformamos el COdigo ASCI a CArateres
				System.out.println(letra);
			}
			entrada.close();
		} catch (IOException  Error) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el Archivo");
		}
	}
	
	
}
