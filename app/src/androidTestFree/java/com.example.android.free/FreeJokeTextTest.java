package com.example.android.free;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class FreeJokeTextTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkAdViewIsDisplayed() {
        onView(ViewMatchers.withId(R.id.adView)).check(matches(isDisplayed()));
    }

    @Test
    public void clickGetJoke_JokeLoads_JokeTextDisplays() {
        onView(ViewMatchers.withText(R.string.button_text))
                .perform(ViewActions.click());

        onView(ViewMatchers.withId(R.id.joke_textview)).check(matches(isDisplayed()));

        onView(ViewMatchers.withText("")).check(doesNotExist());

        onView(ViewMatchers.withText("connection timed out")).check(doesNotExist());

        onView(ViewMatchers.withId(R.id.joke_textview))
                .check(matches(ViewMatchers.withText(
                        "How many programmers does it take to change a light bulb?" +
                "\nNone, that's a hardware problem.")));
    }
}
