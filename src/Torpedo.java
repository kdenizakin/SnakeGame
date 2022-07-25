
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Torpedo implements KeyListener, Runnable {

	private Game game;// to get access to other class object through game class
	private int r;

	BufferedImage torpedoImage;
	BufferedImage torpedoImage2;

	private boolean naser = true;

	public boolean isNaser() {
		return naser;
	}

	public void setNaser(boolean naser) {
		this.naser = naser;
	}

	int[] torpedoXLength = new int[750];
	int[] torpedoYLength = new int[750];
	private int lengthoftorpedo = 2; // begining value of torpedo when game is starting

	public void setlengthoftorpedo() {
		// to accsess this variable from other i create a setter here for this var
		lengthoftorpedo++;
	}

	private int location = 0;// for moving torpedo on screen

	private boolean up = false;
	private boolean down = false;
	private boolean right = true;
	private boolean left = false;

	// ***************************************************************Rectangle()*****************************

	public boolean collision() {
		
		

		return game.coinObject.getBounds().intersects(getBounds());
	}

	
	public Rectangle getBounds() { // get bouds method is giving back x and y of coin

		return new Rectangle(torpedoXLength[0], torpedoYLength[0], torpedoImage.getWidth(), torpedoImage.getHeight());

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (location == 0) {
			torpedoXLength[0] = 200; // coordinate of torpedo when game is starting
			torpedoYLength[0] = 100;
			location++;// for just once this command(loop) to be run
		}

		if (right == true && naser) {

			for (int r = lengthoftorpedo - 1; r >= 0; r--)
				
			{

				torpedoYLength[r + 1] = torpedoYLength[r];
			}
			for (int r = lengthoftorpedo; r >= 0; r--)
				
			{

				if (r == 0) {
					torpedoXLength[r] = torpedoXLength[r] + 45;
				} else {
					torpedoXLength[r] = torpedoXLength[r - 1];
				}
				if (torpedoXLength[r] > 850) {
					game.setGameOver(false);
				}
			}
		}

		for (int i = 0; i < lengthoftorpedo; i++) {

			if (right && naser) {

				if (i == 0)
					g2.drawImage(torpedoImage, torpedoXLength[i], torpedoYLength[i], null);

				else {
					g2.drawImage(torpedoImage2, torpedoXLength[i], torpedoYLength[i], null);
				}
			}
		}

		if (right && !naser) {

			for (int r = lengthoftorpedo - 1; r >= 0; r--) {

				torpedoYLength[r + 1] = torpedoYLength[r];
			}
			for (int r = lengthoftorpedo; r >= 0; r--) {

				if (r == 0) {
					torpedoXLength[r] = torpedoXLength[r] + 45;
				}

				else {
					torpedoXLength[r] = torpedoXLength[r - 1];
				}
				if (torpedoXLength[r] > 870) {
//					torpedoXLength[r] = 25;
					game.setGameOver(false);
				}
			}

		}

		if (left && !naser) {

			for (int r = lengthoftorpedo - 1; r >= 0; r--) {

				torpedoYLength[r + 1] = torpedoYLength[r];
			}
			for (int r = lengthoftorpedo; r >= 0; r--) {

				if (r == 0) {
					torpedoXLength[r] = torpedoXLength[r] - 45;
				}

				else {
					torpedoXLength[r] = torpedoXLength[r - 1];
				}
				if (torpedoXLength[r] < -30) {
//					torpedoXLength[r] = 850;
					game.setGameOver(false);

				}
			}

		}

		if (down && !naser) {

			for (int r = lengthoftorpedo - 1; r >= 0; r--) {

				torpedoXLength[r + 1] = torpedoXLength[r];
			}
			for (int r = lengthoftorpedo; r >= 0; r--) {

				if (r == 0) {
					torpedoYLength[r] = torpedoYLength[r] + 45;
				}

				else {
					torpedoYLength[r] = torpedoYLength[r - 1];
				}
				if (torpedoYLength[r] > 600) {
//					torpedoYLength[r] = 75;
					game.setGameOver(false);

				}
			}

		}

		if (up && !naser) {
			for (int r = lengthoftorpedo - 1; r >= 0; r--) {

				torpedoXLength[r + 1] = torpedoXLength[r];
			}
			for (int r = lengthoftorpedo; r >= 0; r--) {

				if (r == 0) {
					torpedoYLength[r] = torpedoYLength[r] - 45;
				}

				else {
					torpedoYLength[r] = torpedoYLength[r - 1];
				}
				if (torpedoYLength[r] < -20) {
					// torpedoYLength[r] = 625;
					game.setGameOver(false);

				}

			}

		}

		for (int i = 0; i < lengthoftorpedo; i++) {

			if (i == 0 && right && !naser) {

				

				g2.drawImage(torpedoImage, torpedoXLength[i], torpedoYLength[i], null);
			}

			if (i == 0 && left && !naser) {

				
				g2.drawImage(torpedoImage, torpedoXLength[i], torpedoYLength[i], null);

			}

			if (i == 0 && up && !naser) {

				
				g2.drawImage(torpedoImage, torpedoXLength[i], torpedoYLength[i], null);

			}

			if (i == 0 && down && !naser) {

				
				g2.drawImage(torpedoImage, torpedoXLength[i], torpedoYLength[i], null);

			}

			if (i != 0 && !naser) {

				g2.drawImage(torpedoImage2, torpedoXLength[i], torpedoYLength[i], null);

			}
		}
		for (int j = 1; j < lengthoftorpedo; j++) {

			if (torpedoXLength[j] == torpedoXLength[0] && torpedoYLength[j] == torpedoYLength[0]) {

				game.setGameOver(false);
			}

		}

	}

	public int getLengthoftorpedo() {
		return lengthoftorpedo;
	}

	public Torpedo(Game game) {
		this.game = game;

		try {

			torpedoImage = ImageIO.read(new File("torpedoImageM.png"));
			torpedoImage2 = ImageIO.read(new File("torpedoImage2.png"));

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
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
			down = false;
			up = false;
			right = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && !right) {
			down = false;
			up = false;
			left = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && !up) {
			down = true;
			right = false;
			left = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_UP && !down) {
			up = true;
			right = false;
			left = false;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void repaint() {
		// TODO Auto-generated method stub

	}

}