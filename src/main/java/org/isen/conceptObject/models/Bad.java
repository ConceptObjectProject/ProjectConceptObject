package org.isen.conceptObject.models;

public abstract class Bad extends Alive {
    protected Bad(int posX, int posY, int numbersLives, int numberMessagesMax, double chanceToWin, String race,int numberMovement) {
        super(posX, posY, numbersLives,numberMessagesMax, chanceToWin, race, false,numberMovement);
    }
}
