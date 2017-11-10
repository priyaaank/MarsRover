package com.thoughtworks.rover.universe;

public class Plateau {

    //update to top right coordinates
    private Coordinates topRightCoordinates = new Coordinates(5, 5);
    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

    public Plateau(final int topRightXCoordinate, final int topRightYCoordinate) {
        this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate, topRightYCoordinate);
    }

    public boolean hasWithinBounds(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.hasOutsideBounds(coordinates) && this.topRightCoordinates.hasWithinBounds(coordinates);
    }

}
