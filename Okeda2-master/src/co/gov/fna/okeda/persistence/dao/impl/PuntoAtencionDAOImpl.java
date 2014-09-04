package co.gov.fna.okeda.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import co.gov.fna.okeda.persistence.dao.IPuntoAtencionDAO;
import co.gov.fna.okeda.persistence.sqlite.contract.PuntoAtencionContract;
import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;
import co.gov.fna.okeda.persistencia.sqlite.AccessorSqliteOpenHelper;

public class PuntoAtencionDAOImpl implements IPuntoAtencionDAO {
	
	private static final String TAG = PuntoAtencionDAOImpl.class.getSimpleName();
	
	private static PuntoAtencionDAOImpl instance = null;
	private AccessorSqliteOpenHelper accessorSqliteOpenHelper;
	
	private PuntoAtencionDAOImpl(Context context){
		super();
		this.accessorSqliteOpenHelper = new AccessorSqliteOpenHelper(context);
	}
	
	public static synchronized PuntoAtencionDAOImpl getInstance(Context context){
		if(instance == null){
			instance = new PuntoAtencionDAOImpl(context);
		}
		
		return (instance);
	}

	@Override
	public List<ContentValues> findAll(Boolean distinct, String table,
			String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy, String limit) {
		try {
			SQLiteDatabase sqLiteDatabase = this.accessorSqliteOpenHelper
					.getReadableDatabase();
			Cursor cursor = sqLiteDatabase.query(distinct.booleanValue(),
					table, columns, selection, selectionArgs, groupBy, having,
					orderBy, limit);
			List<ContentValues> contentValuesList = this.convertCursorToEntity(
					cursor, columns);
			cursor.close();

			return (contentValuesList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (null);
	}

	@Override
	public ContentValues save(ContentValues puntoAtencionContentValues) {
		try {
			SQLiteDatabase sqLiteDatabase = accessorSqliteOpenHelper
					.getReadableDatabase();

			long rowId = sqLiteDatabase.insertWithOnConflict(
					PuntoAtencionContract.TABLE_NAME, null, puntoAtencionContentValues,
					SQLiteDatabase.CONFLICT_IGNORE);
			return ((rowId != -1L) ? puntoAtencionContentValues : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ContentValues update(ContentValues puntoAtencionContentValues,
			String whereClause, String[] whereArgs) {
		try {
			SQLiteDatabase sqLiteDatabase = accessorSqliteOpenHelper
					.getReadableDatabase();
			long rowId = sqLiteDatabase.updateWithOnConflict(
					PuntoAtencionContract.TABLE_NAME, puntoAtencionContentValues,
					whereClause, whereArgs, SQLiteDatabase.CONFLICT_IGNORE);
			return ((rowId != 0) ? puntoAtencionContentValues : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<ContentValues> convertCursorToEntity(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		ContentValues contentValues = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			contentValues = new ContentValues();

			for (String column : columns) {
				contentValues.put(column,
						cursor.getString(cursor.getColumnIndex(column)));
			}

			contentValuesList.add(contentValues);
			cursor.moveToNext();
		}

		return (contentValuesList);
	}

}
