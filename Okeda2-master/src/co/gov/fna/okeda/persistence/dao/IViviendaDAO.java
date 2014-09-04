package co.gov.fna.okeda.persistence.dao;


import android.content.ContentValues;

import java.util.List;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public interface IViviendaDAO {

    public List<ContentValues> findAll(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit);

    public ContentValues save (ContentValues viviendaContentValues);

    public ContentValues update (ContentValues viviendaContentValues, String whereClause, String[] whereArgs);

}
