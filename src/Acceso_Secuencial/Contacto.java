package Acceso_Secuencial;

import java.io.Serializable;

public class Contacto implements Serializable {
	
	String nombre ;
	String Telefono;
	String Direccion;
	
	
	public Contacto(String nombre,String Telefono,String Direccion) 
	{
		this.nombre = nombre;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	@Override
	public String toString() 
	{
		String	cadena = "Nombre :" +nombre+ " , telefono " +Telefono+ " , Direccion : " +Direccion;
		return cadena;
	}

}
