package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for Grid
 */
class GridTest {

    @Test
    void top() throws RectangleException {
        Rectangle<Integer> rectangle = Rectangle.of(5, 3, 6, 9);
        assertEquals(5, rectangle.top());
        assertDoesNotThrow(rectangle::top);
    }

    @Test
    void bottom() throws RectangleException {
        Rectangle<Integer> rectangle = Rectangle.of(5, 3, 6, 9);
        assertEquals(3, rectangle.bottom());
        assertDoesNotThrow(rectangle::bottom);
    }

    @Test
    void left() throws RectangleException {
        Rectangle<Integer> rectangle = Rectangle.of(5, 3, 6, 9);
        assertEquals(6, rectangle.left());
        assertDoesNotThrow(rectangle::left);
    }

    @Test
    void right() throws RectangleException {
        Rectangle<Integer> rectangle = Rectangle.of(5, 3, 6, 9);
        assertEquals(9, rectangle.right());
        assertDoesNotThrow(rectangle::right);
    }

    @Test
    void from() throws RectangleException {
        Rectangle<Integer> rectangle = Rectangle.of(6, 3, 4, 8);
        //ensures that Grid follows rectangle's borders
        assertEquals(6, Grid.from(rectangle).top());
        assertEquals(3, Grid.from(rectangle).bottom());
        assertEquals(4, Grid.from(rectangle).left());
        assertEquals(8, Grid.from(rectangle).right());
    }
}