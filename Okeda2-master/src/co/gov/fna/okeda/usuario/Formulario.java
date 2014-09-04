package co.gov.fna.okeda.usuario;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Vivienda;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Formulario extends Activity {

	Spinner opcionesDoc;
	Button btnEnviar;
	EditText nombre;
	EditText apellido;
	EditText ciudad;
	EditText numero;
	EditText tel;
	TextView inmueble;
	EditText canon;
	EditText ingreso;
	public static int tipoBienSeleccionado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario_inscripcion);
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			final Vivienda v = (Vivienda) e;
			// opcionesDoc = (Spinner) findViewById(R.id.spinner1);
			this.nombre = (EditText) findViewById(R.id.editText1);
			this.apellido = (EditText) findViewById(R.id.editTxtApell1);
			// nombre.setText(MainActivity.b.getNombredelbien().toString());
			this.ciudad = (EditText) findViewById(R.id.editText2);
			this.numero = (EditText) findViewById(R.id.editText3);
			this.tel = (EditText) findViewById(R.id.editText4);
			// this.inmueble = (TextView) findViewById(R.id.textView1);
			this.canon = (EditText) findViewById(R.id.editText6);
			this.canon.setText(v.getValorInmueble());

			btnEnviar = (Button) findViewById(R.id.btnEnviar);
			btnEnviar.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					Intent i = new Intent(Intent.ACTION_SEND);
					i.setType("message/rfc822");
					i.putExtra(Intent.EXTRA_EMAIL,
							new String[] { v.getEmailConstructora() });

					if (Formulario.tipoBienSeleccionado == 0) {
						i.putExtra(
								Intent.EXTRA_SUBJECT,
								"Formulario arrendamiento inmuebles "
										+ v.getNombreProyecto());
						i.putExtra(
								Intent.EXTRA_TEXT,
								"Hay un usuario de Okeda para Android que desea mas informacion acerca del inmueble su correo es: "
										+ v.getEmailConstructora());

					}
					startActivity(i);
				}
			});
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_viviendas, menu);
		return true;
	}

}
