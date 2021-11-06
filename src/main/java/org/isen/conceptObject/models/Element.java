package org.isen.conceptObject.models;

import java.util.Random;

public class Element {
    protected int posX;
    protected int posY;
    protected boolean isAlive;
    protected Random random = new Random();

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private Element(){}

    public Element(int posX,int posY,Boolean isAlive){
        this.posX=posX;
        this.posY=posY;
        this.isAlive=isAlive;
    }
}
