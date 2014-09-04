package co.gov.fna.okeda.presentacion.actividades.Dashboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorDashBoard;
import co.gov.fna.okeda.presentacion.actividades.BusquedaPuntoAtencionActivity;
import co.gov.fna.okeda.presentacion.actividades.BusquedaViviendas;
import co.gov.fna.okeda.presentacion.actividades.SimuladorActivity;

import com.example.usuario.tryww.CreditoActivity;
import com.example.usuario.tryww.PerfilActivity;

public class DashBoard extends Activity {

	private GridView gridOpciones;
	private ControladorDashBoard controlador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dash_board);
		gridOpciones = (GridView) findViewById(R.id.gridView1);
		controlador = new ControladorDashBoard(this);
		controlador.createGrid();

	}

	public void changeToBusquedaViviendasActivity() {
		Intent i = new Intent(this, BusquedaViviendas.class);
		startActivity(i);
	}

	public void changeToBusquedaPuntoAtencionActivity() {
		Intent myItent = new Intent(this, BusquedaPuntoAtencionActivity.class);
		startActivity(myItent);
	}

	public GridView getGridOpciones() {
		return gridOpciones;
	}

	public void setGridOpciones(GridView gridOpciones) {
		this.gridOpciones = gridOpciones;
	}

	public void changeToPerfilActivity() {
		Intent myItent = new Intent(this, PerfilActivity.class);
		startActivity(myItent);
	}

	public void changeToCreditoActivity() {
		Intent myItent = new Intent(this, CreditoActivity.class);
		startActivity(myItent);
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

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog
					.setMessage(
							"¿Esta seguro que desea salir de la aplicación?")
					.setTitle("Alerta").setCancelable(false);
			alertDialog.setPositiveButton("Salir", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					System.exit(1);

				}
			});
			alertDialog.setNegativeButton("Cancelar", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			});

			AlertDialog alertDialog2 = alertDialog.create();

			alertDialog2.show();
		}

		return super.onKeyDown(keyCode, event);
	}
}
