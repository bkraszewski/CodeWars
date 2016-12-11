package com.bartek;

public class Sequence {
    public static long getScore(long n) {
        long value = 0;
        long adder = 0;
        for (int a = 0; a < n; a++) {
            adder += 50;
            value += adder;
        }

        return value;
    }
}
