package Pre_Examen;

import java.io.*;
import java.util.*;

public class $_20_LeerTexto_Sin_Espacios {

	public static void main(String[] args) {
		
		try {
			if (args.length < 1) {
				throw new ErrorNumeroArgumentos();
			}else {
				File archivo = new File(args[0]);
				if (!archivo.exists()) {
					throw new FileNotFoundException();
				}else {
					//Metodo de lectura
					leer_Archivo(args);
				}
			}
		}catch(ErrorNumeroArgumentos er) {
			System.out.println("Faltan argumentos");
		}catch(FileNotFoundException er1) {
			System.out.println("No existe el archivo :");
		}
	}
	//Metodo par Leer fichero
	public static void leer_Archivo(String[] args) {
		
		FileReader archivo =null;
		try {
			archivo = new FileReader(args[0]);
			int valor = archivo.read();
			while(valor!=-1){
                //Si el caracter es un espacio no lo escribe
                if(valor!=32){
                    System.out.print((char)valor);
                }
                valor=archivo.read();
            }
        }catch(IOException e){
            System.out.println("Problemas con el E/S "+e);
        }
	}
}
class ErrorNumeroArgumentos extends Exception 
{
	public ErrorNumeroArgumentos() 
	{
		super();
	}
}
