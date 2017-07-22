package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getTargetContext;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskInstrumentedTest {

    @Test
    public void testAsyncLoadsJokes() {

        try {
            String joke = new EndpointsAsyncTask().execute(getTargetContext()).get();
            Assert.assertNotEquals("", joke);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        }
    }
}
