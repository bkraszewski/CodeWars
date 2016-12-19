package com.bartek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bartek on 18/12/16.
 */
public class TheClockwiseSpiralTest {
    TheClockwiseSpiral spiral = new TheClockwiseSpiral();

    @Test
    public void should_test_spiral() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};

        Assert.assertArrayEquals(expected, spiral.createSpiral(3));

    }

    @Test
    public void test_randomized_30() {
        int[][] expected = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        Assert.assertArrayEquals(expected, spiral.createSpiral(4));

    }
}
