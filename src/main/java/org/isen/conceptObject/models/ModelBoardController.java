package org.isen.conceptObject.models;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.container.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelBoardController {


    List<Alive> allAlivesElement = new ArrayList<>();


    public List<Alive> getAllAlivesElement() {
        return allAlivesElement;
    }

    public void setAllAlivesElement(List<Alive> allAlivesElement) {
        this.allAlivesElement = allAlivesElement;
    }

    public void setAllPawn(){
        for(int i = 0 ; i < Constant.NUMBER_PAWN_PER_TEAM ; i++){
            int posY;
            int posX;
            if(i<3){
                posX = i;
                posY = Constant.MAP_SIZE_Y-4;
            }else{
                posX = 3;
                posY = Constant.MAP_SIZE_Y-7+i;
            }
            Goblins goblins = new Goblins(posX,posY);
            allAlivesElement.add(goblins);
        }

        for(int i = 0 ; i < Constant.NUMBER_PAWN_PER_TEAM ; i++){
            int posY;
            int posX;
            if(i<3){
                posX = Constant.MAP_SIZE_X-4;
                posY = i;
            }else{
                posX = Constant.MAP_SIZE_X-7+i;
                posY = 3;
            }
            Orc orc = new Orc(posX,posY);
            allAlivesElement.add(orc);
        }

        for(int i = 0 ; i < Constant.NUMBER_PAWN_PER_TEAM ; i++){
            int posY;
            int posX;
            if(i<3){
                posX = i;
                posY = 3;
            }else{
                posX = 3;
                posY = i-3;
            }
            Human human = new Human(posX,posY);
            allAlivesElement.add(human);
        }

        for(int i = 0 ; i < Constant.NUMBER_PAWN_PER_TEAM ; i++){
            int posY;
            int posX;
            if(i<3){
                posX = Constant.MAP_SIZE_X-3+i;
                posY = Constant.MAP_SIZE_Y-4;
            }else{
                posX = Constant.MAP_SIZE_Y-4;
                posY = Constant.MAP_SIZE_X-7+i;
            }
            Elve elve = new Elve(posX,posY);
            allAlivesElement.add(elve);
        }

    }

    public void moveAllElements(){


        for ( Alive elive : allAlivesElement){

        }

    }


}
