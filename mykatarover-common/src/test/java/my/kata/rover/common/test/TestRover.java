package my.kata.rover.common.test;

import my.kata.rover.common.domain.Rover;
import my.kata.rover.common.utils.Landing;
import org.junit.Assert;
import org.junit.Test;

public class TestRover {

    @Test
    public void roverInitialPoint(){
        Rover rover = new Rover();
        Landing.landOverSomePlace(rover);
        Assert.assertNotNull(rover.getDirection());
        Assert.assertNotNull(rover.getPlace());
    }
}
