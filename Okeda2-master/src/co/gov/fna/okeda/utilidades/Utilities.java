package co.gov.fna.okeda.utilidades;

import java.util.ArrayList;
import java.util.List;


import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.IBusquedaCriteros;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.test.ActivityUnitTestCase;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by usuario on 19/07/14.
 */
 public class Utilities implements IBusquedaCriteros{

    private Context actividad;
    private ProgressDialog dialog;

    public Utilities(Activity actividad) {
        this.actividad = actividad;
    }

    public void showDialog(String titulo, String mensaje, Boolean isCancelable){
        dialog= new ProgressDialog(actividad);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.setCancelable(isCancelable);
        dialog.show();

    }

    public  void showAlertMessage(String mensaje, String titulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(actividad);
        builder.setIcon(actividad.getResources().getDrawable(R.drawable.logo100));
        builder.setTitle(titulo);

        builder.setMessage(mensaje).setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog dialog = builder.show();
        dialog.show();

    }
    
    

    public void cancellDialog(){
        dialog.dismiss();
    }

	@Override
	public List<String> getDepartments(List<Entidades> listaEntidades) {
		// TODO Auto-generated method stub
		List<String> listaDepartamentos = new ArrayList<String>();
	
		for(Entidades e:listaEntidades){
			if(!isElementOnList(e.getDepartamento(), listaDepartamentos)){
				listaDepartamentos.add(e.getDepartamento());
			}
		}
		java.util.Collections.sort(listaDepartamentos);
		listaDepartamentos.add(0, "Seleccione");
		return listaDepartamentos;
	}

	@Override
	public List<String> getCiudadesOrMunicipios(List<Entidades> listaEntidades) {
		// TODO Auto-generated method stub
		List<String> listaMunicipios = new ArrayList<String>();
		for(Entidades e:listaEntidades){
			if(!isElementOnList(e.getMunicipioCiudad(), listaMunicipios)){
				listaMunicipios.add(e.getMunicipioCiudad());
			}
		}
		java.util.Collections.sort(listaMunicipios);
		listaMunicipios.add(0, "Seleccione");
		return listaMunicipios;
	}

	@Override
	public boolean isElementOnList(String s, List<String> lista) {
		// TODO Auto-generated method stub
		return lista.contains(s);
		
	}

	@Override
	public List<String> getEstadoObra(List<Entidades> listaEntidades) {
		// TODO Auto-generated method stub
		List<String> listaEstadoObra = new ArrayList<String>();
		for(Entidades e:listaEntidades){
			if(e instanceof Vivienda){
				Vivienda v = (Vivienda)e;
				if(!isElementOnList(v.getEstadoObra(), listaEstadoObra)){
					listaEstadoObra.add(v.getEstadoObra());
				}
			}
		}
		java.util.Collections.sort(listaEstadoObra);
		listaEstadoObra.add(0, "Seleccione");
		return listaEstadoObra;
	}
	
	

	@Override
	public List<String> getCostos(List<Entidades> listaEntidades) {
		List<String> listaCosto = new ArrayList<String>();
		for(Entidades e:listaEntidades){
			if(e instanceof PuntoAtencion){
				PuntoAtencion v = (PuntoAtencion)e;
				if(!isElementOnList(v.getCostoTransaccion(), listaCosto)){
					listaCosto.add(v.getCostoTransaccion());
				}
			}
		}
		
		java.util.Collections.sort(listaCosto);
		listaCosto.add(0, "Seleccione");
		return listaCosto;
	}

	@Override
	public List<String> getTipo(List<Entidades> listaEntidades) {
		List<String> listaTipo = new ArrayList<String>();
		for(Entidades e:listaEntidades){
			if(e instanceof PuntoAtencion){
				PuntoAtencion v = (PuntoAtencion)e;
				if(!isElementOnList(v.getTipoServicioOfrecido(), listaTipo)){
					listaTipo.add(v.getTipoServicioOfrecido());
				}
			}
		}
		
		java.util.Collections.sort(listaTipo);
		listaTipo.add(0, "Seleccione");
		return listaTipo;
	}
}

