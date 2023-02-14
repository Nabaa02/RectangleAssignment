package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for RectangleException class
 */
class RectangleExceptionTest {

    @Test
    void verifyNonNull() throws RectangleException {
        //tests whether IllegalArgumentException is thrown if there is null argument
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, null);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.RIGHT, 3);
        enumMap.put(Direction.LEFT, 2);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertThrows(IllegalArgumentException.class, () -> RectangleException.verifyNonNull(rectangle.getBorder(Direction.TOP), rectangle.getBorder(Direction.BOTTOM)));

        //tests whether IllegalArgumentException is not thrown if there is no null argument
        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.TOP, 5);
        enumMap2.put(Direction.BOTTOM, 4);
        enumMap2.put(Direction.RIGHT, 3);
        enumMap2.put(Direction.LEFT, 2);
        Rectangle<Integer> rectangle2 = new Rectangle<>(enumMap2);
        assertDoesNotThrow(() -> rectangle2.of(rectangle2.top(), rectangle2.bottom(), rectangle2.left(), rectangle2.right()));
    }

    @Test
    void verifyBounds() throws RectangleException {
        //tests whether IllegalArgumentException is thrown if the top/bottom bounds are out of order
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 3);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.RIGHT, 3);
        enumMap.put(Direction.LEFT, 2);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertThrows(IllegalArgumentException.class, () -> RectangleException.verifyBounds(rectangle.getBorder(Direction.BOTTOM), rectangle.getBorder(Direction.TOP)));

        //tests whether IllegalArgumentException is thrown if the left/right bounds are out of order
        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.TOP, 5);
        enumMap2.put(Direction.BOTTOM, 4);
        enumMap2.put(Direction.RIGHT, 3);
        enumMap2.put(Direction.LEFT, 7);
        Rectangle<Integer> rectangle2 = new Rectangle<>(enumMap2);
        assertThrows(IllegalArgumentException.class, () -> RectangleException.verifyBounds(rectangle2.getBorder(Direction.LEFT), rectangle2.getBorder(Direction.RIGHT)));

        //tests whether IllegalArgumentException is not thrown if the borders are in order
        EnumMap<Direction, Integer> enumMap3 = new EnumMap<>(Direction.class);
        enumMap3.put(Direction.TOP, 8);
        enumMap3.put(Direction.BOTTOM, 6);
        enumMap3.put(Direction.RIGHT, 5);
        enumMap3.put(Direction.LEFT, 1);
        Rectangle<Integer> rectangle3 = new Rectangle<>(enumMap3);
        assertDoesNotThrow(() -> rectangle3.of(rectangle3.top(), rectangle3.bottom(), rectangle3.left(), rectangle3.right()));
    }
}