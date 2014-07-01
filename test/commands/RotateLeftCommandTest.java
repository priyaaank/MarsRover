package commands;

import com.thoughtworks.rover.navigation.INavigable;
import com.thoughtworks.rover.commands.RotateLeftCommand;
import org.junit.Assert;
import org.junit.Test;

public class RotateLeftCommandTest {

    @Test
    public void testThatRotateLeftCommandRotatesTheNavigableObjectLeft() {
        //Given
        RotateLeftCommand command = new RotateLeftCommand();
        MovableRover rover = new MovableRover();

        //When
        command.execute(rover);

        //Then
        Assert.assertTrue(rover.rotated);
    }

    class MovableRover implements INavigable {

        public boolean rotated = false;

        @Override
        public void rotateRight() {
            //Do nothing
        }

        @Override
        public void rotateLeft() {
            rotated = true;
        }

        @Override
        public void move() {
            //Do nothing
        }
    }
}
