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
        StringCommandParser parser = new StringCommandParser("L");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateLeftCommand);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void testThatStringRMapsToRotateRightCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("R");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateRightCommand);
    }

    @Test
    public void testThatStringMMapsToMoveCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("M");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
    }

}
