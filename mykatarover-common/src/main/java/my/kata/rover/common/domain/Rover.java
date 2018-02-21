package my.kata.rover.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.kata.rover.common.interfaces.CommunicationApi;
import my.kata.rover.common.interfaces.ReportApi;
import my.kata.rover.common.interfaces.Something;
import my.kata.rover.common.utils.Constants;

@NoArgsConstructor
@AllArgsConstructor
public class Rover implements CommunicationApi, Something {

    @Getter
    @Setter
    private Place place;

    @Getter
    @Setter
    private Direction direction;

    @Getter
    @Setter
    char [] thingsToDo;

    @Getter
    @Setter
    private Sensor sensor;

    @Getter
    @Setter
    private ReportApi houston;

    public Rover(Place place,Direction direction,char... thingsToDo){
        this.place = place;
        this.direction = direction;
        this.thingsToDo = thingsToDo;

    }

    public void recieveMovementPattern(char... actions) {
        setThingsToDo(actions);
    }

    public void  executeMovementPattern(){
        for(char action : thingsToDo){

            if(action == 'f' || action == 'b'){
                if(!move(action)){
                    break;
                }
            }else if(action == 'l' || action == 'r'){
                turn(action);
            }
        }

    }

    public boolean move(char command){
        int [] vector = directionVector();
        int translation = 0;
        if(command == 'f'){
            translation = 1;
        }else  if (command == 'b'){
            translation = -1;
        }
        int x,y;
        x = Math.abs((Constants.MARS_SIZE+(getPlace().getX()+(vector[0]*translation))) % Constants.MARS_SIZE);
        y = Math.abs((Constants.MARS_SIZE+(getPlace().getY()+(vector[1]*translation))) % Constants.MARS_SIZE);

        if(getSensor() != null){
            Place inFrontPlace = new Place(x,y);
            if(!getSensor().checkPlaceIsSecureToMove(inFrontPlace)){
                if(checkConectionToReportApi()){
                    getHouston().reportObstacle("Movement aborted: Houston, we got a problem!",inFrontPlace);
                    return false;
                }
            }
        }
        getPlace().setX(x);
        getPlace().setY(y);
        return true;
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
                return new int[]{0, -1};

            case E:
                return new int[]{1, 0};

            case S:
                return new int[]{0, 1};

            case W:
                return new int[]{-1, 0};

            default:
                return new int[]{0,0};
        }
    }

    private boolean checkConectionToReportApi(){
        return houston != null && houston.isConnected();
    }


}
