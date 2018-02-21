package my.kata.rover.common.test;

import lombok.Getter;
import lombok.Setter;
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
        roverInitialPoint();
        Place roverInitPlace = new Place(getRover().getPlace().getX(),getRover().getPlace().getY());
        getRover().move('b');
        Assert.assertTrue(roverInitPlace.getX() != getRover().getPlace().getX() || roverInitPlace.getY() != getRover().getPlace().getY());
    }

    @Test
    public void roverGoesForward(){
        roverInitialPoint();
        Place roverInitPlace = new Place(getRover().getPlace().getX(),getRover().getPlace().getY());
        getRover().move('f');
        Assert.assertTrue(roverInitPlace.getX() != getRover().getPlace().getX() || roverInitPlace.getY() != getRover().getPlace().getY());

    }
}
