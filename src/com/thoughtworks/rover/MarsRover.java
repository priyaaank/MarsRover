package com.thoughtworks.rover;

import com.thoughtworks.rover.commands.ICommand;
import com.thoughtworks.rover.navigation.INavigable;
import com.thoughtworks.rover.parser.StringCommandParser;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Direction;
import com.thoughtworks.rover.universe.Plateau;

import java.util.List;

public class MarsRover implements INavigable {

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Plateau plateau;


    public MarsRover(Plateau plateau, Direction direction, Coordinates coordinates) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }

    public void run(String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).parseToCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    @Override
    public void rotateRight() {
        this.currentDirection = this.currentDirection.right();
    }

    @Override
    public void rotateLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    @Override
    public void move() {
        Coordinates wouldBeCoordinates = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if rover is bring driven off plateau
        if(plateau.isInside(wouldBeCoordinates)) {
            currentCoordinates.changeXCoordinatesBy(currentDirection.stepSizeForXAxis());
            currentCoordinates.changeYCoordinatesBy(currentDirection.stepSizeForYAxis());
        }
    }
}