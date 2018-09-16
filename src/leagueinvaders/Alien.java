package leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	
	int speed;
	int direction;
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}
		
	void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);       
	}
	
	void update() {
		super.update();
		this.y += speed;
		if(this.direction <= 2) {
		this.direction -= new Random().nextInt(2);
		this.direction += new Random().nextInt(2);
		}
		this.x += direction;
		if(this.y >= 800 ) {
			this.isAlive = false;
		}
		if(this.x < 0 || this.x > 500-width) {
			this.direction = direction*-1;
		}
	}
	
}
