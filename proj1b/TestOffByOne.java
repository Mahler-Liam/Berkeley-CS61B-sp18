import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    static OffByOne offbyone = new OffByOne();

    @Test
    public void TestEqualChars() {
        assertTrue("Test1 failed, expected True but False", offbyone.equalChars('a', 'b'));
        assertTrue("Test2 failed, expected True but False", offbyone.equalChars('b', 'a'));
        assertTrue("Test3 failed, expected True but False", offbyone.equalChars('r', 'q'));
        assertTrue("Test4 failed, expected True but False", offbyone.equalChars('&', '%'));

        assertFalse("Test5 failed, expected False but True", offbyone.equalChars('a', 'B'));
        assertFalse("Test6 failed, expected False but True", offbyone.equalChars('z', 'a'));
        assertFalse("Test7 failed, expected False but True", offbyone.equalChars('a', 'a'));

    }
}
