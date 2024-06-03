package score;

import dice.Dice;

import java.util.List;

public class SmallStraight implements Score {
    @Override
    public Integer calculatedScore(List<Dice> dices) {
        int[] count = { 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < 5; i++) {
            int num = dices.get(i).getNum();
            count[num - 1]++;
        }
        for (int i = 0; i < 3; i++) {
            if (count[i] >= 1 && count[i + 1] >= 1 && count[i + 2] >= 1 && count[i + 3] >= 1) {
                return 30;
            }
        }
        return 0;
    }
}