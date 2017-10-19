package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void testClickTweetListToEditTweetActivity(){
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body), "my tweet");
        solo.clickOnButton("Save");
        assertTrue(solo.waitForText("my tweet"));

        ListView oldTweetsList = (ListView)solo.getView(R.id.oldTweetsList);

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong activity", EditTweetActivity.class);

        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);

        assertEquals(tweet.getMessage(), "my tweet");
        assertTrue(solo.waitForText(tweet.getMessage()));

    }
}