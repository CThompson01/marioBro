package game;

import java.awt.Canvas;

import game.Block;

public class Levels {
	
	public static Block levelOne(Canvas canvas) {
		Block block1 = new Block(25, 25);
		block1.setPosition(50, canvas.getHeight() - 50);
		return block1;
	}

}
