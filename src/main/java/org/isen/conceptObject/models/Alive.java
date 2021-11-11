package org.isen.conceptObject.models;

import org.isen.conceptObject.misc.Utils;
import org.isen.conceptObject.models.container.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Alive extends Element {

    protected int numbersLives;
    protected List<String> allMessages = new ArrayList<>();
    protected int numberMessagesMax;
    protected double chanceToWin;
    protected boolean goodOrBad;
    protected boolean inAlliance;
    protected boolean havePlayed;
    protected int numberMovement;
    protected String race;


    protected abstract Boolean isCaseFree(Pair<Integer, Integer> pos, List<Element> allElements);

    protected abstract Boolean isMasterMeet(Pair<Integer, Integer> pos, Alive elem);


    public void move(List<Element> allElements) {
        this.havePlayed = true;
        for (int i = 0; i < this.numberMovement; i++) {
            Pair<Integer, Integer>[] allAimedPos = new Pair[4];
            allAimedPos[0] = new Pair<>(this.getPosX(), this.getPosY() - 1);
            allAimedPos[1] = new Pair<>(this.getPosX() - 1, this.getPosY());
            allAimedPos[2] = new Pair<>(this.getPosX() + 1, this.getPosY());
            allAimedPos[3] = new Pair<>(this.getPosX(), this.getPosY() + 1);

            List<Pair<Integer, Integer>> allPossiblePositions = new ArrayList<>();

            for (Pair<Integer, Integer> pos : allAimedPos) {
                if (this.isCaseFree(pos, allElements)) {
                    allPossiblePositions.add(pos);
                }
            }

            if (!allPossiblePositions.isEmpty()) {
                Pair<Integer, Integer> newPosition = allPossiblePositions.get(Utils.random.nextInt(allPossiblePositions.size()));
                this.setPosX(newPosition.x);
                this.setPosY(newPosition.y);
            }
        }


        this.meet(allElements);


    }


    public void meet(List<Element> allElements) {
        Pair<Integer, Integer>[] allAimedPos = new Pair[4];
        allAimedPos[0] = new Pair<>(this.getPosX(), this.getPosY() - 1);
        allAimedPos[1] = new Pair<>(this.getPosX() - 1, this.getPosY());
        allAimedPos[2] = new Pair<>(this.getPosX() + 1, this.getPosY());
        allAimedPos[3] = new Pair<>(this.getPosX(), this.getPosY() + 1);


        for (Pair<Integer, Integer> pos : allAimedPos) {
            for (Element element : allElements) {
                if (Alive.class.isAssignableFrom(element.getClass()) && ((Alive) element).getNumbersLives() > 0) {

                    if (element.getPosX() == pos.x && element.getPosY() == pos.y) {
                        if (this.isMasterMeet(pos, (Alive) element)) {
                            giveToYourMaster((Alive) element, this);
                        } else if (this.isGoodOrBad()) {
                            if (Good.class.isAssignableFrom(element.getClass())) {
                                this.ally(this, (Alive) element);
                            } else {
                                this.fight(this, (Alive) element);
                            }
                        } else {
                            if (Bad.class.isAssignableFrom(element.getClass())) {
                                this.ally(this, (Alive) element);
                            } else {
                                this.fight(this, (Alive) element);
                            }
                        }
                    }


                }
            }
        }
    }

    public void fight(Alive alive1, Alive alive2) {
        double maxAliveFirst = alive1.getChanceToWin();
        double maxAliveSecond = alive2.getChanceToWin();

        double whichOneWon = Utils.random.nextDouble() * (maxAliveSecond + maxAliveFirst);


        if (whichOneWon <= maxAliveFirst) {

            for (String msg : alive2.getAllMessages()) {
                alive1.addMessages(msg);
            }
            alive2.getAllMessages().clear();
            alive2.setNumbersLives(alive2.getNumbersLives() - 1);

            String messages = Utils.generateRandomString();
            alive2.addMessages(messages);
        } else {
            for (String msg : alive1.getAllMessages()) {
                alive2.addMessages(msg);
            }
            alive1.getAllMessages().clear();
            alive1.setNumbersLives(alive1.getNumbersLives() - 1);

            String messages = Utils.generateRandomString();
            alive1.addMessages(messages);


        }


    }

    public void ally(Alive alive1, Alive alive2) {

        for (String msg : alive1.getAllMessages()) {
            alive2.addMessages(msg);
        }

        for (String msg : alive2.getAllMessages()) {
            alive1.addMessages(msg);
        }
    }


    public Boolean isMessageOwn(String message) {
        return this.getAllMessages().contains(message);
    }

    public void giveToYourMaster(Alive master, Alive alive2) {
        for (String msg : alive2.getAllMessages()) {
            master.addMessages(msg);
        }
        alive2.getAllMessages().clear();

    }

    private Alive(int posX, int posY) {
        super(posX, posY, true);
    }

    protected Alive(int posX, int posY, int numbersLives, int numberMessagesMax, double chanceToWin, String race, Boolean goodOrBad, int numberMovement) {
        super(posX, posY, true);
        this.havePlayed = false;
        this.isAlive = true;
        this.numbersLives = numbersLives;
        this.numberMessagesMax = numberMessagesMax;
        this.chanceToWin = chanceToWin;
        this.race = race;
        this.goodOrBad = goodOrBad;
        this.numberMovement = numberMovement;
    }

    public int getNumbersLives() {
        return numbersLives;
    }

    public void setNumbersLives(int numbersLives) {
        this.numbersLives = numbersLives;
    }

    public List<String> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(List<String> allMessages) {
        this.allMessages = allMessages;
    }

    public boolean isHavePlayed() {
        return havePlayed;
    }

    public void setHavePlayed(boolean havePlayed) {
        this.havePlayed = havePlayed;
    }

    public int getNumberMessagesMax() {
        return numberMessagesMax;
    }

    public void setNumberMessagesMax(int numberMessagesMax) {
        this.numberMessagesMax = numberMessagesMax;
    }

    public double getChanceToWin() {
        return chanceToWin;
    }

    public void setChanceToWin(double chanceToWin) {
        this.chanceToWin = chanceToWin;
    }

    public boolean isGoodOrBad() {
        return goodOrBad;
    }

    public void setGoodOrBad(boolean goodOrBad) {
        this.goodOrBad = goodOrBad;
    }

    public boolean isInAlliance() {
        return inAlliance;
    }

    public void setInAlliance(boolean inAlliance) {
        this.inAlliance = inAlliance;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }


    public void addMessages(String message) {
        if (!this.isMessageOwn(message) && this.getAllMessages().size() < this.numberMessagesMax) {
            this.getAllMessages().add(message);
        }
    }

}
