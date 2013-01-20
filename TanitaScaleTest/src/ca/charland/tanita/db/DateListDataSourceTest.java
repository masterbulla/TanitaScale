package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.db.Data;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DateListDataSourceTest {

	private DateListDataSource dateList;

	@Before
	public void setup() {
		dateList = new DateListDataSource(null);
	}

	@After
	public void tearDown() {
		dateList.closeDatabaseConnection();
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.DateListDataSource#DateListDataSource(android.content.Context)}.
	 */
	@Test
	public void testDateListDataSource() {
		assertNotNull(dateList);
	}
	/**
	 * Test method for {@link ca.charland.tanita.db.DateListDataSource#convertToAbstractData(android.database.Cursor)}.
	 */
	@Test
	public void testConvertToAbstractData() {
		int id = 5;
		int person = 53;
		long date = 112341234L;

		CustomCursor cursor = new CustomCursor();
		cursor.setInt(0, id);
		cursor.setInt(1, person);
		cursor.setLong(2, date);

		Data data = dateList.convertToAbstractData(cursor);
		
		assertEquals(id, data.getId());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.DateListDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumns() {
		List<String> allColumns = dateList.getAllColumns();
		assertEquals(3, allColumns.size());
		assertEquals("_id", allColumns.get(0));
		assertEquals("person", allColumns.get(1));
		assertEquals("date", allColumns.get(2));
	}
}
