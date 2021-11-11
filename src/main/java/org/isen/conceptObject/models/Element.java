package org.isen.conceptObject.models;


public class Element {
    protected int posX;
    protected int posY;
    protected boolean isAlive;

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
