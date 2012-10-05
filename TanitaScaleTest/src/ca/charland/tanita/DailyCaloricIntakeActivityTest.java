package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing DailyCaloricIntake Activity Class.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DailyCaloricIntakeActivityTest {

	/** The class under test. */
	@Inject
	private DailyCaloricIntakeActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.dci, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.DAILY_CALORIC_INTAKE, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MetabolicAgeActivity.class, activity.getNextClass());
	}

}