package com.bartek;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class FindOdd {
    public static int findIt(int[] A) {
        Map<Integer, Integer> counts = new HashMap<>();
        IntStream.of(A).forEach(value -> counts.put(value, counts.getOrDefault(value, 0) + 1));

        Optional<Map.Entry<Integer, Integer>> value = counts.entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .findFirst();

        return value.get().getKey();
    }
}