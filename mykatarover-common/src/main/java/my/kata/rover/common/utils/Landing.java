package my.kata.rover.common.utils;

import my.kata.rover.common.domain.Direction;
import my.kata.rover.common.domain.Place;
import my.kata.rover.common.domain.Rover;

import java.util.Random;

public class Landing {
    public static void landOverSomePlace(Rover rover){
        int possibleDirections = Direction.values().length;
        Random random = new Random();
        int randomDirection = random.nextInt(possibleDirections);
        rover.setDirection(Direction.values()[randomDirection]);
        Place landingPlace = new Place();
        landingPlace.setX(random.nextInt(Constants.MARS_SIZE));
        landingPlace.setY(random.nextInt(Constants.MARS_SIZE));
        rover.setPlace(landingPlace);
    }
}
