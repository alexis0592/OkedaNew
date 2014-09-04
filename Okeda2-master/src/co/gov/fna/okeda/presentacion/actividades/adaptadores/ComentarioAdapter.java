package co.gov.fna.okeda.presentacion.actividades.adaptadores;

import java.util.List;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.presentacion.actividades.Dashboard.util.OpcionesDashBoard;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ComentarioAdapter extends BaseAdapter {

	Context context;
	List<Comentario> lista;

	public ComentarioAdapter(Context context, List<Comentario> lista) {
		super();
		this.context = context;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Comentario getItem(int arg0) {
		// TODO Auto-generated method stub
		return lista.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return lista.indexOf(getItem(arg0));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater.inflate(R.layout.comentarios_layout, null);

			holder = new viewHolder();
			holder.txtMensaje = (TextView) convertView
					.findViewById(R.id.txtUsername);
			holder.txtUsername = (TextView) convertView
					.findViewById(R.id.txtMensaje);
			holder.puntuacion = (RatingBar) convertView
					.findViewById(R.id.ratingBar1);
			convertView.setTag(holder);
		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// String s = (String) getItem(position);
		Comentario option = getItem(position);
		holder.txtMensaje.setText("Comentario: " + option.getComent());
		holder.txtUsername.setText("Usuario: " + option.getUsername());
		holder.puntuacion.setRating(Float.parseFloat(option.getPuntuacion()));

		// holder.imagen.setText(s);

		return convertView;
	}

	private class viewHolder {
		RatingBar puntuacion;
		TextView txtMensaje;
		TextView txtUsername;
	}

}
