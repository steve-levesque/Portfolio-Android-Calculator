package com.example.calculator;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculator.utilities.DataUtility;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /**
     * Desc: Context of the app under test.
     * Class: None
     * In: None
     * Out: String ("com.example.calculator")
     * Test: "com.example.calculator" == Out
     */
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calculator", appContext.getPackageName());
    }

    /**
     * Desc: Check if on the physical test device, 1000 items are created by default.
     * Class: {@link DataUtility}
     * In: None
     * Out: Int (1000)
     * Test: 1000 == Out, 100 != Out
     */
    @Test
    public void initialItemCount() {
        // On the test device, 1000 items are created by default.
        assertEquals(1000, DataUtility.count());
        assertNotEquals(100, DataUtility.count());
    }
}
