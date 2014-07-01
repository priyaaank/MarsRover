package com.thoughtworks.rover.commands;

public class MoveCommand implements ICommand {

    @Override
    public void execute(INavigable navigable) {
        navigable.move();
    }

}
