package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainClass {
	/*##############Purpose############
	 * used to output the game into a window
	 * #############Description##########
	 * creates a frame with settings and adds the game class to it
	 */
	


	public MainClass() {

	}
	public static void main(String[] args) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenW = screensize.getWidth();
		double screenH = screensize.getHeight();
		System.out.println(screenW);
		System.out.println(screenH);
		JFrame frame = new JFrame("Game");
		frame.pack();
		frame.setSize(850,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game());
		frame.setVisible(true);

	}

}
