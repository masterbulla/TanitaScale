package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.R;
import ca.charland.activity.manage.PersonHomeActivity;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;
/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PhysicRatingActivityTest {

	private static class ActivityUnderTest extends PhysicRatingActivity {

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
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.physic_rating, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.PHYSIC_RATING, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(PersonHomeActivity.class, activity.getNextClass());
	}

}
