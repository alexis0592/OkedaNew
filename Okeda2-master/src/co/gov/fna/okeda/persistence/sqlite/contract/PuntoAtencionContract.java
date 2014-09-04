package co.gov.fna.okeda.persistence.sqlite.contract;

public class PuntoAtencionContract extends PersistanceContract {

	public static final String TABLE_NAME = "PUNTO_ATENCION";

	public PuntoAtencionContract() {
		super();
	}

	public static final class Column {

		public static final String CEDULA_O_CODIGO_DE_BARRAS = "cedula_o_codigo_de_barras";
		public static final String COSTO_DE_TRANSACCION = "costo_de_transaccion";
		public static final String DEPARTAMENTO = "departamento";
		public static final String DIRECCION = "direccion";
		public static final String HORARIO_DE_ATENCION = "horario_atencion";
		public static final String HORARIO_EXTENDIDO = "horario_extendido";
		public static final String LATITUD = "latitud";
		public static final String LONGITUD = "longitud";
		public static final String MUNICIPIO = "municipio";
		public static final String NO = "no";
		public static final String PARTITION_KEY = "partition_key";
		public static final String TIPO_DE_ENTIDAD = "tipo_entidad";
		public static final String TIPO_DE_SERVICIO_QUE_OFRECE_AL_AFILIADO = "tipo_de_servicio_que_ofrece_al_afiliado";

		public static final String[] getAllColumns() {

			return (new String[] { CEDULA_O_CODIGO_DE_BARRAS,
					COSTO_DE_TRANSACCION, DEPARTAMENTO, DIRECCION,
					HORARIO_DE_ATENCION, HORARIO_EXTENDIDO, LATITUD, LONGITUD,
					MUNICIPIO, NO, PARTITION_KEY, TIPO_DE_ENTIDAD,
					TIPO_DE_SERVICIO_QUE_OFRECE_AL_AFILIADO});
		}
	}

}
