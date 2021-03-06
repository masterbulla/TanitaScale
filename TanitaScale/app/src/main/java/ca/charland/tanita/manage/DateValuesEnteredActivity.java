package ca.charland.tanita.manage;

import java.util.List;

import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.base.activity.manage.BaseDateListOfPreviousEntriesActivity;
import ca.charland.tanita.base.activity.manage.BaseSingleDateValuesEnteredActivity;
import ca.charland.tanita.base.db.Data;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TanitaDatabaseConnection;

public class DateValuesEnteredActivity extends BaseSingleDateValuesEnteredActivity {

	@InjectView(R.id.weight)
	private TextView weight;

	@InjectView(R.id.dci)
	private TextView dci;

	@InjectView(R.id.metabolic_age)
	private TextView metabolicAge;

	@InjectView(R.id.body_water_percentage)
	private TextView bodyWaterPercentage;

	@InjectView(R.id.visceral_fat)
	private TextView visceralFat;

	@InjectView(R.id.bone_mass)
	private TextView boneMass;

	@InjectView(R.id.body_fat_total)
	private TextView bodyFatTotal;

	@InjectView(R.id.body_fat_arm_left)
	private TextView bodyfatArmLeft;

	@InjectView(R.id.body_fat_arm_right)
	private TextView bodyFatArmRight;

	@InjectView(R.id.body_fat_leg_left)
	private TextView bodyFatLegLeft;

	@InjectView(R.id.body_fat_leg_right)
	private TextView bodyFatLegRight;

	@InjectView(R.id.body_fat_trunk)
	private TextView bodyFatTrunk;

	@InjectView(R.id.muscle_mass_total)
	private TextView muscleMassTotal;

	@InjectView(R.id.muscle_mass_arm_left)
	private TextView muscleMassArmLeft;

	@InjectView(R.id.muscle_mass_arm_right)
	private TextView muscleMassArmRight;

	@InjectView(R.id.muscle_mass_leg_right)
	private TextView muscleMassLegRight;

	@InjectView(R.id.muscle_mass_leg_left)
	private TextView muscleMassLegLeft;

	@InjectView(R.id.muscle_mass_trunk)
	private TextView muscleMassTrunk;

	@InjectView(R.id.physic_rating)
	private TextView physicRating;

	@InjectView(R.id.email)
	private Button email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TanitaData td = getTanitaData();

		populateData(td);

		email.setOnClickListener(new EmailButtonOnClickListener(this, td));

	}

	protected TanitaData getTanitaData() {

		TanitaDataSource datasource = new TanitaDataSource(new TanitaDatabaseConnection(this));
		datasource.openDatabaseConnection();

		TanitaData td = getTanitaData(datasource);

		datasource.closeDatabaseConnection();

		return td;
	}

	private TanitaData getTanitaData(TanitaDataSource datasource) {
		List<Data> data = datasource.query(getSelection());
		TanitaData td = (TanitaData) data.get(0);
		return td;
	}

	private String getSelection() {
		Bundle extras = getIntent().getExtras();
		String selection = TanitaDataTable.Column.ID.toString() + " = " + extras.getInt(BaseDateListOfPreviousEntriesActivity.ID);
		return selection;
	}

	private void populateData(TanitaData td) {
		weight.setText(String.valueOf(td.getWeight()));
		dci.setText(String.valueOf(td.getDailyCaloricIntake()));
		metabolicAge.setText(String.valueOf(td.getMetabolicAge()));
		bodyWaterPercentage.setText(String.valueOf(td.getBodyWaterPercentage()));
		visceralFat.setText(String.valueOf(td.getVisceralFat()));
		boneMass.setText(String.valueOf(td.getBoneMass()));

		bodyFatTotal.setText(String.valueOf(td.getBodyFatTotal()));
		bodyfatArmLeft.setText(String.valueOf(td.getBodyFatLeftArm()));
		bodyFatArmRight.setText(String.valueOf(td.getBodyFatRightArm()));
		bodyFatLegLeft.setText(String.valueOf(td.getBodyFatLeftLeg()));
		bodyFatLegRight.setText(String.valueOf(td.getBodyFatRightLeg()));
		bodyFatTrunk.setText(String.valueOf(td.getBodyFatTrunk()));

		muscleMassTotal.setText(String.valueOf(td.getMuscleMassTotal()));
		muscleMassArmLeft.setText(String.valueOf(td.getMuscleMassLeftArm()));
		muscleMassArmRight.setText(String.valueOf(td.getMuscleMassRightArm()));
		muscleMassLegRight.setText(String.valueOf(td.getMuscleMassRightLeg()));
		muscleMassLegLeft.setText(String.valueOf(td.getMuscleMassLeftLeg()));
		muscleMassTrunk.setText(String.valueOf(td.getMuscleMassTrunk()));

		physicRating.setText(String.valueOf(td.getPhysicRating()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.date_values_entered, menu);
		return true;
	}

	/**
	 * Event Handling for Individual menu item selected Identify single menu item by it's id
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.delete:
			Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show();

			TanitaDataSource datasource = new TanitaDataSource(new TanitaDatabaseConnection(this));
			datasource.openDatabaseConnection();
			datasource.removeTableRow(getSelection());
			datasource.closeDatabaseConnection();
			
			finishActivity(Intent.FLAG_ACTIVITY_NO_HISTORY);
			finish();
			return true;
		}
		return false;
	}
}
