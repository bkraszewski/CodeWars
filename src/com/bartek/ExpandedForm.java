package com.bartek;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpandedForm {

    private static final int SYSTEM = 10;

    public static String expandedForm(int i) {
        List<Integer> result = new LinkedList<>();

        int divider = 1;

        do {
            int mod = i % SYSTEM;

            if (mod != 0) {
                result.add(0, mod * divider);
            }

            divider *= SYSTEM;
            i /= SYSTEM;
        } while (i > 0);

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
    }
}
