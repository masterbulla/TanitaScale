package ca.charland.activity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Intent;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.TanitaDateAndTimeActivity;
import ca.charland.tanita.WeightActivity;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;

/**
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DateAndTimeActivityTest {

	private static class ActivityUnderTest extends TanitaDateAndTimeActivity {

		@Override 
		protected TanitaDataSource getDataSource() {
			return new TestTanitaDataSource();
		}
	}
	
	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.setIntent(new Intent());
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.activity.DateAndTimeActivity#getValues()}.
	 */
	@Test
	public final void testGetValues() {
		
		ContentValues values = activity.getValues();
		assertTrue(values.containsKey(TanitaDataTable.Column.DATE.toString()));
		Long object = (Long) values.get(TanitaDataTable.Column.DATE.toString());
		assertTrue(object.intValue() < 0);
	}

	/**
	 * Test method for {@link ca.charland.activity.DateAndTimeActivity#getNextClass()}.
	 */
	@Test
	public final void testGetNextClass() {
		assertEquals(WeightActivity.class, activity.getNextClass());
	}
}