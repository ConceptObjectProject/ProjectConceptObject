package org.isen.conceptObject.models;

public abstract class Bad extends Alive {
    public Bad(int posX, int posY) {
        super(posX, posY);
        this.goodOrBad = false;
    }
}
