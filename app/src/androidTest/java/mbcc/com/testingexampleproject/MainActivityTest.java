package mbcc.com.testingexampleproject;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(emulateSdk= 18)
public class MainActivityTest {

    private Activity activity;
    private ActivityController<MainActivity> mainActivityController;

    @Before
    public void setup()  {
        Intent i= new Intent(Robolectric.application, MainActivity.class);
        i.putExtra("isTesting", true);

        mainActivityController = Robolectric.buildActivity(MainActivity.class).withIntent(i);
        mainActivityController.create();
        activity = mainActivityController.get();
    }

    @Test
    public void shouldGetMainActivity() {
        assertTrue(activity instanceof MainActivity);
    }

    @Test
     public void shouldFindTextViewInMainActivity() {

        TextView textView = (TextView) activity.findViewById(R.id.textview);
        assertNotNull(textView);
    }

    @Test
    public void shouldProduceGreetingWhenButtonPressed() {

        Button button = (Button) activity.findViewById(R.id.button);
        assertNotNull(button);

        button.performClick();
        TextView textView = (TextView) activity.findViewById(R.id.textview);
        assertTrue(textView.getText().toString().contains(activity.getString(R.string.Greetings)));
    }

    @Test
    public void shouldGetCorrectAdapterFromSpinner() {

        Spinner spinner = (Spinner) activity.findViewById(R.id.spinner);
        assertNotNull(spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        assertEquals(spinner.getAdapter().getCount(), adapter.getCount());
        assertEquals(spinner.getAdapter().getItem(0), adapter.getItem(0));
        assertEquals(spinner.getAdapter().getItem(adapter.getCount()-1), adapter.getItem(adapter.getCount()-1));
    }

}
