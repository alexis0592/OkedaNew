package co.gov.fna.okeda.controladores;

import java.util.ArrayList;
import java.util.List;


import co.gov.fna.okeda.R;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.interfaces.impl.FactoryVivienda;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.presentacion.actividades.BusquedaViviendas;
import co.gov.fna.okeda.utilidades.Utilities;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class ControladorBusquedaVivienda {

	private BusquedaViviendas activity;
	private ArrayAdapter<String> adaptador;
	private List<Entidades> listaViviendasEncontradas;
	private String departamentoSeleccionado;
	private String municipioSeleccionado;
	private String estratoSeleccionado;
	private String estadoObraSeleccionado;
	private String precioDesdeSeleccionado;
	private String precioHastaSeleccionado;

	public ControladorBusquedaVivienda(BusquedaViviendas activity) {
		super();
		this.activity = activity;
	}

	public void showSearchResults() {
		if (this.listaViviendasEncontradas != null
				&& this.listaViviendasEncontradas.size() > 0) {
			AlertDialog.Builder builderSingle = new AlertDialog.Builder(
					activity);
			builderSingle.setIcon(R.drawable.ic_launcher);
			builderSingle.setTitle("Select One Name:-");
			final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					activity, android.R.layout.select_dialog_singlechoice);
			for (Entidades e : listaViviendasEncontradas) {
				Vivienda v = (Vivienda) e;
				arrayAdapter.add(v.getNombreProyecto());
			}

			builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {

					ControladorMostrarVivienda controladorMoestrMostrarVivienda = ControladorMostrarVivienda
							.getInstace();
					controladorMoestrMostrarVivienda
							.setVivienda((Vivienda) listaViviendasEncontradas
									.get(arg1));
					activity.showVivienda();
					FactoryEntidades factoryEntidades = FactoryEntidades
							.getInstance();
					factoryEntidades
							.setEntidadInCurrentActivity(listaViviendasEncontradas
									.get(arg1));

				}
			});
			builderSingle.show();

		}
	}

	public void setListToSpinner() {
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		Utilities utilities = new Utilities(activity);

		List<String> listaString = utilities.getDepartments(factoryVivienda
				.getListaViviendas());
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
						else
							departamentoSeleccionado = null;

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		listaString = utilities.getCiudadesOrMunicipios(factoryVivienda
				.getListaViviendas());
		Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpCiudad().setAdapter(adaptador);
		this.activity.getSpCiudad().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0)
							municipioSeleccionado = arg0
									.getItemAtPosition(arg2).toString();
						else
							municipioSeleccionado = null;

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		listaString = utilities.getEstadoObra(factoryVivienda
				.getListaViviendas());
		Array = new String[listaString.size()];
		Array = listaString.toArray(Array);
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpEstadoObra().setAdapter(adaptador);
		this.activity.getSpEstadoObra().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0)
							estadoObraSeleccionado = arg0.getItemAtPosition(
									arg2).toString();
						else
							estadoObraSeleccionado = null;
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		Array = new String[7];
		Array[0] = "Seleccione";
		for (int i = 1; i < Array.length; i++) {
			Array[i] = Integer.toString(i + 1);
		}
		adaptador = new ArrayAdapter<String>(activity,
				android.R.layout.simple_list_item_1, Array);
		this.activity.getSpEstrato().setAdapter(adaptador);
		this.activity.getSpEstrato().setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (arg2 != 0)
							estratoSeleccionado = arg0.getItemAtPosition(arg2)
									.toString();
						else
							estratoSeleccionado = null;

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});
	}

	public void processSearchButton() {
		precioDesdeSeleccionado = this.activity.getTxtPrecioDesde().getText()
				.toString();
		precioHastaSeleccionado = this.activity.getTxtPrecioHasta().getText()
				.toString();

		if (departamentoSeleccionado != null) {
			if (municipioSeleccionado != null) {
				if (estadoObraSeleccionado != null) {
					if (estratoSeleccionado != null) {
						if (precioDesdeSeleccionado != null) {

							if (precioHastaSeleccionado != null) {
								searchByDepartamentoCiudadEstratoEstadoObraPrecioDesdePrecioHasta(
										departamentoSeleccionado,
										estratoSeleccionado,
										estadoObraSeleccionado,
										precioDesdeSeleccionado,
										precioHastaSeleccionado,
										municipioSeleccionado);
							}
							searchByDepartamentoCiudadEstratoEstadoObraPrecioDesde(
									departamentoSeleccionado,
									estratoSeleccionado,
									estadoObraSeleccionado,
									precioDesdeSeleccionado,
									municipioSeleccionado);
						}
					}
					searchByDepartamentoCiudadEstratoEstadoObra(
							departamentoSeleccionado, municipioSeleccionado,
							estratoSeleccionado, estadoObraSeleccionado);

				}
				searchByDepartamentoCiudad(departamentoSeleccionado,
						municipioSeleccionado);
			} else if (estadoObraSeleccionado != null) {
				if (estratoSeleccionado != null) {
					if (precioDesdeSeleccionado != null) {
						if (precioHastaSeleccionado != null) {
							searchByDepartamentoEstratoEstadoObraPrecioDesdePrecioHasta(
									departamentoSeleccionado,
									estratoSeleccionado,
									estadoObraSeleccionado,
									precioDesdeSeleccionado,
									precioHastaSeleccionado);
						}
						searchByDepartamentoEstratoEstadoObraPrecioDesde(
								departamentoSeleccionado, estratoSeleccionado,
								estadoObraSeleccionado, precioDesdeSeleccionado);
					}
					searchByDepartamentoEstrato(departamentoSeleccionado,
							estratoSeleccionado);
				}
			} else if (estratoSeleccionado != null) {
				if (precioDesdeSeleccionado != null) {
					if (precioHastaSeleccionado != null) {
						searchByDepartamentoEstratoPrecioDesdePrecioHasta(
								departamentoSeleccionado,
								precioDesdeSeleccionado,
								precioHastaSeleccionado, estratoSeleccionado);
					}
					searchByDepartamentoEstratoPrecioDesde(
							departamentoSeleccionado, estratoSeleccionado,
							precioDesdeSeleccionado);
				} else if (precioHastaSeleccionado != null) {
					searchByDepartamentoEstratoPrecioHasta(
							departamentoSeleccionado, estratoSeleccionado,
							precioHastaSeleccionado);
				}
				searchByDepartamentoEstrato(departamentoSeleccionado,
						estratoSeleccionado);
			} else if (precioDesdeSeleccionado != null) {
				if (precioHastaSeleccionado != null) {
					searchByDepartamentoPrecioDesdePrecioHasta(
							departamentoSeleccionado, precioDesdeSeleccionado,
							precioHastaSeleccionado);
				}
				searchByDepartamentoPrecioDesde(departamentoSeleccionado,
						precioDesdeSeleccionado);
			}
			searchByDepartamento(departamentoSeleccionado);

		} else if (estratoSeleccionado != null) {
			if (estadoObraSeleccionado != null) {
				if (precioDesdeSeleccionado != null) {
					if (precioHastaSeleccionado != null) {
						searchByEstratoEstadoObraPrecioDesdePrecioHasta(
								estratoSeleccionado, estadoObraSeleccionado,
								precioDesdeSeleccionado,
								precioHastaSeleccionado);
					}
					searchByEstratoEstadoObraPrecioDesde(estratoSeleccionado,
							estadoObraSeleccionado, precioDesdeSeleccionado);
				} else if (precioHastaSeleccionado != null) {
					searchByEstratoEstadoObraPrecioHasta(estratoSeleccionado,
							estadoObraSeleccionado, precioHastaSeleccionado);
				}
			}
			searchByEstrato(estratoSeleccionado);
		} else if (estadoObraSeleccionado != null) {
			if (precioDesdeSeleccionado != null) {
				if (precioHastaSeleccionado != null) {
					searchByEstadoObraPrecioDesdePrecioHasta(
							estadoObraSeleccionado, precioDesdeSeleccionado,
							precioHastaSeleccionado);
				}
				searchByEstadoObraPrecioDesde(estadoObraSeleccionado,
						precioDesdeSeleccionado);
			}
			searchByEstadoObra(estadoObraSeleccionado);
		} else if (precioDesdeSeleccionado != null) {
			if (precioHastaSeleccionado != null) {
				searchByPrecioDesdePrecioHasta(precioDesdeSeleccionado,
						precioHastaSeleccionado);
			}
			searchByPrecioDesde(precioDesdeSeleccionado);
		} else if (precioHastaSeleccionado != null) {
			searchByPrecioHasta(precioHastaSeleccionado);
		} else {
			Utilities utilities = new Utilities(activity);
			utilities.showAlertMessage(
					"Error Parametros de Busqueda Vacios o Invalidos", "Error");
		}

	}

	public void searchByDepartamento(String departamento) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			if (e.getDepartamento().equals(departamento))
				listaViviendasEncontradas.add(e);
		}
		showSearchResults();

	}

	public void searchByDepartamentoPrecioDesde(String departamento,
			String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			if (e.getDepartamento().equals(departamento)) {
				Vivienda v = (Vivienda) e;
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(e);
					}
				}
			}

		}
		showSearchResults();

	}

	public void searchByDepartamentoEstrato(String Departamento, String estrato) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato))
				listaViviendasEncontradas.add(e);
		}
		showSearchResults();
	}

	public void searchByDepartamentoEstratoEstadoObra(String Departamento,
			String estrato, String estadoObra) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra))
				listaViviendasEncontradas.add(e);
		}
		showSearchResults();
	}

	public void searchByDepartamentoEstratoPrecioDesde(String Departamento,
			String estrato, String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(e);
					}
				}

			}

		}
		showSearchResults();
	}

	public void searchByDepartamentoEstratoEstadoObraPrecioDesde(
			String Departamento, String estrato, String estadoObra,
			String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(e);
					}
				}

			}

		}
		showSearchResults();

	}

	public void searchByDepartamentoEstratoEstadoObraPrecioDesdePrecioHasta(
			String Departamento, String estrato, String estadoObra,
			String precioDesde, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(e);
					}
				}

			}

		}
		showSearchResults();

	}

	public int tryConvertStringToInt(String s) {
		try {
			int x = Integer.parseInt(s);
			return x;
		} catch (Exception e) {
			return -10;
		}

	}

	public void searchByDepartamentoCiudad(String Departamento, String ciudad) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			if (e.getDepartamento().equals(Departamento)
					&& e.getMunicipioCiudad().equals(ciudad))
				listaViviendasEncontradas.add(e);
		}
		showSearchResults();

	}

	public void searchByDepartamentoCiudadEstrato(String Departamento,
			String ciudad, String estrato) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getMunicipioCiudad().equals(ciudad)
					&& v.getEstrato().equals(estrato))
				listaViviendasEncontradas.add(v);
		}

		showSearchResults();
	}

	public void searchByDepartamentoCiudadEstratoEstadoObra(
			String Departamento, String ciudad, String estrato,
			String estadoObra) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getMunicipioCiudad().equals(ciudad)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra))
				;
			listaViviendasEncontradas.add(v);
		}
		showSearchResults();

	}

	public void searchByDepartamentoCiudadEstratoEstadoObraPrecioDesde(
			String Departamento, String estrato, String estadoObra,
			String precioDesde, String ciudad) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra)
					&& v.getMunicipioCiudad().equals(ciudad)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(v);
					}
				}

			}

		}
		showSearchResults();

	}

	public void searchByDepartamentoCiudadEstratoEstadoObraPrecioDesdePrecioHasta(
			String Departamento, String estrato, String estadoObra,
			String precioDesde, String precioHasta, String ciudad) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estrato)
					&& v.getEstadoObra().equals(estadoObra)
					&& v.getMunicipioCiudad().equals(ciudad)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(v);
					}
				}

			}

		}
		showSearchResults();
	}

	public void searchByDepartamentoEstratoPrecioDesdePrecioHasta(
			String Departamento, String precioDesde, String precioHasta,
			String estrato) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estratoSeleccionado)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(v);
					}
				}

			}

		}
		showSearchResults();
	}

	public void searchByDepartamentoEstratoPrecioHasta(String Departamento,
			String estrato, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)
					&& v.getEstrato().equals(estratoSeleccionado)) {

				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (m != -10) {
					int n = tryConvertStringToInt(precioHasta);
					if (m <= n)
						listaViviendasEncontradas.add(v);

				}

			}

		}
		showSearchResults();
	}

	public void searchByDepartamentoPrecioDesdePrecioHasta(String Departamento,
			String precioDesde, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(v);
					}
				}

			}

		}
		showSearchResults();
	}

	public void searchByDepartamentoPrecioHasta(String Departamento,
			String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getDepartamento().equals(Departamento)) {

				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (m != -10) {
					int n = tryConvertStringToInt(precioHasta);
					if (m <= n)
						listaViviendasEncontradas.add(v);

				}

			}

		}
		showSearchResults();
	}

	// estratos

	public void searchByEstrato(String Estrato) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstrato().equals(Estrato)) {
				listaViviendasEncontradas.add(v);
			}
		}
		showSearchResults();
		//
	}

	public void searchByEstratoEstadoObra(String Estrato, String estadoObra) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstrato().equals(Estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				listaViviendasEncontradas.add(v);
			}
		}
		showSearchResults();
		//
	}

	public void searchByEstratoEstadoObraPrecioDesde(String Estrato,
			String estadoObra, String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstrato().equals(Estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(v);
					}
				}
			}
		}
		showSearchResults();
		//
	}

	public void searchByEstratoEstadoObraPrecioHasta(String Estrato,
			String estadoObra, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstrato().equals(Estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10) {
					int x = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y <= x)
							listaViviendasEncontradas.add(v);
					}
				}
			}
		}
		showSearchResults();

		//
	}

	public void searchByEstratoEstadoObraPrecioDesdePrecioHasta(String Estrato,
			String estadoObra, String precioDesde, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstrato().equals(Estrato)
					&& v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(v);
					}
				}
			}
		}
		showSearchResults();
		//
	}

	public void searchByEstadoObra(String estadoObra) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstadoObra().equals(estadoObra)) {
				listaViviendasEncontradas.add(v);
			}
		}
		showSearchResults();

		//
	}

	public void searchByEstadoObraPrecioDesde(String estadoObra,
			String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				if (y != -10) {
					int x = tryConvertStringToInt(precioDesde);
					if (x != -10) {
						if (y >= x)
							listaViviendasEncontradas.add(v);
					}
				}
			}
		}
		showSearchResults();

		//
	}

	public void searchByEstadoObraPrecioDesdePrecioHasta(String estadoObra,
			String precioDesde, String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			if (v.getEstadoObra().equals(estadoObra)) {
				int y = tryConvertStringToInt(v.getPrecioDesde());
				int m = tryConvertStringToInt(v.getPrecioHasta());
				if (y != -10 && m != -10) {
					int x = tryConvertStringToInt(precioDesde);
					int n = tryConvertStringToInt(precioHasta);
					if (x != -10) {
						if (y >= x && m <= n)
							listaViviendasEncontradas.add(v);
					}
				}
			}
		}
		showSearchResults();

		//
	}

	public void searchByPrecioDesde(String precioDesde) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			int y = tryConvertStringToInt(v.getPrecioDesde());
			if (y != -10) {
				int x = tryConvertStringToInt(precioDesde);
				if (x != -10) {
					if (y >= x)
						listaViviendasEncontradas.add(v);
				}
			}
		}
		showSearchResults();
	}

	public void searchByPrecioDesdePrecioHasta(String precioDesde,
			String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			int y = tryConvertStringToInt(v.getPrecioDesde());
			int m = tryConvertStringToInt(v.getPrecioHasta());
			if (y != -10 && m != -10) {
				int x = tryConvertStringToInt(precioDesde);
				int n = tryConvertStringToInt(precioHasta);
				if (x != -10) {
					if (y >= x && m <= n)
						listaViviendasEncontradas.add(v);
				}
			}
		}
		showSearchResults();
	}

	public void searchByPrecioHasta(String precioHasta) {
		listaViviendasEncontradas = new ArrayList<Entidades>();
		FactoryVivienda factoryVivienda = FactoryVivienda.getInstance();
		for (Entidades e : factoryVivienda.getListaViviendas()) {
			Vivienda v = (Vivienda) e;
			int y = tryConvertStringToInt(v.getPrecioHasta());
			if (y != -10) {
				int x = tryConvertStringToInt(precioHasta);
				if (x != -10) {
					if (y <= x)
						listaViviendasEncontradas.add(v);
				}
			}
		}
		showSearchResults();
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(BusquedaViviendas activity) {
		this.activity = activity;
	}

}
