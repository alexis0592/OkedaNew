package co.gov.fna.okeda.servicios;

import android.app.Activity;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import co.gov.fna.okeda.controladores.ControladorBusquedaPuntoAtencion;
import co.gov.fna.okeda.controladores.ControladorLoginActivity;
import co.gov.fna.okeda.controladores.ControladorPuntoAtencion;
import co.gov.fna.okeda.presentacion.actividades.BusquedaPuntoAtencionActivity;
import co.gov.fna.okeda.presentacion.actividades.LoginActitvity;
import co.gov.fna.okeda.presentacion.actividades.PuntoAtencionActivity;
import co.gov.fna.okeda.utilidades.Utilities;

/**
 * Created by usuario on 1/07/14.
 */
public class GetRestServices extends AsyncTask<String, String, String> {

	// esta es la url del servicio web
	private String url;
	private String TAG_RESPONSE_OK = "its_ok";
	private String TAG_RESPONSE_ERROR = "something_go_wrong";
	private ControladorLoginActivity controladorLogin;
	private ControladorBusquedaPuntoAtencion controladorPuntoAtencion;
	private Utilities util;
	private Activity activity;

	public GetRestServices(String url, Activity activity) {
		this.url = url;
		this.util = new Utilities(activity);
		this.activity = activity;
		if (activity instanceof LoginActitvity) {
			this.controladorLogin = new ControladorLoginActivity(
					(LoginActitvity) activity);
			controladorPuntoAtencion = null;
		} else if (activity instanceof BusquedaPuntoAtencionActivity) {
			this.controladorPuntoAtencion = ControladorBusquedaPuntoAtencion
					.getInstace();
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected String doInBackground(String... strings) {
		HttpClient cliente = new DefaultHttpClient();
		HttpGet del = new HttpGet(url);

		String stringResp;
		try {

			HttpResponse resp = cliente.execute(del);
			HttpEntity entity = resp.getEntity();
			stringResp = EntityUtils.toString(entity);
			JSONObject respJSON = new JSONObject(stringResp);

			if (this.activity instanceof LoginActitvity) {
				this.controladorLogin.procesaRespuestaRestFul(respJSON);

			} else {
				this.controladorPuntoAtencion.procesaRespuestaRestFul(respJSON);
			}

		} catch (Exception e) {

			return TAG_RESPONSE_ERROR;

		}
		return TAG_RESPONSE_OK;

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		this.util.showDialog("ALerta", "Por Favor Espere", false);

	}

	@Override
	protected void onPostExecute(String s) {
		super.onPostExecute(s);
		if (this.controladorPuntoAtencion != null) {
			controladorPuntoAtencion.setListToSpinner();
		}
		this.util.cancellDialog();
	}
}
