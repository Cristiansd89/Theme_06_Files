package Acceso_Secuencial;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Ejercicio_02 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        FileWriter ficheroSobrescrito;
        String opcion = "si";

        try {

            if(args.length != 1){
                throw new ErrorArgumentos();
            } else {
                File nombreFichero = new File(args[0]);
                if(nombreFichero.exists()){
                    System.out.println("¿Quieres sobreescribir el fichero existente? si/no");
                    opcion = entrada.nextLine();
                }
                
                if(opcion.equalsIgnoreCase("si")){
                	ficheroSobrescrito = new FileWriter(nombreFichero);
                    System.out.println("Introduce el contenido: Pulsa Enter y Control D para finalizar. ");
                    crearFichero(ficheroSobrescrito);
                }
                    
                System.out.println("Fin de programa.");
                    
                } 
                

        } catch (ErrorArgumentos errorArgumentos) {
            System.err.println("Error en el numero de argumentos.");
            System.err.println("Syntaxis del comando: java CrearFicheroTexto nombreFichero");
        } catch (IOException error) {
            System.out.println(error);
        }


    }

    public static void crearFichero(FileWriter fw) {

    	try {
    	
        char caracter;
        final char eof = (char) - 1;

        caracter = (char) System.in.read();
        while(caracter != eof) {
            fw.write(caracter);
            caracter = (char) System.in.read();
        }
    	} catch (IOException error) {
    		System.err.println("Error de escritura." + error.getMessage());
    	}
        
        finally {
        	 try {
             	if(fw != null) {
             		fw.close();
             	}
             }
        	 catch (IOException error) {
             	System.err.println("Error al cerrar el flujo.");
             }
        } 
       
    }



}

class ErrorArgumentos extends Exception {
    public ErrorArgumentos(){
        super();
    }

}
