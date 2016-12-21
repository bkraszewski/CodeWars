package com.bartek;

/**
 * Created by bartek on 20/12/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrdersSummaryTest {

    @Test
    public void test1() {
        String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(l));

    }

    @Test
    public void test2(){
        String input = "CSCO 250.0 29 B, GOOG 200 580.0 S";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(input));
    }

    @Test
    public void testGoogle(){
        String input = "GOOG 200 580.12 S,";
        assertEquals("Buy: 0 Sell: 116024",
                OrdersSummary.balanceStatements(input));
    }


}
