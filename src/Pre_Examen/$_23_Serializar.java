package Pre_Examen;


import java.io.*;
import java.util.*;


public class $_23_Serializar 
{

	public static void main(String[] args) 
	{
		Scanner ent =new Scanner(System.in);
		 String resp = "si";
			try {
				if (args.length < 1) {
					throw new ErrorNumeroArgumentos();
				}else {
					File archivo = new File(args[0]);
					if(archivo.exists()) {
						System.out.println("Quieres añadir otro vehiculo :");
						resp = ent.nextLine();
					}
					if(resp.equalsIgnoreCase("si")) {
						insertar_Coche(args);
						Vehiculos(args);
					}
				}
				
			}catch(ErrorNumeroArgumentos e) {
				System.out.println("Faltan argumentos: ");
			}
	}
	public static void insertar_Coche(String[] args)
	{
		Scanner ent =new Scanner(System.in);
		ObjectOutputStream fichero = null;
		try {
			
			//Flujo de salida
			fichero =new ObjectOutputStream (new FileOutputStream(args[0]));
			System.out.println("Matricula :");
			String Matricula = ent.nextLine();
			
			System.out.println("Marca :");
			String marca = ent.nextLine();
			
			System.out.println("Modelo :");
			String Modelo = ent.nextLine();
			
			System.out.println("Deposito :");
			int Deposito = ent.nextInt();
			
			
			
			//Creamos un objeto de la clase vehiculo con sus caracterirsticas propias
			vehiculo coche1 = new vehiculo(Matricula,marca,Deposito,Modelo);
			
			//Es el propio objeto creado el que serializamos y metemos en el fichero
			fichero.writeObject(coche1);
			fichero.close();
		}catch(IOException e) {
			System.out.println("Error en el flujo de datos :");
		}
	}
	public static void Vehiculos(String[] args) {
		ObjectInputStream fichero = null;
		
	
		try {
			///Flujo de datos
			fichero= new ObjectInputStream(new FileInputStream(args[0]));
			//Introducimos los datos en una variable tipo vehiculo
			while(true) {
				//ira leyendo mientras haya informacion
				vehiculo coche = (vehiculo) fichero.readObject();
				System.out.println("Matricula : " +coche.getMatricula());
				System.out.println("Marca  : " +coche.getMarca());
				System.out.println("Deposito : " +coche.getDeposito());
				System.out.println("Modelo : " +coche.getModelo());
			}
			
		
		}catch(EOFException e) {
			System.out.println("Fin del archivo :");
		}catch(IOException e1) {
			System.out.println("Error en el flujo de lectura");
		}catch(ClassNotFoundException er1) {
			//El ide nos va pedir crear una excepcion de este tipo con la serializacion
			System.out.println("clase no encontrada");
		}
	}
}
class ErrorNumeroArgumentos extends Exception {
	public ErrorNumeroArgumentos () {
		super();
	}
}
