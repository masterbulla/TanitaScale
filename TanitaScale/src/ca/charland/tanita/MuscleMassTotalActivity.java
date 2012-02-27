package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MuscleMassTotalActivity.
 * 
 * @author mcharland
 */
public class MuscleMassTotalActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_total;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_TOTAL;
	}
}
