package edu.cwru.nak95;
import java.util.*;
/**
 * @author Nabaa Khan
 * Enum implementing primary directions
 */
enum Direction {
    TOP (false, true),
    BOTTOM (false, false),
    LEFT (true, false),
    RIGHT (true, true);

    //ascertains whether direction is horizontal
    private final boolean horizontal;
    //ascertains whether direction increases coordinate value
    private final boolean increment;
    static final Set<Direction> HORIZONTAL_BOUNDS = EnumSet.of(Direction.LEFT, Direction.RIGHT);
    static final Set<Direction> VERTICAL_BOUNDS = EnumSet.of(Direction.BOTTOM, Direction.TOP);

    /**
     * Represents a particular direction, which is characterized by its "horizontal" and "increment" values
     */
    Direction(boolean horizontal, boolean increment) {
        this.horizontal = horizontal;
        this.increment = increment;
    }
}
