
import java.awt.Color;

import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wall {

	private int x = -200;
	private int y = 0;
	private int avoidCollision1 = 0;
	private int avoidCollision2 = 0;

//x and y are coordinates of randomly generated walls.

	Random randomInt = new Random();

	Random randomBoo1 = new Random();
	Random randomBoo2 = new Random();

	private Game game;

	Rectangle rectangleWall = new Rectangle(this.x, this.y, 60, 60);
	private BufferedImage wallImage;
	private BufferedImage wallImage2;
	private BufferedImage wallImage3;
	private BufferedImage wallImage4;
	private BufferedImage wallImage5;
	private BufferedImage wallImage6;

	public Wall(Game game) {
		this.game = game;
		try {

			wallImage = ImageIO.read(new File("wallImagem.png"));
			wallImage2 = ImageIO.read(new File("wallImagem2.png"));
			wallImage3 = ImageIO.read(new File("wallImagem3.png"));
			wallImage4 = ImageIO.read(new File("wallImagem4.png"));
			wallImage5 = ImageIO.read(new File("wallImagem5.png"));
			wallImage6 = ImageIO.read(new File("wallImagem6.png"));

		} catch (Exception e) {

			System.err.println("file wall not found");
		}
	}

	public void randomWall() {

		// Sizes of the wall determined by coins which have been eaten by snake.

		if (game.playerObject.getScore() >= 100) {
			avoidCollision1 = randomInt.nextInt(110) + 100;
			avoidCollision2 = randomInt.nextInt(110) + 100;

		} else if (game.playerObject.getScore() >= 80) {
			avoidCollision1 = randomInt.nextInt(90) + 80;
			avoidCollision2 = randomInt.nextInt(90) + 80;
		} else {
			avoidCollision1 = randomInt.nextInt(60) + 50;
			avoidCollision2 = randomInt.nextInt(60) + 50;
		}

		if (randomBoo1.nextBoolean()) {
			this.x = game.torpedoObject.torpedoXLength[0] - avoidCollision1;
			this.y = game.torpedoObject.torpedoYLength[0] + avoidCollision2;

		} else if (randomBoo2.nextBoolean()) {
			this.x = game.torpedoObject.torpedoXLength[0] + avoidCollision1;
			this.y = game.torpedoObject.torpedoYLength[0] - avoidCollision2;

		}

		else {
			this.x = game.torpedoObject.torpedoXLength[0] - avoidCollision1;
			this.y = game.torpedoObject.torpedoYLength[0] - avoidCollision2;

		}
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (game.playerObject.getScore() >= 180)
			g2.drawImage(wallImage6, this.x, this.y, null);

		else if (game.playerObject.getScore() >= 150)
			g2.drawImage(wallImage5, this.x, this.y, null);

		else if (game.playerObject.getScore() >= 120)
			g2.drawImage(wallImage4, this.x, this.y, null);

		else if (game.playerObject.getScore() >= 100)
			g2.drawImage(wallImage3, this.x, this.y, null);

		else if (game.playerObject.getScore() >= 80)
			g2.drawImage(wallImage2, this.x, this.y, null);

		else
			g2.drawImage(wallImage, this.x, this.y, null);

	}

	public Rectangle getBounds() {

		if (game.playerObject.getScore() >= 180)
			return new Rectangle(this.x, this.y, 180 - 3, 180 - 3);

		else if (game.playerObject.getScore() >= 150)
			return new Rectangle(this.x, this.y, 150 - 3, 150 - 3);

		else if (game.playerObject.getScore() >= 120)
			return new Rectangle(this.x, this.y, 120 - 3, 120 - 3);

		else if (game.playerObject.getScore() >= 100)
			return new Rectangle(this.x, this.y, 100 - 3, 100 - 3);

		else if (game.playerObject.getScore() >= 80)
			return new Rectangle(this.x, this.y, 80 - 3, 80 - 3);

		else
			return new Rectangle(this.x, this.y, 50 - 3, 50 - 3);

	}

	public boolean collision() {

		if (game.playerObject.getScore() >= 20) {

			return game.torpedoObject.getBounds().intersects(getBounds());
		}
		return false;

	}

	public boolean collision2() {

		return game.coinObject.getBounds().intersects(getBounds());

	}

}