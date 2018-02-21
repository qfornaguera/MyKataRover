package my.kata.rover.common.domain;

import lombok.Getter;
import my.kata.rover.common.interfaces.Something;
import my.kata.rover.common.utils.Constants;

import java.util.Random;

public class Mars {

    @Getter
    private Something[][] land;


    public Mars(){
        land = new Rock[Constants.MARS_SIZE][Constants.MARS_SIZE];
        Random random = new Random();
        for(int i = 0; i< Constants.MARS_SIZE;  i++){
            for(int j = 0; j< Constants.MARS_SIZE;  j++){
                if(Math.random() <= 0.25){
                    land[i][j] = new Rock();
                }
            }
        }

    }
}
