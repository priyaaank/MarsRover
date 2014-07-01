import com.thoughtworks.rover.MarsRover;
import com.thoughtworks.rover.navigation.Compass;
import com.thoughtworks.rover.navigation.Navigator;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

    @Test
    public void TestThatRoverCanRotateRight() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates initialRoverCoordinates = new Coordinates(1,2);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("R");

        //then
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void TestThatRoverCanRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates initialRoverCoordinates = new Coordinates(1,2);
        Navigator roverNavigator = new Navigator(new Compass().pointingToSouth(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("L");

        //then
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void TestThatRoverCanMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates initialRoverCoordinates = new Coordinates(1,2);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("M");

        //then
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void TestThatRoverCanProcessAStringOfCommands() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates initialRoverCoordinates = new Coordinates(3,3);
        Navigator roverNavigator = new Navigator(new Compass().pointingToEast(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("MMRMMRMRRM");

        //then
        Assert.assertEquals("5 1 E", marsRover.currentLocation());
    }

    @Test
    public void TestThatRoverIgnoredTheCommandToDriveOffPlateau() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates initialRoverCoordinates = new Coordinates(3,3);
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("MMMMMMMMMMR");

        //then
        Assert.assertEquals("3 5 E", marsRover.currentLocation());
    }

}
