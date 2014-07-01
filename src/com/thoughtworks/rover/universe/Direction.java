package com.thoughtworks.rover.universe;

public class Direction {

    private static final int ZERO = 0;
    private static final int POSITIVE_ONE = 1;
    private static final int NEGATIVE_ONE = -1;
    private static Direction north;
    private static Direction south;
    private static Direction west;
    private static Direction east;

    private DirectionName name;
    private int stepSizeOnXAxis;
    private int stepSizeOnYAxis;

    private Direction(DirectionName name, final int stepSizeOnXAxis, final int stepSizeOnYAxis) {
        this.name = name;
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public int stepSizeForXAxis() {
        return stepSizeOnXAxis;
    }

    public int stepSizeForYAxis() {
        return stepSizeOnYAxis;
    }

    public static Direction north() {
        if(north == null) north = new Direction(DirectionName.North, ZERO, POSITIVE_ONE);
        return north;
    }

    public static Direction south() {
        if(south == null) south = new Direction(DirectionName.South, ZERO, NEGATIVE_ONE);
        return south;
    }

    public static Direction east() {
        if(east == null) east = new Direction(DirectionName.East, POSITIVE_ONE, ZERO);
        return east;
    }

    public static Direction west() {
        if(west == null) west = new Direction(DirectionName.West, NEGATIVE_ONE, ZERO);
        return west;
    }

    @Override
    public String toString() {
        return name.toString().substring(0,1);
    }

    enum DirectionName {
        North,
        South,
        East,
        West
    }
}
