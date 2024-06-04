package score;

import dice.Dice;

import java.util.List;

public class FourOfKind implements Score {
	@Override
	public Integer calculatedScore(List<Dice> dices) {
		int score = 0;
		int[] count = { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			int num = dices.get(i).getNum();
			score += num;
			count[num - 1]++;
		}
		for (int i = 0; i < 6; i++) {
			if (count[i] >= 4)
				return score;
		}
		return 0;
	}
}
