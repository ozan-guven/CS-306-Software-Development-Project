package ch.epfl.sdp.healthplay;

import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BarcodeScanActivityTest {
    /*
    @Rule
    public ActivityScenarioRule<BarcodeScanActivity> testRule =
            new ActivityScenarioRule<>(BarcodeScanActivity.class);

    @Test
    public void testOnClick() {
        Intents.init();

        ViewInteraction button = Espresso.onView(ViewMatchers.withId(R.id.get_information_from_barcode));
        button.perform(ViewActions.click());

        // Check if the intent is the correct destination
        Intents.intended(IntentMatchers.hasComponent(ProductInfoActivity.class.getName()));

        Intents.release();
    }

    @Test
    public void testEnterManually() {
        Intents.init();

        ViewInteraction button = Espresso.onView(ViewMatchers.withId(R.id.enter_manually_button));
        button.perform(ViewActions.click());

        // Check if the intent is the correct destination
        Intents.intended(IntentMatchers.hasComponent(BarcodeInformationActivity.class.getName()));

        Intents.release();
    }*/
}