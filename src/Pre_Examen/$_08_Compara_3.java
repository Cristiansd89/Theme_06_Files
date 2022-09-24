package Pre_Examen;
import java.io.*;

public class $_08_Compara_3
{

	public static void main(String[] args) 
	{
		int contLinea = 1, 
	              contCar = 1; 

	      try 
	      {
	         BufferedReader entr1 = new BufferedReader(new FileReader("firma.txt"));
	         BufferedReader entr2 = new BufferedReader(new FileReader("Agenda.txt"));

	         int c1 = entr1.read(); 
	         int c2 = entr2.read();

	         while (c1 != -1 && c2 != -1 && c1 == c2)
	         { 
	            contCar++; 
	            if ((char) c1 == '\n') 
	            {
	               contLinea++;
	               contCar = 1;   
	            }
	            c1 = entr1.read();
	            c2 = entr2.read();
	         }

	         
	         if (c1 != c2) 
	         { 
	            System.out.println("Distinto:");
	            System.out.println("Línea: " + contLinea);
	            System.out.println("Caracter: " + contCar);
	         } else 
	         {
	            System.out.println("Los ficheros son iguales.");
	         }

	         entr1.close();  
	         entr2.close();
	      } catch (IOException eof) {
	         System.out.println("Error de fichero");
	      }
	   }
	
		
	}



