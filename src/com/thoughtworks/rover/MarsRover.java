package com.thoughtworks.rover;

import com.thoughtworks.rover.commands.ICommand;
import com.thoughtworks.rover.navigation.Navigator;
import com.thoughtworks.rover.parser.StringCommandParser;

import java.util.List;

public class MarsRover {

    private Navigator roverNavigator;

    public MarsRover(Navigator roverNavigator) {
        this.roverNavigator = roverNavigator;
    }

    public void handleCommand(String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).parseToCommands();
        for (ICommand command : roverCommands) {
            command.execute(roverNavigator);
        }
    }

    public String currentLocation() {
        return roverNavigator.currentLocation();
    }
}