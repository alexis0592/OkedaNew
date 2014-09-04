package co.gov.fna.okeda.process;

import java.util.List;

import co.gov.fna.okeda.modelo.entidades.Vivienda;

public interface IViviendaProcess {
	
	public Vivienda saveVivienda(Vivienda vivienda);
	
	public Vivienda updateVivienda(Vivienda vivienda);
	
	public List<Vivienda> findAllViviendas();

}
