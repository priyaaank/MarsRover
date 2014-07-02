package navigation;

import com.thoughtworks.rover.navigation.Compass;
import com.thoughtworks.rover.universe.Direction;
import org.junit.Assert;
import org.junit.Test;

public class CompassTest {

    @Test
    public void testThatDirectionOnRightOfNorthIsEast() {
        //Given
        Compass directionCompass = new Compass().pointingToNorth();

        //When
        //chirag: how about pointRight() instead of pointToDirectionOnRight() ?
        directionCompass.pointToDirectionOnRight();

        //Then
        Assert.assertEquals(Direction.east(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnLeftOfNorthIsWest() {
        //Given
        Compass directionCompass = new Compass().pointingToNorth();

        //When
        directionCompass.pointToDirectionOnLeft();

        //Then
        Assert.assertEquals(Direction.west(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnRightOfEastIsNorth() {
        //Given
        Compass directionCompass = new Compass().pointingToEast();

        //When
        directionCompass.pointToDirectionOnRight();

        //Then
        Assert.assertEquals(Direction.south(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnLeftOfEastIsSouth() {
        //Given
        Compass directionCompass = new Compass().pointingToEast();

        //When
        directionCompass.pointToDirectionOnLeft();

        //Then
        Assert.assertEquals(Direction.north(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnRightOfWestIsNorth() {
        //Given
        Compass directionCompass = new Compass().pointingToWest();

        //When
        directionCompass.pointToDirectionOnRight();

        //Then
        Assert.assertEquals(Direction.north(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnLeftOfWestIsSouth() {
        //Given
        Compass directionCompass = new Compass().pointingToWest();

        //When
        directionCompass.pointToDirectionOnLeft();

        //Then
        Assert.assertEquals(Direction.south(), directionCompass.currentDirection());
    }

    @Test
    public void testThatDirectionOnRightOfSouthIsWest() {
        //Given
        Compass directionCompass = new Compass().pointingToSouth();

        //When
        directionCompass.pointToDirectionOnRight();

        //Then
        Assert.assertEquals(Direction.west(), directionCompass.currentDirection());
    }

    // chirag : these four more basic tests ought be on top and the other tests lower in the class
    @Test
    public void testThatDirectionOnLeftOfSouthIsEast() {
        //Given
        Compass directionCompass = new Compass().pointingToSouth();

        //When
        directionCompass.pointToDirectionOnLeft();

        //Then
        Assert.assertEquals(Direction.east(), directionCompass.currentDirection());
    }

    @Test
    public void testThatCompassPointingInNorthDirectionHasNorthAhead() {
        //Given
        Compass compass = new Compass().pointingToNorth();

        //Then
        Assert.assertEquals(Direction.north(), compass.currentDirection());
    }

    @Test
    public void testThatCompassPointingInSouthDirectionHasSouthAhead() {
        //Given
        Compass compass = new Compass().pointingToSouth();

        //Then
        Assert.assertEquals(Direction.south(), compass.currentDirection());
    }

    @Test
    public void testThatCompassPointingInEastDirectionHasEastAhead() {
        //Given
        Compass compass = new Compass().pointingToEast();

        //Then
        Assert.assertEquals(Direction.east(), compass.currentDirection());
    }

    @Test
    public void testThatCompassPointingInWestDirectionHasWestAhead() {
        //Given
        Compass compass = new Compass().pointingToWest();

        //Then
        Assert.assertEquals(Direction.west(), compass.currentDirection());
    }
}
