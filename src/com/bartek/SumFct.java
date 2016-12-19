package com.bartek;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bartek on 11/12/16.
 * <p>
 */

public class SumFct {

    public static BigInteger perimeter(BigInteger n) {
        BigInteger sum = calculateSumOfFibonacci(n);
        return sum.multiply(BigInteger.valueOf(4));
    }

    public static BigInteger calculateSumOfFibonacci(BigInteger n) {
        if (n.longValue() == 0) {
            return BigInteger.ONE;
        }

        if (n.longValue() == 1) {
            return BigInteger.valueOf(2);
        }

        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;

        BigInteger total = first.add(second);

        BigInteger currentFib;

        for (long a = 2; a <= n.longValue(); a++) {
            currentFib = first.add(second);

            first = second;
            second = currentFib;

            total = total.add(currentFib);
            //System.out.println(String.format("N: %d, first: %d, second: %d currentFib: %d total: %d",a, first.intValue(), second.intValue(), currentFib.intValue(), total.intValue()));
        }

        return (total);
    }

}
