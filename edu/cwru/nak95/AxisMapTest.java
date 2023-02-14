package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for AxisMap
 */
class AxisMapTest {

    @Test
    void from() {
        Collection<Integer> coordinates = new ArrayList<>();
        coordinates.add(3);
        coordinates.add(5);
        coordinates.add(null);
        //ensures that proper AssertionError is thrown when value of coordinate is null
        assertThrows(AssertionError.class, () -> AxisMap.from(coordinates));

        Collection<Integer> coordinates2 = List.of(5, 7, 2, 4);
        //ensures that no exception is thrown when input is valid
        assertDoesNotThrow(() -> AxisMap.from(coordinates2));

        //verifies that AxisMap is in proper, sorted order
        assertEquals(0, AxisMap.from(coordinates2).flatIndexOf(2));
        assertEquals(1, AxisMap.from(coordinates2).flatIndexOf(4));
        assertEquals(2, AxisMap.from(coordinates2).flatIndexOf(5));
        assertEquals(3, AxisMap.from(coordinates2).flatIndexOf(7));
    }

    @Test
    void flatIndexOf() {
        Collection<Integer> coordinates = List.of(4, 12, 3, 2, 10);
        assertEquals(2, AxisMap.from(coordinates).flatIndexOf(4));
        assertEquals(3, AxisMap.from(coordinates).flatIndexOf(10));
        //ensures that null is returned when input is not present is collection of coordinates
        assertNull(AxisMap.from(coordinates).flatIndexOf(9));
        //ensures that null is returned when input consists of null element
        assertNull(AxisMap.from(coordinates).flatIndexOf(null));
    }

    @Test
    void getSize() {
        Collection<Integer> coordinates = List.of(3, 5, 2, 10, 25, 12);
        assertEquals(6, AxisMap.from(coordinates).getSize());

        Collection<Integer> coordinates2 = List.of(3, 5, 1);
        assertEquals(3, AxisMap.from(coordinates2).getSize());

        Collection<Integer> coordinates3 = List.of();
        assertEquals(0, AxisMap.from(coordinates3).getSize());

        Collection<Integer> coordinates4 = new ArrayList<>();
        coordinates4.add(5);
        coordinates4.add(1);
        coordinates4.add(null);
        //ensures that proper AssertionError is thrown when attempting to get size of AxisMap with null element
        assertThrows(AssertionError.class, () -> AxisMap.from(coordinates4).getSize());
    }

    @Test
    void indexOf() {
        Collection<Integer> coordinates = List.of(3, 4, 2, 8, 10);
        Optional<Integer> optional = Optional.of(1);
        Optional<Integer> optional2 = Optional.of(3);
        assertEquals(optional, AxisMap.from(coordinates).indexOf(3));
        assertEquals(optional2, AxisMap.from(coordinates).indexOf(8));
        //ensures that null is returned when input is not present is collection of coordinates
        assertEquals(Optional.empty(), AxisMap.from(coordinates).indexOf(12));
        //ensures that null is returned when input consists of null element
        assertEquals(Optional.empty(), AxisMap.from(coordinates).indexOf(null));
    }
}