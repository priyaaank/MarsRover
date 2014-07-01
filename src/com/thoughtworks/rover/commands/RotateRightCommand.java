package com.thoughtworks.rover.commands;

import com.thoughtworks.rover.navigation.INavigable;

public class RotateRightCommand implements ICommand {

    @Override
    public void execute(INavigable navigable) {
        navigable.rotateRight();
    }

}
