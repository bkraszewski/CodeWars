package com.bartek;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bartek on 11/12/16.
 *
 * Carefull - its very calculation efficient method, but nut thread safe, only can run one instance
 */

public class SumFct {

    private static Map<BigInteger, BigInteger> fibCache = new HashMap<>();

    static {
        fibCache.put(BigInteger.ZERO, BigInteger.ONE);
        fibCache.put(BigInteger.ONE, BigInteger.ONE);
    }


    public static BigInteger perimeter(BigInteger n) {
        fibbonaci(n);

        BigInteger sum = BigInteger.ZERO;

        sum = sumNumbersUntillN(n, sum);

        return sum.multiply(BigInteger.valueOf(4));
    }

    private static BigInteger sumNumbersUntillN(BigInteger n, BigInteger sum) {
        for (Map.Entry<BigInteger, BigInteger> entry : fibCache.entrySet()) {
            if(entry.getKey().compareTo(n) > 0){
                break;
            }
            sum = sum.add(entry.getValue());
        }
        return sum;
    }

    public static BigInteger fibbonaci(BigInteger n) {
        if (n.longValue() == 0) {
            return fibCache.get(n);
        }

        if (n.longValue() == 1) {
            return fibCache.get(n);
        }

        BigInteger currentFib;

        if (fibCache.get(n) == null) {
            BigInteger prev = fibbonaci(n.subtract(BigInteger.ONE));
            BigInteger prevPrev = fibbonaci(n.subtract(BigInteger.valueOf(2)));

            currentFib = prev.add(prevPrev);

            if (fibCache.get(n) == null) {
                fibCache.put(n, currentFib);
            }
        } else {
            currentFib = fibCache.get(n);
        }

        return currentFib;
    }

}
