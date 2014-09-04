package co.gov.fna.okeda.servicios;

import java.util.List;



import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ParseServices extends AsyncTask<String, Integer, Boolean> {

    private Activity actividad;
	List<ParseObject> ob;
	ProgressDialog dialog;
	String nombreObjeto;
	String tipo;
	boolean vacio;

	public ParseServices(String nombreObjeto, String tipo, Activity actividad) {
		this.nombreObjeto = nombreObjeto;
		this.tipo = tipo;
        this.actividad= actividad;
	}

	@Override
	protected Boolean doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		boolean result = true;
		ParseQuery<ParseObject> query = ParseQuery.getQuery(nombreObjeto);

		try {
			ob = query.find();
			if (ob.size() == 0) {

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
		super.onPreExecute();
		dialog = new ProgressDialog(actividad);
		dialog.setMessage("Por Favor Espere");
		dialog.setCancelable(false);
		dialog.show();

	}

	@Override
	protected void onPostExecute(Boolean result) {

        /*/
		if (result) {
			if (tipo.equals("categoria")) {
				LoginController.loadCategorias(ob);
			} else if (tipo.equals("actividades")) {
				Comunicador.loadActivities(ob);
			}

		} else {
			Utilitys.mensajeDeAlerta("Error recupendo los objetos", "Error");
		}
		/*/
		dialog.dismiss();
	}
}
