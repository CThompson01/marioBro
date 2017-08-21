package gui;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Render {
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	Graphics2D graphics;
	
	public Render(Canvas can) {
		canvas = can;
		bufferStrategy = canvas.getBufferStrategy();
	}
	
	public void render(int x, int y, int w, int h) {
		updateGraphicsInstance();
		clear();
		renderBorder();
		graphics.fillRect(x, y, w, h);
		graphics.dispose();
		bufferStrategy.show();
	}
	
	private void updateGraphicsInstance() {
		graphics = (Graphics2D)bufferStrategy.getDrawGraphics();
	}
	
	private void clear() {
		graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	private void renderBorder() {
		graphics.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1);
	}
}
