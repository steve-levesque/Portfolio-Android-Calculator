package com.example.calculator.models;

import com.example.calculator.ItemListActivity;
import com.example.calculator.utilities.DataUtility;

/**
 * Data class
 * Represents a calculus made by the user which is showed in the app within {@link ItemListActivity}.
 * The data resides inside {@link DataUtility} and can be manipulated by the utility.
 */
public class CalculatorItem {
    public final String id;
    public final String content;
    public final String details;

    public CalculatorItem(String id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}
