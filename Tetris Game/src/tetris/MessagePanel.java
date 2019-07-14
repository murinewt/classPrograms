package tetris;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MessagePanel extends JPanel {
	
	public String message;
	public JTextArea textArea;
	public Timer timer;
	public GamePanel panel;
	
	
	public MessagePanel(){
		setLayout(null);
		setBackground(Color.WHITE);
		setForeground(Color.blue);
		
		textArea = new JTextArea(30 , 8);
		textArea.setBounds(5,5,300,50);
		textArea.setBorder(BorderFactory.createBevelBorder(3,Color.BLACK , Color.GRAY));
		textArea.setFont(new Font("optima" ,Font.ITALIC , 15));
		this.add(textArea);
		
		message = "";
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				message = panel.message + "\n  @Michael Kuria2017";
				textArea.setText(message);
				repaint();
			}

		};
		
		timer = new Timer(300, action);
		timer.start();	
	}// end of constructor
	
	public  void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}

}
