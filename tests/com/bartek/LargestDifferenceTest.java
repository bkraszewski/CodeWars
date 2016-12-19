package com.bartek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bartek on 12/12/16.
 */
public class LargestDifferenceTest {
    @Test
    public void test1() {
        assertEquals(4, LargestDifference.largestDifference(new int[]{9,4,1,10,3,4,0,-1,-2}));
    }

    @Test
    public void test2(){
        assertEquals(0, LargestDifference.largestDifference(new int[]{3,2,1}));
    }
}
