package universe;

import com.thoughtworks.rover.universe.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testThatXCoordinateValueIsIncrementWhenStepValueIsPositive() {
        //Given
        Coordinates coordinatesSet = new Coordinates(2,3);

        //When
        coordinatesSet = coordinatesSet.newCoordinatesFor(1, 0);

        //Then
        Assert.assertEquals("3 3", coordinatesSet.toString());
    }

    @Test
    public void testThatXCoordinateValueIsDecrementWhenStepValueIsNegative() {
        //Given
        Coordinates coordinatesSet = new Coordinates(2,3);

        //When
        coordinatesSet = coordinatesSet.newCoordinatesFor(-1, 0);

        //Then
        Assert.assertEquals("1 3", coordinatesSet.toString());
    }

    @Test
    public void testThatYCoordinateValueIsIncrementWhenStepValueIsPositive() {
        //Given
        Coordinates coordinatesSet = new Coordinates(2,3);

        //When
        coordinatesSet = coordinatesSet.newCoordinatesFor(0, 1);

        //Then
        Assert.assertEquals("2 4", coordinatesSet.toString());
    }

    @Test
    public void testThatYCoordinateValueIsDecrementWhenStepValueIsNegative() {
        //Given
        Coordinates coordinatesSet = new Coordinates(2,3);

        //When
        coordinatesSet = coordinatesSet.newCoordinatesFor(0, -1);

        //Then
        Assert.assertEquals("2 2", coordinatesSet.toString());
    }

    /*
    Chirag: your testname has "smaller than" and the assert has "greater than". Both should be symmetric
    **/
    @Test
    public void testThatXCoordinateSmallerThanCurrentCoordinatesAreIdentifiedCorrectly() {
        //Given
        Coordinates coordinatesSet = new Coordinates(5,5);

        //When
        Coordinates coordinatesToCheck = new Coordinates(4,5);

        //Then
        Assert.assertTrue(coordinatesSet.isGreaterThan(coordinatesToCheck));
    }


    @Test
    public void testThatYCoordinateSmallerThanCurrentCoordinatesAreIdentifiedCorrectly() {
        //Given
        Coordinates coordinatesSet = new Coordinates(5,5);

        //When
        Coordinates coordinatesToCheck = new Coordinates(5,4);

        //Then
        Assert.assertTrue(coordinatesSet.isGreaterThan(coordinatesToCheck));
    }


    @Test
    public void testThatXCoordinateGreaterThanCurrentCoordinatesAreIdentifiedCorrectly() {
        //Given
        Coordinates coordinatesSet = new Coordinates(5,5);

        //When
        Coordinates coordinatesToCheck = new Coordinates(8,5);

        //Then
        Assert.assertTrue(coordinatesSet.isLessThan(coordinatesToCheck));
    }


    @Test
    public void testThatYCoordinateGreaterThanCurrentCoordinatesAreIdentifiedCorrectly() {
        //Given
        Coordinates coordinatesSet = new Coordinates(5,5);

        //When
        Coordinates coordinatesToCheck = new Coordinates(5,8);

        //Then
        Assert.assertTrue(coordinatesSet.isLessThan(coordinatesToCheck));
    }

    @Test
    public void testThatCoordinatesCanProvideNewerCoordinatesForAGivenStepSizeWithoutChangingCurrentCoordinates() {
        //Given
        Coordinates coordinatesSet = new Coordinates(5,5);

        //When
        Coordinates updatedCoordinates = coordinatesSet.newCoordinatesForStepSize(1, -1);

        //Then
        Assert.assertEquals("6 4", updatedCoordinates.toString());
        Assert.assertEquals("5 5", coordinatesSet.toString());
    }

}
