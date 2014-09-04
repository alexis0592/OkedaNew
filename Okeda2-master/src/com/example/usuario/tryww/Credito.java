package com.example.usuario.tryww;


import java.util.ArrayList;
import java.util.List;

public class Credito {
	
	private List<String> valorCredito;
	
	private List<String> entidad;
	private List<String> interes;
	
	public Credito(){
		
	}

	public List<String> getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito() {
		this.valorCredito = new ArrayList<String>();
		this.valorCredito.add("1'500.000");
		this.valorCredito.add("3'450.000");
		this.valorCredito.add("10'000.000");
		this.valorCredito.add("7'850.000");
		this.valorCredito.add("23'850.000");
		this.valorCredito.add("4'850.000");
		this.valorCredito.add("6'850.000");
		this.valorCredito.add("12'850.000");
		this.valorCredito.add("45'850.000");
		this.valorCredito.add("17'850.000");
		
	}

	public List<String> getEntidad() {
		return entidad;
	}

	public void setEntidad() {
		this.entidad = new ArrayList<String>();
		this.entidad.add("Bancolombia");
		this.entidad.add("Fondo Nacional del Ahorro");
		this.entidad.add("Banco de Bogota");
		this.entidad.add("ICETEX");
	}

	public List<String> getInteres() {
		return interes;
	}

	public void setInteres() {
		this.interes = new ArrayList<String>();
		this.interes.add("0.5");
		this.interes.add("0.2");
		this.interes.add("0.8");
	}
	
	
	
	
	

}
