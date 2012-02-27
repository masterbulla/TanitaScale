package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing of Abstract Text View Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class AbstractTextViewActivityTest {

	/** The class under test. */
	@Inject
	private BodyFatLeftArmActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.AbstractTextViewActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertEquals(1, values.size());
		assertTrue(values.containsKey(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
		assertEquals("", values.get(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
	}

}
