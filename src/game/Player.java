package game;

public class Player {
	public int xPos, yPos, width, height, crouchHeight, coins;
	public boolean movingLeft, movingRight, inAir, onGround, crouch;
	
	private Player() {
		movingLeft = false; 
		movingRight = false;
		inAir = false;
		onGround = true;
		crouch = false;
		coins = 0;
	}
	
	public Player(int w, int h) {
		this();
		width = w;
		height = h;
		crouchHeight = height /2;
	}
	
	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
}
