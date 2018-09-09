package leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	
	int speed;
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}
		
	void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);       
	}
	
	void update() {
		this.y += speed;
		if(this.y >= 800 ) {
			this.isAlive = false;
		}
	}
	
}
