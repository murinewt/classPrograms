package players;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Playeraverage extends JFrame {
	public Playeraverage() throws IOException{
		PlayerPlus player;
		Scanner keyboard = new Scanner(new File("F:\\Java\\Hankees.txt"));
		for(int num=1; num<=9;num++){
			player = new PlayerPlus (keyboard.nextLine(),keyboard.nextDouble());
			keyboard.nextLine();
			addPlayerInfo(player);
		}
	add(new JLabel());
	add(new JLabel(" ------"));
	add(new JLabel("Team Batting Average:"));
	add(new JLabel(PlayerPlus.findTeamAverageString()));
	setTitle("The Hankees");
	setLayout(new GridLayout(11, 2, 20, 3));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
	keyboard.close();
	}
	void addPlayerInfo(PlayerPlus player){
		add(new JLabel("   "+ player.getname()));
		add(new JLabel(player.getAverageString()));
	}
}
