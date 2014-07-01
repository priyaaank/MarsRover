package com.thoughtworks.rover.commands;

public class RotateRightCommand implements ICommand {

    @Override
    public void execute(INavigable navigable) {
        navigable.rotateRight();
    }

}
