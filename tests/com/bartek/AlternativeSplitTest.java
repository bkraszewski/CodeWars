package com.bartek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bartek on 10/12/16.
 */
public class AlternativeSplitTest {

    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", AlternativeSplit.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", AlternativeSplit.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", AlternativeSplit.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", AlternativeSplit.encrypt("This is a test!", 3));
        assertEquals("This is a test!", AlternativeSplit.encrypt("This is a test!", 4));
        assertEquals("This is a test!", AlternativeSplit.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", AlternativeSplit.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", AlternativeSplit.decrypt("This is a test!", 0));
        assertEquals("This is a test!", AlternativeSplit.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", AlternativeSplit.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", AlternativeSplit.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", AlternativeSplit.decrypt("This is a test!", 4));
        assertEquals("This is a test!", AlternativeSplit.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", AlternativeSplit.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", AlternativeSplit.encrypt("", 0));
        assertEquals("", AlternativeSplit.decrypt("", 0));
        assertEquals(null, AlternativeSplit.encrypt(null, 0));
        assertEquals(null, AlternativeSplit.decrypt(null, 0));
    }
}
