package leagueinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer t;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	
	Font instructFont;
	Font titleFont;
	Font deathFont;
	Font restartFont;
		
	RocketShip rs;
	ObjectManager om;
	
	GamePanel(){
		rs = new RocketShip(250,700,50,50);
		om = new ObjectManager(rs);
		t = new Timer(1000/60,this);
		titleFont = new Font("Arial",Font.PLAIN,53);
		instructFont = new Font("Arial",Font.PLAIN,25);
		deathFont = new Font("Arial",Font.PLAIN,53);
		restartFont = new Font("Arial",Font.BOLD,25);
	}
	
	void startGame() {
		t.start();
	}
	
	void updateMenuState(){
				
	}	
	void updateGameState(){
		om.update();	
	}
	void updateEndState(){
				
	}	
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);	
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 0, 200);
		g.setFont(instructFont);
		g.drawString("Press ENTER to start", 120, 400);
		g.drawString("Press SPACE for instructions", 80, 500);
	}	
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);	
		g.fillRect(0, 0, 500, 800);	
		om.draw(g);
		om.update();
	}	
	void drawEndState(Graphics g){
		g.setColor(Color.RED);	
		g.fillRect(0, 0, 500, 800);	
		g.setColor(Color.BLACK);
		g.setFont(deathFont);
		g.drawString("GAME OVER", 80, 200);
		g.setFont(restartFont);
		g.drawString("You killed " + 1 + " enemies", 125, 400);
		g.drawString("press ENTER to restart", 120, 500);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE){
            updateMenuState();
        }else if(currentState == GAME_STATE){
            updateGameState();
        }else if(currentState == END_STATE){
            updateEndState();
        }
	}
	
    @Override
     public void paintComponent(Graphics g){
    	    if(currentState == MENU_STATE){
            drawMenuState(g);
        }else if(currentState == GAME_STATE){
            drawGameState(g);
        }else if(currentState == END_STATE){
            drawEndState(g);
        }
     }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("I");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			rs.directiony = 2;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			rs.directiony = 1;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			rs.directionx = 2;
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			rs.directionx = 1;
		}
		
		rs.update();
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {

	    if(currentState == MENU_STATE){
	      	currentState = GAME_STATE;
	      	
        }else if(currentState == GAME_STATE){
        	   currentState = END_STATE;
        }else if(currentState == END_STATE){
            currentState = MENU_STATE;
        }
	    
		}
	    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("end");
		rs.directionx = 0;
		rs.directiony = 0;
	}
}
