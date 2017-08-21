package game;

import gui.Render;
import game.Player;

import java.awt.Canvas;
import java.awt.event.KeyEvent;

public class Game implements Runnable {
	
	// Engine Variables
	private Canvas canvas;
	private boolean running = true;
	private Player player1;
	private int ticks;
	private Render render;
	
	// Player Momentum
	static boolean startJump;
	static double playerXMomentum;
	static double playerYMomentum;
	
	public Game(Canvas can) {
		// Allows for access to canvas variables
		canvas = can;
		
		// Creates the player
		player1 = new Player(10, 25);
		player1.coins = 0;
		player1.xPos = 25;
		player1.yPos = canvas.getHeight() - player1.height;
		
		// Sets up misc variables
		startJump = false;
		playerXMomentum = 0;
		playerYMomentum = 0;
		ticks = 0;
		
		render = new Render(canvas);
	}
	
	public void run() {     
		while (running) {
			update();
			render();
			ticks += 1;
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		// Player Momentum
		if (player1.movingRight && playerXMomentum < 5 && ticks % 3 == 0) {
			playerXMomentum += 1;
		} else if (playerXMomentum >= 5) {
			playerXMomentum = 5;
		} if (player1.movingLeft && playerXMomentum > -5 && ticks % 3 == 0) {
			playerXMomentum -= 1;
		} else if (playerXMomentum <= -5) {
			playerXMomentum = -5;
		} 
		
		if (startJump) {
			playerYMomentum = -5;
			player1.inAir = true;
			startJump = false;
		}
		
		// FizX by nuclearpheasant
		if (ticks % 12 == 0) {
			if (playerXMomentum > 0) {
				playerXMomentum -= 1;
			} if (playerXMomentum < 0) {
				playerXMomentum += 1;
			}
		} if (player1.yPos < canvas.getHeight() - player1.height) {
			player1.inAir = true;
			if (ticks % 5 == 0) {
				playerYMomentum += 1;
			}
		} else if (player1.yPos > canvas.getHeight() - player1.height){
			player1.yPos = canvas.getHeight() - player1.height;
			playerYMomentum = 0;
			player1.inAir = false;
		} 
		
		// Moving the Player
		player1.xPos += playerXMomentum;
		player1.yPos += playerYMomentum;
		
		// Check player contact
		if (player1.xPos <= 0) {
			player1.xPos = 0;
		} else if (player1.xPos >= canvas.getWidth() - player1.width) {
			player1.xPos = canvas.getWidth() - player1.width;
		}
	}
	   
	public void render() {
		// Renders the Player
		render.render(player1);
	}

	public void keyPressed(int keycode) {
		if (keycode == KeyEvent.VK_W) {
			// Jump
			if (!player1.inAir) {
				startJump = true;
			}
		} if (keycode == KeyEvent.VK_S) {
			// Duck
		} if (keycode == KeyEvent.VK_D || keycode == 39) {
			// Right
			player1.movingRight = true;
		} if (keycode == KeyEvent.VK_A || keycode == 37) {
			// Left
			player1.movingLeft = true;
		}
	}
	
	public void keyReleased(int keycode) {
		if (keycode == KeyEvent.VK_W) {
			// Jump
		} if (keycode == KeyEvent.VK_S) {
			// Duck
		} if (keycode == KeyEvent.VK_D || keycode == 39) {
			// Right
			player1.movingRight = false;
		} if (keycode == KeyEvent.VK_A || keycode == 37) {
			// Left
			player1.movingLeft = false;
		}
	}
}