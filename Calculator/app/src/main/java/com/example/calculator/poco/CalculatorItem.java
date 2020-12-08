package com.example.calculator.poco;

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
