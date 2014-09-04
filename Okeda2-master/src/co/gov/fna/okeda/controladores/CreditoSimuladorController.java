package co.gov.fna.okeda.controladores;

import java.util.List;

import android.content.Intent;
import co.gov.fna.okeda.modelo.entidades.Credito;
import co.gov.fna.okeda.presentacion.actividades.CreditFoundedActivity;
import co.gov.fna.okeda.presentacion.actividades.CreditsSimulator;

public class CreditoSimuladorController {

	private List<Credito> listadoCreditos;
	private int UVR = 236600;
	private int puntosUVR;
	
	private CreditsSimulator activity;

	private Credito creditoCalculado;
	
	

	public CreditoSimuladorController(CreditsSimulator act) {
		super();
		this.activity = act;
	}

	public void creaCreditos() {
		// Credito cr1 = new Credito(100000, cuotaPactada, valorMIF, plazoPagar,
		// uvrPactado)
	}

	public void calculaCredito(int ingresos, int ingresosExt, int egresos,
			int plazo, int cuotas) {

		int ingTotal = ingresos + ingresosExt - egresos;

		calculaPuntos(ingTotal);

		int cuotaPac = calculaUVRUnico(ingTotal);
		int valorMif = (
				cuotaPac + 1000000) * plazo;
		int maxCred = valorMif - ((valorMif * 20) / 100); // Valor minimo a
															// financiar - 20 %

		this.creditoCalculado = new Credito(maxCred, cuotaPac, valorMif, plazo,
				puntosUVR);
		
		showSearchResults();

	}

	private int calculaUVRUnico(int ingTotal) {
		int UVRCal;

		switch (puntosUVR) {
		case 9:
		case 8:
		case 7:
		case 6:
		case 5:
			UVRCal = UVR + ((UVR * puntosUVR) / 100);
			break;

		default:
			UVRCal = UVR;
			break;
		}

		return UVRCal;
	}

	private void calculaPuntos(int ingTotal) {
		if (ingTotal < 500000) {
			puntosUVR = 0;
		}else if (ingTotal < 1000000) {
			puntosUVR = 9;
		} else if (ingTotal < 2000000) {
			puntosUVR = 8;
		} else if (ingTotal < 3000000) {
			puntosUVR = 7;
		} else if (ingTotal < 4000000) {
			puntosUVR = 6;
		} else if (ingTotal < 5000000) {
			puntosUVR = 5;
		} else {
			puntosUVR = 0;
		}
	}

	public void showSearchResults() {

		Intent i = new Intent(activity, CreditFoundedActivity.class);
		
		i.putExtra("CreditoCalculado", creditoCalculado);
		activity.startActivity(i);
		
		
	}

}
