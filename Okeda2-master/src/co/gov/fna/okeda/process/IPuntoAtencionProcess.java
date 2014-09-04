package co.gov.fna.okeda.process;

import java.util.List;

import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;

public interface IPuntoAtencionProcess {

	public PuntoAtencion savePuntoAtencion(PuntoAtencion puntoAtencion);

	public PuntoAtencion updatePuntoAtencion(PuntoAtencion puntoAtencion);

	public List<PuntoAtencion> findAllPuntosAtencion();
}
