package co.gov.fna.okeda.interfaces.impl;

import android.provider.CalendarContract.Instances;
import co.gov.fna.okeda.interfaces.IFactoryEntidades;
import co.gov.fna.okeda.modelo.entidades.Entidades;

public class FactoryEntidades implements IFactoryEntidades {

	private static FactoryEntidades instance;
	private Entidades entidad;

	private FactoryEntidades() {

	}

	public static FactoryEntidades getInstance() {
		if (instance == null)
			instance = new FactoryEntidades();
		return instance;
	}

	@Override
	public Entidades getEntidadInCurrentActivity() {
		// TODO Auto-generated method stub
		return this.entidad;
	}

	@Override
	public void setEntidadInCurrentActivity(Entidades entidades) {
		// TODO Auto-generated method stub
		this.entidad = entidades;
	}

}
