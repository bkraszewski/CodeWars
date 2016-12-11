package com.bartek;

/**
 * Created by bartek on 10/12/16.
 */
public class AlternativeSplit {

    public static String encrypt(final String text, final int n) {
        if (text == null || text.length() == 0) {
            return text;
        }

        if (n < 1) {
            return text;
        }

        String result = text;
        for (int a = 0; a < n; a++) {
            result = encryptOnce(result);
        }

        return result;
    }

    private static String encryptOnce(final String text) {
        StringBuilder nonEven = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int a = 0; a < text.length(); a++) {
            if (a % 2 == 0) {
                even.append(text.charAt(a));
            } else {
                nonEven.append(text.charAt(a));
            }
        }

        nonEven.append(even);
        return nonEven.toString();
    }

    public static String decrypt(final String text, final int n) {
        if (text == null || text.length() == 0) {
            return text;
        }

        if (n < 1) {
            return text;
        }

        String result = text;
        for (int a = 0; a < n; a++) {
            result = decryptOnce(result);
        }

        return result;
    }

    private static String decryptOnce(final String encryptedText) {
        int half = encryptedText.length() / 2;

        StringBuilder result = new StringBuilder();

        for (int a = 0; a <= half; a++) {
            if (half + a < encryptedText.length()) {
                result.append(encryptedText.charAt(half + a));
            }

            if (a != half) {
                result.append(encryptedText.charAt(a));
            }
        }

        return result.toString();
    }
}
