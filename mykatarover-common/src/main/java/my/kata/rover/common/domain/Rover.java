package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Rover {

    @Getter
    @Setter
    private Place place;

    @Getter
    @Setter
    private Direction direction;
}
