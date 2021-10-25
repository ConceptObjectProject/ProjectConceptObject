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


    }

    public void moveAllElements(){


        for ( Alive elive : allAlivesElement){

        }

    }


}
