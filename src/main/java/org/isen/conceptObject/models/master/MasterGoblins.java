package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Goblins;

public class MasterGoblins extends Goblins {
    private MasterGoblins unique;

    private MasterGoblins(int posX, int posY) {
        super(posX, posY);
    }

    public MasterGoblins getInstance(){
        if (unique == null)
        {
            unique = new MasterGoblins(Constant.MASTER_GOBLINS_POS_X,Constant.MASTER_GOBLINS_POS_Y);
        }
        return unique;
    }
}
