package edu.cwru.nak95;
import java.util.*;

public final class RectangleGroup<T extends Comparable<T>> {

    private final Set<Rectangle<T>> rectangleSet;

    private final PlaneMap<T> planeMap;

    private final int[][] matrix;

    private RectangleGroup(Set<Rectangle<T>> rectangleSet, PlaneMap<T> planeMap, int[][] matrix) {
        this.rectangleSet = rectangleSet;
        this.planeMap = planeMap;
        this.matrix = matrix;
    }

    public Set<Rectangle<T>> getRectangleSet() {
        return rectangleSet;
    }

    public PlaneMap<T> getPlaneMap() {
        return planeMap;
    }

    //public int[][] createMatrix() {

        //for(int i = 0; i < getPlaneMap().getAxisMapX().flatIndexOf(getPlaneMap().getAxisMapX().getSize() - 1))
        //for(int i = 0; i < getPlaneMap().indexOf(getPlaneMap().xSize(), true); i++) {
        //}
        //int rows;
        //int cols;
        //int[][] rectangleMatrix = new int[rows][cols];
    //}
    //set of x coordinates = x axis
    //set of y coordinates = y axis


    public static void main(String[] args) throws RectangleException {
        Set<Rectangle<Integer>> rec = new HashSet<>();
        rec.add(Rectangle.of(4, 2, 1, 3));
        rec.add(Rectangle.of(5, 3, 2, 6));
        //what is PlaneMap.from supposed to return?
        System.out.println(PlaneMap.from(rec));
    }

    /*static<T extends Comparable<T>> RectangleGroup<T> from(Set<Rectangle<T>> rectangles) throws RectangleException {
        Objects.requireNonNull(rectangles);
        Set<Rectangle<T>> rectangleSet = new HashSet<>();
        for(Rectangle<T> rectangle : rectangles) {
            rectangleSet.add(Rectangle.copyOf(rectangle));
        }
        return new RectangleGroup<>(rectangleSet);
    }*/
}
