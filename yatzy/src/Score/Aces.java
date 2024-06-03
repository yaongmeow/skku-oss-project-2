package Score;

/*2020314193 Hwang Su Yeong*/
class Aces extends ScoreBoard {
	@Override
	public void calculateScore(Dice[] diceArray) {
		/* Calculate the score by scoreboard */
		score = 0;
		for (int i = 0; i < 5; i++) {
			int num = diceArray[i].getNum();
			if (num == 1) {
				score += num;
			}
		}
	}
}