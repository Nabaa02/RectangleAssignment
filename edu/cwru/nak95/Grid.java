package edu.cwru.nak95;
import java.util.*;
/**
 * @author Nabaa Khan
 * Class implementing a Grid
 */
public final class Grid<T> implements Iterable<IndexPair> {

    private final Rectangle<Integer> rectangle;

    private Grid(Rectangle<Integer> rectangle) throws RectangleException {
        this.rectangle = Rectangle.copyOf(rectangle);
    }

    @Override
    public Iterator<IndexPair> iterator() {
        return new MyIterator(rectangle);
    }

    /**
     * Delegate methods
     * @return rectangle's border values
     */
    public Integer top() {
        return rectangle.top();
    }

    public Integer bottom() { return rectangle.bottom(); }

    public Integer left() {
        return rectangle.left();
    }

    public Integer right() {
        return rectangle.right();
    }

    /**
     * Creates Grid from a rectangle
     * @param rectangle object from which Grid will be made
     * @return Grid made from rectangle
     * @exception RectangleException from Rectangle.class
     */
    public static<T> Grid<T> from(Rectangle<Integer> rectangle) throws RectangleException {
        return new Grid<>(Rectangle.copyOf(rectangle));
    }

    /**
     * Iterator class
     */
    public static class MyIterator implements Iterator<IndexPair> {

        private final Rectangle<Integer> rectangle;

        private IndexPair indexPair;

        //represents rectangle's borders that are not to be reached, i.e. right and top
        private final IndexPair limit;

        public MyIterator(Rectangle<Integer> rectangle) {
            this.rectangle = rectangle;
            //initialize indexPair to start from bottom left border of rectangle
            this.indexPair = new IndexPair(rectangle.left(), rectangle.bottom());
            //designate an indexPair to represent where iteration must be terminated
            this.limit = new IndexPair(rectangle.right(), rectangle.top());
        }

        /**
         * Tailored hasNext method such that if this indexPair comes before the limit's indexPair, method returns true
         * @return boolean representing whether iteration may take place
         */
        @Override
        public boolean hasNext() {
            return this.indexPair.compareTo(this.limit) < 0;
        }

        /**
         * Tailored next method such that iteration may take place as long as limit (rectangle's top and right border) is not reached
         * @return indexPair representing updated x and y values
         */
        @Override
        public IndexPair next() {
            //ensure that iteration may take place
            if(this.hasNext()) {
                //check to see if border constraint is violated
                if (this.indexPair.getYIndex() < rectangle.top() - 1) {
                    //update indexPair's y value, as continued iteration is possible
                    this.indexPair = new IndexPair(this.indexPair.getXIndex(), this.indexPair.increment(Direction.TOP).getYIndex());
                }
                //if border constraint is violated, increment x index but reset y index to rectangle's bottom border
                else {
                    this.indexPair = new IndexPair(this.indexPair.increment(Direction.RIGHT).getXIndex(), rectangle.bottom());
                }
            }
            //if iteration may not take place, throw exception
            else {
                throw new NoSuchElementException();
            }
            return indexPair;
        }
    }
}
