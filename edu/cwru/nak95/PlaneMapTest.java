package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for PlaneMap
 */
class PlaneMapTest {

    @Test
    void of() {
        Collection<Integer> x = List.of(2, 5, 1);
        Collection<Integer> y = List.of(4, 6, 3);
        //verifies that PlaneMap is in proper, sorted order
        assertEquals(0, PlaneMap.of(x, y).indexOf(1, true));
        assertEquals(1, PlaneMap.of(x, y).indexOf(2, true));
        assertEquals(2, PlaneMap.of(x, y).indexOf(5, true));
        assertEquals(0, PlaneMap.of(x, y).indexOf(3, false));
        assertEquals(1, PlaneMap.of(x, y).indexOf(4, false));
        assertEquals(2, PlaneMap.of(x, y).indexOf(6, false));

        Collection<Integer> x2 = new ArrayList<>();
        x2.add(3);
        x2.add(null);
        x2.add(2);
        Collection<Integer> y2 = List.of(1, 4, 5);
        //ensures that proper AssertionError is thrown when value in collection is null
        assertThrows(AssertionError.class, () -> PlaneMap.of(x2, y2));
    }

    @Test
    void xIndexOf() {
        Collection<Integer> x = List.of(2, 6, 8);
        Collection<Integer> y = List.of(4, 2, 10);
        Optional<Integer> optional = Optional.of(2);
        Optional<Integer> optional2 = Optional.of(0);
        assertEquals(optional, PlaneMap.of(x, y).xIndexOf(8));
        assertEquals(optional2, PlaneMap.of(x, y).xIndexOf(2));
        //ensures that method does not return index from wrong collection
        assertEquals(Optional.empty(), PlaneMap.of(x, y).xIndexOf(4));
        //ensures that method throws proper exception when input is null
        assertThrows(NullPointerException.class, () -> PlaneMap.of(x, y).xIndexOf(null));
    }

    @Test
    void yIndexOf() {
        Collection<Integer> x = List.of(2, 6, 8);
        Collection<Integer> y = List.of(4, 2, 10);
        Optional<Integer> optional = Optional.of(1);
        Optional<Integer> optional2 = Optional.of(2);
        assertEquals(optional, PlaneMap.of(x, y).yIndexOf(4));
        assertEquals(optional2, PlaneMap.of(x, y).yIndexOf(10));
        //ensures that method does not return index from wrong collection
        assertEquals(Optional.empty(), PlaneMap.of(x, y).yIndexOf(8));
        //ensures that method throws proper exception when input is null
        assertThrows(NullPointerException.class, () -> PlaneMap.of(x, y).yIndexOf(null));
    }

    @Test
    void xSize() {
        Collection<Integer> x = List.of(5, 7, 2, 9, 10);
        Collection<Integer> emptyX = List.of();
        Collection<Integer> y = List.of(4, 5, 1);
        assertEquals(5, PlaneMap.of(x, y).xSize());
        assertEquals(0, PlaneMap.of(emptyX, y).xSize());
    }

    @Test
    void ySize() {
        Collection<Integer> x = List.of(5, 7, 2, 9, 10);
        Collection<Integer> y = List.of(4, 5, 1);
        Collection<Integer> emptyY = List.of();
        assertEquals(3, PlaneMap.of(x, y).ySize());
        assertEquals(0, PlaneMap.of(x, emptyY).ySize());
    }

    @Test
    void indexOf() {
        Collection<Integer> x = List.of(4, 3, 12);
        Collection<Integer> y = List.of(9, 13, 6);
        assertEquals(2, PlaneMap.of(x, y).indexOf(12, true));
        assertEquals(0, PlaneMap.of(x, y).indexOf(6, false));
        //ensures that method returns null when input is null
        assertNull(PlaneMap.of(x, y).indexOf(null, false));
        //ensures that method returns null when attempting to retrieve index of value from wrong collection
        assertNull(PlaneMap.of(x, y).indexOf(9, true));
        assertNull(PlaneMap.of(x, y).indexOf(3, false));
    }

    @Test
    void from() throws RectangleException {
        Rectangle<Integer> rec1 = Rectangle.of(10, 8, 1, 12);
        Rectangle<Integer> rec2 = Rectangle.of(13, 11, 3, 7);
        Set<Rectangle<Integer>> rectangles = Set.of(rec1, rec2);
        assertEquals(0, PlaneMap.from(rectangles).indexOf(1, true));
        assertEquals(5, PlaneMap.from(rectangles).indexOf(11, false));
    }
}