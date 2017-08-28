package game;

public class Block {
	public int xPos, yPos, width, height;
	
	public Block(int w, int h) {
		width = w;
		height = h;
	}
	
	public void setPosition (int x, int y) {
		xPos = x;
		yPos = y;
	}
}
