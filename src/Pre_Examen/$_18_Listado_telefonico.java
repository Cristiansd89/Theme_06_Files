package Pre_Examen;

import java.util.*;

import java.io.*;

public class $_18_Listado_telefonico {
	
	static String[] Lista = new String[0];

	public static void main(String[] args) {
		
		
		try {
			if(args.length < 1) {
				throw new ErrorNumeroArgumentos();
				
			}else {
				File archivo = new File(args[0]);
				if(!archivo.exists()) {
					throw new FileNotFoundException(); 
				}else {
					Menu(args, Lista);
					//Llamamos al metodo
				}
			}
		}catch(ErrorNumeroArgumentos e) {
			System.out.println("Falta Argumentos");
			
		}catch(FileNotFoundException e1) {
			System.out.println("El archivo no se ha encontrado");
		}

	}
	/**
	 * Creamos un menu para elegir la opciones que queremos
	 * a traves de int y un switch seleccionamos al metodo que queremos llamar
	 */
	public static void Menu(String[] args,String[] Lista) {
		Scanner ent = new Scanner (System.in);
		
		boolean salir = false;
		do {
		System.out.println("1-Mostrar llamadas");
		System.out.println("2-Añadir llamadas");
		System.out.println("3-Salir");
		System.out.println("  ");
		System.out.println("Introduzca opcion :");
		//opcion que seleccionar el usuario
		int opc = ent.nextInt();
		
		switch(opc) {
		case 1:
			//Metodo para mostrar las llamadas
			LeerLista(args,Lista);
			break;
		case 2: 
			
			//Metodo para añadir llamadas
			añadirLLamada(args, Lista);
			break;
		case 3:
			salir = true;
		}
		
	}while(!salir);

	}
	/**
	 * Este metodo abre un archivo binario y le su contenido introduciendolo todo en
	 * un Array de tipo String si la longitud fuese 0 el programa no diria que la lista telefonica esta vacia
	 * @param args
	 */
	public static void LeerLista(String[] args,String[] Lista) {
		ObjectInputStream lecAchivo = null;
		
		//Se inicializa a cero para que no produzca 
		//un error al intentar evaluar su longitud cuando es 0;
		
		
		try {
			lecAchivo = new ObjectInputStream(new FileInputStream(args[0]));
			Lista= (String[])lecAchivo.readObject();
			
			System.out.println("LLamadas :");
			System.out.println(Arrays.toString(Lista));
				
			lecAchivo.close();
			
		}catch(ClassNotFoundException e1) {
			System.out.println(" No se ha encontrado la clase");
		}catch(IOException e) {
			System.out.println("Error en el flujo de lectura");
		}
		
		/**
		 * Este metodo se utiliza para añadir nombres de las llamadas entrantes 
		 * pasamos 2 parametors arg con el nombre del archivo donde queremos guardar el nombre y el Array donde vamos a copiar los
		 * datos para introducirlos posteriormente en el fichero
		 * 
		 */
	}
	public static void añadirLLamada(String[] args,String[] Lista) {
		Scanner ent = new Scanner (System.in);
		ObjectOutputStream añadir = null;
		boolean salir = false;
		
		try {
			do {
			añadir = new ObjectOutputStream(new FileOutputStream(args[0]));
			//aumentamos en 1 la longitud del Array
			String ListAux[] = Arrays.copyOf(Lista, Lista.length+1);
			System.out.println("Introduzca nombre de hoy : /fin para salir");
			ListAux[Lista.length]=ent.nextLine();
			if(ListAux[Lista.length].equalsIgnoreCase("fin")) {
				salir=true;
			}
			
			//Copiamos el Array Aux en el original para actualizar la informacion
			Lista = ListAux;
			añadir.writeObject(Lista);
			}while(!salir);
			añadir.close();
		}catch(IOException e1) {
			System.out.println("Error en el flujo de escritura :");
		}
		
		}
}
class ErrorNumeroArgumentos extends Exception{
	public ErrorNumeroArgumentos() {
		super();
	}
}
