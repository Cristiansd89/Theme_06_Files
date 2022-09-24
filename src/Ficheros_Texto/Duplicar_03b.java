package Ficheros_Texto;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;


public class Duplicar_03b 
{

	public static void main(String[] args) throws IOException 
	{
		Scanner ent= new Scanner(System.in);
		
		System.out.println("Nombre Fichero Fuente : ");
		String fuente = ent.nextLine();//Nombre del fichero a copiar
		String destino = nombreFichero(fuente);// funcion que añade el fichero  "Copia_de"
		
		try {
			BufferedReader f1 = new BufferedReader(new FileReader(fuente));//Para abrir el Archivo Fuente
			BufferedWriter f2 = new BufferedWriter(new FileWriter(destino));//Para abrir el Archivo de destino
			
			int c = f1.read();//Leemos el ARchivo Original
			
			while(c != -1) {
				f2.write(c);
				c = f1.read();
			}
			f1.close();
			f2.close();
			
		}catch(EOFException fallo) {
			System.out.println("Error : No se puede abrir el archivo");
		}
		
	}
	
	public static String nombreFichero(String nombre) {
		String nuevoNombre;
		int pos = nombre.lastIndexOf('/');//Buscamos la ultima ocurrencia  de '/'
		if (pos == -1) {//si no contiene '/'
			nuevoNombre ="copia_de_"+nombre;
		}else {
			nuevoNombre = nombre.substring(0, pos + 1);
			nuevoNombre = nombre.substring(pos +1) + "copia_de_"+nombre;	
			}
		
		return (nuevoNombre);
			
			
		}
		
		
		
		
	}


