package leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	
	int speed;
	
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 8;
	}
	
	void update() {
		if(this.y <= 0) {
			this.isAlive = false;
		}
			this.y -= speed;
			width -= 2;
		width = 10;
	}
	
	void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
	
}
