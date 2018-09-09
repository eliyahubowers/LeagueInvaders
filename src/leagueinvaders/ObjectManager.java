package leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	RocketShip rS;	
	
	ObjectManager(RocketShip rS){
		this.rS = rS;
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
	}
	
	void update(){
		rS.update();
		for(Projectile p : projectiles) {
			p.update();
		}
		for(Alien a : aliens) {
			a.update();
		}
	}
	
	void draw(Graphics G) {
		rS.draw(G);
		for(Projectile p : projectiles) {
			p.draw(G);
		}
		for(Alien a : aliens) {
			a.draw(G);
		}
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);	
	}
	
    public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));
                
                enemySpawnTime = new Random().nextInt(2000); 
                enemyTimer = System.currentTimeMillis();
        }
   }
	
	void addAlien(Alien a) {
		aliens.add(a);
	}
	
}
