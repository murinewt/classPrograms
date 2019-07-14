package tetris;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GameShapeDisplay extends JPanel{
	
	public int currentShape;
	public GamePanel panel;
	public Timer timer;
	public String message;
	
	public GameShapeDisplay(){
		setBackground(new Color(250,250,210));
		setPreferredSize(new Dimension(150,150));
		message = "Nothing yet";
		currentShape = 1;
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				currentShape = panel.myShape;
				repaint();
			}

		};
		timer = new Timer(400,action);
		timer.start();
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(5, 5, 140, 140);
		//g.drawRect(4, 4, 192, 192);
		
		g.setFont(new Font("optima" ,Font.PLAIN , 12));
		if(currentShape == 1){
			g.fillRect( 65 , 65, 20, 20);
		}
		else if(currentShape == 2){
			g.fillRect(70, 55, 10, 40);
		}
		else if(currentShape == 3){
			g.fillRect(65, 60, 10, 30);
			g.fillRect(75, 70, 10, 10);
			
		}
		else if(currentShape == 4){
			g.fillRect(65, 60, 10, 30);
			g.fillRect(75, 80, 10, 10);
			
		}
		else if(currentShape == 5){
			g.fillRect(60, 65, 20, 10);
			g.fillRect(70, 75, 20, 10);
			
		}
		else{
			g.drawString(message, 45, 45);
				
		}
		
	}// end of paintComponent
	

}
