package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;

/**
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class MetabolicAgeActivityTest {

	private static class ActivityUnderTest extends MetabolicAgeActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected TanitaDataSource getDataSource() {
			return new TestTanitaDataSource();
		}
		
		@Override
		protected void setData() {
		}
	}
	
	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.metabolic_age, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.METABOLIC_AGE, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyWaterPercentageActivity.class, activity.getNextClass());
	}

}
