package com.thoughtworks.rover.universe;

public class Plateau {

    private Coordinates topRightCoordinates = new Coordinates(0, 0);
    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

    public Plateau(final int topRightXCoordinate, final int topRightYCoordinate) {
        this.topRightCoordinates.changeXCoordinatesBy(topRightXCoordinate);
        this.topRightCoordinates.changeYCoordinatesBy(topRightYCoordinate);
    }

    public boolean isWithinPlateauDimensions(Coordinates coordinates) {
        return this.bottomLeftCoordinates.isLessThan(coordinates) && this.topRightCoordinates.isGreaterThan(coordinates);
    }

}
