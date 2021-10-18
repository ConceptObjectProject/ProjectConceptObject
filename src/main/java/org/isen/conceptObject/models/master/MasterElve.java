package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Elve;

public class MasterElve extends Elve {

    private org.isen.conceptObject.models.master.MasterElve unique;

    private MasterElve(int posX, int posY) {
        super(posX, posY);
    }

    public org.isen.conceptObject.models.master.MasterElve getInstance() {
        if (unique == null) {
            unique = new org.isen.conceptObject.models.master.MasterElve(Constant.MASTER_ELVE_POS_X, Constant.MASTER_ELVE_POS_Y);
        }
        return unique;
    }
}
