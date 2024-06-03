package score;

import dice.Dice;

import java.util.List;

public class Yacht implements Score {
    @Override
    public Integer calculatedScore(List<Dice> dices) {
        int num = dices.get(0).getNum();
        for (int i = 1; i < 5; i++) {
            if (dices.get(i).getNum() != num) {
                return 0;
            }
        }
        return 50;
    }
}