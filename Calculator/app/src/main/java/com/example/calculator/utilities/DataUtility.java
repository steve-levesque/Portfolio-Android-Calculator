package com.example.calculator.utilities;

import com.example.calculator.models.CalculatorItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for manipulation of data on the app.
 */
public class DataUtility {
    private static final int COUNT = 1000;
    public static final List<CalculatorItem> ITEMS = new ArrayList<CalculatorItem>();
    public static final Map<String, CalculatorItem> ITEM_MAP = new HashMap<String, CalculatorItem>();

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(CalculatorItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void removeItems() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static int count() {
        return ITEMS.size();
    }

    private static CalculatorItem createDummyItem(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\nMore details information here about item " + position + ".");
        String result = builder.toString();

        return new CalculatorItem(String.valueOf(position), "Item " + position, result);
    }
}
