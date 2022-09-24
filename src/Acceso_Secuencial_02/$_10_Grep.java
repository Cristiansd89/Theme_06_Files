package Acceso_Secuencial_02;

import java.util.*;
import java.io.*;

public class $_10_Grep {

	public static void main(String[] args) 
	
	{
		try 
		{
			if(args.length < 2) 
			{
				throw new ErrorNumeroArgumentos();
			}else 
			{
				
				for (int i = 1; i< args.length; i++) 
				{

					File Archivo = new File(args[i]);
					if(Archivo.exists()) {
						Buscar_palabra(args[0],args[i]);
							
					}else {
						System.out.println("El fichero no existe ");
					}
				}
			}
			
		}catch(ErrorNumeroArgumentos error) {
			System.out.println("El numero de argumentos intrducido no es correcto");
			System.out.println("Sintaxis:java Grep palabra nomFich1......nomFichN");
		}
		
	
		
	
	}
	public static void Buscar_palabra(String palabra,String nombre) 
	{
		BufferedReader Recu_Archivo = null;
		final String fin = null;
		
		String Linea;
		try {
			Recu_Archivo =new BufferedReader (new FileReader(nombre));
			int cont = 0;
			boolean encontrado = false;
			while ((Linea = Recu_Archivo.readLine()) != fin) {
				cont++;
			}
			if(Linea.indexOf(palabra)!= -1) 
			{
				System.out.println(cont+ " " +Linea+ "encontrado en el fichero");
				encontrado = true;
			}
			if(!encontrado) {
				 System.out.println("No se ha encontrado en el fichero: "+nombre);
			}
			
			
		}catch(IOException E) {
			System.out.println("No se pudo abrir el archivo ");
			System.out.println(E.getMessage());
		}finally {
			try
            {
				Recu_Archivo.close();
            }
            catch(IOException error)
            {
               System.out.println(error.getMessage());
            }
		}
			
		
			
		
	}
	
	
	
	public static String Pedir_palabra() 
	{
		Scanner ent = new Scanner(System.in);
		System.out.println(" Palabra :");
		String Buscar = ent.nextLine();
		return Buscar;
		
	}
	
}

class ErrorNumeroArgumentos extends Exception
{
	
	public ErrorNumeroArgumentos () {
		super();
	}
	
	
}