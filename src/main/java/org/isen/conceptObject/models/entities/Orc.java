package org.isen.conceptObject.models.entities;


import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Alive;
import org.isen.conceptObject.models.Bad;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.container.Pair;
import org.isen.conceptObject.models.master.MasterOrc;

import java.util.List;


public class Orc extends Bad {
    @Override
    protected Boolean isCaseFree(Pair<Integer, Integer> pos, List<Element> allElements) {
        if (pos.x >= 0 && pos.x < Constant.MAP_SIZE_X && pos.y >= 0 && pos.y < Constant.MAP_SIZE_Y) {

            if (Goblins.isInSafeZone(pos) || Elve.isInSafeZone(pos) || Human.isInSafeZone(pos)) {
                return false;
            }

            for (Element element : allElements) {
                if (element.getPosX() == pos.x && element.getPosY() == pos.y) {
                    return Boolean.FALSE;
                }
            }
        } else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean isInSafeZone(Pair<Integer, Integer> pos) {
        if (pos.x >= Constant.SAFE_ZONE_ORC[0] && pos.x <= Constant.SAFE_ZONE_ORC[1]) {
            if (pos.y >= Constant.SAFE_ZONE_ORC[2] && pos.y <= Constant.SAFE_ZONE_ORC[3]) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Boolean isMasterMeet(Pair<Integer, Integer> pos, Alive elem) {
        if (elem.getClass() == MasterOrc.class) {
            return true;
        }
        return false;
    }

    public Orc(int posX, int posY) {
        super(posX, posY, 5, 7, 0.65, "Orc",1);
    }


}
