package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.entities.Goblins;

import java.util.List;

public class MasterGoblins extends Goblins {
    private static MasterGoblins unique;

    private MasterGoblins(int posX, int posY) {
        super(posX, posY);
        this.numberMessagesMax = 1000;
    }

    public static MasterGoblins getInstance(){
        if (unique == null)
        {
            unique = new MasterGoblins(Constant.MASTER_GOBLINS_POS_X,Constant.MASTER_GOBLINS_POS_Y);
        }
        return unique;
    }

    @Override
    public void move(List<Element> allElements){
        //Can't move
    }
}
