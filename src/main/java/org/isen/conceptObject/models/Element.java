package org.isen.conceptObject.models;

public class Element {
    protected int posX;
    protected int posY;
    protected boolean isAlive;
    protected boolean statut=false;

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

    public Element(int posX,int posY){
        this.posX=posX;
        this.posY=posY;
    }
}
