package Acceso_Secuencial;

import java.io.*;
import java.util.*;

public class Ejercicio_06 {

	public static void main(String[] args) {
			
			Scanner entrada = new Scanner(System.in);

			System.out.println("Escribe el nombre del archivo: ");
			String nombre = entrada.nextLine();
	       
			String opcion = "S";

			File fichero = new File(nombre);
	           	if(fichero.exists()){
	           		System.out.println("¿Quieres sobreescribir el fichero existente? S/N");
	                   opcion = entrada.nextLine();
	           }
	                
	                if(opcion.equalsIgnoreCase("S")){
	                	crearFichero(nombre);
	                }
	                    
	                System.out.println("\n Esta es tu lista de contactos");
	                leerFichero(nombre);
	                                   

		}
		
		public static void crearFichero(String nombreFichero) {
			
			DataOutputStream dos = null;
			Scanner entrada = new Scanner(System.in);
			
	    	try {
	    		dos = new DataOutputStream(new FileOutputStream(nombreFichero));
	    		String respuesta = "S";
	    		while (respuesta.equalsIgnoreCase("S")) {
	    			System.out.println("Escribe el nombre del contacto: ");
	    			// lee nombre del teclado
	    			String nombre = leerDato();
	    			//Almacenar un nombre, 
	    			dos.writeUTF(nombre);
	    			
	    			System.out.println("Escribe su teléfono: ");
	    			// lee nombre del teclado
	    			String tlfn = leerDato();
	    			//Almacenar un nombre, 
	    			dos.writeUTF(tlfn);
	    			
	    			System.out.println("Escribe su dirección: ");
	    			// lee nombre del teclado
	    			String direccion = leerDato();
	    			//Almacenar un nombre, 
	    			dos.writeUTF(direccion);
	    			
	    			System.out.println("¿Quieres añadir más contactos? S/N");
	    			respuesta = entrada.nextLine();
	    		}		
	    		
	    	} catch (IOException error) {
	    		System.err.println("Error de escritura." + error.getMessage());
	    	}
	        
	        finally {
	        	 try {
	             	if(dos != null) {
	             		dos.close();
	             	}
	             }
	        	 catch (IOException error) {
	             	System.err.println("Error al cerrar el flujo.");
	             }
	        } 
	       
	    }
		
		
		public static String leerDato() {
			Scanner entrada = new Scanner(System.in);
			String dato = entrada.nextLine();
			return dato;
		}
		
		
		public static void leerFichero(String nombreFichero) {
			
			DataInputStream dis = null;
			
			try {
				dis = new DataInputStream(new FileInputStream(nombreFichero));
				
				while (true) {
					System.out.println("Nombre:"+ dis.readUTF());
					System.out.println("Teléfono:"+ dis.readUTF());
					System.out.println("Dirección:"+ dis.readUTF());
					
				}
					
			} catch (EOFException finalLista) {
	    		System.out.println("Has llegado al final de tu lista de contactos.");
			} catch (IOException error) {
	    		System.err.println("Error de escritura." + error.getMessage());
	    	}
		}

	}
