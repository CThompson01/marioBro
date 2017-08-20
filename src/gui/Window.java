package gui;

import game.Game;
import gui.Render;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JPanel implements KeyListener{
	private final String title = "Mario Bro";
	private final String version = "1.0.2";
	private final Dimension windowSize = new Dimension(290, 290);
	private final int maxWidth = 300;
	private final int maxHeight = 300;
	
	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	
	public Window() {
		frame = new JFrame(title + " v" + version);
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(windowSize);
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0,0,maxWidth,maxHeight);
		canvas.setIgnoreRepaint(true);
		
		panel.add(canvas);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		
		canvas.addKeyListener(this);
		canvas.requestFocus();
		
		Render.setUp(canvas, bufferStrategy);
		Game.setUp(canvas);
		
		Game ex = new Game();
		new Thread(ex).start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key pressed");
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == 39) {
			// Moves right
			Game.keyPressed(e.getKeyCode());
		} if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == 37) {
			// Moves left
			Game.keyPressed(e.getKeyCode());
		} if (e.getKeyCode() == KeyEvent.VK_W) {
			// Jumps
			Game.keyPressed(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == 39) {
			// Stops moving right
			Game.keyReleased(e.getKeyCode());
		} if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == 37) {
			// Stops moving left
			Game.keyReleased(e.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
