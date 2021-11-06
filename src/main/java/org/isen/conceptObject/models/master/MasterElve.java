package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.entities.Elve;

import java.util.List;

public class MasterElve extends Elve {

    private static MasterElve unique;

    private MasterElve(int posX, int posY) {
        super(posX, posY);
        this.numberMessagesMax = 1000;
    }

    public static MasterElve getInstance() {
        if (unique == null) {
            unique = new MasterElve(Constant.MASTER_ELVE_POS_X, Constant.MASTER_ELVE_POS_Y);
        }
        return unique;
    }

    @Override
    public void move(List<Element> allElements){
        //Can't move
    }
}
