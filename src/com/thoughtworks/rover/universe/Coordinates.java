package com.thoughtworks.rover.universe;

public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinates(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Coordinates newCoordinatesFor(final int xCoordinateStepValue, final int yCoordinateStepValue) {
        return new Coordinates(this.xCoordinate + xCoordinateStepValue, this.yCoordinate + yCoordinateStepValue);
    }

    @Override
    public String toString() {
        StringBuffer coordinateOutput = new StringBuffer();
        coordinateOutput.append(xCoordinate);
        coordinateOutput.append(" ");
        coordinateOutput.append(yCoordinate);
        return coordinateOutput.toString();
    }

    public boolean isGreaterThan(final Coordinates coordinates) {
        return isXCoordinateInInnerBounds(coordinates.xCoordinate) && isYCoordinateInInnerBounds(coordinates.yCoordinate);
    }

    public boolean isLessThan(final Coordinates coordinates) {
        return isXCoordinateInOuterBounds(coordinates.xCoordinate) && isYCoordinateInOuterBounds(coordinates.yCoordinate);
    }

    private boolean isXCoordinateInOuterBounds(final int xCoordinate) {
        return xCoordinate >= this.xCoordinate;
    }

    private boolean isYCoordinateInOuterBounds(final int yCoordinate) {
        return yCoordinate >= this.yCoordinate;
    }

    private boolean isYCoordinateInInnerBounds(final int yCoordinate) {
        return yCoordinate <= this.yCoordinate;
    }

    private boolean isXCoordinateInInnerBounds(final int xCoordinate) {
        return xCoordinate <= this.xCoordinate;
    }

    public Coordinates newCoordinatesForStepSize(final int xCoordinateStepValue, final int yCoordinateStepValue) {
        return new Coordinates(xCoordinate+xCoordinateStepValue, yCoordinate+yCoordinateStepValue);
    }

}
