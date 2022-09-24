package Acesso_Aleatorio;

public class Registro
{
	

	private String Cod_Producto;
	private String Desc_Producto;
	private double Precio;
	
	public Registro(String Cod_Producto,String Desc_Producto,double Precio) 
	{
		
		this.Cod_Producto = Cod_Producto;
		this.Desc_Producto = Desc_Producto;
		this.Precio = Precio;
		
	}
	public String getCod_Producto() {
		return Cod_Producto;
	}

	public void setCod_Producto(String cod_Producto) {
		Cod_Producto = cod_Producto;
	}

	public String getDesc_Producto() {
		return Desc_Producto;
	}

	public void setDesc_Producto(String desc_Producto) {
		Desc_Producto = desc_Producto;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}
}
