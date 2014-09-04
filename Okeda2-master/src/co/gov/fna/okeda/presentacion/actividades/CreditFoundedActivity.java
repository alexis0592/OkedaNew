package co.gov.fna.okeda.presentacion.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.modelo.entidades.Credito;


public class CreditFoundedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credit_founded);
		
		Intent i = getIntent();
		
		Credito cred = (Credito)i.getSerializableExtra("CreditoCalculado");
		setInformation(cred);
		
		
	}
	
	public void setInformation(Credito cred){
		EditText u1 = (EditText)findViewById(R.id.editText000);
		u1.setText(Integer.toString(cred.getMaxCredito()), TextView.BufferType.EDITABLE);
		
		EditText u2 = (EditText)findViewById(R.id.editText01);
		u2.setText(Integer.toString(cred.getCuotaPactada()), TextView.BufferType.EDITABLE);
		
		EditText u3 = (EditText)findViewById(R.id.editText02);
		u3.setText(Integer.toString(cred.getValorMIF()), TextView.BufferType.EDITABLE);
		
		EditText u4 = (EditText)findViewById(R.id.editText03);
		u4.setText(Integer.toString(cred.getPlazoPagar()), TextView.BufferType.EDITABLE);
		
		EditText u5 = (EditText)findViewById(R.id.editText04);
		u5.setText(Integer.toString(cred.getUvrPactado()), TextView.BufferType.EDITABLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.credit_founded, menu);
		return true;
	}

}
