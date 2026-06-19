package com.digitalnurture.testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("cba", utils.reverse("abc"));
        assertEquals("", utils.reverse(""));
    }

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("racecar"));
        assertFalse(utils.isPalindrome("hello"));
    }
}
