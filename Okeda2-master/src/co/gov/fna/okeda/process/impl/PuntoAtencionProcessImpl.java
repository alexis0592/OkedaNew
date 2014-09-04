package co.gov.fna.okeda.process.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Ubicacion;
import co.gov.fna.okeda.persistence.dao.impl.PuntoAtencionDAOImpl;
import co.gov.fna.okeda.persistence.sqlite.contract.PuntoAtencionContract;
import co.gov.fna.okeda.process.IPuntoAtencionProcess;

public class PuntoAtencionProcessImpl implements IPuntoAtencionProcess {

	private PuntoAtencionDAOImpl puntoAtencionDAOImpl;

	public PuntoAtencionProcessImpl(Context context) {
		super();
		this.puntoAtencionDAOImpl = PuntoAtencionDAOImpl.getInstance(context);
	}

	@Override
	public PuntoAtencion savePuntoAtencion(PuntoAtencion puntoAtencion) {
		return ((this.puntoAtencionDAOImpl.save(this
				.convertPuntoAtencionToContentValues(puntoAtencion)) != null) ? puntoAtencion
				: null);
	}

	@Override
	public PuntoAtencion updatePuntoAtencion(PuntoAtencion puntoAtencion) {
		return null;
	}

	@Override
	public List<PuntoAtencion> findAllPuntosAtencion() {

		try {
			List<ContentValues> contentValuesList = this.puntoAtencionDAOImpl
					.findAll(Boolean.FALSE, PuntoAtencionContract.TABLE_NAME,
							PuntoAtencionContract.Column.getAllColumns(), null,
							null, null, null, null, null);
			List<PuntoAtencion> puntoAtencionList = new ArrayList<PuntoAtencion>();

			for (ContentValues contentValues : contentValuesList) {
				puntoAtencionList
						.add(convertContentValueToPuntoAtencion(contentValues));
			}
			return puntoAtencionList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	private ContentValues convertPuntoAtencionToContentValues(
			PuntoAtencion puntoAtencion) {
		ContentValues contentValues = new ContentValues();

		contentValues.put(PuntoAtencionContract.Column.PARTITION_KEY,
				puntoAtencion.getPartitionKey());
		contentValues.put(
				PuntoAtencionContract.Column.CEDULA_O_CODIGO_DE_BARRAS,
				puntoAtencion.getCedulaCodigoBarras());
		contentValues.put(PuntoAtencionContract.Column.COSTO_DE_TRANSACCION,
				puntoAtencion.getCostoTransaccion());
		contentValues.put(PuntoAtencionContract.Column.DEPARTAMENTO,
				puntoAtencion.getDepartamento());
		contentValues.put(PuntoAtencionContract.Column.DIRECCION,
				puntoAtencion.getDireccion());
		contentValues.put(PuntoAtencionContract.Column.HORARIO_DE_ATENCION,
				puntoAtencion.getHorarioAtencion());
		contentValues.put(PuntoAtencionContract.Column.HORARIO_EXTENDIDO,
				puntoAtencion.getHorarioExtendido());
		contentValues.put(PuntoAtencionContract.Column.LATITUD, puntoAtencion
				.getUbicacion().getLatitud());
		contentValues.put(PuntoAtencionContract.Column.LONGITUD, puntoAtencion
				.getUbicacion().getLonguitud());
		contentValues.put(PuntoAtencionContract.Column.MUNICIPIO,
				puntoAtencion.getMunicipioCiudad());
		contentValues.put(PuntoAtencionContract.Column.NO,
				puntoAtencion.getNumero());
		contentValues.put(PuntoAtencionContract.Column.TIPO_DE_ENTIDAD,
				puntoAtencion.getTipoEntidad());
		contentValues
				.put(PuntoAtencionContract.Column.TIPO_DE_SERVICIO_QUE_OFRECE_AL_AFILIADO,
						puntoAtencion.getTipoServicioOfrecido());

		return (contentValues);
	}

	public PuntoAtencion convertContentValueToPuntoAtencion(
			ContentValues contentValues) {
		PuntoAtencion puntoAtencion = new PuntoAtencion();

		puntoAtencion.setPartitionKey(contentValues
				.getAsString(PuntoAtencionContract.Column.PARTITION_KEY));
		puntoAtencion
				.setCedulaCodigoBarras(contentValues
						.getAsString(PuntoAtencionContract.Column.CEDULA_O_CODIGO_DE_BARRAS));
		puntoAtencion
				.setCostoTransaccion(contentValues
						.getAsString(PuntoAtencionContract.Column.COSTO_DE_TRANSACCION));
		puntoAtencion.setDepartamento(contentValues
				.getAsString(PuntoAtencionContract.Column.DEPARTAMENTO));
		puntoAtencion.setDireccion(contentValues
				.getAsString(PuntoAtencionContract.Column.DIRECCION));
		puntoAtencion.setHorarioAtencion(contentValues
				.getAsString(PuntoAtencionContract.Column.HORARIO_DE_ATENCION));
		puntoAtencion.setHorarioExtendido(contentValues
				.getAsString(PuntoAtencionContract.Column.HORARIO_EXTENDIDO));
		puntoAtencion.setMunicipioCiudad(contentValues
				.getAsString(PuntoAtencionContract.Column.MUNICIPIO));
		puntoAtencion.setNumero(contentValues
				.getAsString(PuntoAtencionContract.Column.NO));
		puntoAtencion.setTipoEntidad(contentValues
				.getAsString(PuntoAtencionContract.Column.TIPO_DE_ENTIDAD));
		puntoAtencion
				.setTipoServicioOfrecido(contentValues
						.getAsString(PuntoAtencionContract.Column.TIPO_DE_SERVICIO_QUE_OFRECE_AL_AFILIADO));
		Ubicacion ubicacion = new Ubicacion(0.0, 0.0);
		ubicacion.setLatitud(contentValues
				.getAsDouble(PuntoAtencionContract.Column.LATITUD));
		ubicacion.setLonguitud(contentValues
				.getAsDouble(PuntoAtencionContract.Column.LONGITUD));

		return puntoAtencion;
	}

}
