package leagueinvaders;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame jf;
	final int h = 800;
	final int w = 500;
	
	LeagueInvaders(){
		jf = new JFrame();
	}
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
	
	void setup() {
		jf.setSize(w, h);
		jf.setVisible(true);
		jf.setTitle("LeagueInvaders");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
