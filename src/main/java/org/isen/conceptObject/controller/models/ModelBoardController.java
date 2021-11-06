package org.isen.conceptObject.controller.models;

import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Alive;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.Obstacle;
import org.isen.conceptObject.models.container.Pair;
import org.isen.conceptObject.models.entities.Elve;
import org.isen.conceptObject.models.entities.Goblins;
import org.isen.conceptObject.models.entities.Human;
import org.isen.conceptObject.models.entities.Orc;
import org.isen.conceptObject.models.master.MasterElve;
import org.isen.conceptObject.models.master.MasterGoblins;
import org.isen.conceptObject.models.master.MasterHuman;
import org.isen.conceptObject.models.master.MasterOrc;

import java.util.*;

public class ModelBoardController {


    int numberTurn;

    List<Element> allElements = new ArrayList<>();
    List<Alive> allPawn = new ArrayList<>();


    public int getNumberTurn() {
        return numberTurn;
    }

    public void setNumberTurn(int numberTurn) {
        this.numberTurn = numberTurn;
    }

    public ModelBoardController() {
        this.numberTurn = Constant.NUMBER_TURN;
        this.setAllPawn();
        this.setAllObstacles();
        this.setAllMaster();
        Collections.shuffle(this.allPawn);

    }

    public List<Alive> getAllPawn() {
        return allPawn;
    }

    public void setAllPawn(List<Alive> allPawn) {
        this.allPawn = allPawn;
    }

    public List<Element> getAllElements() {
        return allElements;
    }

    public void setAllElements(List<Element> allElements) {
        this.allElements = allElements;
    }

    private void setAllMaster() {
        allElements.addAll(Arrays.asList(
                MasterOrc.getInstance(),
                MasterHuman.getInstance(),
                MasterElve.getInstance(),
                MasterGoblins.getInstance()
        ));

    }

    protected String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        return generatedString;
    }

    private void setAllPawn() {
        for (int i = 0; i < Constant.NUMBER_PAWN_PER_TEAM; i++) {
            int posY;
            int posX;
            if (i < 3) {
                posX = i;
                posY = Constant.MAP_SIZE_Y - 4;
            } else {
                posX = 3;
                posY = Constant.MAP_SIZE_Y - 7 + i;
            }
            Goblins goblins = new Goblins(posX, posY);
            allPawn.add(goblins);
            allElements.add(goblins);
        }

        for (int i = 0; i < Constant.NUMBER_PAWN_PER_TEAM; i++) {
            int posY;
            int posX;
            if (i < 3) {
                posX = Constant.MAP_SIZE_X - 4;
                posY = i;
            } else {
                posX = Constant.MAP_SIZE_X - 7 + i;
                posY = 3;
            }
            Orc orc = new Orc(posX, posY);
            allPawn.add(orc);
            allElements.add(orc);
        }

        for (int i = 0; i < Constant.NUMBER_PAWN_PER_TEAM; i++) {
            int posY;
            int posX;
            if (i < 3) {
                posX = i;
                posY = 3;
            } else {
                posX = 3;
                posY = i - 3;
            }
            Human human = new Human(posX, posY);
            allPawn.add(human);
            allElements.add(human);
        }

        for (int i = 0; i < Constant.NUMBER_PAWN_PER_TEAM; i++) {
            int posY;
            int posX;
            if (i < 3) {
                posX = Constant.MAP_SIZE_X - 3 + i;
                posY = Constant.MAP_SIZE_Y - 4;
            } else {
                posX = Constant.MAP_SIZE_Y - 4;
                posY = Constant.MAP_SIZE_X - 7 + i;
            }
            Elve elve = new Elve(posX, posY);
            allPawn.add(elve);
            allElements.add(elve);
        }

        for (Alive pawn : allPawn) {
            pawn.addMessages(generateRandomString());
        }

    }

    private void setAllObstacles() {
        Random random = new Random();
        int numberObstacle = random.nextInt(10);

        List<Pair<Integer, Integer>> allPossiblePosition = new ArrayList<>();

        for (var i = 0; i < Constant.MAP_SIZE_X; i++) {
            for (var j = 0; j < Constant.MAP_SIZE_Y; j++) {
                if (!((i < 4 || i > Constant.MAP_SIZE_X - 5) && (j < 4 || j > Constant.MAP_SIZE_Y - 5))) {
                    allPossiblePosition.add(new Pair<>(i, j));
                }
            }
        }


        for (var i = 0; i < numberObstacle; i++) {
            var randPosInList = random.nextInt(allPossiblePosition.size());
            Pair<Integer, Integer> pos = allPossiblePosition.get(randPosInList);
            allPossiblePosition.remove(randPosInList);
            var obstacle = new Obstacle(pos.x, pos.y);
            allElements.add(obstacle);
        }
    }

    public void resetAllPlayedElem() {
        this.numberTurn -= 1;
        for (Alive pawn : allPawn) {
            pawn.setHavePlayed(false);
        }

        Collections.shuffle(this.allPawn);
    }

    public void moveAllElements() {


        for (Alive pawn : allPawn) {
            if (!pawn.isHavePlayed()) {
                if (pawn.getNumbersLives() > 0) {
                    pawn.move(allElements);
                }
            }
        }


        resetAllPlayedElem();
    }

    public void moveOne() {

        for (Alive pawn : allPawn) {
            if (!pawn.isHavePlayed()) {
                if (pawn.getNumbersLives() > 0) {
                    pawn.move(allElements);
                    return;
                }
            }
        }
        resetAllPlayedElem();
        this.moveOne();
    }


}
