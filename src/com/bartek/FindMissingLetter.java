package com.bartek;

public class FindMissingLetter {
    public static char findMissingLetter(char[] chars) {
        if (chars.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        for (int a = 0; a < chars.length - 1; a++) {
            int currentChar = chars[a];
            int next = chars[a + 1];

            if (next - currentChar != 1) {
                return (char) (currentChar + 1);
            }
        }

        throw new IllegalArgumentException("Passed array have no missing value");
    }
}
