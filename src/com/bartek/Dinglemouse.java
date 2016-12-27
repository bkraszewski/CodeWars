package com.bartek;

import com.bartek.model.Preloaded;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bartek on 24/12/16.
 */
public class Dinglemouse {

    private static final List<Character> ALPHABET = Preloaded.ALPHABET.chars().mapToObj(value -> (char) value).collect(Collectors.toList());

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        String[] returnedLines = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            int[] chars = convertToCharIndexes(lines[i]);

            for (int j = 0; j < rotors[i].length; j++) {
                chars = rotateRange(j, chars, rotors[i][j]);
            }

            returnedLines[i] = buildStringFromIndexes(chars);
        }

        return returnedLines;
    }

    public static String buildStringFromIndexes(int[] chars) {

        StringBuilder builder = new StringBuilder();
        Arrays.stream(chars)
                .mapToObj(value -> ALPHABET.get(value))
                .forEach(builder::append);
        return builder.toString();
    }

    public static int[] convertToCharIndexes(String line) {
        return line.chars()
                .mapToObj(value -> ALPHABET.indexOf((char) value))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] rotateRange(int startIndex, int[] indexes, int flips) {
        for (int a = startIndex; a < indexes.length; a++) {
            indexes[a] = (indexes[a] + flips) % ALPHABET.size();
        }

        return indexes;
    }
}
