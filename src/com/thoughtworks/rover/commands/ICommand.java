package com.thoughtworks.rover.commands;

import com.thoughtworks.rover.navigation.INavigable;

public interface ICommand {

    public void execute(INavigable navigable);

}
