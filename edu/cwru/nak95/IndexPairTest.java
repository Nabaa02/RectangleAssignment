package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for IndexPair
 */
class IndexPairTest {

    @Test
    void compareTo() {
        IndexPair pair1 = new IndexPair(4, 5);
        IndexPair pair2 = new IndexPair(5, 7);
        IndexPair pair3 = new IndexPair(3, 8);
        IndexPair pair4 = new IndexPair(4, 10);
        IndexPair pair5 = new IndexPair(4, 5);
        //tests whether pair1 comes before pair2 (according to xIndex)
        assertEquals(-1, pair1.compareTo(pair2));
        //tests whether pair1 comes before pair4 (according to yIndex)
        assertEquals(-5, pair1.compareTo(pair4));
        //tests whether pair1 comes after pair3
        assertEquals(1, pair1.compareTo(pair3));
        //tests whether pair1 and pair5 are equal in comparison
        assertEquals(0, pair1.compareTo(pair5));
    }

    @Test
    void increment() {
        IndexPair pair = new IndexPair(2, 3);
        //verifies that values after incrementing are correct
        assertEquals(4, pair.increment(Direction.TOP).getYIndex());
        assertEquals(2, pair.increment(Direction.BOTTOM).getYIndex());
        assertEquals(3, pair.increment(Direction.RIGHT).getXIndex());
        assertEquals(1, pair.increment(Direction.LEFT).getXIndex());
        //ensures that proper exception is thrown when input is null
        assertThrows(NullPointerException.class, () -> pair.increment(null).getXIndex());
    }

    @Test
    void getXIndex() {
        IndexPair pair = new IndexPair(4, 9);
        assertEquals(4, pair.getXIndex());

        IndexPair pair2 = new IndexPair(12, 4);
        assertEquals(12, pair2.getXIndex());
    }

    @Test
    void getYIndex() {
        IndexPair pair = new IndexPair(5, 7);
        assertEquals(7, pair.getYIndex());

        IndexPair pair2 = new IndexPair(8, 4);
        assertEquals(4, pair2.getYIndex());
    }
}