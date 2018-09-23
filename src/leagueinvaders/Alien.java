package leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	
	int speed;
	double direction;
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}
		
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);     
	}
	
	void update() {
		super.update();
		this.y += speed;
		this.direction -= new Random().nextInt(2);
		this.direction += new Random().nextInt(2);
		this.x += direction;
		if(this.y >= 800 ) {
			this.isAlive = false;
		}
		if(this.x < 0) {
			this.direction = direction*-.1;
		}else if(this.x > 500-width) {
			this.direction = direction*-.1;
		}
	}
	
}
