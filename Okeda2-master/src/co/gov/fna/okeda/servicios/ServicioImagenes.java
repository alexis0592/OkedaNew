package co.gov.fna.okeda.servicios;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorMostrarVivienda;
import co.gov.fna.okeda.utilidades.Utilities;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.URLUtil;

public class ServicioImagenes extends AsyncTask<String, Integer, Boolean> {

	private List<String> urls;
	private List<Bitmap> bmp;
	private int identificador;
	int escala;
	private ControladorMostrarVivienda controlador;
	boolean error;

	public ServicioImagenes(ControladorMostrarVivienda controlador) {
		this.controlador = controlador;
		escala = 2;

	}
	
	

	public List<String> getUrls() {
		return urls;
	}



	public void setUrls(List<String> urls) {
		this.urls = urls;
	}



	@Override
	protected void onPreExecute() {
		controlador.showProgressDialogImagenes();

	}

	@SuppressWarnings("finally")
	public boolean verificaUrl(String u) {
		URLUtil uu = new URLUtil();
		if (URLUtil.isValidUrl(u)) {
			return true;
		}
		return false;

	}

	protected Boolean doInBackground(String... params) {

		boolean resul = true;
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = escala;
		URL url7;
		Bitmap bitmapAux;

		try {

			bmp = new ArrayList<Bitmap>();

			for (String s : urls) {

				url7 = new URL(s);

				try {
					bitmapAux = BitmapFactory.decodeStream(url7
							.openConnection().getInputStream(), null, options);
					bmp.add(bitmapAux);
				} catch (Exception e) {
					Bitmap largeIcon = BitmapFactory.decodeResource(controlador
							.getActividad().getResources(), R.drawable.house);
					bitmapAux = largeIcon;

					bmp.add(largeIcon);
				}

			}

		} catch (Exception ex) {
			Log.e("ServicioRest", "Error!", ex);
			resul = false;
		}
		return resul;
	}

	protected void onPostExecute(Boolean result) {
		if (result) {
			controlador.getVivienda().setImagenes(bmp);
			controlador.muestraImagenes();
		}
		controlador.cancellProgressDialog();

	}

	public int searchForEmptyUrlArray() {
		for (String s : urls) {
			if (s == null || s.equals("Sin informaci—n") || s.equals("")) {
				return 1;
			} else if (!URLUtil.isValidUrl(s)) {
				return 2;
			}
		}
		return 0;

	}

}
