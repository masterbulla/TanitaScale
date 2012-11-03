package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Holds common implementations for dealing with data sources.
 * 
 * @author mcharland
 * 
 */
public abstract class DataSource {

	protected SQLiteDatabase database;

	private DatabaseHelper databaseHelper;

	private final String table;

	public DataSource(Context context, String table) {
		this.databaseHelper = new DatabaseHelper(context);
		this.table = table;
	}

	public void openDatabaseConnection() throws SQLException {
		database = databaseHelper.getWritableDatabase();
	}

	public long insertTableRow(ContentValues values) {
		long insert = database.insert(table, null, values);
		return insert;
	}

	public long updateTableRow(String id, Object idValue, ContentValues values) {
		long effected = database.update(table, values, id + '=' + idValue, null);
		return effected;
	}

	public List<Data> getAllValues() {
		return query(null);
	}

	public List<Data> query(String selection) {
		String[] columns = getAllColumns().toArray(new String[0]);
		Cursor cursor = database.query(table, columns, selection, null, null, null, null);
		List<Data> populateAll = populateAll(cursor);
		cursor.close();
		return populateAll;
	}

	private List<Data> populateAll(Cursor cursor) {
		List<Data> all = new ArrayList<Data>();
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Data comment = convertToAbstractData(cursor);
			all.add(comment);
			cursor.moveToNext();
		}
		return all;
	}

	protected abstract Data convertToAbstractData(Cursor cursor);

	protected abstract List<String> getAllColumns();

	public void closeDatabaseConnection() {
		databaseHelper.close();
	}
}
