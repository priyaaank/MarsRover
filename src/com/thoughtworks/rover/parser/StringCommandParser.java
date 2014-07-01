package com.thoughtworks.rover.parser;

import com.thoughtworks.rover.commands.ICommand;
import com.thoughtworks.rover.commands.MoveCommand;
import com.thoughtworks.rover.commands.RotateLeftCommand;
import com.thoughtworks.rover.commands.RotateRightCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCommandParser {

    private static Map<String, ICommand> stringToCommandMap = new HashMap<String, ICommand>();

    static {
        stringToCommandMap.put("L", new RotateLeftCommand());
        stringToCommandMap.put("R", new RotateRightCommand());
        stringToCommandMap.put("M", new MoveCommand());
    }

    private String commandString;

    public StringCommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> parseToCommands() {
        return buildCommandsList(commandString.toUpperCase());
    }

    private List<ICommand> buildCommandsList(String commandString) {
        List<ICommand> commands = new ArrayList<ICommand>();
        for(int index =0; index < commandString.length(); index++) {
            ICommand mappedCommand = lookupEquivalentCommand(commandString.substring(index, index + 1));
            commands.add(mappedCommand);
        }
        return commands;
    }

    private ICommand lookupEquivalentCommand(String commandString) {
        return stringToCommandMap.get(commandString);
    }

}
