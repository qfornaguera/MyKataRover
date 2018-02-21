package my.kata.rover.common.test;

import lombok.Getter;
import lombok.Setter;
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
}
