package org.isen.conceptObject.models;

public abstract class Good extends Alive {
    protected Good(int posX, int posY, int numbersLives, int numberMessagesMax, double chanceToWin, String race,int numberMovement) {
        super(posX, posY, numbersLives,numberMessagesMax, chanceToWin, race, true,numberMovement);
    }
}
