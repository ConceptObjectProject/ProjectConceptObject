package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Elve;

public class MasterElve extends Elve {

   private MasterElve unique;

    private MasterElve(int posX, int posY) {
        super(posX, posY);
    }

    public MasterElve getInstance(){
        if (unique == null)
        {
            unique = new MasterElve(Constant.MASTER_ELVE_POS_X,Constant.MASTER_ELVE_POS_Y);
        }
        return unique;
    }
}
