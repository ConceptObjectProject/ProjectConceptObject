package org.isen.conceptObject.models;

import java.util.ArrayList;

public abstract class Alive extends Element{

    protected int numbersLives;
    protected int numberMessages;
    protected int numberMessagesMax;
    protected double chancetoWin;
    protected boolean goodOrBad;
    protected boolean inAlliance;
    protected String race;
    protected ArrayList<Integer[]> forbiddenCase;
    abstract void move();
    abstract void meet(Alive alive);
    abstract void fight(Alive alive1, Alive alive2);
    
    public Alive(int posX, int posY) {
        super(posX, posY);
        this.statut=true;
        this.isAlive=true;
    }
}
