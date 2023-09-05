import static org.junit.Assert.*;

import org.junit.Test;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static CharacterComparator offbyone = new OffByOne();

    @Test
    public void TestEqualChars() {
        assertTrue(offbyone.equalChars('a', 'b'));
        assertTrue(offbyone.equalChars('b', 'a'));
        assertTrue(offbyone.equalChars('r', 'q'));
        assertTrue(offbyone.equalChars('&', '%'));

        assertFalse(offbyone.equalChars('a', 'B'));
        assertFalse(offbyone.equalChars('z', 'a'));
        assertFalse(offbyone.equalChars('a', 'a'));

    }
}
