package leagueinvaders;

import java.awt.Graphics;

public class ObjectManager {
	
	RocketShip rS;
	
	ObjectManager(RocketShip rS){
		this.rS = rS;
	}
	
	void update(){
		rS.update();
	}
	
	void draw(Graphics G) {
		rS.draw(G);
	}
	
}
