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
 * Testing Visceral Fat Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class VisceralFatActivityTest {

	/** The class under test. */
	@Inject
	private VisceralFatActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.visceral_fat, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BoneMassActivity.class, activity.getNextClass());
	}

}
