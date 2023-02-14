package edu.cwru.nak95;
import java.util.*;
import java.lang.*;
/**
 * @author Nabaa Khan
 * Class implementing exceptions for the Rectangle class
 */
public final class RectangleException extends Exception {

    private static final long serialVersionUID = 293L;

    //nested enum
    public enum Error {
        NULL_POINTERS, INVALID_BOUNDS
    }

    private final Error error;
    private final Set<Integer> indexes;
    private final Object lesserBound;
    private final Object greaterBound;

    /**
     * Instantiates an exception for particular error
     */
    RectangleException(Error error) {
        this.error = error;
        this.indexes = null;
        this.lesserBound = null;
        this.greaterBound = null;
    }

    /**
     * Instantiates an exception for multiple erroneous null values
     */
    RectangleException(Set<Integer> indexes) {
        this.error = Error.NULL_POINTERS;
        this.indexes = indexes;
        this.lesserBound = null;
        this.greaterBound = null;
    }

    /**
     * Instantiates an exception for erroneous bounds
     */
    RectangleException(Error error, Object lesserBound, Object greaterBound) {
        this.error = error;
        this.lesserBound = lesserBound;
        this.greaterBound = greaterBound;
        this.indexes = null;
    }

    /**
     * Checks whether bounds are in order
     * @param arguments vararg Object array
     */
    public static<T extends Comparable<T>> void verifyNonNull(Object... arguments) {
        for(Object i : arguments) {
            if(i == null) {
                throw new IllegalArgumentException(new RectangleException(Error.NULL_POINTERS));
            }
            else {
                //the method's main purpose is  to throw  an exception if a null argument exists
                //therefore, an else statement, outlining an alternative scenario, is not needed
            }
        }
    }

    /**
     * Checks whether bounds are in order
     * @param lesserBound the lower bound
     * @param greaterBound the higher bound
     */
    public static<T extends Comparable<T>> void verifyBounds(T lesserBound, T greaterBound) {
        RectangleException.verifyNonNull(lesserBound, greaterBound);
        if(0 <= lesserBound.compareTo(greaterBound)) {
            throw new IllegalArgumentException(new RectangleException(Error.INVALID_BOUNDS, lesserBound, greaterBound));
        }
        else {
            //the method's main purpose is to throw an exception for out-of-order bounds
            //therefore, an else statement, outlining an alternative scenario, is not needed
        }
    }
}
