package universe;

import com.thoughtworks.rover.universe.Direction;
import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testThatThereIsAlwaysSingleInstanceForNorthDirection() {
        //Given
        Direction northDirectionOne = Direction.north();
        Direction northDirectionTwo = Direction.north();

        //Then
        Assert.assertSame(northDirectionOne, northDirectionTwo);
    }

    @Test
    public void testThatThereIsAlwaysSingleInstanceForSouthDirection() {
        //Given
        Direction southDirectionOne = Direction.south();
        Direction southDirectionTwo = Direction.south();

        //Then
        Assert.assertSame(southDirectionOne, southDirectionTwo);
    }

    @Test
    public void testThatThereIsAlwaysSingleInstanceForEastDirection() {
        //Given
        Direction eastDirectionOne = Direction.east();
        Direction eastDirectionTwo = Direction.east();

        //Then
        Assert.assertSame(eastDirectionOne, eastDirectionTwo);
    }

    @Test
    public void testThatThereIsAlwaysSingleInstanceForWestDirection() {
        //Given
        Direction westDirectionOne = Direction.west();
        Direction westDirectionTwo = Direction.west();

        //Then
        Assert.assertSame(westDirectionOne, westDirectionTwo);
    }

    @Test
    public void testThatDirectionStringRepresentationIsFirstCharacterOfDirectionName() {
        //Given
        Direction westDirection = Direction.west();

        //Then
        Assert.assertEquals("W", westDirection.toString());
    }
}
