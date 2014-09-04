package co.gov.fna.okeda.modelo.entidades;

/**
 * Created by Oscar Gallon
 */
public class Ubicacion {

    private double Latitud;
    private double Longuitud;


    public Ubicacion(double latitud, double longuitud) {
        Latitud = latitud;
        Longuitud = longuitud;

    }


    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLonguitud() {
        return Longuitud;
    }

    public void setLonguitud(double longuitud) {
        Longuitud = longuitud;
    }
}
