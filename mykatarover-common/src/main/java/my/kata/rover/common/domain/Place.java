package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Place implements Serializable {

    @Getter
    @Setter
    private int x;

    @Getter
    @Setter
    private int y;
}
