package co.gov.fna.okeda.controladores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryPuntoAtencion;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.presentacion.actividades.LoginActitvity;
import co.gov.fna.okeda.presentacion.actividades.PuntoAtencionActivity;
import co.gov.fna.okeda.servicios.GetRestServices;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class ControladorPuntoAtencion {

	private String[] urlSet;
	private static ControladorPuntoAtencion instance;
	private PuntoAtencion puntoEscogido;
	private PuntoAtencionActivity activity;

	public static ControladorPuntoAtencion getInstace() {
		if (instance == null) {
			instance = new ControladorPuntoAtencion();
		}
		return instance;
	}

	public void setPuntoEscogido(PuntoAtencion punto) {
		this.puntoEscogido = punto;
	}

	public void showPunto() {

		if (puntoEscogido == null)
			return;
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		factoryEntidades.setEntidadInCurrentActivity(puntoEscogido);
		this.activity.txt0.setText(puntoEscogido.getTipoEntidad());
		this.activity.txt1.setText(puntoEscogido.getDepartamento());
		this.activity.txt2.setText(puntoEscogido.getMunicipioCiudad());
		this.activity.txt3.setText(puntoEscogido.getDireccion());
		this.activity.txt4.setText(puntoEscogido.getHorarioAtencion());
		this.activity.txt5.setText(puntoEscogido.getHorarioExtendido());
		this.activity.txt6.setText(puntoEscogido.getTipoServicioOfrecido());
		this.activity.txt7.setText(puntoEscogido.getCostoTransaccion());

	}

	public void setActivity(PuntoAtencionActivity acti) {
		this.activity = acti;
	}

	public String[] getUrlSet() {
		return urlSet;
	}

	public void setUrlSet(String[] urlSet) {
		this.urlSet = urlSet;
	}

	public static ControladorPuntoAtencion getInstance() {
		return instance;
	}

	public static void setInstance(ControladorPuntoAtencion instance) {
		ControladorPuntoAtencion.instance = instance;
	}

	public PuntoAtencion getPuntoEscogido() {
		return puntoEscogido;
	}

	public PuntoAtencionActivity getActivity() {
		return activity;
	}

}
