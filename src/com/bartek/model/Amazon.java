package com.bartek.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by bartek on 25/12/16.
 */
public class Amazon {

    public static class Solution {

        private static final List<Character> OPENED_BRACES = Arrays.asList(new Character[]{'(', '<', '[', '{'});
        private static final List<Character> ENDED_BRACES = Arrays.asList(new Character[]{')', '>', ']', '}'});



        public static int hasBalancedBrackets(String str) {
            if (str == null || str.isEmpty()) {
                return 0;
            }

            Stack<Character> openedBrancesStack = new Stack<>();

            for (int a = 0; a < str.length(); a++) {
                char currentChar = str.charAt(a);

                if (OPENED_BRACES.contains(currentChar)) {
                    openedBrancesStack.add(currentChar);
                    continue;
                }

                if (ENDED_BRACES.contains(currentChar)) {
                    if (openedBrancesStack.isEmpty()) {
                        return 0;
                    }

                    char recentOpenedBraces = openedBrancesStack.peek();
                    if (getMatchingBraceClosing(recentOpenedBraces) == currentChar) {
                        openedBrancesStack.pop();
                        continue;
                    } else {
                        return 0;
                    }
                }
            }

            return openedBrancesStack.isEmpty() ? 1 : 0;
        }

        private static char getMatchingBraceClosing(char c) {
            switch (c) {
                case '(':
                    return ')';
                case '[':
                    return ']';
                case '{':
                    return '}';
                case '<':
                    return '>';
                default:
                    throw new IllegalArgumentException("Not a bracket passed as argument: " + c);
            }
        }
    }

    static class SolutinTest {

        @Test
        public void shouldReturnZeroWhenNotBalanced() {
            int val = Solution.hasBalancedBrackets("(h[e{lo}!]£)()()(");
            assertEquals(0, val);

            int value = Solution.hasBalancedBrackets("[](){}<>");
            assertEquals(1, value);
        }


    }
}
