package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

import com.google.inject.Inject;

/**
 * Testing Body Water Percentage Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyWaterPercentageActivityTest {

	/** The class under test. */
	@Inject
	private BodyWaterPercentageActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_water_percentage, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(VisceralFatActivity.class, activity.getNextClass());
	}

}
