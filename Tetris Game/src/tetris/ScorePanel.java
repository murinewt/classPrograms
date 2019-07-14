package tetris;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	
	public String score;
	public Timer timer;
	GamePanel panel;
	
	public ScorePanel(){
		
		setBackground(new Color(250,250,210));
		setPreferredSize(new Dimension(150,50));
		score = "Your Score :  0" ;
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				score = "Your Score : " + panel.score;
				repaint();
			}

		};
		
		timer = new Timer(300, action);
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(5,5, 140 , 40);
		
		g.setFont(new Font("optima" ,Font.PLAIN , 15));
		g.drawString(score,45 ,25);
		
	}

}
