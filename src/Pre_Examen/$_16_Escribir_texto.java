package Pre_Examen;

import java.util.*;
import java.io.*;

public class $_16_Escribir_texto {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		String resp = "si";
		try {
			if (args.length < 1) {
				throw new ErrorNumeroArgumentos();
				
			}else {
				File archivoB = new File(args[0]);
				if(archivoB.exists()) {
					System.out.println("quieres Sobreescribir el Archivo :");
					resp = ent.nextLine();
				}
				if(resp.equalsIgnoreCase("si")) {
					Escribir(args);
					LeerObjeto(args);
				}
			}
			
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Faltan argumentos");
		}
	
	}
	public static void Escribir(String[] args) {
		Scanner ent = new Scanner(System.in);
	
		ObjectOutputStream Escribir = null;
		try {
			
			Escribir = new  ObjectOutputStream(new FileOutputStream(args[0]));
			System.out.println("Escribe una linea :");
			String texto = ent.nextLine();
			while(!texto.isEmpty()) {
				Escribir.writeObject(texto);
				System.out.println("Escrible una linea");
				texto = ent.nextLine();
			}
			Escribir.close();
			
			
		}catch(IOException err) {
		System.out.println("Error en el flujo de datos ");
	}
		///Falta el metodo de lectura
		
}
	public static void LeerObjeto(String[] args) {
			ObjectInputStream lectura= null;
		try {
			lectura = new ObjectInputStream(new FileInputStream(args[0]));
			String Cont = (String)lectura.readObject();
			while (Cont!= null) {
				System.out.println(Cont);
				Cont = (String)lectura.readObject();
			}
			lectura.close();
			
		}catch(ClassNotFoundException err1) {
			System.out.println("Clase no encotrada :");
			
		}catch(IOException err) {
			System.out.println("Error en flujo de datos ");
		}
		
		
		
	}
	
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
	}
}
