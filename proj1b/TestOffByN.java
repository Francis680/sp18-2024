import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {


    CharacterComparator offByOne = new OffByN(1);
    CharacterComparator offByTwo = new OffByN(2);
    CharacterComparator offByThree = new OffByN(3);
    CharacterComparator offByTen = new OffByN(10);
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByTwo.equalChars('c', 'e'));
        assertTrue(offByThree.equalChars('a', 'd'));

        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByTen.equalChars('a', 'z'));
        assertFalse(offByTwo.equalChars('a', 'e'));
        assertFalse(offByThree.equalChars('a', 'A'));
    }
}
