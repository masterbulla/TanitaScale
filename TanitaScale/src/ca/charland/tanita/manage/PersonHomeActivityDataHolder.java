package ca.charland.tanita.manage;

import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;

public class PersonHomeActivityDataHolder extends MultipleActivityData {

	@Override
	public int getAdd() {
		return R.string.add;
	}

	@Override
	public int getView() {
		return R.string.view;
	}

	@Override
	public Class<?> getNextAddClass() {
		return DateAndTimeActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return DateListOfPreviousEntriesActivity.class;
	}
}
