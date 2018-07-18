package leagueinvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame jf;
	
	GamePanel gp;
	
	final int h = 800;
	final int w = 500;
	
	LeagueInvaders(){
		jf = new JFrame();
		gp = new GamePanel();
	}
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
	
	void setup() {
		jf.add(gp);
		jf.addKeyListener(gp);
		jf.setSize(w, h);
		jf.setVisible(true);
		jf.setTitle("LeagueInvaders");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setPreferredSize(new Dimension(w, h));
        jf.pack();
        gp.startGame();
	}
}
