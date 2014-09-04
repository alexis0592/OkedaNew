package co.gov.fna.okeda.modelo.entidades;

public  abstract class Entidades {
	
	private Ubicacion ubicacion;
	private String departamento;
	private String municipioCiudad;
	

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipioCiudad() {
		return municipioCiudad;
	}

	public void setMunicipioCiudad(String municipioCiudad) {
		this.municipioCiudad = municipioCiudad;
	}
	
	
	
	
}
