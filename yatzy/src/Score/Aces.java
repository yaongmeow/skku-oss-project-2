package Score;

import Dice.Dice;

import java.util.List;

class Aces implements  Score {
	@Override
	public Integer calculateScore(List<Dice> dices) {
		int score = 0;
		for (Dice dice : dices) {
			int num = dice.getNum();
			if(num == 1) score += num;
		}
		return score;
	}
}