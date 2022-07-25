
import javax.swing.JFrame;

public class Main extends JFrame {

	public Main() {
		Game game = new Game();
		

		setTitle("Torpedo Loves Bitcoin");
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(game);
		add(game);
	}

	public static void main(String[] args) {
//		new Main();
		new Menu();
	}

}
