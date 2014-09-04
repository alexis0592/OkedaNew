package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryUsuario;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Usuario;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.ComentariosActivity;
import co.gov.fna.okeda.presentacion.actividades.adaptadores.Comentario;
import co.gov.fna.okeda.presentacion.actividades.adaptadores.ComentarioAdapter;
import co.gov.fna.okeda.utilidades.Utilities;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ControladorComentarios {
	private List<ParseObject> listaObjetos;
	private Utilities util;
	private ComentariosActivity activity;
	private List<String> listaComentarios;
	private List<String> puntuations;
	private List<Comentario> comentarios;

	public ControladorComentarios(ComentariosActivity actividad) {
		this.activity = actividad;
		util = new Utilities(actividad);
		puntuations = new ArrayList<String>();
		comentarios = new ArrayList<Comentario>();

	}

	public Utilities getUtil() {
		return util;
	}

	public void setUtil(Utilities util) {
		this.util = util;
	}

	public void createComent(final String Puntuacion, final String coment) {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();

		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			final Vivienda v = (Vivienda) e;
			ParseQuery<ParseObject> query = ParseQuery.getQuery("vivienda");
			query.whereEqualTo("partitionKey", v.getPartitionKey());
			query.findInBackground(new FindCallback<ParseObject>() {
				public void done(List<ParseObject> scoreList, ParseException e) {
					if (e == null) {
						if (!scoreList.isEmpty())
							saveComent(scoreList.get(0), coment, Puntuacion, v);
						else
							saveComent(new ParseObject("vivienda"), coment,
									Puntuacion, v);
					} else {

					}
				}
			});

		}
	}

	public void saveComent(final ParseObject vivienda, final String coment,
			final String Puntuacion, final Vivienda v) {

		FactoryUsuario factoryUsuario = FactoryUsuario.getInstance();

		final Usuario u = factoryUsuario.getCurrentUserInActivity();

		final SaveCallback comentarioSavedCallBack = new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null)
					updatePromComentarios(vivienda, Puntuacion);
				addToViviendaList(coment, Puntuacion, u.getUser().getUsername());
				util.showAlertMessage("Comentario Enviado Correctamente",
						"Exito");
			}
		};

		final SaveCallback viviendaSavedCallback = new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null) {
					ParseObject comentario = new ParseObject("Comentario");
					comentario.put("mensaje", coment);
					comentario.put("vivienda", vivienda);
					comentario.put("usuario", u.getUser());
					comentario.put("puntuacion", Puntuacion);
					comentario.saveInBackground(comentarioSavedCallBack);

				}

			}
		};

		vivienda.put("partitionKey", v.getPartitionKey());
		vivienda.increment("numeroVisitas");
		vivienda.increment("numeroComentarios");
		vivienda.saveInBackground(viviendaSavedCallback);

	}

	public void updatePromComentarios(ParseObject v, String puntuacion) {
		int numeroVisits = v.getInt("numeroVisitas");
		int prom = v.getInt("puntuacionPromedio");
		int promedio = 0;
		if (numeroVisits != 0) {
			for (String s : puntuations) {
				promedio += Integer.parseInt(s);

			}
			if (promedio != 0) {

				promedio = promedio / numeroVisits;
				v.put("puntuacionPromedio", promedio);
				v.saveInBackground();
			}
		}

	}

	public void showProgress() {
		util.showDialog("Alerta",
				"Por Favor Espere Mientras traemos los Comentarios", false);
	}

	public void cancelDialog() {
		util.cancellDialog();
	}

	public void MuestraComentarios() {
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			final Vivienda v = (Vivienda) e;
			ParseObject vivi;
			String[] x = new String[listaObjetos.size()];
			int i = 0;
			for (final ParseObject p : listaObjetos) {
				p.getParseObject("vivienda").fetchIfNeededInBackground(
						new GetCallback<ParseObject>() {

							@Override
							public void done(ParseObject vivienda,
									ParseException arg1) {
								// TODO Auto-generated method stub
								if (vivienda != null) {
									String partitionKey = vivienda
											.getString("partitionKey");
									if (partitionKey != null) {
										if (partitionKey.equals(v
												.getPartitionKey())) {
											p.getParseObject("usuario")
													.fetchIfNeededInBackground(
															new GetCallback<ParseUser>() {

																@Override
																public void done(
																		ParseUser usuer,
																		ParseException arg1) {
																	// TODO
																	// Auto-generated
																	// method
																	// stub
																	addToViviendaList(
																			p.getString("mensaje"),
																			p.getString("puntuacion"),
																			usuer.getUsername());
																}
															});

											String pipi = p
													.getString("puntuacion");
											if (pipi != null)
												puntuations.add(pipi);

										}
									}
								}
							}
						});
				/*
				 * / if (vivi != null) { String partitionKey =
				 * vivi.getString("id"); if (partitionKey != null) { if
				 * 
				 * 
				 * } /
				 */

			}

		}

	}

	public void addToViviendaList(String mensaje, String puntuacion,
			String username) {
		if (comentarios == null) {
			comentarios = new ArrayList<Comentario>();
		}
		Comentario c = new Comentario();
		c.setComent(mensaje);
		c.setPuntuacion(puntuacion);
		c.setUsername(username);
		comentarios.add(c);
		showComentList();

	}

	public void showComentList() {

		ComentarioAdapter ada = new ComentarioAdapter(
				activity.getApplicationContext(), comentarios);

		activity.getLv().setAdapter(ada);
		activity.getLv().setOnItemClickListener(
				new android.widget.AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					}
				});
	}

	public List<ParseObject> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(List<ParseObject> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	public void getComentarios() {
		ParseServices parse = new ParseServices("Comentario", this);
		parse.execute();
	}
}
