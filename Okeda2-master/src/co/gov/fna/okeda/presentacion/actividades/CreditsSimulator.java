package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.controladores.CreditoSimuladorController;


public class CreditsSimulator extends Activity {

	private CreditoSimuladorController controlador;

	private EditText ingresosTV;
	private EditText ingresosExTV;
	private EditText egresosTV;
	private EditText cuotasTV;
	private EditText plazoTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credits_simulator);

		this.controlador = new CreditoSimuladorController(this);
		initComponents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.credits_simulator, menu);
		return true;
	}

	private void initComponents() {
		this.ingresosTV = (EditText) findViewById(R.id.editText0);
		this.ingresosExTV = (EditText) findViewById(R.id.editText1);
		this.egresosTV = (EditText) findViewById(R.id.editText2);
		this.cuotasTV = (EditText) findViewById(R.id.editText3);
		this.plazoTV = (EditText) findViewById(R.id.editText4);

	}

	public void calculeCredit(View v) {
		int ingre, ingreEx, egre, cout, plazo;

		if (ingresosTV.getText().toString() == null
				|| ingresosTV.getText().toString().equals("")) {
			showMenssage(4);
			return;
		} else {
			ingre = Integer.parseInt(ingresosTV.getText().toString());
			if (ingre < 500000) {
				showMenssage(1);
				return;
			}
		}

		if (ingresosExTV.getText().toString() == null
				|| ingresosExTV.getText().toString().equals("")) {
			ingreEx = 0;
		} else {
			ingreEx = Integer.parseInt(ingresosExTV.getText().toString());
		}

		if (egresosTV.getText().toString() == null
				|| egresosTV.getText().toString().equals("")) {
			showMenssage(4);
			return;
		} else {
			egre = Integer.parseInt(egresosTV.getText().toString());
			if (egre > ingre) {
				showMenssage(2);
				return;
			}
		}

		if (cuotasTV.getText().toString() == null
				|| cuotasTV.getText().toString().equals("")) {
			cout = 0;
		} else {
			cout = Integer.parseInt(cuotasTV.getText().toString());
		}

		if (plazoTV.getText().toString() == null
				|| plazoTV.getText().toString().equals("")) {
			showMenssage(3);
			return;
		} else {
			plazo = Integer.parseInt(plazoTV.getText().toString());
			if (plazo < 5 || plazo > 25) {
				showMenssage(3);
				return;
			}
		}

		plazo = Integer.parseInt(plazoTV.getText().toString());

		this.controlador.calculaCredito(ingre, ingreEx, egre, plazo, cout);
	}

	public void showMenssage(int i) {
		
		switch (i) {
		case 1:
			new AlertDialog.Builder(this)
			.setTitle("Ingresos")
			.setMessage(
					"Sus ingresos deben ser mayor a $500.000")
			.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
							return;
						}
					}).setIcon(android.R.drawable.ic_dialog_alert).show();
			break;
		case 2:
			new AlertDialog.Builder(this)
			.setTitle("Egresos")
			.setMessage(
					"Usted no puede un egreso mayor que sus ingresos")
			.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
							return;
						}
					}).setIcon(android.R.drawable.ic_dialog_alert).show();
			break;
		case 3:
			new AlertDialog.Builder(this)
			.setTitle("Plazo de Crédito")
			.setMessage(
					"Debe ingresar un plazo (en años) de crédito entre 5 y 25 años ")
			.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
							return;
						}
					}).setIcon(android.R.drawable.ic_dialog_alert).show();
			break;
		case 4:
			new AlertDialog.Builder(this)
			.setTitle("Campos vacios")
			.setMessage(
					"Los campos Ingresos, egresos y plazo de crédito no pueden estar vacios")
			.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
							return;
						}
					}).setIcon(android.R.drawable.ic_dialog_alert).show();
			break;


		default:
			break;
		}
		

	}

}
