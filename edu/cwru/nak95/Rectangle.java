package edu.cwru.nak95;
import java.util.*;
import java.util.EnumMap;
/**
 * @author Nabaa Khan
 * Class implementing a rectangle
 */
public final class Rectangle<T extends Comparable<T>> implements Comparable<Rectangle<T>> {

    private final EnumMap<Direction, T> borders;

    /**
     * Instantiates a rectangle
     */
    Rectangle(EnumMap<Direction, T> borders) {
        this.borders = borders;
    }

    /**
     * Overrides Comparable interface's compareTo method
     * @param bound the object to be compared
     * @return int representing order of bounds
     */
    @Override
    public int compareTo(Rectangle<T> bound) {
        return 0;
    }

    /**
     * Retrieves value associated with direction
     * @param direction the object to which value is mapped to
     * @return the value associated with the provided direction
     */
    T getBorder(Direction direction) {
        return borders.get(direction);
    }

    /**
     * Retrieves the top border of rectangle
     */
    public T top() { return getBorder(Direction.TOP); }

    /**
     * Retrieves the bottom border of rectangle
     */
    public T bottom() {
        return getBorder(Direction.BOTTOM);
    }

    /**
     * Retrieves the left border of rectangle
     */
    public T left() { return getBorder(Direction.LEFT); }

    /**
     * Retrieves the right border of rectangle
     */
    public T right() {
        return getBorder(Direction.RIGHT);
    }

    /**
     * Retrieves the values associated with a collection of directions
     * @param directions collection of objects to which values are mapped to
     * @return an EnumMap which maps each direction to its respective value
     */
    EnumMap<Direction, T> getBorders(Collection<Direction> directions) {
        RectangleException.verifyNonNull(directions);
        for(Direction direction: directions) {
            T val = getBorder(direction);
            borders.put(direction, val);
        }
        return borders;
    }

    /**
     * Creates a rectangle given top, bottom, left, and right bounds
     * @param top object corresponding to top bound of rectangle
     * @param bottom object corresponding to bottom bound of rectangle
     * @param left object corresponding to left bound of rectangle
     * @param right object corresponding to right bound of rectangle
     * @return rectangle formed from the provided bounds
     * @exception RectangleException to ensure non-null and properly ordered bounds
     */
    public static<T extends Comparable<T>> Rectangle<T> of(T top, T bottom, T left, T right) throws RectangleException {
        //check whether any bounds are null
        RectangleException.verifyNonNull(top, bottom, left, right);
        //check if pairs of bounds (bottom/top, left/right) are out of order
        RectangleException.verifyBounds(bottom, top);
        RectangleException.verifyBounds(left, right);
        EnumMap<Direction, T> enumMap = new EnumMap<>(Direction.class);
        enumMap.put(Direction.TOP, top);
        enumMap.put(Direction.BOTTOM, bottom);
        enumMap.put(Direction.LEFT, left);
        enumMap.put(Direction.RIGHT, right);
        return new Rectangle<>(enumMap);
    }

    /**
     * Creates copy of a rectangle
     * @param rectangle object to be copied
     * @return copy of provided rectangle
     * @exception RectangleException to ensure non-null and properly ordered bounds
     */
    public static<T extends Comparable<T>> Rectangle<T> copyOf(Rectangle<T> rectangle) throws RectangleException {
        return Rectangle.of(rectangle.top(), rectangle.bottom(), rectangle.left(), rectangle.right());
    }

    /**
     * Converts argument to String format
     */
    @Override
    public String toString() {
        return "Rectangle: " + borders;
    }
}
