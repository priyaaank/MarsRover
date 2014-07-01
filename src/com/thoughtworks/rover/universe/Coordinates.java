package com.thoughtworks.rover.universe;

public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinates(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void changeXCoordinatesBy(int stepValue) {
        xCoordinate = xCoordinate + stepValue;
    }

    public void changeYCoordinatesBy(int stepValue) {
        yCoordinate = yCoordinate + stepValue;
    }

    @Override
    public String toString() {
        StringBuffer coordinateOutput = new StringBuffer();
        coordinateOutput.append(xCoordinate);
        coordinateOutput.append(" ");
        coordinateOutput.append(yCoordinate);
        return coordinateOutput.toString();
    }

    public boolean isGreaterThan(Coordinates coordinates) {
        return isXCoordinateInInnerBounds(coordinates.xCoordinate) && isYCoordinateInInnerBounds(coordinates.yCoordinate);
    }

    public boolean isLessThan(Coordinates coordinates) {
        return isXCoordinateInOuterBounds(coordinates.xCoordinate) && isYCoordinateInOuterBounds(coordinates.yCoordinate);
    }

    private boolean isXCoordinateInOuterBounds(int xCoordinate) {
        return xCoordinate >= this.xCoordinate;
    }

    private boolean isYCoordinateInOuterBounds(int yCoordinate) {
        return yCoordinate >= this.yCoordinate;
    }

    private boolean isYCoordinateInInnerBounds(int yCoordinate) {
        return yCoordinate <= this.yCoordinate;
    }

    private boolean isXCoordinateInInnerBounds(int xCoordinate) {
        return xCoordinate <= this.xCoordinate;
    }

    public Coordinates newCoordinatesForStepSize(int xCoordinateStepValue, int yCoordinateStepValue) {
        return new Coordinates(xCoordinate+xCoordinateStepValue, yCoordinate+yCoordinateStepValue);
    }

}
