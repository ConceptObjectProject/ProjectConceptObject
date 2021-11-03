package org.isen.conceptObject.models;

import java.util.ArrayList;

public abstract class Alive extends Element{

    protected int numbersLives;
    protected int numberMessages;
    protected int numberMaxMessages;
    protected boolean inAlliance;
    protected boolean inLife;
    protected boolean good;
    protected double chancetowin;
    protected String race;
   


    public Alive(int posX, int posY) {
        super(posX, posY);
        this.use=true;
    }
    abstract void move();
    abstract void meet(Alive alive);
    abstract void fight(Alive alive);
    abstract void Isgood();
}
