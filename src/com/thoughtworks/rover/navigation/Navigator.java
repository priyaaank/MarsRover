package com.thoughtworks.rover.navigation;

import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Direction;
import com.thoughtworks.rover.universe.Plateau;

public class Navigator implements INavigable {

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Compass directionCompass;
    private Plateau plateau;

    public Navigator(final Compass compassPointingInCurrentDirection, final Coordinates currentCoordinates, final Plateau plateau) {
        this.currentCoordinates = currentCoordinates;
        this.directionCompass = compassPointingInCurrentDirection;
        this.currentDirection = directionCompass.currentDirection();
        this.plateau = plateau;
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    @Override
    public void rotateRight() {
        directionCompass.pointToDirectionOnRight();
        currentDirection = directionCompass.currentDirection();
    }

    @Override
    public void rotateLeft() {
        directionCompass.pointToDirectionOnLeft();
        currentDirection = directionCompass.currentDirection();
    }

    @Override
    public void move() {
        Coordinates wouldBeCoordinates = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForXAxis());

        //ignores the command if rover is bring driven off plateau
        if(plateau.isWithinPlateauDimensions(wouldBeCoordinates)) {
            currentCoordinates.changeXCoordinatesBy(currentDirection.stepSizeForXAxis());
            currentCoordinates.changeYCoordinatesBy(currentDirection.stepSizeForYAxis());
        }
    }

}