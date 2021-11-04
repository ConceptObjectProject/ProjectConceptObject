package org.isen.conceptObject.models;

public class Obstacle extends Element{

    public Obstacle(int posX, int posY) {
        super(posX, posY);
        this.statut=true;
        this.isAlive= false;
    }
}
