package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The Class BodyFatTrunkActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_trunk)
public class BodyFatTrunkActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.next)
	Button next;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),
						MuscleMassTotalActivity.class));
			}
		});
	}
}
