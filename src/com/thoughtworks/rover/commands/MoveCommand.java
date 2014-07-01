package com.thoughtworks.rover.commands;

import com.thoughtworks.rover.navigation.INavigable;

public class MoveCommand implements ICommand {

    @Override
    public void execute(INavigable navigable) {
        navigable.move();
    }

}
