package co.gov.fna.okeda.persistencia.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import co.gov.fna.okeda.persistence.sqlite.contract.PersistanceContract;
import co.gov.fna.okeda.persistence.sqlite.contract.PuntoAtencionContract;
import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class AccessorSqliteOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = AccessorSqliteOpenHelper.class
			.getSimpleName();

	public AccessorSqliteOpenHelper(Context context) {
		super(context, PersistanceContract.DATABASE_NAME, null,
				PersistanceContract.DATABASE_VERSION);
		Log.d(TAG, "Se creo la Base de datos");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String viviendasTableSqlCreator = String
				.format("CREATE TABLE %s (" +
						"%s TEXT PRIMARY KEY," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT,"
						+ "%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT"
						+ ",%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT,"
						+ "%s TEXT," +
						"%s TEXT," +
						"%s TEXT"
						+ ",%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT,"
						+ "%s TEXT," +
						"%s TEXT"
						+ ",%s REAL ," +
						"%s TEXT," +
						"%s REAL," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT"
						+ ",%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s TEXT);",
						ViviendaContract.TABLE_NAME,
						ViviendaContract.Column.PARTITION_KEY,
						ViviendaContract.Column.ACABADOS,
						ViviendaContract.Column.APLICA_SUBSIDIO,
						ViviendaContract.Column.AREA_DESDE,
						ViviendaContract.Column.AREA_HASTA,
						ViviendaContract.Column.BARRIO,
						ViviendaContract.Column.CANTIDADDE_INMUEBLES_DISPONIBLES,
						ViviendaContract.Column.CARACTERISTICAS_PROYECTO,
						ViviendaContract.Column.CLASE_DE_VIVIENDA,
						ViviendaContract.Column.CREDITO_FNA,
						ViviendaContract.Column.CIUDAD,
						ViviendaContract.Column.CUOTA_INICIAL,
						ViviendaContract.Column.CUOTA_MENSUAL,
						ViviendaContract.Column.DEPARTAMENTO,
						ViviendaContract.Column.DIA_DE_ATENCION_DESDE,
						ViviendaContract.Column.DIA_DE_ATENCION_HASTA,
						ViviendaContract.Column.DIRECCION_PROYECTO,
						ViviendaContract.Column.DIRECCION_SALA_DE_VENTAS,
						ViviendaContract.Column.DIRECCION_SEDE_PRINCIPAL_CONSTRUCTORA,
						ViviendaContract.Column.EMAIL_CONSTRUCTORA,
						ViviendaContract.Column.ESTADO_OBRA,
						ViviendaContract.Column.FECHA_DE_ENTREGA,
						ViviendaContract.Column.HORA_DE_ATENCION_HASTA,
						ViviendaContract.Column.HORARIO_DE_ATENCION_DESDE,
						ViviendaContract.Column.IMAGEN_PRINCIPAL,
						ViviendaContract.Column.IMAGEN1,
						ViviendaContract.Column.IMAGEN2,
						ViviendaContract.Column.IMAGEN3,
						ViviendaContract.Column.IMAGEN4,
						ViviendaContract.Column.IMAGEN5,
						ViviendaContract.Column.LATITUD,
						ViviendaContract.Column.LOCALIDAD_O_ZONA,
						ViviendaContract.Column.LONGITUD,
						ViviendaContract.Column.NIT_CONSTRUCTORA,
						ViviendaContract.Column.NOMBRE_CONSTRUCTORA,
						ViviendaContract.Column.NOMBRE_CONTACTO_CONSTRUCTORA,
						ViviendaContract.Column.NOMBRE_CONTACTO_SALA_DE_VENTA,
						ViviendaContract.Column.NOMBRE_PROYECTO,
						ViviendaContract.Column.NOMBRE_REPRESENTANTE_LEGAL_CONSTRUCTORA,
						ViviendaContract.Column.PRECIO_DESDE,
						ViviendaContract.Column.PRECIO_HASTA,
						ViviendaContract.Column.TELEFONO_CELULAR_SALA_DE_VENTAS,
						ViviendaContract.Column.TELEFONO_CONTACTO_CONSTRUCTORA,
						ViviendaContract.Column.TELEFONO_FIJO_SALA_DE_VENTAS,
						ViviendaContract.Column.TIPO_DE_INMUEBLE_OFRECIDO,
						ViviendaContract.Column.VALOR_INMUBLE);

		String puntoAtencionSqlCreator = String
				.format("CREATE TABLE %s(" +
						"%s TEXT PRIMARY KEY," +
						" %s TEXT," +
						" %s TEXT," +
						"%s TEXT,"
						+ "%s TEXT," +
						"%s TEXT," +
						"%s TEXT," +
						"%s REAL," +
						"%s REAL," +
						"%s TEXT,"
						+ "%s TEXT," +
						"%s TEXT," +
						"%s TEXT);",
						PuntoAtencionContract.TABLE_NAME,
						PuntoAtencionContract.Column.PARTITION_KEY,
						PuntoAtencionContract.Column.CEDULA_O_CODIGO_DE_BARRAS,
						PuntoAtencionContract.Column.COSTO_DE_TRANSACCION,
						PuntoAtencionContract.Column.DEPARTAMENTO,
						PuntoAtencionContract.Column.DIRECCION,
						PuntoAtencionContract.Column.HORARIO_DE_ATENCION,
						PuntoAtencionContract.Column.HORARIO_EXTENDIDO,
						PuntoAtencionContract.Column.LATITUD,
						PuntoAtencionContract.Column.LONGITUD,
						PuntoAtencionContract.Column.MUNICIPIO,
						PuntoAtencionContract.Column.NO,
						PuntoAtencionContract.Column.TIPO_DE_ENTIDAD,
						PuntoAtencionContract.Column.TIPO_DE_SERVICIO_QUE_OFRECE_AL_AFILIADO);

		Log.d(TAG, viviendasTableSqlCreator);
		Log.d(TAG, puntoAtencionSqlCreator);

		db.execSQL(viviendasTableSqlCreator);
		db.execSQL(puntoAtencionSqlCreator);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL(String.format("DROP TABLE IF EXISTS %s",
				ViviendaContract.TABLE_NAME));
		db.execSQL((String.format("DROP TABLE IF EXISTS %s",
				PuntoAtencionContract.TABLE_NAME)));

		this.onCreate(db);

	}
}
