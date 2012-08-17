package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing of People Table.
 * 
 * @author mcharland
 *
 */
public class PersonDataTableTest extends PersonDataTable {

	/**
	 * Test that the CREATE method has been generated correctly.
	 */
	@Test
	public void testCreate() {
		assertEquals("create table person( _id integer primary key autoincrement, name text not null, email text not null);", PersonDataTable.CREATE);
	}

}
