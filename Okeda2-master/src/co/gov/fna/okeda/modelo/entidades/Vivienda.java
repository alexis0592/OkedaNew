package co.gov.fna.okeda.modelo.entidades;

import android.graphics.Bitmap;

import java.util.List;


/**
 * Created by Oscar Gallon
 */
public class Vivienda extends Entidades {

    private String aplicaSubsidio;
    private String telefonoCelularSalaDeVentas;
    private String direccionSalaDeVentas;
    private List<Bitmap> imagenes;
    private String direccionSedePrincipalConstructora;
    private String areaDesde;
    private String emailConstructora;
    private String estadoObra;
    private String caracteristicasProyecto;
    private String fechaDeEntrega;
    private String horaDeAtencionHasta;
    private String acabado;
    private String diaDeAtencionDesde;
    private String telefonoFijoSalaDeVentas;
    private String cuotaInicial;
    private String cuotaMensual;
    private List<String> urlImagenes;
    private String localidadoZona;
    private String tipoInmuebleOfrecido;
    private String nombreRepresentanteLegalConstructora;
    private String creditoFna;
    private String claseDEVivienda;
    private String nombreContactoConstructora;
    private String nombreContatoSalaDeVentas;
    private String horaDeAtencionDesde;
    private String valorInmueble;
    private String estrato;
    private String barrio;
    private String diaDeAtencionHasta;
    private String areHasta;
    private String cantidadDeInmueblesDisponibles;
    private String telefonoContactContructora;
    private String nitConstructora;
    private String direccionProyecto;
    private String precioDesde;
    private String precioHasta;
    private String nombreConstructora;
    private String nombreProyecto;
    private String partitionKey;
    

    

    public Vivienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    public Vivienda(String partitionKey){
    	this.setPartitionKey(partitionKey);
    }

 
    
    public String getPartitionKey() {

        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public String getAplicaSubsidio() {
        return aplicaSubsidio;
    }

    public void setAplicaSubsidio(String aplicaSubsidio) {
        this.aplicaSubsidio = aplicaSubsidio;
    }

    public String getPrecioHasta() {
        return precioHasta;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public void setPrecioHasta(String precioHasta) {
        this.precioHasta = precioHasta;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

 

    public String getTelefonoCelularSalaDeVentas() {
        return telefonoCelularSalaDeVentas;
    }

    public void setTelefonoCelularSalaDeVentas(String telefonoCelularSalaDeVentas) {
        this.telefonoCelularSalaDeVentas = telefonoCelularSalaDeVentas;
    }

    public String getDireccionSalaDeVentas() {
        return direccionSalaDeVentas;
    }

    public void setDireccionSalaDeVentas(String direccionSalaDeVentas) {
        this.direccionSalaDeVentas = direccionSalaDeVentas;
    }

    public List<Bitmap> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Bitmap> imagenes) {
        this.imagenes = imagenes;
    }

    public String getDireccionSedePrincipalConstructora() {
        return direccionSedePrincipalConstructora;
    }

    public void setDireccionSedePrincipalConstructora(String direccionSedePrincipalConstructora) {
        this.direccionSedePrincipalConstructora = direccionSedePrincipalConstructora;
    }

    public String getAreaDesde() {
        return areaDesde;
    }

    public void setAreaDesde(String areaDesde) {
        this.areaDesde = areaDesde;
    }

    public String getEmailConstructora() {
        return emailConstructora;
    }

    public void setEmailConstructora(String emailConstructora) {
        this.emailConstructora = emailConstructora;
    }

    public String getEstadoObra() {
        return estadoObra;
    }

    public void setEstadoObra(String estadoObra) {
        this.estadoObra = estadoObra;
    }

    public String getCaracteristicasProyecto() {
        return caracteristicasProyecto;
    }

    public void setCaracteristicasProyecto(String caracteristicasProyecto) {
        this.caracteristicasProyecto = caracteristicasProyecto;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public String getHoraDeAtencionHasta() {
        return horaDeAtencionHasta;
    }

    public void setHoraDeAtencionHasta(String horaDeAtencionHasta) {
        this.horaDeAtencionHasta = horaDeAtencionHasta;
    }

    public String getAcabado() {
        return acabado;
    }

    public void setAcabado(String acabado) {
        this.acabado = acabado;
    }

    public String getDiaDeAtencionDesde() {
        return diaDeAtencionDesde;
    }

    public void setDiaDeAtencionDesde(String diaDeAtencionDesde) {
        this.diaDeAtencionDesde = diaDeAtencionDesde;
    }

    public String getTelefonoFijoSalaDeVentas() {
        return telefonoFijoSalaDeVentas;
    }

    public void setTelefonoFijoSalaDeVentas(String telefonoFijoSalaDeVentas) {
        this.telefonoFijoSalaDeVentas = telefonoFijoSalaDeVentas;
    }



    public String getCuotaInicial() {
        return cuotaInicial;
    }

    public void setCuotaInicial(String cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }

    public List<String> getUrlImagenes() {
        return urlImagenes;
    }

    public void setUrlImagenes(List<String> urlImagenes) {
        this.urlImagenes = urlImagenes;
    }

    public String getLocalidadoZona() {
        return localidadoZona;
    }

    public void setLocalidadoZona(String localidadoZona) {
        this.localidadoZona = localidadoZona;
    }

    public String getTipoInmuebleOfrecido() {
        return tipoInmuebleOfrecido;
    }

    public void setTipoInmuebleOfrecido(String tipoInmuebleOfrecido) {
        this.tipoInmuebleOfrecido = tipoInmuebleOfrecido;
    }

    public String getNombreRepresentanteLegalConstructora() {
        return nombreRepresentanteLegalConstructora;
    }

    public void setNombreRepresentanteLegalConstructora(String nombreRepresentanteLegalConstructora) {
        this.nombreRepresentanteLegalConstructora = nombreRepresentanteLegalConstructora;
    }

    public String getCreditoFna() {
        return creditoFna;
    }

    public void setCreditoFna(String creditoFna) {
        this.creditoFna = creditoFna;
    }



    public String getClaseDEVivienda() {
        return claseDEVivienda;
    }

    public void setClaseDEVivienda(String claseDEVivienda) {
        this.claseDEVivienda = claseDEVivienda;
    }

    public String getNombreContactoConstructora() {
        return nombreContactoConstructora;
    }

    public void setNombreContactoConstructora(String nombreContactoConstructora) {
        this.nombreContactoConstructora = nombreContactoConstructora;
    }

    public String getNombreContatoSalaDeVentas() {
        return nombreContatoSalaDeVentas;
    }

    public void setNombreContatoSalaDeVentas(String nombreContatoSalaDeVentas) {
        this.nombreContatoSalaDeVentas = nombreContatoSalaDeVentas;
    }

    public String getHoraDeAtencionDesde() {
        return horaDeAtencionDesde;
    }

    public void setHoraDeAtencionDesde(String horaDeAtencionDesde) {
        this.horaDeAtencionDesde = horaDeAtencionDesde;
    }

    public String getValorInmueble() {
        return valorInmueble;
    }

    public void setValorInmueble(String valorInmueble) {
        this.valorInmueble = valorInmueble;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDiaDeAtencionHasta() {
        return diaDeAtencionHasta;
    }

    public void setDiaDeAtencionHasta(String diaDeAtencionHasta) {
        this.diaDeAtencionHasta = diaDeAtencionHasta;
    }

    public String getAreHasta() {
        return areHasta;
    }

    public void setAreHasta(String areHasta) {
        this.areHasta = areHasta;
    }

    public String getCantidadDeInmueblesDisponibles() {
        return cantidadDeInmueblesDisponibles;
    }

    public void setCantidadDeInmueblesDisponibles(String cantidadDeInmueblesDisponibles) {
        this.cantidadDeInmueblesDisponibles = cantidadDeInmueblesDisponibles;
    }

    public String getTelefonoContactContructora() {
        return telefonoContactContructora;
    }

    public void setTelefonoContactContructora(String telefonoContactContructora) {
        this.telefonoContactContructora = telefonoContactContructora;
    }

    public String getNitConstructora() {
        return nitConstructora;
    }

    public void setNitConstructora(String nitConstructora) {
        this.nitConstructora = nitConstructora;
    }

    public String getDireccionProyecto() {
        return direccionProyecto;
    }

    public void setDireccionProyecto(String direccionProyecto) {
        this.direccionProyecto = direccionProyecto;
    }

    public String getPrecioDesde() {
        return precioDesde;
    }

    public void setPrecioDesde(String precioDesde) {
        this.precioDesde = precioDesde;
    }

    public String getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(String cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }
}
