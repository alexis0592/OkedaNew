package com.example.usuario.tryww;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Vivienda;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Mapas extends Activity {
	GoogleMap mapa;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		setContentView(R.layout.mapas_layout);
		mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		if (mapa != null) {
			Log.i("PERRA", "WE HAD MAP");
			FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
			ubicarEscenario(factoryEntidades.getEntidadInCurrentActivity(), 12);
		} else {
			Log.i("PERRA", "NO MAPP");
		}

	}

	public void ubicarEscenario(Entidades e, int size) {
		Double lat = e.getUbicacion().getLatitud();
		Double lng = e.getUbicacion().getLonguitud();

		LatLng latlong = new LatLng(lat, lng);
		// mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraPosition posicion = new CameraPosition.Builder().target(latlong)
				.zoom(size).bearing(0).build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(posicion);
		mapa.animateCamera(camUpd);
		String nombre;
		if (e instanceof Vivienda) {
			Vivienda v = (Vivienda) e;
			nombre = ((Vivienda) e).getNombreProyecto();
		} else {
			PuntoAtencion p = (PuntoAtencion) e;
			nombre = p.getNumero();
		}

		Marker n = mapa.addMarker(new MarkerOptions()
				.position(new LatLng(lat, lng))
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_RED))
				.title(nombre)
				.snippet(e.getDepartamento() + "; " + e.getMunicipioCiudad()));

		// n.setIcon(BitmapDescriptorFactory.defaultMarker())

		n.showInfoWindow();

		// se muestra la venta de info

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.streetView:
			FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
			Entidades e = factoryEntidades.getEntidadInCurrentActivity();
			Uri streetViewUri = Uri.parse("google.streetview:cbll="
					+ e.getUbicacion().getLatitud() + ","
					+ e.getUbicacion().getLonguitud()
					+ "&cbp=1,90,,0,1.0&mz=20");
			Intent streetViewIntent = new Intent(Intent.ACTION_VIEW,
					streetViewUri);
			startActivity(streetViewIntent);
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}

}
