package com.bartek;

import org.junit.Assert;
import org.junit.Test;

public class RevrotTests {

    @Test
    public void shouldCalculateNumber(){
        String output = Revrot.revrot("123456987654", 6);
        Assert.assertEquals("234561876549", output);
    }

    @Test
    public void shouldCalculateNumber2(){
        String output = Revrot.revrot("123456987653", 6);
        Assert.assertEquals("234561356789", output);
    }

    @Test
    public void shouldCalculateNumber3(){
        String output = Revrot.revrot("66443875", 4);
        Assert.assertEquals("44668753", output);
    }

    @Test
    public void shouldReturnEmptyStringWhenNumberInvalid(){
        String output = Revrot.revrot("123456987654",0 );
        Assert.assertEquals("", output);
    }

    @Test
    public void shouldReturnEmptyStringWhenNumberBiggerThanStringCount(){
        String output = Revrot.revrot("123",6 );
        Assert.assertEquals("", output);
    }
}
