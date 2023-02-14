package edu.cwru.nak95;
import java.util.*;
/**
 * @author Nabaa Khan
 * Record for pairs of indices
 */
public record IndexPair (int xIndex, int yIndex) implements Comparable<IndexPair> {

    /**
     * Tailored compareTo method such that comparison may be drawn between pairs of indices
     * @param pair object to be compared to
     * @return int representing whether this pair is greater/less than or equal to input pair
     */
    @Override
    public int compareTo(IndexPair pair) {
        //compare x values first
        if(this.xIndex - pair.xIndex != 0) {
            return this.xIndex - pair.xIndex;
        }
        //if x values are the same, compare y values to discern order of pairs
        else {
            return this.yIndex - pair.yIndex;
        }
    }

    /**
     * Increments indexPair according to direction
     * @param direction object that decides whether xIndex or yIndex is updated
     * @return IndexPair representing incremented indexPair
     */
    public IndexPair increment(Direction direction) {
        Objects.requireNonNull(direction);
        //create dictionary, mapping direction with increment
        Dictionary<Direction, Integer> dictionary = new Hashtable<>();
        dictionary.put(Direction.TOP, getYIndex() + 1);
        dictionary.put(Direction.BOTTOM, getYIndex() - 1);
        dictionary.put(Direction.LEFT, getXIndex() - 1);
        dictionary.put(Direction.RIGHT, getXIndex() + 1);
        //if direction is horizontal, update indexPair's xIndex but keep yIndex the same
        if(Direction.HORIZONTAL_BOUNDS.contains(direction)) {
            return new IndexPair(dictionary.get(direction), getYIndex());
        }
        //otherwise, keep xIndex the same but update yIndex
        else {
           return new IndexPair(getXIndex(), dictionary.get(direction));
        }
    }

    /**
     * Retrieves indexPair's x index
     */
    public int getXIndex() {
        return xIndex;
    }

    /**
     * Retrieves indexPair's y index
     */
    public int getYIndex() {
        return yIndex;
    }
}
