public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> word_deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            word_deque.addLast(word.charAt(i));
        }
        return word_deque;
    }
    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        cc = new OffByOne();
        if (word == null || word.length() <= 1) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}