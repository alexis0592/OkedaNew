package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.ControladorComentarios;


public class ComentariosActivity extends Activity {
	private ControladorComentarios controlador;
	private EditText txtComentario;

	private ListView lv;
	private RatingBar ratingBarComentario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios);
		controlador = new ControladorComentarios(this);
		this.ratingBarComentario = (RatingBar) super
				.findViewById(R.id.ratingBar1);
	
		txtComentario = (EditText) findViewById(R.id.txtComentario);

		lv = (ListView) findViewById(R.id.listView1);
		controlador.getComentarios();
	}

	public void comentar(View v) {
		int x =(int) ratingBarComentario.getRating();
		String puntuacion = Integer.toString(x);
		controlador
				.createComent(puntuacion, txtComentario.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comentarios, menu);
		return true;
	}

	public ControladorComentarios getControlador() {
		return controlador;
	}

	public void setControlador(ControladorComentarios controlador) {
		this.controlador = controlador;
	}

	public EditText getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(EditText txtComentario) {
		this.txtComentario = txtComentario;
	}


	public ListView getLv() {
		return lv;
	}

	public void setLv(ListView lv) {
		this.lv = lv;
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
