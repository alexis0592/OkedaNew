package co.gov.fna.okeda.modelo.entidades;



public class PuntoAtencion extends Entidades {


    

	private String tipoEntidad;
	private String numero;
	private Ubicacion ubicacion;
	private String direccion;
	private String horarioAtencion;
	private String horarioExtendido;
	private String partitionKey;
	private String tipoServicioOfrecido;
	private String costoTransaccion;
	private String cedulaCodigoBarras;

	public PuntoAtencion(String tipoEntidad, String numero,
			Ubicacion ubicacion, String departamento, String municipio,
			String cedulaCodigoBarras) {
		setTipoEntidad(tipoEntidad);

		setNumero(numero);
		setUbicacion(ubicacion);
		setCedulaCodigoBarras(cedulaCodigoBarras);
	}

	public PuntoAtencion() {
	}

	public String getPartitionKey() {
		return partitionKey;
	}

	public void setPartitionKey(String partitionKey) {
		this.partitionKey = partitionKey;
	}

	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public String getHorarioExtendido() {
		return horarioExtendido;
	}

	public void setHorarioExtendido(String horarioExtendido) {
		this.horarioExtendido = horarioExtendido;
	}

	public String getTipoServicioOfrecido() {
		return tipoServicioOfrecido;
	}

	public void setTipoServicioOfrecido(String tipoServicioOfrecido) {
		this.tipoServicioOfrecido = tipoServicioOfrecido;
	}

	public String getCostoTransaccion() {
		return costoTransaccion;
	}

	public void setCostoTransaccion(String costoTransaccion) {
		this.costoTransaccion = costoTransaccion;
	}

	public String getCedulaCodigoBarras() {
		return cedulaCodigoBarras;
	}

	public void setCedulaCodigoBarras(String cedulaCodigoBarras) {
		this.cedulaCodigoBarras = cedulaCodigoBarras;
	}

}
