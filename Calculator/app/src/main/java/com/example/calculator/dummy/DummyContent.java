package com.example.calculator.dummy;

import com.example.calculator.poco.CalculatorItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CalculatorItem> ITEMS = new ArrayList<CalculatorItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CalculatorItem> ITEM_MAP = new HashMap<String, CalculatorItem>();

    private static final int COUNT = 2;

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
        return new CalculatorItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
