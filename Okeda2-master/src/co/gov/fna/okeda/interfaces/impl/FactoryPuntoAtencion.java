package co.gov.fna.okeda.interfaces.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.gov.fna.okeda.interfaces.IFactoryPuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Entidades;
import co.gov.fna.okeda.modelo.entidades.PuntoAtencion;
import co.gov.fna.okeda.modelo.entidades.Ubicacion;

/**
 * Created by admin on 19/07/2014.
 */
public class FactoryPuntoAtencion implements IFactoryPuntoAtencion {

    private static FactoryPuntoAtencion instance;
    private List<Entidades> listaPuntosV;

    public FactoryPuntoAtencion() {
    }

    public static FactoryPuntoAtencion getInstance() {
        if (instance == null) {
            instance = new FactoryPuntoAtencion();
        }
        return instance;
    }

    @Override
    public List<Entidades> getPuntoAtencionRest() {
        return listaPuntosV;
    }

    @Override
    public void fillPuntoAtencion(JSONArray arreglo, String[] arrayPropertiesNames) {

        if (arreglo == null || arreglo.length() == 0) {
            return;
        }

        listaPuntosV = new ArrayList<Entidades>();
        JSONObject object;
        try {
            for (int i = 0; i < arreglo.length(); i++){
                object = arreglo.getJSONObject(i);
                PuntoAtencion p = new PuntoAtencion();
                int j = 0;

                p.setCedulaCodigoBarras(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setCostoTransaccion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setDepartamento(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setDireccion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setHorarioAtencion(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setHorarioExtendido(object.getString(arrayPropertiesNames[j]));
                j++;

                //Inicia ubicacion
                Double x = Double.parseDouble(object.getString(arrayPropertiesNames[j]));
                j++;
                Double y = Double.parseDouble(object.getString(arrayPropertiesNames[j]));
                j++;
                Ubicacion u = new Ubicacion(x, y);
                p.setUbicacion(u);
                //termina ubicacion

                p.setMunicipioCiudad(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setNumero(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setPartitionKey(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setTipoEntidad(object.getString(arrayPropertiesNames[j]));
                j++;
                p.setTipoServicioOfrecido(object.getString(arrayPropertiesNames[j]));
                j++;

                listaPuntosV.add(p);
            }
            setListaPuntos(listaPuntosV);
        }catch (JSONException e) {
            return;
        }

    }
    
	public void setListaPuntos(List<Entidades> listaViviendas) {
		this.listaPuntosV = listaViviendas;
	}



}
