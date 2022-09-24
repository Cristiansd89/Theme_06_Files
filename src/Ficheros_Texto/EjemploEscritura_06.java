package Ficheros_Texto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploEscritura_06 {

	public static void main(String[] args) 
	{
		 try(FileWriter fw=new FileWriter("/home/cristian/eclipse-workspace/EntradaySalidaLibro/Nuevo_Texto.txt");
		            FileReader fr=new FileReader("/home/cristian/eclipse-workspace/EntradaySalidaLibro/Nuevo_Texto.txt")){
		            //Escribimos en el fichero un String y un caracter 97 (a)
		            fw.write("Esto es una prueb");
		            fw.write(97);
		            //Guardamos los cambios del fichero
		            fw.flush();
		            //Leemos el fichero y lo mostramos por pantalla
		            int valor=fr.read();
		            while(valor!=-1){
		                System.out.print((char)valor);
		                valor=fr.read();
		            }
		        }catch(IOException e){
		            System.out.println("Error E/S: "+e);
		        }

	}

}
