package co.gov.fna.okeda.controladores;

import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.graphics.Bitmap;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.MostrarVivienda;
import co.gov.fna.okeda.servicios.ServicioImagenes;
import co.gov.fna.okeda.utilidades.Utilities;

public class ControladorMostrarVivienda {
	private Vivienda vivienda;
	private MostrarVivienda actividad;
	private Utilities util;
	private static ControladorMostrarVivienda instance;
	private ServicioImagenes servicesImagenes;

	private ControladorMostrarVivienda() {

	}

	public static ControladorMostrarVivienda getInstace() {
		if (instance == null) {
			instance = new ControladorMostrarVivienda();
		}
		return instance;
	}

	public void goForImagenes() {
		servicesImagenes = new ServicioImagenes(getInstace());
		servicesImagenes.setUrls(vivienda.getUrlImagenes());
		servicesImagenes.execute();
	}

	public void muestraImagenes() {
		for (int i = 0; i < vivienda.getImagenes().size(); i++) {
			if (i == 0)
				actividad.getIm1()
						.setImageBitmap(vivienda.getImagenes().get(i));
			if (i == 1)
				actividad.getIm2()
						.setImageBitmap(vivienda.getImagenes().get(i));
			if (i == 2)
				actividad.getIm3()
						.setImageBitmap(vivienda.getImagenes().get(i));
			if (i == 3)
				actividad.getIm4()
						.setImageBitmap(vivienda.getImagenes().get(i));
			if (i == 4)
				actividad.getIm5()
						.setImageBitmap(vivienda.getImagenes().get(i));
			if (i == 5)
				actividad.getIm6()
						.setImageBitmap(vivienda.getImagenes().get(i));

		}
	}

	public void findRating(Vivienda v) {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("vivienda");
		query.whereEqualTo("partitionKey", v.getPartitionKey());
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> scoreList, ParseException e) {
				if (e == null) {
					if (!scoreList.isEmpty())
						setRating(scoreList.get(0));

				} else {

				}
			}
		});

	}

	public void setRating(ParseObject p) {
		int x = p.getInt("puntuacionPromedio");
		if (x!=0) {
			float i = (float)x;
			this.getActividad().getRating().setRating(i);
		} else {
			float i = 3;
			this.getActividad().getRating().setRating(i);
		}
	}

	public void showViviendaInformation() {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {

			// this.actividad.getRating().setRating(rating)
			findRating(vivienda);
			this.actividad.getTxtNombreProyecto().setText(
					"Nombre Proyecto: " + vivienda.getNombreProyecto());
			this.actividad.getTxtClaseDeVivienda().setText(
					"Clase de Vivienda: " + vivienda.getClaseDEVivienda());
			this.actividad.getTxtDepartamento().setText(
					"Departamento: " + vivienda.getDepartamento());
			this.actividad.getTxtCiudad().setText(
					"Municipio: " + vivienda.getMunicipioCiudad());
			this.actividad.getTxtEstrato().setText(
					"Estrato: " + vivienda.getEstrato());
			this.actividad.getTxtEstadoObra().setText(
					"Estado Obra: " + vivienda.getEstadoObra());
			this.actividad.getTxtFechaEntrega().setText(
					"Fecha Entrega: " + vivienda.getFechaDeEntrega());
			this.actividad.getTxtValorInmueble().setText(
					"Valor Inmueble: " + vivienda.getValorInmueble());
			this.actividad.getTxtCuotaInicial().setText(
					"Cuota Inicial: " + vivienda.getCuotaInicial());
			this.actividad.getTxtCuotaMensual().setText(
					"Cuota Mensual: " + vivienda.getCuotaMensual());
			this.actividad.getTxtDireccionSalaDeVentas().setText(
					"Direccion Sala de Ventas: "
							+ vivienda.getDireccionSalaDeVentas());
		}
	}

	public void showMessage(String title, String menssage) {

		util.showAlertMessage(title, menssage);
	}

	public void showProgressDialogImagenes() {
		util.showDialog("ESspere", "LLendo Por Las Imagenes Espere Por Favor",
				true);
	}

	public void cancellProgressDialog() {
		util.cancellDialog();
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public MostrarVivienda getActividad() {
		return actividad;
	}

	public void setActividad(MostrarVivienda actividad) {
		util = new Utilities(actividad);
		this.actividad = actividad;
	}

	public Utilities getUtil() {
		return util;
	}

	public void setUtil(Utilities util) {
		this.util = util;
	}

}
