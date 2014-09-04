package co.gov.fna.okeda.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import co.gov.fna.okeda.persistence.dao.IViviendaDAO;
import co.gov.fna.okeda.persistence.sqlite.contract.ViviendaContract;
import co.gov.fna.okeda.persistencia.sqlite.AccessorSqliteOpenHelper;

/**
 * Created by Alexis-PC on 19/07/2014.
 */
public class ViviendaDAOImpl implements IViviendaDAO {

	private static final String TAG = ViviendaDAOImpl.class.getSimpleName();

	private static ViviendaDAOImpl instance = null;
	private AccessorSqliteOpenHelper accessorSqliteOpenHelper;

	private ViviendaDAOImpl(Context context) {
		super();
		this.accessorSqliteOpenHelper = new AccessorSqliteOpenHelper(context);
	}

	public static synchronized ViviendaDAOImpl getInstance(Context context) {
		if (instance == null) {
			instance = new ViviendaDAOImpl(context);
		}
		return instance;
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
	public ContentValues save(ContentValues viviendaContentValues) {

		try {
			SQLiteDatabase sqLiteDatabase = accessorSqliteOpenHelper
					.getWritableDatabase();

			long rowId = sqLiteDatabase.insertWithOnConflict(
					ViviendaContract.TABLE_NAME, null, viviendaContentValues,
					SQLiteDatabase.CONFLICT_IGNORE);
			return ((rowId != -1L) ? viviendaContentValues : null);
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		//return null;
	}

	@Override
	public ContentValues update(ContentValues viviendaContentValues,
			String whereClause, String[] whereArgs) {
		try {
			SQLiteDatabase sqLiteDatabase = accessorSqliteOpenHelper
					.getWritableDatabase();
			long rowId = sqLiteDatabase.updateWithOnConflict(
					ViviendaContract.TABLE_NAME, viviendaContentValues,
					whereClause, whereArgs, SQLiteDatabase.CONFLICT_IGNORE);
			return ((rowId != 0) ? viviendaContentValues : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ContentValues> cursorToContentValues(Cursor cursor,
			String[] columns) {
		List<ContentValues> contentValuesList = new ArrayList<ContentValues>();

		if ((cursor == null) || (cursor.isClosed())) {

			return (contentValuesList);
		}

		if (columns == null) {
			columns = ViviendaContract.Column.getAllColumns();
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
