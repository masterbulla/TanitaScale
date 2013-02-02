package ca.charland.tanita;

import ca.charland.activity.DateAndTimeActivity;
import ca.charland.activity.NextButtonOnClickListener;
import ca.charland.db.DataSource;

public class TanitaDateAndTimeActivity extends DateAndTimeActivity {

	@Override
	protected NextButtonOnClickListener getNextButtonOnClickListener() {
		return new TanitaNextButtonOnClickListener(this, datasource);
	}

	@Override
	protected DataSource getDataSource() {
		return TanitaBaseActivity.getTanitaDataSource(this);
	}
	
	@Override
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}

}
