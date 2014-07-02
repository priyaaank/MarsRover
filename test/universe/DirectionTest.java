package universe;

import com.thoughtworks.rover.universe.Direction;
import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testThatThereIsAlwaysSingleInstanceForNorthDirection() {
        // Chirag: you can inline the northDirectionOne and northDirectionTwo variables
        // Chirag: now this is a bit debatable but in such easy to understand tests, 
        // I would lose the descriptive names of testcases and simply go with test1(), test2()
        // I am too lazy to type such long names when the test code is so  easy to read than the name itself
        // or maybe in this case it makes sense to break the one assert per test rule and plunk all these assertSame()s in one testcase
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
