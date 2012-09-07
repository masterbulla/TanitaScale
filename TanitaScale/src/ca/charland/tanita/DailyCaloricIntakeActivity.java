package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class DailyCaloricIntakeActivity.
 * 
 * @author mcharland
 */
public class DailyCaloricIntakeActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.dci;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MetabolicAgeActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.DAILY_CALORIC_INTAKE;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.dci;
	}
}
