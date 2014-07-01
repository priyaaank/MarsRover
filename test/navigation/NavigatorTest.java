package navigation;

import com.thoughtworks.rover.navigation.Compass;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.navigation.Navigator;
import com.thoughtworks.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class NavigatorTest {

    @Test
    public void testThatNavigatorPointsToDirectionOnRightWhenRotatedRight() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,2);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), atCoordinates, mars);

        //When
        roverNavigator.rotateRight();

        //Then
        Assert.assertEquals("1 2 E", roverNavigator.currentLocation());
    }

    @Test
    public void testThatNavigatorPointsToDirectionOnLeftWhenRotatedLeft() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), atCoordinates, mars);

        //When
        roverNavigator.rotateLeft();

        //Then
        Assert.assertEquals("1 1 W", roverNavigator.currentLocation());
    }

    @Test
    public void testThatNavigatorMovesForwardOnXAxisByOneStepIfDirectionAheadIsNorth() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), atCoordinates, mars);

        //When
        roverNavigator.move();

        //Then
        Assert.assertEquals("1 2 N", roverNavigator.currentLocation());
    }

    @Test
    public void testThatNavigatorMovesBackOnYAxisByOneStepIfDirectionAheadIsSouth() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToSouth(), atCoordinates, mars);

        //When
        roverNavigator.move();

        //Then
        Assert.assertEquals("1 0 S", roverNavigator.currentLocation());
    }

    @Test
    public void testThatNavigatorMovesForwardOnYAxisByOneStepIfDirectionAheadIsEast() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToEast(), atCoordinates, mars);

        //When
        roverNavigator.move();

        //Then
        Assert.assertEquals("2 1 E", roverNavigator.currentLocation());
    }

    @Test
    public void testThatNavigatorMovesBackOnYAxisByOneStepIfDirectionAheadIsWest() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToWest(), atCoordinates, mars);

        //When
        roverNavigator.move();

        //Then
        Assert.assertEquals("0 1 W", roverNavigator.currentLocation());
    }

    @Test
    public void testThatCurrentLocationIsCombinationOfXCoordinateYCoordinateAndDirection() {
        //Given
        Plateau mars = new Plateau(5,5);
        Coordinates atCoordinates = new Coordinates(1,1);
        Navigator roverNavigator = new Navigator(new Compass().pointingToWest(), atCoordinates, mars);

        //When
        String locationString = roverNavigator.currentLocation();

        //Then
        Assert.assertEquals("1 1 W", locationString);
    }

}
