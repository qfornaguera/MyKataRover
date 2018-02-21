package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.kata.rover.common.interfaces.CommunicationApi;
import my.kata.rover.common.utils.Constants;

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

    public void move(char command){
        int [] vector = directionVector();
        int translation = 0;
        if(command == 'f'){
            translation = 1;
        }else  if (command == 'b'){
            translation = -1;
        }
        getPlace().setX(Math.abs((getPlace().getX()+(vector[0]*translation)) % Constants.MARS_SIZE));
        getPlace().setY(Math.abs((getPlace().getY()+(vector[1]*translation)) % Constants.MARS_SIZE));

    }

    public void turn(char command){
        Direction[] directions = Direction.values();
        int translation;
        if(command == 'r'){
            translation = 1;
        }else  if (command == 'l'){
            translation = -1;
        }else{
            return;
        }
        int nextDirectionOrdinal = Math.abs((getDirection().ordinal()+translation) % directions.length);
        setDirection(directions[nextDirectionOrdinal]);
    }

    private int[] directionVector(){
        switch(getDirection()){
            case N:
                return new int[]{0, 1};

            case E:
                return new int[]{1, 0};

            case S:
                return new int[]{0, -1};

            case W:
                return new int[]{-1, 0};

            default:
                return new int[]{0,0};
        }
    }


}
