import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.
    @Test
    public void testIsPalindrome() {
        assertTrue("Test1 failed, expected True but False", palindrome.isPalindrome(""));
        assertTrue("Test2 failed, expected True but False", palindrome.isPalindrome("a"));
        assertTrue("Test3 failed, expected True but False", palindrome.isPalindrome("aaccbbbbccaa"));

        assertFalse("Test4 failed, expected False but True", palindrome.isPalindrome("horse"));
        assertFalse("Test5 failed, expected False but True", palindrome.isPalindrome("aaabbaa"));
        assertFalse("Test6 failed, expected False but True", palindrome.isPalindrome("ababba"));

    }
    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByOne();
        assertTrue("Test1 failed, expected True but False", palindrome.isPalindrome("flake", cc));
        assertTrue("Test2 failed, expected True but False", palindrome.isPalindrome("", cc));
        assertTrue("Test3 failed, expected True but False", palindrome.isPalindrome("c", cc));

        assertFalse("Test4 failed, expected False but True", palindrome.isPalindrome("asender", cc));
        assertFalse("Test5 failed, expected False but True", palindrome.isPalindrome("aa", cc));
        assertFalse("Test6 failed, expected False but True", palindrome.isPalindrome("aba", cc));
    }
}
