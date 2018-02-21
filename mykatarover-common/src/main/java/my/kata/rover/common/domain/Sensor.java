package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Sensor {

    @Getter
    @Setter
    private Mars marsEnvironment;

    public boolean checkPlaceIsSecureToMove(Place place){
        return getMarsEnvironment().getLand()[place.getX()][place.getY()] instanceof Rock;
    }
}
