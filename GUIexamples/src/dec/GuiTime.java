package dec;

import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiTime extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myDate;
	private Date date;
	/*private int hour;
	private int min;
	private int sec;*/
	private Timer timer;
	public  GuiTime(){
		ActionListener action = new ActionListener(){
			//@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt){
				//setBackground(Color.GRAY);
				date = new Date();
				/*hour = date.getHours();
				min = date.getMinutes();
				sec = date.getSeconds();*/
				myDate =" "+ date;//hour + " : "+ min +" : "+ sec;  
				repaint();
			}
		};
		
		timer = new Timer(100, action);
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont( new Font("Arial Black", Font.PLAIN, 28 ));
		g.drawString(myDate,0 ,50);
		
	}
	
	
	public static void main(String [] args){
		JFrame window = new JFrame("CLOCK");
		GuiTime content = new GuiTime();
		window.setContentPane(content);
		window.setSize(400 , 200);
		window.setLocation(200 , 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
	}
	

}
