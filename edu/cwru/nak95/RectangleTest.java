package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for Rectangle class
 */
class RectangleTest {

    @Test
    void compareTo() {
        //tests whether the bottom bound's value is less than the top bound's value
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.TOP, 5);
        assertTrue(enumMap.get(Direction.BOTTOM).compareTo(enumMap.get(Direction.TOP)) < 0);

        //tests whether the left bound's value is larger than the right bound's value
        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.LEFT, 6);
        enumMap2.put(Direction.RIGHT, 3);
        assertTrue(enumMap2.get(Direction.LEFT).compareTo(enumMap2.get(Direction.RIGHT)) > 0);

        //tests whether the top and left bounds have the same value
        EnumMap<Direction, Integer> enumMap3 = new EnumMap<>(Direction.class);
        enumMap3.put(Direction.TOP, 2);
        enumMap3.put(Direction.LEFT, 2);
        assertEquals(0, enumMap3.get(Direction.TOP).compareTo(enumMap3.get(Direction.LEFT)));
    }

    @Test
    void getBorder() {
        //tests if proper value was retrieved for particular border
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 5);
        enumMap.put(Direction.BOTTOM, 3);
        enumMap.put(Direction.LEFT, 2);
        enumMap.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(5, rectangle.getBorder(Direction.TOP));
        assertEquals(3, rectangle.getBorder(Direction.BOTTOM));
        assertEquals(2, rectangle.getBorder(Direction.LEFT));
        assertEquals(7, rectangle.getBorder(Direction.RIGHT));
    }

    @Test
    void top() {
        //tests if proper value was retrieved for top border
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 6);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.LEFT, 1);
        enumMap.put(Direction.RIGHT, 8);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(6, rectangle.top());
        assertNotEquals(1, rectangle.top());
    }

    @Test
    void bottom() {
        //tests if proper value was retrieved for bottom border
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 6);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.LEFT, 1);
        enumMap.put(Direction.RIGHT, 8);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(4, rectangle.bottom());
        assertNotEquals(8, rectangle.bottom());
    }

    @Test
    void left() {
        //tests if proper value was retrieved for left border
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 6);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.LEFT, 1);
        enumMap.put(Direction.RIGHT, 8);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(1, rectangle.left());
        assertNotEquals(6, rectangle.left());
    }

    @Test
    void right() {
        //tests if proper value was retrieved for right border
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 6);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.LEFT, 1);
        enumMap.put(Direction.RIGHT, 8);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(8, rectangle.right());
        assertNotEquals(1, rectangle.right());
    }

    @Test
    void getBorders() {
        //tests if proper values were retrieved for particular borders
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.BOTTOM, 1);
        enumMap.put(Direction.RIGHT, 6);
        Collection<Direction> directions = List.of(Direction.BOTTOM, Direction.RIGHT);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        assertEquals(enumMap, rectangle.getBorders(directions));

        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.TOP, 9);
        enumMap2.put(Direction.LEFT, 5);
        enumMap2.put(Direction.RIGHT, 6);
        Collection<Direction> directions2 = List.of(Direction.TOP, Direction.LEFT, Direction.RIGHT);
        Rectangle<Integer> rectangle2 = new Rectangle<>(enumMap2);
        assertEquals(enumMap2, rectangle2.getBorders(directions2));
    }

    @Test
    void of() throws RectangleException {
        //tests whether the rectangle created has the correct border values
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 5);
        enumMap.put(Direction.BOTTOM, 4);
        enumMap.put(Direction.LEFT, 6);
        enumMap.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        Rectangle.of(rectangle.top(), rectangle.bottom(), rectangle.left(), rectangle.right());
        assertEquals(5, rectangle.top());
        assertEquals(4, rectangle.bottom());
        assertEquals(6, rectangle.left());
        assertEquals(7, rectangle.right());

        //tests whether IllegalArgumentException is thrown if there is null argument
        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.TOP, null);
        enumMap2.put(Direction.BOTTOM, 4);
        enumMap2.put(Direction.LEFT, 6);
        enumMap2.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle2 = new Rectangle<>(enumMap2);
        assertThrows(IllegalArgumentException.class, () -> rectangle2.of(rectangle2.top(), rectangle2.bottom(), rectangle2.left(), rectangle2.right()), "Entering null argument should throw");

        //tests whether IllegalArgumentException is thrown if the top/bottom bounds are out of order
        EnumMap<Direction, Integer> enumMap3 = new EnumMap<>(Direction.class);
        enumMap3.put(Direction.TOP, 2);
        enumMap3.put(Direction.BOTTOM, 5);
        enumMap3.put(Direction.LEFT, 6);
        enumMap3.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle3 = new Rectangle<>(enumMap3);
        assertThrows(IllegalArgumentException.class, () -> rectangle3.of(rectangle3.top(), rectangle3.bottom(), rectangle3.left(), rectangle3.right()), "Entering out-of-order bounds should throw");

        //tests whether IllegalArgumentException is thrown if the left/right bounds are out of order
        EnumMap<Direction, Integer> enumMap4 = new EnumMap<>(Direction.class);
        enumMap4.put(Direction.TOP, 2);
        enumMap4.put(Direction.BOTTOM, 5);
        enumMap4.put(Direction.LEFT, 6);
        enumMap4.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle4 = new Rectangle<>(enumMap4);
        assertThrows(IllegalArgumentException.class, () -> rectangle4.of(rectangle4.top(), rectangle4.bottom(), rectangle4.left(), rectangle4.right()), "Entering out-of-order bounds should throw");
    }

    @Test
    void copyOf() throws RectangleException {
        //tests whether the copied rectangle has the same border values as the original rectangle
        EnumMap<Direction, Integer> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, 7);
        enumMap.put(Direction.BOTTOM, 6);
        enumMap.put(Direction.LEFT, 2);
        enumMap.put(Direction.RIGHT, 10);
        Rectangle<Integer> rectangle = new Rectangle<>(enumMap);
        Rectangle<Integer> copiedRectangle = rectangle.copyOf(rectangle);
        assertEquals(rectangle.top(), copiedRectangle.top());
        assertEquals(rectangle.bottom(), copiedRectangle.bottom());
        assertEquals(rectangle.left(), copiedRectangle.left());
        assertEquals(rectangle.right(), copiedRectangle.right());

        //tests whether IllegalArgumentException is thrown if there is null argument
        EnumMap<Direction, Integer> enumMap2 = new EnumMap<>(Direction.class);
        enumMap2.put(Direction.TOP, null);
        enumMap2.put(Direction.BOTTOM, 4);
        enumMap2.put(Direction.LEFT, 6);
        enumMap2.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle2 = new Rectangle<>(enumMap2);
        assertThrows(IllegalArgumentException.class, () -> rectangle2.copyOf(rectangle2), "Entering null argument should throw");

        //tests whether IllegalArgumentException is thrown if the top/bottom bounds are out of order
        EnumMap<Direction, Integer> enumMap3 = new EnumMap<>(Direction.class);
        enumMap3.put(Direction.TOP, 2);
        enumMap3.put(Direction.BOTTOM, 4);
        enumMap3.put(Direction.LEFT, 6);
        enumMap3.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle3 = new Rectangle<>(enumMap3);
        assertThrows(IllegalArgumentException.class, () -> rectangle3.copyOf(rectangle3), "Entering out-of-order bounds should throw");

        //tests whether IllegalArgumentException is thrown if the left/right bounds are out of order
        EnumMap<Direction, Integer> enumMap4 = new EnumMap<>(Direction.class);
        enumMap4.put(Direction.TOP, 6);
        enumMap4.put(Direction.BOTTOM, 4);
        enumMap4.put(Direction.LEFT, 8);
        enumMap4.put(Direction.RIGHT, 7);
        Rectangle<Integer> rectangle4 = new Rectangle<>(enumMap4);
        assertThrows(IllegalArgumentException.class, () -> rectangle4.copyOf(rectangle4), "Entering out-of-order bounds should throw");
    }
}