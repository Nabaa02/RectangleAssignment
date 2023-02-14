package edu.cwru.nak95;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Nabaa Khan
 * Test class for Direction enum
 */
class DirectionTest {

    @Test
    void valueOf() {
        //tests whether proper enum constants are returned given enum type and specific enum name
        assertEquals(Direction.TOP, Direction.valueOf("TOP"));
        assertEquals(Direction.BOTTOM, Direction.valueOf("BOTTOM"));
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
    }

    @Test
    void values() {
        //tests whether all values in enum are returned
        Direction[] directions = {Direction.TOP, Direction.BOTTOM, Direction.LEFT, Direction.RIGHT};
        assertArrayEquals(directions, Direction.values());
    }
}