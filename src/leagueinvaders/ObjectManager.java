package leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	RocketShip rS;	
	
	long enemySpawnTime = 10; 
	long enemyTimer = 0;
	
	int score = 0;
	
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
	
	void purgeObjects(){
		for(int i = 0; i < aliens.size(); i ++) {
		    if(aliens.get(i).isAlive == false) {
		    	    aliens.remove(i);
		    }
		}
		for(int i = 0; i < projectiles.size(); i ++) {
			if(projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for(Alien a : aliens){
	        if(rS.collisionBox.intersects(a.collisionBox)){
	                rS.isAlive = false;
	                System.out.println("hi");
	        }
	    }
		for(Alien a : aliens) {
			for(Projectile p : projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					this.score++;
					System.out.println("hi");
				}
			}
		}
	}
	
    public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));
                
                enemySpawnTime = new Random().nextInt(2000)+500; 
                enemyTimer = System.currentTimeMillis();
        }
   }
	
	void addAlien(Alien a) {
		aliens.add(a);
	}
	
	int getScore() {
		return this.score;
	}
	
}
