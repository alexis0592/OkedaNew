package co.gov.fna.okeda.presentacion.actividades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.gov.fna.okeda.R;
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

public class FragmentoMapa extends MapFragment {

	GoogleMap mapa;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.mapas_layout, container, false);
		mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		return v;
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

}
