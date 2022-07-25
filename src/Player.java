
import java.awt.Graphics;

public class Player {

	private Game game;

	private int score = 0;
	Coin coin = new Coin();
	Graphics g;

	private int coinPos = 0; // every time that the game is running(first time) come and read XYRandom
								// function

	private boolean flag = true;
	private int highest;
	private int[] arrayOfScores;
	private int i = 0;
	// **********************************getCoin()********

	public void setScore(int score) {
		this.score = score;
	}

	public void getCoin() {

		if (game.torpedoObject.collision()) {

			game.coinObject.XYRandom();// change x and y of our coin

			score += 10;

			if (score % 20 == 0)
				flag = true;

			game.torpedoObject.setlengthoftorpedo();

		}
	}

	// ******************
	public int getScore() {
		return score;
	}

	public void getCoinPos() {
		if (coinPos == 0) {
			game.coinObject.XYRandom();
			coinPos++; // cause we dont want every time the place of coin be change
		}

	}

	public void changeWallPosition() {
	
		if (getScore() >= 20 && flag) {
			game.wallObject.randomWall();

			flag = false;

		}
		if (game.wallObject.collision2())
			game.wallObject.randomWall();
	}

	public Player(Game game) {
		this.game = game;

	}

	public void highestScore() {
		arrayOfScores = new int[1000];
		
		while(i<1000) {
			if(!game.isGameOver()) {
			arrayOfScores[i]= getScore();
			i++;
			break;
			}
			
		}
	}

}
