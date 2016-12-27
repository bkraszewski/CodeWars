package com.bartek.model;

import java.util.Arrays;


public class Preloaded {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public static String[] prettyPrint(String[] a) {
        System.out.println(Arrays.deepToString(a));
        return a;
    }
}
