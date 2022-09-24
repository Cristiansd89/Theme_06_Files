package Acesso_Aleatorio;

import java.io.*;
public class TestBaseDeDatos
{
    
    static BaseDeDatos bd= null;
    static boolean ficheroAbierto=false;
    static File fichero =null;
    
    
    public static void main(String args[]) throws IOException
    {
        
        boolean marcado=false;
        int opcion;
        do
        {
            opcion=menu();
            if(opcion!=7)
            {
                switch (opcion)
                {
                    case 1:
                       nuevoFich();
                        break;
                       
                    case 2:
                        abrirFich();
                        break;
                        
                    case 3:
                        anadirReg();
                        break;
                        
                    case 4:
                        modificarReg();
                        break;
                        
                    case 5:
                        marcado=eliminarReg();
                        break;
                        
                    case 6:
                        visualizarRegistro();
                        break;
                }
                    
            }
                
        }while(opcion!=7);
        if(marcado)
            bd.actualizar();
        
    }
    
    ////////////////////////////////////////////////
    
    public static int menu()
    {
        
        int opcion;
        boolean opcionValida;
        
        System.out.println("MENU DE BASE DE ARTICULOS");
        if (ficheroAbierto)		
		System.out.println("Nombre del fichero en utilizacion: " +  fichero.getName() );
		else
			System.out.println("!!No hay  ningun fichero abierto !!");
        System.out.println();
        System.out.println("1.Fichero nuevo");
        System.out.println("2.Abrir fichero");
        System.out.println("3.Anadir registro");
        System.out.println("4.Modificar registro");
        System.out.println("5.Eliminar registro");
        System.out.println("6.Visualizar registro");
        System.out.println("7.Salir");
        System.out.println();
        System.out.println("Introduce opcion_");
        do
        {
        opcion=Leer.datoInt();
        opcionValida=(opcion>=1 && opcion <=7);
        if(!opcionValida)
            System.out.println("Opcion invalida");
        }while(!opcionValida);
        return opcion;
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //La funcion del metodo nuevoFich es creaqr un nuevo fichero si este no existe
    public static void nuevoFich()
    {
       System.out.println("Introduce nombre del fichero");
       do 
       {
           //comprueba si existe ya un fichero con el mismo nombre, si no existe lo crea
            fichero=new File(Leer.dato());
            if(fichero.exists())
                System.out.println("El fichero introducido ya existe,introduzca otro nombre para el fichero ");
      }while(fichero.exists());
        
    //creamos la base de datos y actualizamos el interruptor
    bd=new BaseDeDatos(fichero);
    ficheroAbierto=true;
    System.out.println("Fichero creado correctamente");
                  
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    //La funcion del metodo abrirFich es abrir un fichero ya existente.Si el fichero introducido no existe dara la oportunidad de mostrar en pantalla el directorio de trabajo 
    public static void abrirFich()
    {
        
        if(ficheroAbierto)
         System.out.println("El fichero ya esta abierto");
        else
        {
            System.out.println("Introduce nombre del fichero");
            do
            {
             fichero=new File(Leer.dato());
             //comprueba si el fichero existe
             if(!fichero.exists())
             {
                    System.out.println("El fichero introducido no existe, listar el directorio de trabajo actual? (s/n): ");
                    if (getRespuesta() == 's')
                    {
                        //lista el directorio de trabajo actual
                        fichero = new File("");
						File dir = new File(fichero.getAbsolutePath());
						String directorio [] = dir.list();
						System.out.println("Contenido del directorio " + dir.getName() + " :");
						for (int i = 0; i < directorio.length ; i++)
                            System.out.print(directorio[i]+"  ");
                        System.out.println();
                    }
                   System.out.print("Introduce el nombre del fichero: ");
                   fichero = new File(Leer.dato());
                
             }			
            }while(!fichero.exists());
            //creamos la base de datos y actualizamos el interruptor
            bd=new BaseDeDatos(fichero);
            ficheroAbierto=true;
            System.out.println("Fichero abierto");
        }  
        
            
        }
            
      
    ///////////////////////////////////////////////////////////////////////
    //El metodo anadirReg tiene como funcion solicitar los datos a traves del teclado y crear un registro mandandolo a la clase anadir 
    public static void anadirReg()
    {
        if(ficheroAbierto)
        {
            String clave;
        
            do
            {
                System.out.println("Introduce el la clave del articulo: ");
               clave=Leer.dato();
           
                if(bd.Busqueda(clave)!=-1)
                  System.out.println("El registro existe");
           }while(bd.Busqueda(clave)!=-1);
           System.out.println("Introduce la descripcion del articulo: ");
           String descripcion=Leer.dato();
           System.out.println("Introduce el precio del articulo: ");
           double precio=Leer.datoDouble();
       
  
           Registro registro=new Registro(clave,descripcion,precio);
           bd.anadir(registro);
           
         }
        else
            System.out.println("No has abierto ningun fichero");
        
    }
    
    ///////////////////////////////////////////////////////////////////////
    //El metodo modificarReg tiene com funcion llamar al metodo menuModificaciones que mustra un menu para permitir modificar cualquier registro del fichero y salvar ,o no los cambios
    public static void modificarReg()
    {
        if(ficheroAbierto)
        {
            if(bd.basesDedatosVacio())
                System.out.println("La base de datos esta vacia");
            else
            {
                System.out.println("Introduce la clave del articulo: ");
                String clave=Leer.dato();
           
                if(bd.Busqueda(clave)!=-1)
                {
                    int pos=bd.Busqueda(clave);
                    Registro reg=bd.leerRegistro(pos);
                    String descripcion=reg.getDesc_Producto();
                    Double precio=reg.getPrecio();
                    int opcionModificar;
                    
                    do
                    {
                        opcionModificar=menuModificaciones(reg);
                        if(opcionModificar!=5)
                        {
                            switch (opcionModificar)
                            {
                            case 1:
                                System.out.println("Introduce nueva clave del articulo");
                                clave=Leer.dato();
                                break;
                                
                            case 2:
                                System.out.println("Introduce la descripcion del articulo");
                                descripcion=Leer.dato();
                                break;
                             
                            case 3:
                                System.out.println("Introduce el precio del articulo");
                                precio=Leer.datoDouble();
                                break;
                           
                            case 4:
                                Registro registro =new Registro(clave,descripcion,precio);
                                bd.escribirRegistro(pos,registro);
                                opcionModificar=5;
                           }
                     }
                }while(opcionModificar!=5);                
            }
            else
                System.out.println("El registro no existe");
        }
            
          
      }
      else
           System.out.println("No has abierto ningun archivo");
    }
    
    /////////////////////////////////////////////////////////////////////////
    
    public static int menuModificaciones(Registro reg)
    {
        int opcion;
        boolean opcionValida;
        
         System.out.println("Los datos actuales del registro seleccionado son:");
         System.out.println("Clave : " + reg.getCod_Producto());
         System.out.println("Descripcion: " + reg.getDesc_Producto());
         System.out.println("Precio : " +reg.getPrecio());
        
        System.out.println("MENU DE MODIFICACION");
        System.out.println();
        System.out.println("1.Referencia");
        System.out.println("2.Descripcion");
        System.out.println("3.Precio");
        System.out.println("4.Salir y salvar los cambios");
        System.out.println("5.Salir sin salvar cambios");
        System.out.println();
        
        
       do
       {
        System.out.println("Introduce opcion: ");
        opcion=Leer.datoInt();
        opcionValida=(opcion>=1 && opcion <=5);
        if(!opcionValida)
            System.out.println("Opcion invalida");
        }while(!opcionValida);
        return opcion;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //El metodo eliminarReg tiene como funcion marcar un registro para borrarlo
    public static boolean eliminarReg()
    {
        if(ficheroAbierto)
        {
            if(bd.basesDedatosVacio())
                System.out.println("La base de datos esta vacia");
            else
            {
                String clave;
             
                System.out.println("Introduce el la clave del articulo a eliminar: ");
                clave=Leer.dato();
           
                if(bd.Busqueda(clave)!=-1)
                {
                    bd.marcar(bd.Busqueda(clave));
                    System.out.println("Registro borrado");
                    return true;
                    
                }
            }
            return false;
         }
         return false;
    }
    
    /////////////////////////////////////////////////////////////////////////////
    //El metodo visualizarReg tiene como funcion recibir una cadean con la clave del registro a visualizar ,y nmostrarlo por pantalla
    public static void visualizarRegistro()
    {
        if(ficheroAbierto)
        {
            if(bd.basesDedatosVacio())
                System.out.println("La base de datos esta vacia");
            else
            {
                System.out.println("Introduce el la clave del articulo a visualizar: ");
                String clave=Leer.dato();
             
                int pos=bd.Busqueda(clave);
                if(pos!=-1)
                {
                Registro reg=bd.leerRegistro(pos);
                System.out.println("Clave : " + reg.getCod_Producto());
                System.out.println("Descripcion: " + reg.getDesc_Producto());
                System.out.println("Precio : " +reg.getPrecio());
                }
                else
                    System.out.println("El registro no existe");
                
            }
        }
        else
            System.out.println("No hay ninguna archivo abierto");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    // La funcion del metodo getRespuesta es la de devolver la respuesta dada por el usuario siendo solo valida 's' o 'n'
    public static char getRespuesta()
    {
	char respuesta = 'a';
	boolean valida;
	do
	{
		try
		{
			respuesta = (char) System.in.read();
			System.in.skip(2);
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
		respuesta = Character.toLowerCase(respuesta);
		valida = ((respuesta == 's') || (respuesta == 'n'));
		if(!valida)
			System.out.print("!!Respuesta no valida, introduzca 's' o 'n': ");
		
	}while(!valida);
	return respuesta;
	}
            
 
}
    
 
        
       
        
        
           
            
                        
    
    
   