package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.kata.rover.common.interfaces.CommunicationApi;
@NoArgsConstructor
@AllArgsConstructor
public class Rover implements CommunicationApi {

    @Getter
    @Setter
    private Place place;

    @Getter
    @Setter
    private Direction direction;

    @Getter
    @Setter
    char [] thingsToDo;

    public void recieveMovementPattern(char... actions) {
        setThingsToDo(actions);
    }
}
