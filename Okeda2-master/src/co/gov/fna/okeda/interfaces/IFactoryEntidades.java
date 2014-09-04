package co.gov.fna.okeda.interfaces;

import co.gov.fna.okeda.modelo.entidades.Entidades;

public interface IFactoryEntidades {
	public Entidades getEntidadInCurrentActivity();
	public void setEntidadInCurrentActivity(Entidades entidades);
}
