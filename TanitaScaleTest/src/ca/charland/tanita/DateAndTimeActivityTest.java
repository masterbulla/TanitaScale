package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Intent;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DateAndTimeActivityTest {

	@Inject
	private DateAndTimeActivity activity;

	@Before
	public void setup() {
		activity.setIntent(new Intent());
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DateAndTimeActivity#getValues()}.
	 */
	@Test
	public final void testGetValues() {
		
		ContentValues values = activity.getValues();
		assertTrue(values.containsKey(TanitaDataTable.Column.DATE.toString()));
		Long object = (Long) values.get(TanitaDataTable.Column.DATE.toString());
		assertTrue(object.intValue() < 0);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DateAndTimeActivity#getNextClass()}.
	 */
	@Test
	public final void testGetNextClass() {
		assertEquals(WeightActivity.class, activity.getNextClass());
	}
}