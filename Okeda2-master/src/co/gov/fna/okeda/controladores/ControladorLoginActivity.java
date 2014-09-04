package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.util.Log;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryUsuario;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.LoginActitvity;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.DashBoard;
import co.gov.fna.okeda.process.impl.ViviendaProcessImpl;
import co.gov.fna.okeda.servicios.GetRestServices;
import co.gov.fna.okeda.utilidades.Utilities;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by OscarGallon on 18/07/14.
 */
public class ControladorLoginActivity {

	private LoginActitvity activity;
	private String[] urlSet;
	private Usuario usuario;
	private ViviendaProcessImpl viviendaProcessImpl;
	FactoryVivienda factory;

	public ControladorLoginActivity(LoginActitvity actividad) {
		this.activity = actividad;
		this.urlSet = actividad.getResources().getStringArray(R.array.urlset);

	}

	public void procesaRespuestaRestFul(JSONObject objeto) {

		try {
			String[] viviendaPropertysNames = activity.getResources()
					.getStringArray(R.array.viviendas_properties_names);
			JSONArray arregloJSON = objeto.getJSONArray("d");
			factory = FactoryVivienda.getInstance();
			factory.fillViviendas(arregloJSON, viviendaPropertysNames);
			this.saveViviendaIntoDatabase(factory.getListaViviendas());
			this.activity.changeToActivy(DashBoard.class);
		} catch (JSONException e) {

		}

	}

	public void changeToActivy(Class a) {
		Intent i = new Intent(activity, a);
		activity.startActivity(i);
	}

	public void showMessage(String title, String menssage) {
		Utilities util = new Utilities(activity);
		util.showAlertMessage(title, menssage);
	}

	public void singUp(String userName, String password, String email,
			String mobile) {
		final Utilities utilidades = new Utilities(activity);
		utilidades.showDialog(
				getActivity().getResources().getString(R.string.alerta),
				getActivity().getResources().getString(
						R.string.mensaje_registrando), false);
		ParseUser user = new ParseUser();
		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.put("mobile", mobile);

		user.signUpInBackground(new SignUpCallback() {
			public void done(ParseException e) {
				if (e == null) {
					utilidades.cancellDialog();
					utilidades.showAlertMessage(
							getActivity().getResources().getString(
									R.string.mensaje_registro_exitoso),
							getActivity().getResources().getString(
									R.string.exito));

				} else {
					// Sign up didn't succeed. Look at the ParseException
					// to figure out what went wrong
					Log.i("error", e.getMessage());
					utilidades.showAlertMessage(getActivity().getResources()
							.getString(R.string.error_datos), getActivity()
							.getResources().getString(R.string.error));
				}
			}
		});

	}

	public void loggin(final String username, final String pass) {
		final Utilities utilidades = new Utilities(activity);
		utilidades.showDialog(getActivity().getString(R.string.alerta),
				"iniciando Session Espere por Favor", false);

		ParseUser.logInInBackground(username, pass, new LogInCallback() {

			public void done(ParseUser user, ParseException e) {

				if (user != null) {
					// Hooray! The user is logged in
					utilidades.cancellDialog();
					FactoryUsuario factoryUsuario = FactoryUsuario
							.getInstance();
					factoryUsuario.createUser(user);
					getActivity().saveSharedPreference(username, pass);
					viviendaProcessImpl = new ViviendaProcessImpl(activity
							.getApplicationContext());
					List<Vivienda> viviendasList = viviendaProcessImpl
							.findAllViviendas();
					// FIXME: llamado al WS categorias
					if (viviendasList.size() == 0) {
						getRestFullServices();
					} else {
						factory = FactoryVivienda.getInstance();
						factory.setListaViviendas(new ArrayList<Entidades>(
								viviendasList));
						activity.changeToActivy(DashBoard.class);
					}
				} else {
					utilidades.showAlertMessage(getActivity().getResources()
							.getString(R.string.error_datos), getActivity()
							.getResources().getString(R.string.error));

				}
				utilidades.cancellDialog();
			}
		});

	}

	public void getRestFullServices() {
		GetRestServices services;
		services = new GetRestServices(getUrlSet()[0], getActivity());
		services.execute();

	}

	public LoginActitvity getActivity() {
		return activity;
	}

	public void setActivity(LoginActitvity activity) {
		this.activity = activity;
	}

	public String[] getUrlSet() {
		return urlSet;
	}

	public void setUrlSet(String[] urlSet) {
		this.urlSet = urlSet;
	}

	public List<Vivienda> getViviendasFromDatabase() {
		// FIXME: metodo creado para cuando ya hay datos en la BD. Verificar
		List<Vivienda> entidadesList = this.viviendaProcessImpl
				.findAllViviendas();
		this.activity.changeToActivy(DashBoard.class);

		return entidadesList;
	}

	public void saveViviendaIntoDatabase(List<Entidades> entidadesList) {
		this.viviendaProcessImpl = new ViviendaProcessImpl(getActivity()
				.getApplicationContext());
		Vivienda vivienda;

		for (int i = 0; i < entidadesList.size(); i++) {
			vivienda = (Vivienda) entidadesList.get(i);
			try {
				this.viviendaProcessImpl.saveVivienda(vivienda);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
