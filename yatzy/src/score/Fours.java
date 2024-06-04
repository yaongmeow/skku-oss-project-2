package score;

import dice.Dice;

import java.util.List;

public class Fours implements Score {
	@Override
	public Integer calculatedScore(List<Dice> dices) {
		int score = 0;
		for (Dice dice : dices) {
			int num = dice.getNum();
			if(num == 4) score += num;
		}
		return score;
	}

}
