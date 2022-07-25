
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable, KeyListener {

	Scanner keyboard = new Scanner(System.in);

	private BufferedImage gameOverImage;
	private boolean gameOver = true;

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;

	}

	public boolean isGameOver() {
		return gameOver;
	}

	Torpedo torpedoObject = new Torpedo(this);
	Coin coinObject = new Coin();
	Player playerObject = new Player(this);
	Wall wallObject = new Wall(this);

	Thread toprdoThread;

	public void addNotify() {
		super.addNotify();
		toprdoThread = new Thread(this);
		toprdoThread.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(Color.darkGray);
		torpedoObject.paint(g2); // we called the paint method of our torpedo class

		coinObject.paint(g2);

		wallObject.paint(g2);

		g2.setColor(Color.white);
		Font font = new Font("arial", Font.BOLD, 30);
		g2.setFont(font);
		g2.drawString("Score:", 30, 650);
		g2.drawString("" + playerObject.getScore(), 130, 650);
	

		if (wallObject.collision()) {
			System.out.println("Collided to the wall");
			setGameOver(false);
		}
			

		if (!gameOver) {
			System.out.println("Game Over!");

			g2.drawImage(gameOverImage, 0, 0, null);

		}
	}

	public void Move() {

		playerObject.changeWallPosition();

		playerObject.getCoinPos();

		playerObject.getCoin();

	}

	public Game() {
		try {

			gameOverImage = ImageIO.read(new File("gameOverImage - Copy.png"));

		} catch (Exception e) {

			System.err.println("file not found");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		torpedoObject.setNaser(false);

		torpedoObject.keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		while (gameOver) {
			repaint();
			Move();
			if (wallObject.collision())
				break;
			try {
				if (playerObject.getScore() >= 100)
					Thread.sleep(75);

				else if (playerObject.getScore() >= 50)
					Thread.sleep(100);
				else
					Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
