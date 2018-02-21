package my.kata.rover.common.test;

import lombok.Getter;
import lombok.Setter;
import my.kata.rover.common.domain.Direction;
import my.kata.rover.common.domain.Place;
import my.kata.rover.common.domain.Rover;
import my.kata.rover.common.utils.Landing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void roverTurnsRight() {
        testTurn('r');
    }

    @Test
    public void roverTurnsLeft(){
        testTurn('l');
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
