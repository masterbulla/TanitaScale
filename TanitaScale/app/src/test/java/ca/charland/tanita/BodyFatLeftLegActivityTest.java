package ca.charland.tanita;

import com.google.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class BodyFatLeftLegActivityTest
{

    private static class ActivityUnderTest extends BodyFatLeftLegActivity
    {

        @Override
        protected void setSex(int id, int female)
        {
        }

        @Override
        protected TanitaDataSource getDataSource()
        {
            return new TestTanitaDataSource();
        }

        @Override
        protected void setData()
        {
        }
    }

    @Inject
    private ActivityUnderTest activity;

    @Before
    public void setup()
    {
        activity = (ActivityUnderTest) Robolectric.setupActivity(ActivityUnderTest.class);
    }

    @Test
    public void testGetLayoutResID()
    {
        assertThat(activity.getResourceIDForLayout(), is(R.layout.body_fat_left_leg));
    }

    @Test
    public void testGetColumnName()
    {
        assertThat(activity.getColumnName(), is(TanitaDataTable.Column.BODY_FAT_LEFT_LEG));
    }

    @Test
    public void testGetNextClass()
    {
        assertThat(activity.getNextClass().toString(), is(BodyFatTrunkActivity.class.toString()));
    }

}
