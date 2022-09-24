package Acceso_Secuencial;

import java.io.File;
import java.io.FileNotFoundException;

public class Ejercicio_01 {

	public static void main(String[] args) {
		

		try{
			if(args.length == 0)
			{
				throw new ErrorNumeroArgumentos();
			}
			else
			{
				for(int i=0;i<args.length;i++)
				{ 
					File fich = new File(args[i]);
					if(fich.exists())
						mostrarPropiedades(fich);
					else
						throw new FileNotFoundException();
				}
			}
		}
		catch(ErrorNumeroArgumentos e)
		{
			System.out.println("Error, no has introducido ningun argumento");
			System.out.println("java PropiedadesFichero nomFich1, nomFich2");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("El fichero no existe");
		}
	}
	///////////////////////////////////////////////7
	public static void mostrarPropiedades(File fich)
	{
		if(fich.isFile())
		{
			System.out.println("La ruta absoluta es: "+ fich.getAbsolutePath());
			System.out.println("La ruta relativa es: " + fich.getPath());
			System.out.println("El nombre del fichero es :" + fich.getName());
			if(fich.canRead())
				System.out.println("El fichero se puede leer");
			else
				System.out.println("El fichero no se puede leer");
			if(fich.canExecute())
				System.out.println("El fichero se puede ejecutar");
			else
				System.out.println("El fichero no se puede ejecutar");
			if(fich.canWrite())
				System.out.println("El fichero tiene permiso de escritura");
			else 
				System.out.println("El fichero no El fichero tiene permiso de escritura");
		}
		else
			if(fich.isDirectory())	
			{
				String listaFicheros[] = fich.list();
				for(int i=0;i<listaFicheros.length;i++)
				{
					System.out.println(listaFicheros[i]);
				}
			}
			

		}
	}


/////////////////////////////////////////

class ErrorNumeroArgumentos extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorNumeroArgumentos()
	{
		super();
	}
	

}

