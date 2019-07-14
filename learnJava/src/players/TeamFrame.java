package players;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TeamFrame extends JFrame{
	public TeamFrame() throws IOException{
		Player player;
		Scanner keyboard = new Scanner(new File("F:\\Java\\Hankees.txt"));
		for(int num=1; num<=9;num++){
			player = new Player (keyboard.nextLine(),keyboard.nextDouble());
			keyboard.nextLine();
			addPlayerInfo(player);
		}
	setTitle("The Hankees");
	setLayout(new GridLayout(9, 2, 20, 3));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
	keyboard.close();
	}
	void addPlayerInfo(Player player){
		add(new JLabel("   "+ player.getname()));
		add(new JLabel(player.getAverageString()));
	}

}
