package co.gov.fna.okeda.presentacion.actividades;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorBusquedaPuntoAtencion;
import co.gov.fna.okeda.interfaces.impl.FactoryPuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Entidades;


public class BusquedaPuntoAtencionActivity extends Activity {
	
	private Spinner spDepartamento;
	private Spinner spMuni;
	private Spinner spCosto;
	private Spinner spTipo;
	private ControladorBusquedaPuntoAtencion controlador;
	private List<Entidades>listaPuntoEncontrados;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda_punto_atencion);
			initComponents();
		
			
			
		
	}

	private void initComponents() {
		this.controlador= ControladorBusquedaPuntoAtencion.getInstace();
		this.controlador.setActivity(this);
		this.controlador.setUrlSet(this.getResources().getStringArray(R.array.urlset));
		this.controlador.getRestFullServices();
		this.spDepartamento = (Spinner)findViewById(R.id.spDepartamentoA);
		this.spMuni= (Spinner)findViewById(R.id.spMuniA);
		this.spCosto= (Spinner)findViewById(R.id.spCostoA);
		this.spTipo= (Spinner)findViewById(R.id.spTipoA);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_viviendas, menu);
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
	
	public Spinner getSpDepartamento() {
		return spDepartamento;
	}

	public void setSpDepartamento(Spinner spDepartamento) {
		this.spDepartamento = spDepartamento;
	}

	public Spinner getSpMunicipio() {
		return spMuni;
	}

	public void setSpMuni(Spinner spMuni) {
		this.spMuni = spMuni;
	}

	public Spinner getSpCosto() {
		return spCosto;
	}

	public void setSpCosto(Spinner spCosto) {
		this.spCosto = spCosto;
	}

	public Spinner getSpTipo() {
		return spTipo;
	}

	public void setSpTipo(Spinner spTipo) {
		this.spTipo = spTipo;
	}
	
	public void buscar(View v){
		controlador.buscarPuntoAtencion();
	}

	public void showPunto() {
		Intent intento = new Intent(this, PuntoAtencionActivity.class);
		startActivity(intento);
		
	}

}
