public class OffByN implements CharacterComparator {
    private int offByN;
    OffByN(int N) {
        offByN = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offByN;
    }
}
