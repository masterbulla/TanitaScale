package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import ca.charland.db.BasicPersonDataSource;

/**
 * Holds the database information related to a person.
 * 
 * @author mcharland
 */
public class PersonDataSource extends BasicPersonDataSource {

	public PersonDataSource(Context context) {
		super(context, PersonDataTable.CREATE_PEOPLE_TABLE, PersonDataTable.TABLE);
	}

	public long create(String name, String email, String sex) {
		ContentValues values = new ContentValues();
		values.put(PersonDataTable.Column.NAME.toString(), name);
		values.put(PersonDataTable.Column.EMAIL.toString(), email);
		values.put(PersonDataTable.Column.SEX.toString(), sex);
		return insertTableRow(values);
	}

	public int delete(PersonData name) {
		long id = name.getId();
		System.out.println("Person deleted with id: " + id);
		int delete = database.delete(PersonDataTable.TABLE, PersonDataTable.Column.ID + " = " + id, null);
		return delete;
	}

	@Override
	protected PersonData convertToAbstractData(Cursor cursor) {
		PersonData person = new PersonData();
		person.setId(cursor.getInt(0));
		person.setName(cursor.getString(1));
		person.setEmail(cursor.getString(2));
		person.setSex(cursor.getString(3));
		return person;
	}

	@Override
	protected List<String> getAllColumns() {
		List<String> allColumns = new ArrayList<String>();
		allColumns.add(PersonDataTable.Column.ID.toString());
		allColumns.add(PersonDataTable.Column.NAME.toString());
		allColumns.add(PersonDataTable.Column.EMAIL.toString());
		allColumns.add(PersonDataTable.Column.SEX.toString());
		return allColumns;
	}
}
