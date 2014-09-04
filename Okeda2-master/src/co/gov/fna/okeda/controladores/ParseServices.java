package co.gov.fna.okeda.controladores;

import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ParseServices extends AsyncTask<String, Integer, Boolean> {

	List<ParseObject> ob;
	ProgressDialog dialog;
	String nombreObjeto;
	String tipo;
	boolean vacio;
	ControladorComentarios controlador;

	public ParseServices(String nombreObjeto, ControladorComentarios controlador) {
		this.nombreObjeto = nombreObjeto;
		this.controlador = controlador;
	}

	@Override
	protected Boolean doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		boolean result = true;
		ParseQuery<ParseObject> query = ParseQuery.getQuery(nombreObjeto);

		try {
			ob = query.find();
			if (ob.size() == 0) {
				vacio = true;
				return false;
			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			result = false;
		}

		return result;
	}

	@Override
	protected void onPreExecute() {
		controlador.showProgress();
	}

	@Override
	protected void onPostExecute(Boolean result) {

		if (result) {
			controlador.setListaObjetos(ob);
			controlador.MuestraComentarios();

		} else {
			if (!vacio)
				controlador.getUtil().showAlertMessage("Error",
						"Error Al obtener Los Comentarios");
			else
				controlador.getUtil().showAlertMessage("Alerta",
						"Sin Comentarios");
		}
		controlador.cancelDialog();
	}
}
