package com.bartek;

import com.bartek.model.Preloaded;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DingleMouseTests {

    private String[] BEFORE(String[] a) {
        System.out.println("Before:");
        return Preloaded.prettyPrint(a);
    }

    private String[] AFTER(String[] a) {
        System.out.println("After:");
        return Preloaded.prettyPrint(a);
    }

    @Test
    public void example() {
        // CAT => DOG
        String[] before = BEFORE(new String[]{"CAT"});
        int[][] rotors = new int[][]{{1, 13, 27}};
        String[] after = AFTER(Dinglemouse.flapDisplay(before, rotors));
        String[] expected = new String[]{"DOG"};
        assertArrayEquals(expected, after);
    }

    @Test
    public void basic() {
        // HELLO => WORLD!
        String[] before = BEFORE(new String[]{"HELLO "});
        int[][] rotors = new int[][]{{15, 49, 50, 48, 43, 13}};
        String[] after = AFTER(Dinglemouse.flapDisplay(before, rotors));
        String[] expected = new String[]{"WORLD!"};
        assertArrayEquals(expected, after);

        // CODE => WARS
        String[] before2 = BEFORE(new String[]{"CODE"});
        int[][] rotors2 = new int[][]{{20, 20, 28, 0}};
        String[] after2 = AFTER(Dinglemouse.flapDisplay(before2, rotors2));
        String[] expected2 = new String[]{"WARS"};
        assertArrayEquals(expected2, after2);
    }

    @Test
    public void shouldChangeStringToIntArray() {
        String abc = "ABC";
        String cat = "CAT";

        Assert.assertArrayEquals(new int[]{0, 1, 2}, Dinglemouse.convertToCharIndexes(abc));
        Assert.assertArrayEquals(new int[]{2, 0, 19}, Dinglemouse.convertToCharIndexes(cat));
    }

    @Test
    public void shouldBuildStringFromIntArray(){
        Assert.assertEquals("ABC", Dinglemouse.buildStringFromIndexes(new int[]{0, 1, 2}));
        Assert.assertEquals("CAT", Dinglemouse.buildStringFromIndexes(new int[]{2, 0, 19}) );
    }

}
