public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b) {
        int diff = a - b;
        if (diff == 1 || diff == -1) {
            return true;
        }
        return false;
    }
}
