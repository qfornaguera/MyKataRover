package my.kata.rover.common.interfaces;

import my.kata.rover.common.domain.Place;

public interface ReportApi {

    void reportObstacle(String message,Place place);

    boolean  isConnected();
}
