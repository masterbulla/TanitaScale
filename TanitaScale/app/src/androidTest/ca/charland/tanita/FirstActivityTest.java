package ca.charland.tanita;

import android.test.ActivityInstrumentationTestCase2;
import ca.charland.tanita.manage.FirstActivity;

import com.robotium.solo.Solo;

public class FirstActivityTest extends ActivityInstrumentationTestCase2<FirstActivity>{

	private Solo solo;

	public FirstActivityTest() {
		super("ca.charland.tanita.manage", FirstActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
		solo.unlockScreen();
	}
	
	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testOpenAddANewPerson() throws Exception {
		solo.clickOnMenuItem("Add a New Person");
		solo.assertCurrentActivity("Expected Add a new Person activity", "AddANewPersonActivity"); 
	}

	public void testOpenViewAPerson() throws Exception {
		solo.clickOnMenuItem("View a Person");
		solo.assertCurrentActivity("Expected View a Person activity", "AllPeopleListActivity"); 
	}
	
	public void testOpenSettings() throws Exception {
		solo.clickOnMenuItem("Settings");
		solo.assertCurrentActivity("Expected Settings activity", "PreferencesActivity"); 
	}
}
