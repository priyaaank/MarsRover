package universe;

import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

    @Test
    public void testThatPlateauCanIdentifyWhenACoordinateIsInsideItsBounds() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        Coordinates coordinatesWithinBounds = new Coordinates(5, 0);

        //Then
        //Chirag: how about isInside() instead of isWithinPlateauDimensions() ?
        Assert.assertTrue(mars.isWithinPlateauDimensions(coordinatesWithinBounds));
    }

    @Test
    public void testThatPlateauCanIdentifyWhenXCoordinateIsOutsideItsUpperXCoordinateBound() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        Coordinates pointWithXCoordinateOutsideBounds = new Coordinates(6, 0);

        //Then
        Assert.assertFalse(mars.isWithinPlateauDimensions(pointWithXCoordinateOutsideBounds));
    }

    @Test
    public void testThatPlateauCanIdentifyWhenYCoordinateIsOutsideItsUpperYCoordinateBound() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        Coordinates pointWithYCoordinateOutsideBounds = new Coordinates(0, 6);


        //Then
        Assert.assertFalse(mars.isWithinPlateauDimensions(pointWithYCoordinateOutsideBounds));
    }

    @Test
    public void testThatPlateauCanIdentifyWhenYCoordinateIsOutsideItsLowerYCoordinateBound() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        Coordinates pointWithYCoordinateOutsideBounds = new Coordinates(0, -1);


        //Then
        Assert.assertFalse(mars.isWithinPlateauDimensions(pointWithYCoordinateOutsideBounds));
    }

    @Test
    public void testThatPlateauCanIdentifyWhenXCoordinateIsOutsideItsLowerXCoordinateBound() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        Coordinates pointWithXCoordinateOutsideBounds = new Coordinates(-1, 0);


        //Then
        Assert.assertFalse(mars.isWithinPlateauDimensions(pointWithXCoordinateOutsideBounds));
    }
}
