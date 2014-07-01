package com.thoughtworks.rover.commands;

public class RotateLeftCommand implements ICommand {

    @Override
    public void execute(INavigable navigable) {
        navigable.rotateLeft();
    }

}
