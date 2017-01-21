package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainClass {



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
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game());
		frame.setVisible(true);

	}

}
