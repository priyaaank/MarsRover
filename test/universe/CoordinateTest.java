package universe;

import com.thoughtworks.rover.universe.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void xCoordinatesAreIncrementedForPositiveValue() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(1, 0);

        //Then
        Assert.assertEquals("3 3", boundaryCoordinates.toString());
    }

    @Test
    public void xCoordinatesAreDecrementedForNegativeValue() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(-1, 0);

        //Then
        Assert.assertEquals("1 3", boundaryCoordinates.toString());
    }

    @Test
    public void yCoordinatesAreIncrementedForPositiveValue() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, 1);

        //Then
        Assert.assertEquals("2 4", boundaryCoordinates.toString());
    }

    @Test
    public void yCoordinatesAreDecrementedForNegativeValue() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, -1);

        //Then
        Assert.assertEquals("2 2", boundaryCoordinates.toString());
    }

    @Test
    public void pointWithXCoordinateWithinBoundaryAreIdentified() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(5,5);

        //When
        Coordinates internalPoint = new Coordinates(4,5);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
    }


    @Test
    public void pointWithYCoordinateWithinBoundaryAreIdentified() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(5,5);

        //When
        Coordinates internalPoint = new Coordinates(5,4);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
    }


    @Test
    public void pointsWithXCoordinateOutsideBoundaryAreIdentified() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(5,5);

        //When
        Coordinates externalPoint = new Coordinates(8,5);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
    }


    @Test
    public void pointsWithYCoordinateOutsideBoundaryAreIdentified() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(5,5);

        //When
        Coordinates externalPoint = new Coordinates(5,8);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
    }

    @Test
    public void immutableCoordinatesAreCreatedForNewStepSize() {
        //Given
        Coordinates boundaryCoordinates = new Coordinates(5,5);

        //When
        Coordinates newBoundary = boundaryCoordinates.newCoordinatesForStepSize(1, -1);

        //Then
        Assert.assertEquals("6 4", newBoundary.toString());
        Assert.assertEquals("5 5", boundaryCoordinates.toString());
    }

}
