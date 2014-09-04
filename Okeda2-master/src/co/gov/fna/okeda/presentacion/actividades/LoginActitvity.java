package co.gov.fna.okeda.presentacion.actividades;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.parse.Parse;
import com.example.usuario.tryww.PreferenceActivityMain;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorLoginActivity;
import co.gov.fna.okeda.persistence.dao.impl.ViviendaDAOImpl;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.DashBoard;

public class LoginActitvity extends Activity {
	private ControladorLoginActivity controlador;
	private ViviendaDAOImpl viviendaDAOImpl;
	private EditText txtUser;
	private EditText Password;
	private ActionBar action;
	private SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		action = getActionBar();
		controlador = new ControladorLoginActivity(this);
		Parse.initialize(this, getResources().getString(R.string.parseid),
				getResources().getString(R.string.parseid2));
		if (savedInstanceState == null) {
			this.viviendaDAOImpl = ViviendaDAOImpl.getInstance(super
					.getApplicationContext());
		}
		sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		String username = sharedPreferences.getString("username", "NAN");
		String password = sharedPreferences.getString("password", "NAN");

		txtUser = (EditText) findViewById(R.id.txtUsername);
		Password = (EditText) findViewById(R.id.txtPassword);
		if (!username.equals("NAN"))
			txtUser.setText(username);
		if (!password.equals("NAN"))
			Password.setText(password);
	}

	public void getServices(View v) {
		controlador.getRestFullServices();
	}

	public void singUp(View v) {
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.sing_up_dialog);
		dialog.setTitle("Registro");
		

		// set the custom dialog components - text, image and button
		final EditText txtUserName = (EditText) dialog
				.findViewById(R.id.txtUserName);
		final EditText txtPass = (EditText) dialog
				.findViewById(R.id.txtPassword);
		final EditText txtEmail = (EditText) dialog.findViewById(R.id.txtEmail);
		final EditText txtMobile = (EditText) dialog
				.findViewById(R.id.txtMobile);
		ImageView btnOk = (ImageView) dialog.findViewById(R.id.btnOk);
		ImageView btnCancel = (ImageView) dialog.findViewById(R.id.btnCancel);

		// if button is clicked, close the custom dialog
		btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = txtUserName.getText().toString();
				String password = txtPass.getText().toString();
				String email = txtEmail.getText().toString();
				String mobile = txtMobile.getText().toString();
				if (username != null && username.length() > 5
						&& password != null && password.length() > 5
						&& email != null && email.length() > 7
						&& mobile != null && mobile.length() > 5) {
					controlador.singUp(username, password, email, mobile);
				} else {
					controlador.showMessage(
							getResources().getString(R.string.error),
							getResources().getString(R.string.error_datos));
				}
				dialog.dismiss();
			}
		});

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();

	}

	public void saveSharedPreference(String username, String password) {

		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		boolean x = editor.commit();
		String username1 = sharedPreferences.getString("username", "NAN");
		String password2 = sharedPreferences.getString("password", "NAN");
		Log.i("Keys",
				String.format("Username %s,pasword %s  ", username1, password2));
	}

	public void openDashBoar(View v) {
		changeToActivy(DashBoard.class);

	}

	public void atencion(View v) {
		Intent myItent = new Intent(this, BusquedaPuntoAtencionActivity.class);
		startActivity(myItent);
	}

	public void openBusquedaViviendas(View v) {
		Intent i = new Intent(this, BusquedaViviendas.class);
		startActivity(i);
	}

	public void logIn(View v) {
		controlador.loggin(txtUser.getText().toString(), Password.getText()
				.toString());
	}

	public void changeToActivy(Class a) {
		Intent i = new Intent(this, a);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_search:
			Intent i = new Intent(this, PreferenceActivityMain.class);
			startActivity(i);
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}
}
