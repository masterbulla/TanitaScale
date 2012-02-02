package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;

/**
 * This is the first person specific screen which allows you to choose what you want to do.
 * 
 * @author mcharland
 */
@ContentView(R.layout.person_home)
public class PersonHomeActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.add)
	private Button add;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), DateAndTimeActivity.class);
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON, extras.getLong(PeopleListActivity.PERSON));
				startActivity(intent);
			}
		});
	}
}
