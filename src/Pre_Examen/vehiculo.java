package Pre_Examen;

import java.io.*;
import java.util.*;

public class vehiculo implements Serializable {
	private String matricula;
	private String marca;
	private int Deposito;
	private String Modelo;
	
	public vehiculo(String matricula,String marca,int Deposito,String Modelo) {
		
		this.matricula = matricula;
		this.marca = marca ;
		this.Deposito = Deposito;
		this.Modelo = Modelo;
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getDeposito() {
		return Deposito;
	}

	public void setDeposito(int deposito) {
		Deposito = deposito;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	
	
}
