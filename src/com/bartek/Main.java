package com.bartek;

public class Main {

    public static int primitiveReturnTest(){
        int i = 10;
        return i = 20;
    }

    public static void main(String[] args) {
	    System.out.println(primitiveReturnTest());

    }
}
