package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryPuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.BusquedaPuntoAtencionActivity;
import co.gov.fna.okeda.servicios.GetRestServices;
import co.gov.fna.okeda.utilidades.Utilities;


public class ControladorBusquedaPuntoAtencion {

	private BusquedaPuntoAtencionActivity activity;
	private ArrayAdapter<String> adaptador;

	private String[] urlSet;
	
	private String departamentoSeleccionado;
	private String municipioSeleccionado;
	private String costoSeleccionado;
	
	private List<Entidades> busqueda;
	
	private static ControladorBusquedaPuntoAtencion instance;
	
	public static ControladorBusquedaPuntoAtencion getInstace() {
		if (instance == null) {
			instance = new ControladorBusquedaPuntoAtencion();
		}
		return instance;
	}

	public void setListToSpinner() {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		Utilities utilities = new Utilities(activity);

		List<String> listaString = utilities.getDepartments(factoryPunto
				.getPuntoAtencionRest());
		String[] Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpDepartamento().setAdapter(adaptador);
		this.activity.getSpDepartamento().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0)
							departamentoSeleccionado = arg0.getItemAtPosition(
									arg2).toString();
						else{
							departamentoSeleccionado = null;
							municipioSeleccionado = null;
						}
							

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		listaString = utilities.getCiudadesOrMunicipios(factoryPunto
				.getPuntoAtencionRest());
		Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpMunicipio().setAdapter(adaptador);
		this.activity.getSpMunicipio().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0 ){
							if (departamentoSeleccionado != null) {
								municipioSeleccionado = arg0.getItemAtPosition(
										arg2).toString();
							}
						}
							
						else
							municipioSeleccionado = null;

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		listaString = utilities.getCostos(factoryPunto.getPuntoAtencionRest());
		Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpCosto().setAdapter(adaptador);
		this.activity.getSpCosto().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0)
							costoSeleccionado = arg0.getItemAtPosition(
									arg2).toString();
						else
							costoSeleccionado = null;

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		listaString = utilities.getTipo(factoryPunto.getPuntoAtencionRest());
		Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpTipo().setAdapter(adaptador);
	}

	public BusquedaPuntoAtencionActivity getActivity() {
		return this.activity;
	}

	public void setActivity(BusquedaPuntoAtencionActivity activity) {
		this.activity = activity;
	}

	public List<Entidades> findByDepartamento(String depto) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				retorno.add(aux);
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}

	}

	public List<Entidades> findByMunicipio(String muni) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();

		for (int i = 0; i < listaPuntosV.size(); i++) {
			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getMunicipioCiudad().equals(muni)) {
				retorno.add(aux);
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}

	}

	public List<Entidades> findByTipo(String tipo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getTipoEntidad().equals(tipo)) {
				retorno.add(aux);
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByCosto(String costo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getCostoTransaccion().equals(costo)) {
				retorno.add(aux);
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByDepartamentoAndMunicipio(String depto,
			String muni) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getMunicipioCiudad().equals(muni)) {
					retorno.add(aux);
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByDepartamentoAndMunicipioAndCosto(String depto,
			String muni, String costo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getMunicipioCiudad().equals(muni)) {
					if (((PuntoAtencion) aux).getCostoTransaccion().equals(
							costo)) {
						retorno.add(aux);
					}
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByDepartamentoAndMunicipioAndCostoAndTipo(
			String depto, String muni, String costo, String tipo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getMunicipioCiudad().equals(muni)) {
					if (((PuntoAtencion) aux).getCostoTransaccion().equals(
							costo)) {
						if (((PuntoAtencion) aux).getTipoEntidad().equals(tipo)) {
							retorno.add(aux);
						}
					}
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByDepartamentoAndCosto(String depto, String costo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getCostoTransaccion().equals(costo)) {
					retorno.add(aux);
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByDepartamentoAndCostoAndTipo(String depto,
			String costo, String tipo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getCostoTransaccion().equals(costo)) {
					if (((PuntoAtencion) aux).getTipoEntidad().equals(tipo)) {
						retorno.add(aux);
					}
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}

	}

	public List<Entidades> findByDepartamentoAndTipo(String depto, String tipo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getDepartamento().equals(depto)) {
				if (((PuntoAtencion) aux).getTipoEntidad().equals(tipo)) {
					retorno.add(aux);
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public List<Entidades> findByCostoAndTipo(String costo, String tipo) {
		FactoryPuntoAtencion factoryPunto = FactoryPuntoAtencion.getInstance();
		List<Entidades> listaPuntosV = factoryPunto.getPuntoAtencionRest();
		List<Entidades> retorno = new ArrayList<Entidades>();
		for (int i = 0; i < listaPuntosV.size(); i++) {

			Entidades aux = listaPuntosV.get(i);

			if (((PuntoAtencion) aux).getCostoTransaccion().equals(costo)) {
				if (((PuntoAtencion) aux).getTipoEntidad().equals(tipo)) {
					retorno.add(aux);
				}
			}
		}
		if (retorno.isEmpty()) {
			return null;
		} else {
			return retorno;
		}
	}

	public void getRestFullServices() {
		GetRestServices services;
		services = new GetRestServices(getUrlSet()[1], getActivity());
		services.execute();
	}

	public String[] getUrlSet() {
		return urlSet;
	}
	
	public void setUrlSet(String[] url){
		this.urlSet = url;
	}

	public void procesaRespuestaRestFul(JSONObject objeto) {

		try {
			Log.d("Procesasa", "Entre a procesa");
			String[] puntosPropertysNames = activity.getResources()
					.getStringArray(R.array.puntosatencion_properties_names);
			JSONArray arregloJSON = objeto.getJSONArray("d");
			FactoryPuntoAtencion factory = FactoryPuntoAtencion.getInstance();
			factory.fillPuntoAtencion(arregloJSON, puntosPropertysNames);
			// setListToSpinner();
			// Toast.makeText(this.activity, "Consumi jSON",
			// Toast.LENGTH_LONG).show();

		} catch (JSONException e) {

		}

	}

	public void buscarPuntoAtencion() {
		
		if (departamentoSeleccionado != null) {
			if(municipioSeleccionado != null){
				if(costoSeleccionado != null){
					busqueda = findByDepartamentoAndMunicipioAndCosto(departamentoSeleccionado, 
							municipioSeleccionado, costoSeleccionado);
				}else{
					busqueda = findByDepartamentoAndMunicipio(departamentoSeleccionado, municipioSeleccionado);
				}
			}else if(costoSeleccionado != null){
				busqueda = findByDepartamentoAndCosto(departamentoSeleccionado, costoSeleccionado);
			}else{
				busqueda = findByDepartamento(departamentoSeleccionado);
			}
		}else if (costoSeleccionado != null) {
			busqueda = findByCosto(costoSeleccionado);
		}else{
			Utilities util = new Utilities(getActivity());
			util.showAlertMessage("No se encontró ningun resultado con las opciones ingresadas.", "No se encontró ningun resultado");
			return;
		}
		if (busqueda == null) {
			Utilities util = new Utilities(getActivity());
			util.showAlertMessage("No se encontró ningun resultado con las opciones ingresadas.", "No se encontró ningun resultado");
			return;
		}
		showSearchResults(busqueda);
		
	}
	
	public void showSearchResults(List<Entidades> lista) {
		if (lista != null && lista.size() > 0) {
			AlertDialog.Builder builderSingle = new AlertDialog.Builder(
					activity);
			builderSingle.setIcon(R.drawable.ic_launcher);
			builderSingle.setTitle("Select One Name:-");
			final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					activity, android.R.layout.select_dialog_singlechoice);
			for (Entidades e : lista) {
				PuntoAtencion v = (PuntoAtencion) e;
				arrayAdapter.add(v.getNumero() + " "+ v.getDepartamento());
			}

			builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
		
					ControladorPuntoAtencion controladorMoestrMostrarPunto = ControladorPuntoAtencion
							.getInstace();
					controladorMoestrMostrarPunto.setPuntoEscogido((PuntoAtencion) busqueda.get(arg1));
					activity.showPunto();
				}
			});
			builderSingle.show();

		}
	}
}
