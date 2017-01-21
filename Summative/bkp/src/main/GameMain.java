package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;


public class GameMain extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static int width = 600;
	public static int height = width/12*9;
	public static int scale = 2;
	public String title = "Game";
	
	public GameMain() {
		
	}

	public static void main (String args[]){
		GameMain game = new GameMain();
		game.setPreferredSize(new Dimension(width*scale, height*scale));
		game.setMaximumSize(new Dimension(width*scale, height*scale));
		game.setMinimumSize(new Dimension(width*scale, height*scale));
		
		JFrame frame = new JFrame(game.title);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}

	private boolean running = false;
	private Thread thread;
	public void run() {
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		while (running){
			
			
			
			
		}
		stop();
	}
	
	private synchronized void start(){
		if (running)
			return;
		running = true;
		thread = new Thread (this);
		thread.start();
	}
	private synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
}
