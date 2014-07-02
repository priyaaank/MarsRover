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
        //Chirag: initialPosition or startingPosition maybe a slightly better name because it 
        //matches with the domain language in the problem statement
        Coordinates initialRoverCoordinates = new Coordinates(1,2);
        // Chirag: new Compass().pointingToNorth() can be replaced with a static Creator method 
        // Compass.pointingNorth()
        Navigator roverNavigator = new Navigator(new Compass().pointingToNorth(), initialRoverCoordinates, plateau);
        MarsRover marsRover = new MarsRover(roverNavigator);

        //When
        marsRover.handleCommand("R"); 
        //Chirag: handleCommand() is a bit verbose and unnatural as a name. 
        // Think about if you were talking to a rover, what would you say.
        // do(), run(), execute() those are some alternatives. I suspect Java wont allow do or run :()

        //then
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    /*
    Chirag: I prefer to create test cases with the same starting position and starting direction (pointingNorth)
    and then based on R or L movement the resulting pointing direction should be opposite.
    With the current first two tests, its possible that there is a bug in the code that alwys resutls in pointing East
    regardless of the starting direction
    
    The test name can be a bit shorter CanRotateLeft(), CanMove() since we are already in MarsRoverTest. 
    Junit doesn't force you to start with Test....() now right ?
    **/
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
