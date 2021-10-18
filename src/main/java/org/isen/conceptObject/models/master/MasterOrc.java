package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Orc;

public class MasterOrc extends Orc {
    private MasterOrc unique;

    private MasterOrc(int posX, int posY) {
        super(posX, posY);
    }

    public MasterOrc getInstance(){
        if (unique == null)
        {
            unique = new MasterOrc(Constant.MASTER_ORC_POS_X,Constant.MASTER_ORC_POS_Y);
        }
        return unique;
    }
}
