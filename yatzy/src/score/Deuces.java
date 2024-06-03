package score;

import dice.Dice;

import java.util.List;

class Deuces implements Score {
	@Override
	public Integer calculatedScore(List<Dice> dices) {
		int score = 0;
		for (Dice dice : dices) {
			int num = dice.getNum();
			if(num == 2) score += num;
		}
		return score;
	}
}