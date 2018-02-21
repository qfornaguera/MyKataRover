package my.kata.rover.common.test;

import my.kata.rover.common.domain.Place;
import org.junit.Assert;
import org.junit.Test;

public class TestPlace {

    @Test
    public void placeInitialization(){
        Place initialPlace = new Place();
        Assert.assertEquals(0, initialPlace.getX());
        Assert.assertEquals(0,initialPlace.getY());
    }
}
