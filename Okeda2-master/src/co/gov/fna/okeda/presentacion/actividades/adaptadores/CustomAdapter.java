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
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {

	Context context;
	List<OpcionesDashBoard> listaOpciones;

	public CustomAdapter(Context context, List<OpcionesDashBoard> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {
		ImageView imagenOpcioes;
		TextView txtOpcion;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
		
			convertView = mInflater.inflate(R.layout.grid_celd, null);
			
			holder = new viewHolder();
            holder.txtOpcion= (TextView)convertView.findViewById(R.id.txtNombreOpcion);
            holder.imagenOpcioes= (ImageView)convertView.findViewById(R.id.imagenOpcion);
			convertView.setTag(holder);
		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// String s = (String) getItem(position);
		OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		holder.txtOpcion.setText(option.getNombreOpcion());
        holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public OpcionesDashBoard getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}
}
