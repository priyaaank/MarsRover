package com.thoughtworks.rover.navigation;

import com.thoughtworks.rover.universe.Direction;

public class Compass {

    private DirectionNode north;
    private DirectionNode south;
    private DirectionNode east;
    private DirectionNode west;

    private DirectionNode directionAhead;

    public Compass() {
        initializeCompass();
    }

    private void initializeCompass() {
        createDirectionNodes();
        assignRightNodes();
        assignLeftNodes();
        this.directionAhead = this.north;
    }

    private void createDirectionNodes() {
        north = new DirectionNode(Direction.north());
        south = new DirectionNode(Direction.south());
        east  = new DirectionNode(Direction.east());
        west  = new DirectionNode(Direction.west());
    }

    private void assignRightNodes() {
        north.rightDirectionNode = east;
        east.rightDirectionNode = south;
        south.rightDirectionNode = west;
        west.rightDirectionNode = north;
    }

    private void assignLeftNodes() {
        north.leftDirectionNode = west;
        west.leftDirectionNode = south;
        south.leftDirectionNode = east;
        east.leftDirectionNode = north;
    }

    public void pointToDirectionOnLeft() {
        this.directionAhead = directionAhead.leftDirectionNode;
    }

    public void pointToDirectionOnRight() {
        this.directionAhead = directionAhead.rightDirectionNode;
    }

    public Compass pointingToNorth() {
        this.directionAhead = north;
        return this;
    }

    public Compass pointingToSouth() {
        this.directionAhead = south;
        return this;
    }

    public Compass pointingToEast() {
        this.directionAhead = east;
        return this;
    }

    public Compass pointingToWest() {
        this.directionAhead = west;
        return this;
    }

    public Direction currentDirection() {
        return directionAhead.currentDirection;
    }

    class DirectionNode {

        private Direction currentDirection;
        private DirectionNode leftDirectionNode;
        private DirectionNode rightDirectionNode;

        private DirectionNode(final Direction currentDirection) {
            this.currentDirection = currentDirection;
        }
    }
}
