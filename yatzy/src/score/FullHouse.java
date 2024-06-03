package score;

import dice.Dice;

import java.util.Arrays;
import java.util.List;

public class FullHouse implements Score {
	@Override
	public Integer calculatedScore(List<Dice> dices) {
		int[] valueDice = new int[5];
		for (int i = 0; i < 5; i++) {
			valueDice[i] = dices.get(i).getNum();
		}
		Arrays.sort(valueDice);
		if ((valueDice[0] == valueDice[1] && valueDice[2] == valueDice[3] && valueDice[3] == valueDice[4])
				|| (valueDice[0] == valueDice[1] && valueDice[1] == valueDice[2] && valueDice[3] == valueDice[4])) {
			return 25;
		}
		return 0;
	}
}