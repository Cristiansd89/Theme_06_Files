package Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializar_02 {

	public static void main(String[] args) 
	{
	Contacto[] persona = new Contacto[3];
	
	persona [0]= new Contacto("Julian", "610837926", "Fuente de San pedro");
	persona [1]= new Contacto("Carla", "65080333", "Lago iseo");
	persona [2]= new Contacto("Franciso", "65939929", "Avenida de america");
	
	
	try {
		////Creamos un fichero nuevo en el que introducimos los constactos en un objeto Array
		ObjectOutputStream fichero_nuevo = new ObjectOutputStream(new FileOutputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Contacto.jpg"));
		fichero_nuevo.writeObject(persona);
		fichero_nuevo.close();
		
		
		///De esta forma recuperamos el objeto ya copiado en la ruta de l archivo
		ObjectInputStream Recuperar = new  ObjectInputStream(new FileInputStream("/home/cristian/Escritorio/Programacion/UT-5 Entrada-Salida/Contacto.jpg"));
		Contacto [] Contacto_recu = (Contacto[]) Recuperar.readObject();//
		//Hay que hacer un casting para transforma el tipo de Objeto (Contacto)
		Recuperar.close();
		
		
		
		//Ahora para poder ver el orbejo como es un array lo recorremos
		
		for(Contacto e : Contacto_recu) {
			System.out.println(e);
		}
	}catch(Exception error) {
		System.out.println("No se pudo abrir el archivo");
	}
	
	
	}

}
