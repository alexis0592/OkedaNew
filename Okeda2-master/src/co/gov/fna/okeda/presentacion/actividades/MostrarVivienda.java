package co.gov.fna.okeda.presentacion.actividades;

import co.gov.fna.okeda.R;
import co.gov.fna.okeda.R.id;
import co.gov.fna.okeda.R.layout;
import co.gov.fna.okeda.R.menu;
import co.gov.fna.okeda.controladores.ControladorComentarios;
import co.gov.fna.okeda.controladores.ControladorMostrarVivienda;
import co.gov.fna.okeda.interfaces.impl.FactoryEntidades;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.Vivienda;
import co.gov.fna.okeda.utilidades.SocialNetwork;

import com.example.usuario.tryww.Mapas;
import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.os.Build;

public class MostrarVivienda extends Activity {

	private ControladorMostrarVivienda controlador;
	private TextView txtNombreProyecto;
	private TextView txtClaseDeVivienda;
	private TextView txtDepartamento;
	private TextView txtCiudad;
	private TextView txtEstrato;
	private TextView txtEstadoObra;
	private TextView txtFechaEntrega;
	private TextView txtValorInmueble;
	private TextView txtCuotaInicial;
	private TextView txtCuotaMensual;
	private TextView txtDireccionSalaDeVentas;
	static int mFlipping = 0;
	private ImageView im1;
	private ImageView im2;
	private ImageView im3;
	private ImageView im4;
	private ImageView im5;
	private ImageView im6;
	private ViewFlipper viewFlipper;
	private RatingBar rating;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar_vivienda);
		if (savedInstanceState == null) {
			initComponents();
			controlador = ControladorMostrarVivienda.getInstace();
			controlador.setActividad(this);
			controlador.showViviendaInformation();
			controlador.goForImagenes();
		}
	}

	public void comentar(View v) {
		Intent i = new Intent(this, ComentariosActivity.class);
		startActivity(i);

	}

	public void formulario(View v) {
		Intent i = new Intent(this, com.example.usuario.tryww.Formulario.class);
		startActivity(i);

	}

	public void mapaIntent(View v) {
		// Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
		// Uri.parse("http://maps.google.com/maps?saddr="+controlador.getVivienda().getUbicacion().getLatitud()+","+controlador.getVivienda().getUbicacion().getLonguitud()+""));
		Intent intent = new Intent(this, Mapas.class);
		startActivity(intent);
	}

	public void mapaVEr(View v) {
		// Class c= MapaActivity.class;
		// Intent i = new Intent(this, MapasAc.class);
		// startActivity(i);
		double x = controlador.getVivienda().getUbicacion().getLatitud();
		double y = controlador.getVivienda().getUbicacion().getLonguitud();
		Uri streetViewUri = Uri.parse("google.streetview:cbll=" + x + "," + y
				+ "&cbp=1,90,,0,1.0&mz=20");
		Intent streetViewIntent = new Intent(Intent.ACTION_VIEW, streetViewUri);
		startActivity(streetViewIntent);//
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public void initComponents() {
		txtNombreProyecto = (TextView) findViewById(R.id.txtNombreProyecto);
		txtClaseDeVivienda = (TextView) findViewById(R.id.txtClaseDeVivienda);
		txtDepartamento = (TextView) findViewById(R.id.txtDepartamento);
		txtCiudad = (TextView) findViewById(R.id.txtCiudad);
		txtEstrato = (TextView) findViewById(R.id.txtEstrato);
		txtEstadoObra = (TextView) findViewById(R.id.txtEstadoObra);
		txtFechaEntrega = (TextView) findViewById(R.id.txtFechaEntrega);
		txtValorInmueble = (TextView) findViewById(R.id.txtValorInmueble);
		txtCuotaInicial = (TextView) findViewById(R.id.txtCuotaInicia);
		txtCuotaMensual = (TextView) findViewById(R.id.txtCuotaMensual);
		txtDireccionSalaDeVentas = (TextView) findViewById(R.id.txtDireccionSalaDeVentas);
		viewFlipper = (ViewFlipper) findViewById(R.id.flipper2);
		rating = (RatingBar) findViewById(R.id.ratingBar1);
		rating.setEnabled(false);
		im1 = (ImageView) findViewById(R.id.imv1);
		im2 = (ImageView) findViewById(R.id.imv2);
		im3 = (ImageView) findViewById(R.id.imv3);
		im4 = (ImageView) findViewById(R.id.imv4);
		im5 = (ImageView) findViewById(R.id.imv5);
		im6 = (ImageView) findViewById(R.id.imv6);
		im1.setImageResource(R.drawable.house);
		im2.setImageResource(R.drawable.house);
		im3.setImageResource(R.drawable.house);
		im4.setImageResource(R.drawable.house);
		im5.setImageResource(R.drawable.house);
		im6.setImageResource(R.drawable.house);

	}

	public ControladorMostrarVivienda getControlador() {
		return controlador;
	}

	public void setControlador(ControladorMostrarVivienda controlador) {
		this.controlador = controlador;
	}

	public TextView getTxtNombreProyecto() {
		return txtNombreProyecto;
	}

	public void setTxtNombreProyecto(TextView txtNombreProyecto) {
		this.txtNombreProyecto = txtNombreProyecto;
	}

	public TextView getTxtClaseDeVivienda() {
		return txtClaseDeVivienda;
	}

	public void setTxtClaseDeVivienda(TextView txtClaseDeVivienda) {
		this.txtClaseDeVivienda = txtClaseDeVivienda;
	}

	public TextView getTxtDepartamento() {
		return txtDepartamento;
	}

	public void setTxtDepartamento(TextView txtDepartamento) {
		this.txtDepartamento = txtDepartamento;
	}

	public TextView getTxtCiudad() {
		return txtCiudad;
	}

	public void setTxtCiudad(TextView txtCiudad) {
		this.txtCiudad = txtCiudad;
	}
	
	

	public RatingBar getRating() {
		return rating;
	}

	public void setRating(RatingBar rating) {
		this.rating = rating;
	}

	public TextView getTxtEstrato() {
		return txtEstrato;
	}

	public void setTxtEstrato(TextView txtEstrato) {
		this.txtEstrato = txtEstrato;
	}

	public TextView getTxtEstadoObra() {
		return txtEstadoObra;
	}

	public void setTxtEstadoObra(TextView txtEstadoObra) {
		this.txtEstadoObra = txtEstadoObra;
	}

	public TextView getTxtFechaEntrega() {
		return txtFechaEntrega;
	}

	public void setTxtFechaEntrega(TextView txtFechaEntrega) {
		this.txtFechaEntrega = txtFechaEntrega;
	}

	public TextView getTxtValorInmueble() {
		return txtValorInmueble;
	}

	public void setTxtValorInmueble(TextView txtValorInmueble) {
		this.txtValorInmueble = txtValorInmueble;
	}

	public TextView getTxtCuotaInicial() {
		return txtCuotaInicial;
	}

	public void setTxtCuotaInicial(TextView txtCuotaInicial) {
		this.txtCuotaInicial = txtCuotaInicial;
	}

	public TextView getTxtCuotaMensual() {
		return txtCuotaMensual;
	}

	public void setTxtCuotaMensual(TextView txtCuotaMensual) {
		this.txtCuotaMensual = txtCuotaMensual;
	}

	public TextView getTxtDireccionSalaDeVentas() {
		return txtDireccionSalaDeVentas;
	}

	public void setTxtDireccionSalaDeVentas(TextView txtDireccionSalaDeVentas) {
		this.txtDireccionSalaDeVentas = txtDireccionSalaDeVentas;
	}

	public static int getmFlipping() {
		return mFlipping;
	}

	public static void setmFlipping(int mFlipping) {
		MostrarVivienda.mFlipping = mFlipping;
	}

	public ImageView getIm1() {
		return im1;
	}

	public void setIm1(ImageView im1) {
		this.im1 = im1;
	}

	public ImageView getIm2() {
		return im2;
	}

	public void setIm2(ImageView im2) {
		this.im2 = im2;
	}

	public ImageView getIm3() {
		return im3;
	}

	public void setIm3(ImageView im3) {
		this.im3 = im3;
	}

	public ImageView getIm4() {
		return im4;
	}

	public void setIm4(ImageView im4) {
		this.im4 = im4;
	}

	public ImageView getIm5() {
		return im5;
	}

	public void setIm5(ImageView im5) {
		this.im5 = im5;
	}

	public ImageView getIm6() {
		return im6;
	}

	public void setIm6(ImageView im6) {
		this.im6 = im6;
	}

	public ViewFlipper getViewFlipper() {
		return viewFlipper;
	}

	public void setViewFlipper(ViewFlipper viewFlipper) {
		this.viewFlipper = viewFlipper;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mostrar_vivienda, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void MueveADerecha(View v) {
		viewFlipper.setOutAnimation(outToLeftAnimation());
		viewFlipper.showPrevious();

	}

	public void mueveAIzquierda(View v) {
		viewFlipper.setOutAnimation(outToRightAnimation());
		viewFlipper.showNext();

	}

	public void listener1(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(0) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(0));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	public void listener2(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(1) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(1));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	public void listener3(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(2) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(2));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	public void listener4(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(3) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(3));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	public void listener5(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(4) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(4));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	public void listener6(View v) {
		AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
		LayoutInflater factory = LayoutInflater.from(this);
		final View view = factory.inflate(R.layout.imagen_show, null);
		ImageView imd = (ImageView) view.findViewById(R.id.imageShow);
		if (controlador.getVivienda().getImagenes().get(5) != null) {
			imd.setImageBitmap(controlador.getVivienda().getImagenes().get(5));
		}

		alertadd.setNegativeButton("Cerrar",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dlg, int sumthin) {

					}
				});
		alertadd.setView(view);
		alertadd.show();
	}

	private static Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	private static Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(500);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	public void shareOnSocialNetwork(View view) {
		SocialNetwork socialNetwork = new SocialNetwork();
		FactoryEntidades factoryEntidades = FactoryEntidades.getInstance();
		Entidades e = factoryEntidades.getEntidadInCurrentActivity();
		if (e instanceof Vivienda) {
			Vivienda vivienda = (Vivienda) e;
			String viviendaMostrar = "Me interesa esta vivienda: "
					+ vivienda.getNombreProyecto() + "\n"
					+ vivienda.getClaseDEVivienda() + "Valor del inmueble: "
					+ "\n" + vivienda.getValorInmueble()
					+ "Dirección sala de ventas: "
					+ vivienda.getDireccionSalaDeVentas();

			socialNetwork.compartirRedSocial(this, viviendaMostrar);
		}
	}

}
