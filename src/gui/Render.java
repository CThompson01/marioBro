package gui;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Render {
	static Canvas canvas;
	static BufferStrategy bufferStrategy;
	
	public Render(Canvas can) {
		canvas = can;
		bufferStrategy = canvas.getBufferStrategy();
	}
	
	public static void render(int x, int y, int w, int h) {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		renderBorder(g);
		render(g, x, y, w, h);
		g.dispose();
		bufferStrategy.show();
	}
	
	protected static void render(Graphics2D g, int xPosition, int yPosition, int width, int height) {
		g.fillRect(xPosition, yPosition, width, height);
	}
	
	protected static void renderBorder(Graphics2D g) {
		g.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1);
	}
}
