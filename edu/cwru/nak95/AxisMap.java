package edu.cwru.nak95;
import java.util.*;
/**
 * @author Nabaa Khan
 * Class implementing an AxisMap
 */
public final class AxisMap<T extends Comparable<T>> {

    private final Map<T, Integer> index;

    private AxisMap(Map<T, Integer> index) { this.index = index; }

    /**
     * Creates AxisMap from collection of coordinates
     * @param coordinates collection of objects from which AxisMap is made
     * @return sorted AxisMap made from collection of coordinates
     */
    static<T extends Comparable<T>> AxisMap<T> from(Collection<T> coordinates) {
        assert !coordinates.stream().anyMatch(Objects::isNull) : "Cannot have null coordinates";
        List<T> listCoordinates = new ArrayList<>(coordinates);
        Collections.sort(listCoordinates);
        Map<T, Integer> map = new HashMap<>();
        //initialize value "index" of key-value pair in map
        int index = 0;
        for(T coordinate : listCoordinates) {
            map.put(coordinate, index);
            index++;
        }
        return new AxisMap<>(map);
    }

    /**
     * Retrieves index of value in map
     * @param value whose index is to be returned
     * @return Integer representing value's index
     */
    Integer flatIndexOf(T value) {
        return this.index.getOrDefault(value, null);
    }

    /**
     * Retrieves size of map
     */
    public int getSize() {
        return this.index.size();
    }

    /**
     * Retrieves index of value in map in the form of an Optional
     * @param value whose index is to be returned
     * @return Optional representing value's index
     */
    Optional<Integer> indexOf(T value) {
        return Optional.ofNullable(index.get(value));
    }

    /**
     * Converts argument to String format
     */
    @Override
    public String toString() { return "AxisMap: " + index; }
}
