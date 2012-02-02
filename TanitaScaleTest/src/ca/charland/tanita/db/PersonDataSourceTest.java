package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * Testing Person Data Source.
 * 
 * @author mcharland.
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDataSourceTest {

	/**
	 * Test method for
	 * {@link ca.charland.tanita.db.PersonDataSource#PersonDataSource(android.content.Context)}
	 * .
	 */
	@Test
	public void testPersonDataSource() {
		assertNotNull(new PersonDataSource(null));
	}

	/**
	 * Test method for
	 * {@link ca.charland.tanita.db.PersonDataSource#create(java.lang.String)}
	 * .
	 */
	@Test
	public void testCreatePerson() {
		PersonDataSource pds = new PersonDataSource(null);
		pds.open();
		long create = pds.create("bob");
		assertTrue(create != 0);
		pds.close();
	}

	/**
	 * Test method for
	 * {@link ca.charland.tanita.db.PersonDataSource#delete(ca.charland.tanita.db.Person)}
	 * .
	 */
	@Test
	public void testDeletePerson() {
		PersonDataSource pds = new PersonDataSource(null);
		pds.open();
		int delete = pds.delete(new Person());
		assertEquals(0, delete);
		pds.close();
	}

	/**
	 * Test method for
	 * {@link ca.charland.tanita.db.PersonDataSource#getAll()}.
	 */
	@Test
	public void testGetAllPeople() {
		PersonDataSource pds = new PersonDataSource(null);
		pds.open();
		List<AbstractData> allPeople = pds.getAll();
		assertNotNull(allPeople);
		pds.close();
	}

}
