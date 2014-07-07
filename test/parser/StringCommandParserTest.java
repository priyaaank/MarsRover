package parser;

import com.thoughtworks.rover.commands.ICommand;
import com.thoughtworks.rover.commands.MoveCommand;
import com.thoughtworks.rover.commands.RotateLeftCommand;
import com.thoughtworks.rover.commands.RotateRightCommand;
import com.thoughtworks.rover.parser.StringCommandParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringCommandParserTest {

    @Test
    public void testThatStringLMapsToRotateLeftCommand() {
        //Given
        String commandString = "L";
        StringCommandParser parser = new StringCommandParser(commandString);

        //When
        List<ICommand> commands = parser.parseToCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateLeftCommand);
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
