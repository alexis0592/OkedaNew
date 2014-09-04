package co.gov.fna.okeda.interfaces;



import org.json.JSONArray;

import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;

import java.util.List;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public interface IFactoryPuntoAtencion {

    List<Entidades> getPuntoAtencionRest();

    public void fillPuntoAtencion(JSONArray arreglo, String[] arrayPropertiesNames);
}
