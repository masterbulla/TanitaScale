package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class BoneMassActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.bone_mass)
public class BoneMassActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}
