package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Human;

public class MasterHuman extends Human {
    private MasterHuman unique;

    private MasterHuman(int posX, int posY) {
        super(posX, posY);
    }

    public MasterHuman getInstance(){
        if (unique == null)
        {
            unique = new MasterHuman(Constant.MASTER_HUMAN_POS_X,Constant.MASTER_HUMAN_POS_Y);
        }
        return unique;
    }
}
