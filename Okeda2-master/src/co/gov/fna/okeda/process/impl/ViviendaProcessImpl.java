package co.gov.fna.okeda.process.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import co.gov.fna.okeda.modelo.entidades.Ubicacion;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.persistence.dao.impl.ViviendaDAOImpl;
import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;
import co.gov.fna.okeda.process.IViviendaProcess;

public class ViviendaProcessImpl implements IViviendaProcess {

	private ViviendaDAOImpl viviendaDAOImpl;

	public ViviendaProcessImpl(Context context) {
		super();
		this.viviendaDAOImpl = ViviendaDAOImpl.getInstance(context);
	}

	@Override
	public Vivienda saveVivienda(Vivienda vivienda) {

		return ((this.viviendaDAOImpl.save(this
				.convertViviendaToContentValues(vivienda)) != null) ? vivienda
				: null);
	}

	@Override
	public Vivienda updateVivienda(Vivienda vivienda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vivienda> findAllViviendas() {

		try {
			List<ContentValues> contentValuesList = this.viviendaDAOImpl
					.findAll(Boolean.FALSE, ViviendaContract.TABLE_NAME,
							ViviendaContract.Column.getAllColumns(), null,
							null, null, null, null, null);
			List<Vivienda> viviendaslList = new ArrayList<Vivienda>();

			for (ContentValues contentValues : contentValuesList) {
				viviendaslList
						.add(convertContentValueToVivienda(contentValues));
			}

			return viviendaslList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private ContentValues convertViviendaToContentValues(Vivienda vivienda) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(ViviendaContract.Column.PARTITION_KEY,
				vivienda.getPartitionKey());
		contentValues.put(ViviendaContract.Column.ACABADOS,
				vivienda.getAcabado());
		contentValues.put(ViviendaContract.Column.APLICA_SUBSIDIO,
				vivienda.getAplicaSubsidio());
		contentValues.put(ViviendaContract.Column.AREA_DESDE,
				vivienda.getAreaDesde());
		contentValues.put(ViviendaContract.Column.AREA_HASTA,
				vivienda.getAreHasta());
		contentValues.put(ViviendaContract.Column.BARRIO, vivienda.getBarrio());
		contentValues.put(
				ViviendaContract.Column.CANTIDADDE_INMUEBLES_DISPONIBLES,
				vivienda.getCantidadDeInmueblesDisponibles());
		contentValues.put(ViviendaContract.Column.CARACTERISTICAS_PROYECTO,
				vivienda.getCaracteristicasProyecto());
		contentValues.put(ViviendaContract.Column.CIUDAD,
				vivienda.getMunicipioCiudad());
		contentValues.put(ViviendaContract.Column.CLASE_DE_VIVIENDA,
				vivienda.getClaseDEVivienda());
		contentValues.put(ViviendaContract.Column.CREDITO_FNA,
				vivienda.getCreditoFna());
		contentValues.put(ViviendaContract.Column.CUOTA_INICIAL,
				vivienda.getCuotaInicial());
		contentValues.put(ViviendaContract.Column.CUOTA_MENSUAL,
				vivienda.getCuotaMensual());
		contentValues.put(ViviendaContract.Column.DEPARTAMENTO,
				vivienda.getDepartamento());
		contentValues.put(ViviendaContract.Column.DIA_DE_ATENCION_DESDE,
				vivienda.getDiaDeAtencionDesde());
		contentValues.put(ViviendaContract.Column.DIA_DE_ATENCION_HASTA,
				vivienda.getDiaDeAtencionHasta());
		contentValues.put(ViviendaContract.Column.DIRECCION_PROYECTO,
				vivienda.getDireccionProyecto());
		contentValues.put(ViviendaContract.Column.DIRECCION_SALA_DE_VENTAS,
				vivienda.getDireccionSalaDeVentas());
		contentValues.put(
				ViviendaContract.Column.DIRECCION_SEDE_PRINCIPAL_CONSTRUCTORA,
				vivienda.getDireccionSedePrincipalConstructora());
		contentValues.put(ViviendaContract.Column.EMAIL_CONSTRUCTORA,
				vivienda.getEmailConstructora());
		contentValues.put(ViviendaContract.Column.ESTADO_OBRA,
				vivienda.getEstadoObra());
		contentValues.put(ViviendaContract.Column.FECHA_DE_ENTREGA,
				vivienda.getFechaDeEntrega());
		contentValues.put(ViviendaContract.Column.HORA_DE_ATENCION_HASTA,
				vivienda.getHoraDeAtencionHasta());
		contentValues.put(ViviendaContract.Column.HORARIO_DE_ATENCION_DESDE,
				vivienda.getHoraDeAtencionDesde());
		contentValues.put(ViviendaContract.Column.IMAGEN_PRINCIPAL, vivienda
				.getUrlImagenes().get(0));
		contentValues.put(ViviendaContract.Column.IMAGEN1, vivienda
				.getUrlImagenes().get(1));
		contentValues.put(ViviendaContract.Column.IMAGEN2, vivienda
				.getUrlImagenes().get(2));
		contentValues.put(ViviendaContract.Column.IMAGEN3, vivienda
				.getUrlImagenes().get(3));
		contentValues.put(ViviendaContract.Column.IMAGEN4, vivienda
				.getUrlImagenes().get(4));
		contentValues.put(ViviendaContract.Column.IMAGEN5, vivienda
				.getUrlImagenes().get(5));
		contentValues.put(ViviendaContract.Column.LATITUD, vivienda
				.getUbicacion().getLatitud());
		contentValues.put(ViviendaContract.Column.LONGITUD, vivienda
				.getUbicacion().getLonguitud());
		contentValues.put(ViviendaContract.Column.LOCALIDAD_O_ZONA,
				vivienda.getLocalidadoZona());
		contentValues.put(ViviendaContract.Column.NIT_CONSTRUCTORA,
				vivienda.getNitConstructora());
		contentValues.put(ViviendaContract.Column.NOMBRE_CONSTRUCTORA,
				vivienda.getNombreConstructora());
		contentValues.put(ViviendaContract.Column.NOMBRE_CONTACTO_CONSTRUCTORA,
				vivienda.getNombreContactoConstructora());
		contentValues.put(
				ViviendaContract.Column.NOMBRE_CONTACTO_SALA_DE_VENTA,
				vivienda.getNombreContatoSalaDeVentas());
		contentValues.put(ViviendaContract.Column.NOMBRE_PROYECTO,
				vivienda.getNombreProyecto());
		contentValues
				.put(ViviendaContract.Column.NOMBRE_REPRESENTANTE_LEGAL_CONSTRUCTORA,
						vivienda.getNombreRepresentanteLegalConstructora());
		contentValues.put(ViviendaContract.Column.PRECIO_DESDE,
				vivienda.getPrecioDesde());
		contentValues.put(ViviendaContract.Column.PRECIO_HASTA,
				vivienda.getPrecioHasta());
		contentValues.put(
				ViviendaContract.Column.TELEFONO_CELULAR_SALA_DE_VENTAS,
				vivienda.getTelefonoCelularSalaDeVentas());
		contentValues.put(
				ViviendaContract.Column.TELEFONO_CONTACTO_CONSTRUCTORA,
				vivienda.getTelefonoContactContructora());
		contentValues.put(ViviendaContract.Column.TELEFONO_FIJO_SALA_DE_VENTAS,
				vivienda.getTelefonoFijoSalaDeVentas());
		contentValues.put(ViviendaContract.Column.VALOR_INMUBLE,
				vivienda.getValorInmueble());

		return (contentValues);

	}

	private Vivienda convertContentValueToVivienda(ContentValues contentValues) {
		Vivienda vivienda = new Vivienda();

		vivienda.setPartitionKey(contentValues
				.getAsString(ViviendaContract.Column.PARTITION_KEY));
		vivienda.setAcabado(contentValues
				.getAsString(ViviendaContract.Column.ACABADOS));
		vivienda.setAplicaSubsidio(contentValues
				.getAsString(ViviendaContract.Column.APLICA_SUBSIDIO));
		vivienda.setAreaDesde(contentValues
				.getAsString(ViviendaContract.Column.AREA_DESDE));
		vivienda.setAreHasta(contentValues
				.getAsString(ViviendaContract.Column.AREA_HASTA));
		vivienda.setBarrio(contentValues
				.getAsString(ViviendaContract.Column.BARRIO));
		vivienda.setCantidadDeInmueblesDisponibles(contentValues
				.getAsString(ViviendaContract.Column.CANTIDADDE_INMUEBLES_DISPONIBLES));
		vivienda.setCaracteristicasProyecto(contentValues
				.getAsString(ViviendaContract.Column.CARACTERISTICAS_PROYECTO));
		vivienda.setClaseDEVivienda(contentValues
				.getAsString(ViviendaContract.Column.CLASE_DE_VIVIENDA));
		vivienda.setCreditoFna(contentValues
				.getAsString(ViviendaContract.Column.CREDITO_FNA));
		vivienda.setCuotaInicial(contentValues
				.getAsString(ViviendaContract.Column.CUOTA_INICIAL));
		vivienda.setCuotaMensual(contentValues
				.getAsString(ViviendaContract.Column.CUOTA_MENSUAL));
		vivienda.setDepartamento(contentValues
				.getAsString(ViviendaContract.Column.DEPARTAMENTO));
		vivienda.setDiaDeAtencionDesde(contentValues
				.getAsString(ViviendaContract.Column.DIA_DE_ATENCION_DESDE));
		vivienda.setDiaDeAtencionHasta(contentValues
				.getAsString(ViviendaContract.Column.DIA_DE_ATENCION_HASTA));
		vivienda.setDireccionProyecto(contentValues
				.getAsString(ViviendaContract.Column.DIRECCION_PROYECTO));
		vivienda.setDireccionSalaDeVentas(contentValues
				.getAsString(ViviendaContract.Column.DIRECCION_SALA_DE_VENTAS));
		vivienda.setDireccionSedePrincipalConstructora(contentValues
				.getAsString(ViviendaContract.Column.DIRECCION_SEDE_PRINCIPAL_CONSTRUCTORA));
		vivienda.setEmailConstructora(contentValues
				.getAsString(ViviendaContract.Column.EMAIL_CONSTRUCTORA));
		vivienda.setEstadoObra(contentValues
				.getAsString(ViviendaContract.Column.ESTADO_OBRA));
		vivienda.setFechaDeEntrega(contentValues
				.getAsString(ViviendaContract.Column.FECHA_DE_ENTREGA));
		vivienda.setHoraDeAtencionDesde(contentValues
				.getAsString(ViviendaContract.Column.HORARIO_DE_ATENCION_DESDE));
		vivienda.setHoraDeAtencionHasta(contentValues
				.getAsString(ViviendaContract.Column.HORA_DE_ATENCION_HASTA));
		List<String> urlImagenes = new ArrayList<String>();
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN_PRINCIPAL));
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN1));
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN2));
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN3));
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN4));
		urlImagenes.add(contentValues
				.getAsString(ViviendaContract.Column.IMAGEN5));
		vivienda.setUrlImagenes(urlImagenes);
		vivienda.setLocalidadoZona(contentValues
				.getAsString(ViviendaContract.Column.LOCALIDAD_O_ZONA));
		vivienda.setNitConstructora(contentValues
				.getAsString(ViviendaContract.Column.NIT_CONSTRUCTORA));
		vivienda.setNombreConstructora(contentValues
				.getAsString(ViviendaContract.Column.NOMBRE_CONSTRUCTORA));
		vivienda.setNombreContactoConstructora(contentValues
				.getAsString(ViviendaContract.Column.NOMBRE_CONTACTO_CONSTRUCTORA));
		vivienda.setNombreContatoSalaDeVentas(contentValues
				.getAsString(ViviendaContract.Column.NOMBRE_CONTACTO_SALA_DE_VENTA));
		vivienda.setNombreProyecto(contentValues
				.getAsString(ViviendaContract.Column.NOMBRE_PROYECTO));
		vivienda.setNombreRepresentanteLegalConstructora(contentValues
				.getAsString(ViviendaContract.Column.NOMBRE_REPRESENTANTE_LEGAL_CONSTRUCTORA));
		vivienda.setPrecioDesde(contentValues
				.getAsString(ViviendaContract.Column.PRECIO_DESDE));
		vivienda.setPrecioHasta(contentValues
				.getAsString(ViviendaContract.Column.PRECIO_HASTA));
		vivienda.setTelefonoCelularSalaDeVentas(contentValues
				.getAsString(ViviendaContract.Column.TELEFONO_CELULAR_SALA_DE_VENTAS));
		vivienda.setTelefonoContactContructora(contentValues
				.getAsString(ViviendaContract.Column.TELEFONO_CONTACTO_CONSTRUCTORA));
		vivienda.setTelefonoFijoSalaDeVentas(contentValues
				.getAsString(ViviendaContract.Column.TELEFONO_FIJO_SALA_DE_VENTAS));
		vivienda.setTipoInmuebleOfrecido(contentValues
				.getAsString(ViviendaContract.Column.TIPO_DE_INMUEBLE_OFRECIDO));
		Ubicacion ubicacion = new Ubicacion(0.0, 0.0);
		ubicacion.setLatitud(contentValues
				.getAsDouble(ViviendaContract.Column.LATITUD));
		ubicacion.setLonguitud(contentValues
				.getAsDouble(ViviendaContract.Column.LONGITUD));
		vivienda.setUbicacion(ubicacion);
		vivienda.setValorInmueble(contentValues
				.getAsString(ViviendaContract.Column.VALOR_INMUBLE));

		return (vivienda);
	}

}
