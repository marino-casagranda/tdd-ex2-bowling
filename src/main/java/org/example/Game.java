package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameScore=0;
    private int rollIndex = 0;
    private List<Integer> rolls = new ArrayList<>();

    public Game() {
    }

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        //Frame = Lancé 1 + Lancé 2
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) { // Strike
                gameScore += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) { // Spare
                gameScore += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                gameScore += sumOfRollsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
        return gameScore;
    }

    private boolean isStrike(int currentRoll) {
        return rolls.get(currentRoll) == 10;
    }

    private boolean isSpare(int currentRoll) {
        return rolls.get(currentRoll) + rolls.get(currentRoll + 1) == 10;
    }

    private int strikeBonus(int currentRoll) {
        return rolls.get(currentRoll + 1) + rolls.get(currentRoll + 2);
    }

    private int spareBonus(int currentRoll) {
        return rolls.get(currentRoll + 2);
    }

    private int sumOfRollsInFrame(int currentRoll) {
        return rolls.get(currentRoll) + rolls.get(currentRoll + 1);
    }
}
