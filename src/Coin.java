
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Coin {

	Random rand = new Random();

	private BufferedImage coinImage;
	private int xPos;
	private int yPos;

	public void XYRandom() {

		xPos = rand.nextInt(400);
		yPos = rand.nextInt(400);
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(coinImage, xPos, yPos, null);
	}

	public Rectangle getBounds() { // get bouds method is giving back x and y of coin

		return new Rectangle(xPos, yPos, coinImage.getWidth(), coinImage.getHeight());

	}

	// this method is first getting our xpos and ypos then it saying give me the
	// name of object that you create from buffer image class(coin image)

	public Coin() {
		try {

			coinImage = ImageIO.read(new File("coinImage2.png"));

		} catch (Exception e) {

			System.err.println("file not found");
		}
	}

	public void repaint() {
		// TODO Auto-generated method stub

	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

}