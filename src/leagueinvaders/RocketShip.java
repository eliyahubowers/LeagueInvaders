package leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	
	int speed;
	int directiony;
	int directionx;
	
	RocketShip(	int x, int y, int width, int height){
		super(x,y,width,height);
		int speed = 5;
		directiony = 0;
		directionx = 0;
	}
	
	void update(){
		if(directionx == 1) {
		    this.x += 5;
		}else if(directionx == 2) {
			this.x -= 5;
		}
		
		if(directiony == 1) {
		    this.y += 5;
		}else if(directiony == 2) {
			this.y -= 5;
		}
	}
	
	void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
}
