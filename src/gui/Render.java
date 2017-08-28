package gui;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import game.Player;
import game.Block;

public class Render {
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	Graphics2D graphics;
	
	public Render(Canvas can) {
		canvas = can;
		bufferStrategy = canvas.getBufferStrategy();
	}
	
	public void renderPlayer(Player player) {
		if (player.crouch) {
			render(player.xPos, player.yPos, player.width, player.height /2);
		} else {
			render(player.xPos, player.yPos, player.width, player.height);
		}
	}
	
	public void renderObjects(Block block) {
		render(block.xPos, block.yPos, block.width, block.height);
	}
	
	private void render(int x, int y, int w, int h) {
		updateGraphicsInstance();
		renderBorder();
		graphics.fillRect(x, y, w, h);
		graphics.dispose();
		bufferStrategy.show();
	}
	
	private void updateGraphicsInstance() {
		graphics = (Graphics2D)bufferStrategy.getDrawGraphics();
	}
	
	public void clear() {
		updateGraphicsInstance();
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	private void renderBorder() {
		graphics.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1);
	}
}
