package Score;

import Dice.Dice;

public class ScoreBoard {
    int score;
    int[] valDice;

    /* Initial score is zero */
    public ScoreBoard() {
        score = 0;
    }

    public void calculateScore(Dice[] diceArray) {
    }

    public int getScore() {
        return score;
    }
}
