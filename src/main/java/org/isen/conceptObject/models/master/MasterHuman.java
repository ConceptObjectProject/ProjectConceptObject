package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.entities.Human;

import java.util.List;

public class MasterHuman extends Human {
    private static MasterHuman unique;

    private MasterHuman(int posX, int posY) {
        super(posX, posY);
        this.numberMessagesMax = 1000;
    }

    public static MasterHuman getInstance(){
        if (unique == null)
        {
            unique = new MasterHuman(Constant.MASTER_HUMAN_POS_X,Constant.MASTER_HUMAN_POS_Y);
        }
        return unique;
    }

    @Override
    public void move(List<Element> allElements){
        //Can't move
    }
}
