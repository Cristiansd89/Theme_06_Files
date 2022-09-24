package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_19_Dos_Ficheros_bn {

	public static void main(String[] args) 
	{
		/**
		 * Comprombamos  que se pasan los argumentos necesarios y si ambos ficheros de origen existen
		 * sino lanzamos un Error
		 */
		try {
			if(args.length != 2) {
				throw new ErrorNumeroArgumentos();
				
			}else {
				File archivo = new File(args[0]);
				
				if(!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					File archivo2 = new File(args[1]);
					if(!archivo2.exists()) {
						throw new FileNotFoundException();
					}else {
						//Metodo de copia
						Copiar_Binarios(args);
						
					}
				}
			}
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan Argumentos ");
			
		}catch(FileNotFoundException e1) {
			System.out.println("No Existe el archivo1");
	}
		
	}/**
	Metodo  para copiar 2 ficheros binarios en un tercero
	abrirmos 2 flujos de lectura y una de escritura
	*/
	public static void Copiar_Binarios(String[] args) {
		ObjectInputStream origen1 = null;
		ObjectInputStream origen2= null;
		ObjectOutputStream Destino = null;
		
		try 
		{
			origen1 =new ObjectInputStream(new FileInputStream(args[0]));
			origen2 = new ObjectInputStream(new FileInputStream(args[1]));
			Destino = new ObjectOutputStream(new FileOutputStream("Todos.dat"));
			int ultm1;
			int ultm2;
			try {
				 ultm1 = origen1.readInt();
				 ultm2 = origen2.readInt();
				
				/*
				 * comparamos  los numeros de un archivo con el otro 
				 * se copiara en el archivo el numero que sea menor
				 */
				while(true)
				{
					if(ultm1< ultm2)
					{
						Destino.writeObject(ultm1);
						ultm1 = origen1.readInt();
					}else 
					{
						Destino.writeObject(ultm2);
						ultm2 = origen2.readInt();
					}
				}
			}catch(EOFException err) {
				/*
				 * Salimosdel bucle infinito, al llegar al final para
				 * poder salir  utilizamos esta excepcion
				 */
			}//Fin del Segundo try
			
			while(origen1.available()>0) {//Si que dan datos por el se leeran
				ultm1 = origen1.readInt();
				Destino.writeObject(ultm1);
			}
			while(origen2.available()> 0) {
				
				ultm2 = origen2.readInt();
				Destino.writeObject(ultm2);
			}
			origen1.close();
			origen2.close();
			
		}catch(IOException e) {
			System.out.println("Error en el flujo de datos :");
		}//fin del Primer try
	}
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
	}
}

