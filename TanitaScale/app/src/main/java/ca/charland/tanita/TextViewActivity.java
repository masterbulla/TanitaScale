package ca.charland.tanita;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import ca.charland.tanita.base.activity.manage.BaseAllPeopleListActivity;
import ca.charland.tanita.base.db.Data;
import ca.charland.tanita.db.PersonDataHelper;
import ca.charland.tanita.db.PersonDataSource;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataHelper;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * Since most of the classes have a text view when entering data a specific class was created.
 * 
 * @author mcharland
 * 
 */
public abstract class TextViewActivity extends TanitaBaseActivity {

	/*
	 * This cannot be injected because of a limitation in robo guice not allowing injection from an abstract class.
	 */
	private TextView text;

	@InjectView(R.id.enter_your)
	private TextView enter;

	@InjectView(R.id.previous)
	private TextView previous;

	@InjectView(R.id.average)
	private TextView average;

	private List<Data> tanitaData = new ArrayList<Data>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setEnterText();

		setData();
		setPrevious();
		setAverage();

		datasource.closeDatabaseConnection();
	}
	

	@Override
	protected void fillInDataIfSet() {
		TanitaData d = getLatestValue();
		double value = d.get(getColumnName());
		if(value != 0D) 
		{
			text.setText(String.valueOf(value));
		}
	}


	private TanitaData getLatestValue() {
		List<Data> allValues = datasource.getAllValues();
		TanitaData d = new TanitaData();
		if(!allValues.isEmpty()) {
			d= (TanitaData)allValues.get(allValues.size()-1);
		}
		return d;
	}
	
	@Override
	protected View getButtonForKeyPress() {
		text = (TextView) findViewById(R.id.editTextEntry);
		return text;
	}

	protected void setData() {
		String selection = TanitaDataTable.Column.PERSON.toString() + " = " + getPersonID();
		tanitaData = datasource.query(selection);
	}

	private void setEnterText() {
		Resources resources = getResources();
		String raw = resources.getString(R.string.enterYour);
		enter.setText(String.format(raw, resources.getString(getIDForString())));
	}

	private void setPrevious() {
		double prev = TanitaDataHelper.getPrevious(tanitaData, getColumnName());
		previous.setText(format(prev));
	}

	private void setAverage() {
		double avg = TanitaDataHelper.getAverage(tanitaData, getColumnName());
		average.setText(format(avg));
	}

	private String format(double prev) {
		Formatter formatter = new Formatter();
		Formatter format = formatter.format("%1.2f", prev);
		String string = format.toString();
		formatter.close();
		return string;
	}

	private int getPersonID() {
		int id = -1;
		Intent intent = getIntent();
		if (intent != null) {
			Bundle extras = intent.getExtras();
			if (extras == null || !extras.containsKey(BaseAllPeopleListActivity.PERSON_ID)) {
				throw new ExtrasNotSetException("Please add the PERSON_ID in the extras of the Intent");
			}
			id = extras.getInt(BaseAllPeopleListActivity.PERSON_ID);
		}
		return id;
	}

	@Override
	public void onStart() {
		super.onStart();
		showKeyboard();
	}

	private void showKeyboard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	protected abstract int getIDForString();

	protected abstract TanitaDataTable.Column getColumnName();

	@Override
	public final ContentValues getValues() {
		ContentValues values = new ContentValues();
		values.put(getColumnName().toString(), text.getText().toString());
		return values;
	}

	protected void setSex(int id, int female) {
		ImageView image = (ImageView) findViewById(id);

		PersonDataSource datasource = new PersonDataSource(this);
		String sex = PersonDataHelper.getSex(datasource, getPersonID());
		if (sex.equalsIgnoreCase("female")) {
			Bitmap newImage = BitmapFactory.decodeResource(getResources(), female);
			image.setImageBitmap(newImage);
		}
	}
}