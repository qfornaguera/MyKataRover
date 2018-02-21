package my.kata.rover.common.domain;

import lombok.NoArgsConstructor;
import my.kata.rover.common.interfaces.ReportApi;

@NoArgsConstructor
public class Houston implements ReportApi {
    public void reportObstacle(String message, Place place) {
        System.out.println(message + " at x:" +place.getX() + " y:" + place.getY());
    }

    public boolean isConnected() {
        return true;
    }
}
