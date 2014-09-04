package co.gov.fna.okeda.persistence.dao;

import java.util.List;

import android.content.ContentValues;

public interface IPuntoAtencionDAO {

	public List<ContentValues> findAll(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit);

	public ContentValues save(ContentValues puntoAtencionContentValues);

	public ContentValues update(ContentValues puntoAtencionContentValues,
			String whereClause, String[] whereArgs);

}
