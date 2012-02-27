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
 * Testing Metabolic Age Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class MetabolicAgeActivityTest {

	/** The class under test. */
	@Inject
	private MetabolicAgeActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.metabolic_age, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyWaterPercentageActivity.class, activity.getNextClass());
	}

}
