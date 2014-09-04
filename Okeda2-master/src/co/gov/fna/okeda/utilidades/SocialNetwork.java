package co.gov.fna.okeda.utilidades;

import android.app.Activity;
import android.content.Intent;

public class SocialNetwork extends Activity {

	public void compartirRedSocial(Activity a, String vivienda) {
		Intent i = new Intent();
		i.setAction(Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_TEXT, vivienda);
		a.startActivity(Intent.createChooser(i, "Compartir"));

	}
}
