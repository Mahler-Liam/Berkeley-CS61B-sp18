public class OffByN implements CharacterComparator {
    private int off;
    public OffByN(int N) {
        off = N;
    }
    @Override
    public boolean equalChars(char a, char b) {
        int diff = a - b;
        if (diff == off || diff == -off) {
            return true;
        }
        return false;
    }

}
