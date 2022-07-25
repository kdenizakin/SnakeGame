import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel  {
	
	private JButton start;
	private JButton options;
	private JButton close;
	private  JFrame menuFrame;
//	Main main = new Main();
	
	public Menu() {
		
		menuFrame = new JFrame();
		menuFrame.setTitle("Torpedo Loves Bitcoin Menu");
		menuFrame.setSize(900, 700);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setVisible(true);
		menuFrame.setLayout(null);
		
		
		this.setSize(900, 700);
		this.setBackground(Color.BLACK);
		menuFrame.getContentPane().add(this);
		
		
		start = new JButton("Start");	
		start.setBounds(375, 250, 150, 50);
		start.setBackground(Color.RED);
		start.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	
	    	    menuFrame.dispose();		    	
		    	Main main = new Main();
		    }
		});
				
		this.add(start);
		
		close = new JButton("Back to Windows");	
		close.setBounds(375, 320, 150, 50);
		close.setBackground(Color.RED);
		close.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	
	    	   System.exit(0);		    	
		    	
		    }
		});
		
		this.add(close);
		
		
		}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		Font font = new Font("arial", Font.BOLD, 50);
		g2.setFont(font);
		g2.drawString("Torpedo Loves Bitcoin", 165, 100);
		
	}
		

}
