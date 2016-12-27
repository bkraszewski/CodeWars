package com.bartek;

public class StringCounter {
    public static int stringCounter(String input, char c) {
        return input.chars().filter(value -> value == c).toArray().length;
    }
}
