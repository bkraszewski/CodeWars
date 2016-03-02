package com.bartek;

public class Revrot {
    public static String revrot(String s, int n) {
        if (n <= 0 || s.length() < n) {
            return "";
        }

        return revrotInternal(s, n);
    }

    private static String revrotInternal(String s, int n) {
        StringBuilder result = new StringBuilder();

        int start = 0;
        int end = n;

        while (end <= s.length()) {
            String chunk = s.substring(start, end);
            double sum = calculateCubes(chunk);

            if (sum % 2 == 0) {
                result.append(new StringBuilder(chunk)
                        .reverse());
            } else {
                result.append(rotateLeft(chunk, 0, n));
            }

            start += n;
            end += n;
        }
        return end < s.length() ? result.append(s.substring(end)).toString() : result.toString();
    }

    private static String rotateLeft(String sz, int start, int end) {
        StringBuilder str = new StringBuilder(sz);
        str.insert(end, sz.charAt(start));
        str.deleteCharAt(start);
        return str.toString();
    }

    private static double calculateCubes(String sz) {
        return sz.chars()
                .mapToDouble(i -> Math.pow(i - 48, 3))
                .sum();
    }
}
