package leagueinvaders;

import java.awt.Graphics;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	
	GameObject(	int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		y += 20;
		if(y >= 800) {
			y = -(this.height);
			x += 3;
		}
	}
	
	void draw(Graphics g){
		g.fillRect(x,y,100,100);
	}
	
}
