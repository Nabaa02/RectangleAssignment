package edu.cwru.nak95;
import java.util.*;
/**
 * @author Nabaa Khan
 * Class implementing a PlaneMap
 */
public final class PlaneMap<T extends Comparable<T>> {

    private final AxisMap<T> x;

    private final AxisMap<T> y;

    private PlaneMap(AxisMap<T> x, AxisMap<T> y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates PlaneMap from two collections of objects
     * @param x collection of objects from which one AxisMap will be made
     * @param y collection of objects from which another AxisMap will be made
     * @return PlaneMap created from two AxisMaps made from the collections of objects (x, y)
     */
    public static<T extends Comparable<T>> PlaneMap<T> of(Collection<T> x, Collection<T> y) {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);
        return new PlaneMap<>(AxisMap.from(x), AxisMap.from(y));
    }

    /**
     * Returns index of value in x AxisMap in the form of Optional
     * @param value whose index is to be returned
     * @return Optional representing value's index
     */
    public Optional<Integer> xIndexOf(T value) {
        Objects.requireNonNull(value);
        return this.x.indexOf(value);
    }

    /**
     * Returns index of value in y AxisMap in the form of Optional
     * @param value whose index is to be returned
     * @return Optional representing value's index
     */
    public Optional<Integer> yIndexOf(T value) {
        Objects.requireNonNull(value);
        return this.y.indexOf(value);
    }

    /**
     * Retrieves size of x AxisMap
     */
    public int xSize() {
        return this.x.getSize();
    }

    /**
     * Retrieves size of y AxisMap
     */
    public int ySize() {
        return this.y.getSize();
    }

    /**
     * Retrieves index of value based on whether it resides in the x AxisMap or y AxisMap
     * @param value whose index is to be returned
     * @param horizontal which indicates which AxisMap value belongs to
     * @return Integer representing value's index
     */
    Integer indexOf(T value, boolean horizontal) {
        if(horizontal) {
            return this.x.flatIndexOf(value);
        }
        else {
            return this.y.flatIndexOf(value);
        }
    }

    /**
     * Creates a PlaneMap from set of rectangles
     * @param rectangles set of objects from which PlaneMap is created
     * @return PlaneMap made from set of rectangles
     */
    public static<T extends Comparable<T>> PlaneMap<T> from(Set<Rectangle<T>> rectangles) {
        Objects.requireNonNull(rectangles);
        Collection<T> verticalList = new ArrayList<>();
        Collection<T> horizontalList = new ArrayList<>();
        for(Rectangle<T> rectangle : rectangles) {
            verticalList.addAll(rectangle.getBorders(Direction.VERTICAL_BOUNDS).values());
            horizontalList.addAll(rectangle.getBorders(Direction.HORIZONTAL_BOUNDS).values());
        }
        return PlaneMap.of(horizontalList, verticalList);
    }

    public AxisMap<T> getAxisMapX() {
        return x;
    }

    public AxisMap<T> getAxisMapY() {
        return y;
    }

    /**
     * Converts argument to String format
     */
    @Override
    public String toString() { return "x = " + x + "\n" + "y = " + y; }
}
