package commands;

import com.thoughtworks.rover.navigation.INavigable;
import com.thoughtworks.rover.commands.MoveCommand;
import org.junit.Assert;
import org.junit.Test;

public class MoveCommandTest {

    @Test
    public void testThatMoveCommandMovesTheNavigableObject() {
        //Given
        MoveCommand command = new MoveCommand();
        MovableRover rover = new MovableRover();

        //When
        command.execute(rover);

        //Then
        Assert.assertTrue(rover.moved);
    }

    class MovableRover implements INavigable {

        public boolean moved = false;

        @Override
        public void rotateRight() {
            //Do nothing
        }

        @Override
        public void rotateLeft() {
            //Do nothing
        }

        @Override
        public void move() {
            moved = true;
        }
    }
}
