package co.gov.fna.okeda.usuario;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryUsuario;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends Activity {

	TextView text_view_user_name;
	TextView txtEmail;
	TextView txtMobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_perfil);
		FactoryUsuario factoryUsuario = FactoryUsuario.getInstance();
		Usuario u = factoryUsuario.getCurrentUserInActivity();
		txtEmail = (TextView) findViewById(R.id.txtEmail);
		text_view_user_name = (TextView) findViewById(R.id.text_view_user_name);
		txtMobile = (TextView) findViewById(R.id.txtMobile);
		text_view_user_name.setText(u.getUser().getUsername());
		txtEmail.setText(u.getEmail());
		txtMobile.setText(u.getMobile());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
