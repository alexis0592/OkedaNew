package co.gov.fna.okeda.modelo.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Credito implements Serializable{
	
	int maxCredito;
	int cuotaPactada;
	int valorMIF;
	int plazoPagar;
	int uvrPactado;
	
	public Credito(int maxCredito, int cuotaPactada, int valorMIF,
			int plazoPagar, int uvrPactado) {
		super();
		this.maxCredito = maxCredito;
		this.cuotaPactada = cuotaPactada;
		this.valorMIF = valorMIF;
		this.plazoPagar = plazoPagar;
		this.uvrPactado = uvrPactado;
	}

	public Credito() {
		super();
	}

	public int getMaxCredito() {
		return maxCredito;
	}

	public void setMaxCredito(int maxCredito) {
		this.maxCredito = maxCredito;
	}

	public int getCuotaPactada() {
		return cuotaPactada;
	}

	public void setCuotaPactada(int cuotaPactada) {
		this.cuotaPactada = cuotaPactada;
	}

	public int getValorMIF() {
		return valorMIF;
	}

	public void setValorMIF(int valorMIF) {
		this.valorMIF = valorMIF;
	}

	public int getPlazoPagar() {
		return plazoPagar;
	}

	public void setPlazoPagar(int plazoPagar) {
		this.plazoPagar = plazoPagar;
	}

	public int getUvrPactado() {
		return uvrPactado;
	}

	public void setUvrPactado(int uvrPactado) {
		this.uvrPactado = uvrPactado;
	}
	
	
	

}
