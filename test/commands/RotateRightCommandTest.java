package commands;

import com.thoughtworks.rover.commands.INavigable;
import com.thoughtworks.rover.commands.RotateRightCommand;
import org.junit.Assert;
import org.junit.Test;

public class RotateRightCommandTest {
    @Test
    public void testThatRotateRightCommandRotatesTheNavigableObjectRight() {
        //Given
        RotateRightCommand command = new RotateRightCommand();
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
            rotated = true;
        }

        @Override
        public void rotateLeft() {
            //Do nothing
        }

        @Override
        public void move() {
            //Do nothing
        }
    }
}
