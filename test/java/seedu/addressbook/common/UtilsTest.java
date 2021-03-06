package seedu.addressbook.common;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class to test for Utils error
 */
public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertIsNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertIsNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    @Test
    public void isAnyNull() throws Exception {
        // Empty
        assertIsNotNull();

        // One String
        assertIsNotNull("abc");

        // Two Strings
        assertIsNotNull("abc", "def");

        // No string
        assertIsNull((Object) null);

        // Two string
        assertIsNull("abc", null);
        assertIsNull(null, "abc");

        // Three string
        assertIsNull("abc", null, "def");
        assertIsNull(null, "abc", "def");

        // Four string
        assertIsNull("abc", null, "def", "ghi");
        assertIsNull(null, "abc", "def", "ghi");
    }
}
