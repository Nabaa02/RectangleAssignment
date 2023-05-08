## Main Premise
The idea behind this project is creating rectangles, of any type, from scratch. Below is a brief summary of the classes in this project:

## AxisMap
Maintains explicit coordinates in sorted order.

## Direction
An enum that maintains the concept of direction.

## Grid
A grid is a rectangle of integers that supports iterating through the points within the rectangle. 

## IndexPair
A record representing a pair of integers, such as (0,0); it's related to PlaneMap because an index pair is a way to locate
points that appear in a set of rectangles.

## PlaneMap
Maintains axis maps for both horizontal and vertical axes.

## Rectangle
A class defining a rectangle by its borders, aided by an EnumMap<Direction, T> variable that maps each border to its coordinates.

## RectangleException
Handles exceptions encountered while creating a rectangle, such as verifying bounds and ensuring that objects are non-null.

## RectangleGroup
Aggregates rectangles in groups to form various geometric shapes.
