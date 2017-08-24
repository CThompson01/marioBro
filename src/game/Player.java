package game;

public class Player {
	public int xPos, yPos, width, height, coins;
	public boolean movingLeft, movingRight, inAir;
	
	private Player() {
		movingLeft = false; 
		movingRight = false;
		inAir = false;
		coins = 0;
	}
	
	public Player(int w, int h) {
		this();
		width = w;
		height = h;
	}
	
	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
}
