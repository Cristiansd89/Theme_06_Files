package Ficheros_Binarios;


import java.util.*;
import java.io.*;

public class Pedir_Numeros {

	public static void main(String[] args) 
	{
		CrearFicheros();
		Leer_Fichero();
	}
	
	
	public static void CrearFicheros() 
	{
		Scanner ent = new Scanner(System.in);
		int num;
		try {
			ObjectOutputStream Archivo = new ObjectOutputStream(new FileOutputStream("PruebaEnteros1.dat"));
			System.out.println("Introduce numeros : / -99 (para Salir :");
				
			 do{
				num = ent.nextInt();
				if(num != -99)
				Archivo.writeObject(num);	
			}while (num != -99);
			Archivo.close();
		}catch(IOException Error) {
			System.out.println("No se ha podido Crear El archivo ");
			
		}
		
	}
	public static void  Leer_Fichero() {
		
		ObjectInputStream Recu_Archivo = null;
		try {
			Object num;
		
			Recu_Archivo = new ObjectInputStream(new FileInputStream("PruebaEnteros1.dat"));
			while (Recu_Archivo != null)
			{
				
				num = Recu_Archivo.readObject();
				if(Recu_Archivo != null) 
				{
					System.out.println(num);
				}
			}
			
		}catch(IOException Error) {
			System.out.println("No se ha podido abrir el Archivo ");
		
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
