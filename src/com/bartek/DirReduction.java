package com.bartek;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bartek on 14/12/16.
 */
public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        Stack<Direction> total = new Stack<>();

        for (String item : arr) {
            if (!total.isEmpty()) {
                Direction last = total.peek();

                Direction next = Direction.valueOf(item);

                if (next.isOppositeTo(last)) {
                    total.pop();
                    continue;
                } else {
                    total.add(next);
                }
            } else {
                Direction next = Direction.valueOf(item);
                total.add(next);
            }

        }

        List<String> strings = total.stream().map(direction -> direction.main).collect(Collectors.toList());
        return strings.toArray(new String[strings.size()]);
    }


    public enum Direction {

        NORTH("NORTH", "SOUTH"),
        SOUTH("SOUTH", "NORTH"),
        WEST("WEST", "EAST"),
        EAST("EAST", "WEST");

        public final String main;
        private final String opposite;

        Direction(String main, String opposite) {
            this.main = main;
            this.opposite = opposite;
        }

        boolean isOppositeTo(Direction another) {
            return main.equalsIgnoreCase(another.opposite);
        }
    }


}
