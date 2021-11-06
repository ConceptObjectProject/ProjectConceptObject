package org.isen.conceptObject.models.entities;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Alive;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.Good;
import org.isen.conceptObject.models.container.Pair;
import org.isen.conceptObject.models.master.MasterHuman;

import java.util.List;


public class Human extends Good {
    @Override
    protected Boolean isCaseFree(Pair<Integer, Integer> pos, List<Element> allElements) {
        if (pos.x >= 0 && pos.x < Constant.MAP_SIZE_X && pos.y >= 0 && pos.y < Constant.MAP_SIZE_Y) {

            if(Goblins.isInSafeZone(pos) || Orc.isInSafeZone(pos) || Elve.isInSafeZone(pos)){
                return false;
            }

            for (Element element : allElements) {
                if (element.getPosX() == pos.x && element.getPosY() == pos.y) {
                    return Boolean.FALSE;
                }
            }
        }
        else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean isInSafeZone(Pair<Integer,Integer> pos){
        if(pos.x >= Constant.SAFE_ZONE_HUMAN[0]  && pos.x <= Constant.SAFE_ZONE_HUMAN[1]){
            if(pos.y >= Constant.SAFE_ZONE_HUMAN[2]   && pos.y <= Constant.SAFE_ZONE_HUMAN[3]){
                return true;
            }
        }
        return false;
    }

    @Override
    protected Boolean isMasterMeet(Pair<Integer, Integer> pos, Alive elem) {
        if(elem.getClass() == MasterHuman.class){
            return true;
        }
        return false;
    }



    public Human(int posX, int posY) {
		super(posX, posY,6,7,0.5,"Humans",1);
    }




}
