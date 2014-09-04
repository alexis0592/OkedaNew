package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.usuario.tryww.Mapas;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorPuntoAtencion;

public class PuntoAtencionActivity extends Activity {
	private ControladorPuntoAtencion controlador;

	public TextView txt0;
	public TextView txt1;
	public TextView txt2;
	public TextView txt3;
	public TextView txt4;
	public TextView txt5;
	public TextView txt6;
	public TextView txt7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_punto_atencion);
		createComponents();
		controlador = ControladorPuntoAtencion.getInstace();
		controlador.setActivity(this);
		controlador.showPunto();
	}

	public void createComponents() {
		this.txt0 = (TextView) findViewById(R.id.textView0);
		this.txt1 = (TextView) findViewById(R.id.textView);
		this.txt2 = (TextView) findViewById(R.id.textView2);
		this.txt3 = (TextView) findViewById(R.id.textView3);
		this.txt4 = (TextView) findViewById(R.id.textView4);
		this.txt5 = (TextView) findViewById(R.id.textView5);
		this.txt6 = (TextView) findViewById(R.id.textView6);
		this.txt7 = (TextView) findViewById(R.id.textView7);
	}

	public void street(View v) {
		double x = controlador.getPuntoEscogido().getUbicacion().getLatitud();
		double y = controlador.getPuntoEscogido().getUbicacion().getLonguitud();
		Uri streetViewUri = Uri.parse("google.streetview:cbll=" + x + "," + y
				+ "&cbp=1,90,,0,1.0&mz=20");
		Intent streetViewIntent = new Intent(Intent.ACTION_VIEW, streetViewUri);
		startActivity(streetViewIntent);//
	}

	public void goToMapActivity(View v) {
		Intent i = new Intent(this, Mapas.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dash_board, menu);
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

	public void getServices(View v) {
		Log.d("C PuntoAten", "Entre a services");
	}
}
