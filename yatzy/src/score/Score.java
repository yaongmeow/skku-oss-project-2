package score;

import dice.Dice;

import java.util.List;

public interface Score {
    public Integer calculatedScore(List<Dice> dices);
}
