package gui;

import game.Game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel implements KeyListener {
	private static final long serialVersionUID = -291134177019776571L;
	
	private final String TITLE = "Mario Bro";
	private final String VERSION = "1.1.0";
	
	private final Dimension WINDOW_SIZE = new Dimension(290, 290);
	private final int MAX_WIDTH = 300;
	private final int MAX_HEIGHT = 300;
		
	private Canvas canvas;
	
	public Window() {
		JFrame frame = new JFrame(TITLE + " v" + VERSION);
		frame.setSize(WINDOW_SIZE);
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(WINDOW_SIZE);
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0, 0, MAX_WIDTH, MAX_HEIGHT);
		canvas.setIgnoreRepaint(true);
		
		panel.add(canvas);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		
		canvas.addKeyListener(this);
		canvas.requestFocus();
		
		Game game = new Game(canvas);
		
		new Thread(game).start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
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
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == 39) {
			// Stops moving right
			Game.keyReleased(e.getKeyCode());
		} if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == 37) {
			// Stops moving left
			Game.keyReleased(e.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
