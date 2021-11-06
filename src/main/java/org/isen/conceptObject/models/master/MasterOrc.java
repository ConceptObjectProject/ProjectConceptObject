package org.isen.conceptObject.models.master;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.entities.Orc;

import java.util.List;

public class MasterOrc extends Orc {
    private static MasterOrc unique;

    private MasterOrc(int posX, int posY) {
        super(posX, posY);
        this.numberMessagesMax = 1000;
    }

    public static MasterOrc getInstance(){
        if (unique == null)
        {
            unique = new MasterOrc(Constant.MASTER_ORC_POS_X,Constant.MASTER_ORC_POS_Y);
        }
        return unique;
    }

    @Override
    public void move(List<Element> allElements){
        //Can't move
    }
}
