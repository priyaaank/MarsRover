package parser;

import com.thoughtworks.rover.parser.StringCommandParser;
import com.thoughtworks.rover.commands.ICommand;
import com.thoughtworks.rover.commands.MoveCommand;
import com.thoughtworks.rover.commands.RotateLeftCommand;
import com.thoughtworks.rover.commands.RotateRightCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringCommandParserTest {

    @Test
    public void testThatStringLMapsToRotateLeftCommand() {
        //Given
        String commandString = "L";
        // chirag: you can inline commandString it is not adding any more meaning by itself
        StringCommandParser parser = new StringCommandParser(commandString);

        //When
        // parseToCommands() can be called toCommands(). 
        List<ICommand> commands = parser.parseToCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateLeftCommand);
        //Chirag: useful to assert that the size of the commands list is 1, 
        // needs to be done only in one testcase not all 3
    }

    @Test
    public void testThatStringRMapsToRotateRightCommand() {
        //Given
        String commandString = "R";
        StringCommandParser parser = new StringCommandParser(commandString);

        //When
        List<ICommand> commands = parser.parseToCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateRightCommand);
    }

    @Test
    public void testThatStringMMapsToMoveCommand() {
        //Given
        String commandString = "M";
        StringCommandParser parser = new StringCommandParser(commandString);

        //When
        List<ICommand> commands = parser.parseToCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
    }

}
