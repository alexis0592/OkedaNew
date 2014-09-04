package co.gov.fna.okeda.interfaces;

import java.util.List;

import co.gov.fna.okeda.modelo.entidades.Entidades;

public interface IBusquedaCriteros {
	
	//MEtodos para Vienda
	public List<String> getDepartments(List<Entidades> listaEntidades);
	public List<String> getCiudadesOrMunicipios(List<Entidades> listaEntidades);
	public List<String> getEstadoObra(List<Entidades> listaEntidades);
	
	//MEtodo para PuntoAtencion
	public List<String> getCostos(List<Entidades> listaEntidades);
	public List<String> getTipo(List<Entidades> listaEntidades);
	
	
	
	public boolean isElementOnList(String s, List<String> lista);
	
}
