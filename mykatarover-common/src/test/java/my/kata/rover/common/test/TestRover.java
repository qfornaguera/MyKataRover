package my.kata.rover.common.test;

import lombok.Getter;
import lombok.Setter;
import my.kata.rover.common.domain.*;
import my.kata.rover.common.utils.Constants;
import my.kata.rover.common.utils.Landing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestRover {

    @Getter
    @Setter
    Rover rover;


    @Before
    public void initRover(){
        rover = new Rover();
    }


    @Test
    public void roverInitialPoint(){
        Landing.landOverSomePlace(getRover());
        Assert.assertNotNull(getRover().getDirection());
        Assert.assertNotNull(getRover().getPlace());
    }

    @Test
    public void roverRecieveCommands(){
        getRover().recieveMovementPattern('f','r','b','l','f');
    }

    @Test
    public void roverGoesBackwards(){
        testMove('b');
    }

    @Test
    public void roverGoesForward(){
        testMove('f');
    }

    @Test
    public void roverGoesDirectionNorh(){
        Rover roverito = new Rover(new Place(5,5),Direction.N,new char[]{'f','b'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(4,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
        roverito.move(roverito.getThingsToDo()[1]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
    }

    @Test
    public void roverGoesDirectionSouth(){
        Rover roverito = new Rover(new Place(5,5),Direction.S,new char[]{'f','b'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(6,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
        roverito.move(roverito.getThingsToDo()[1]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
    }

    @Test
    public void roverGoesDirectionEast(){
        Rover roverito = new Rover(new Place(5,5),Direction.E,new char[]{'f','b'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(6,roverito.getPlace().getX());
        roverito.move(roverito.getThingsToDo()[1]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
    }


    @Test
    public void roverGoesDirectionWest(){
        Rover roverito = new Rover(new Place(5,5),Direction.W,new char[]{'f','b'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(4,roverito.getPlace().getX());
        roverito.move(roverito.getThingsToDo()[1]);
        Assert.assertEquals(5,roverito.getPlace().getY());
        Assert.assertEquals(5,roverito.getPlace().getX());
    }

    @Test
    public void roverGoesThroughNorthEdge(){
        Rover roverito = new Rover(new Place(5,0),Direction.N,new char[]{'f'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(Constants.MARS_SIZE-1,roverito.getPlace().getY());
    }

    @Test
    public void roverGoesThroughSouthEdge(){
        Rover roverito = new Rover(new Place(5,Constants.MARS_SIZE-1),Direction.S,new char[]{'f'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(0,roverito.getPlace().getY());
    }

    @Test
    public void roverGoesThroughEastEdge(){
        Rover roverito = new Rover(new Place(Constants.MARS_SIZE-1,5),Direction.E,new char[]{'f'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(0,roverito.getPlace().getX());
    }

    @Test
    public void roverGoesThroughWestEdge(){
        Rover roverito = new Rover(new Place(0,5),Direction.W,new char[]{'f'});
        roverito.move(roverito.getThingsToDo()[0]);
        Assert.assertEquals(Constants.MARS_SIZE-1,roverito.getPlace().getX());
    }

    @Test
    public void roverTurnsRight() {
        testTurn('r');
    }

    @Test
    public void roverTurnsLeft(){
        testTurn('l');
    }

    @Test
    public void roverFindsARock(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.checkPlaceIsSecureToMove(new Place())).thenReturn(false);
        Rover roverito = new Rover(
                new Place(5,5),Direction.N,new char[]{'f'},sensor,new Houston()
        );
        roverito.move('f');
        Assert.assertEquals(5,roverito.getPlace().getX());
        Assert.assertEquals(5,roverito.getPlace().getY());
    }

    @Test
    public void roverStopsDoingThingsAfterColission(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.checkPlaceIsSecureToMove(new Place())).thenReturn(false);
        Rover roverito = new Rover(
                new Place(5,5),Direction.N,new char[]{'f','l','f','r','b'},sensor,new Houston()
        );
        roverito.executeMovementPattern();
        Assert.assertEquals(5,roverito.getPlace().getX());
        Assert.assertEquals(5,roverito.getPlace().getY());
    }

    @Test
    public void roverCompletesAMovementPattern(){
        Rover roverito = new Rover(
                new Place(5,5),Direction.N,new char[]{'f','l','f','r','b'}
        );
        roverito.executeMovementPattern();
        Assert.assertEquals(6,roverito.getPlace().getX());
        Assert.assertEquals(3,roverito.getPlace().getY());
    }


    private void testTurn(char command){
        roverInitialPoint();
        Direction roverInitDirection = getRover().getDirection();
        rover.turn(command);
        Assert.assertNotEquals(roverInitDirection,getRover().getDirection());
    }

    private void testMove(char command){
        roverInitialPoint();
        Place roverInitPlace = new Place(getRover().getPlace().getX(),getRover().getPlace().getY());
        getRover().move(command);
        Assert.assertTrue(roverInitPlace.getX() != getRover().getPlace().getX() || roverInitPlace.getY() != getRover().getPlace().getY());
    }


}
