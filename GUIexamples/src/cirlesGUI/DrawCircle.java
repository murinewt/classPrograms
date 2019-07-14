package cirlesGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static CreateCircle [] circle = new CreateCircle[50];
	CreateCircle ci;// = new CreateCircle;
	int xCord, yCord, radii,red,green,blue;
	Random generator = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Circlea");
		DrawCircle drawingArea = new DrawCircle();
		drawingArea.setBackground(Color.white);
		window.setContentPane(drawingArea);
		drawingArea.setPreferredSize(new Dimension(500,500));
		window.pack();
		window.setLocation(500,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		Timer frameTime = new Timer(3000,drawingArea);
		window.setVisible(true);
		frameTime.start();
			
	}
	
	
	
	public void drawFrame(Graphics g,int frameNumber,int width, int height){
		int centerX;
		int centerY;
		int colorChoice;
		int count;
		red = generator.nextInt(256)+1;
		green = generator.nextInt(256)+1;
		blue = generator.nextInt(256)+1;
		for(count=0;count<500;count++){
			colorChoice = (int)(3*Math.random());
			switch(colorChoice){
			case 0:
				g.setColor(Color.red);
				break;
			case 1:
				g.setColor(Color.green);
				break;
			case 2:
				g.setColor(Color.blue);
				break;
			}
			centerX = (int)(width*Math.random());
			centerY = (int)(height*Math.random());
			g.fillOval(centerX-50, centerY-50, 100, 100);
			g.setColor(new Color(red,green,blue));
			g.drawOval(centerX-50, centerY-50, 100, 100);
		}
	}

	private int frameNum = 0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frameNum++;
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		drawFrame(g,frameNum,getWidth(),getHeight());
	}

}
