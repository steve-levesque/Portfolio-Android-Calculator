package com.example.calculator;

import android.content.Context;

import com.example.calculator.models.CalculatorItem;
import com.example.calculator.utilities.DataUtility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /**
     * Desc:
     * Class:
     * In:
     * Out:
     * Test:
     */
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /**
     * Desc: Mock test to show that InstrumentationRegistry is not available here.
     * Class: None
     * In: String
     * Out: String
     * Test: In == Out
     */
    @Test
    public void useAppContext() {
        // InstrumentationRegistry not available on host execution.
        //Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calculator", "com.example.calculator");
    }

    /**
     * Desc: Check if item count is not differing from the intended count.
     * Class: {@link DataUtility}
     * In: None
     * Out: Int (1000)
     * Test: Out == 1000
     */
    @Test
    public void initialItemCount() {
        assertEquals(1000, DataUtility.count());
    }

    /**
     * Desc: Tests the toString method of the Data class CalculatorItem.
     * Class: {@link CalculatorItem#toString()}
     * In: String ("content")
     * Out: String ("content")
     * Test: In == Out
     */
    @Test
    public void CalculatorItem_toString() {
        String content = "content";

        CalculatorItem item = new CalculatorItem(
                "1",
                content,
                "details"
        );

        assertEquals(item.toString(), content);
    }
}