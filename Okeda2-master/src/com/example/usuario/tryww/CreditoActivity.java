package com.example.usuario.tryww;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.presentacion.actividades.CreditsSimulator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class CreditoActivity extends Activity {

	private EditText editTextEntidad;
	private Credito credito;
	private ListView listView;

	private String entidad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credito);
	}


	public void goToSimulator(View v){
		Intent intento = new Intent(this, CreditsSimulator.class);
		startActivity(intento);
	}

}
