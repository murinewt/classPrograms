package cirlesGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppearingCircles extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CircleDetails[] circleData; // holds the data for all 100 circles
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Circlea");
		AppearingCircles drawingArea = new AppearingCircles();
		drawingArea.setBackground(Color.white);
		window.setContentPane(drawingArea);
		drawingArea.setPreferredSize(new Dimension(500,500));
		window.pack();
		window.setLocation(500,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		Timer frameTime = new Timer(1,drawingArea);
		window.setVisible(true);
		frameTime.start();
		

	}
	
	public void drawFrame(Graphics g,int frameNumber,int width, int height){
		if(circleData==null){
			circleData = new CircleDetails[50]; // create the array
			for (int i = 0; i < circleData.length; i++) { // create the objects
				circleData[i] = new CircleDetails(
				(int)(width*Math.random()),
				(int)(height*Math.random()),
				5 );
			}
		}
		for(int i=0;i<circleData.length;i++){
			circleData[i].radius++;
			circleData[i].draw(g);
			if(Math.random()<0.01||circleData[i].radius>150){
				circleData[i]=new CircleDetails(
						(int)(width*Math.random()),
						(int)(height*Math.random()),
						6 );
			
		}
		}
		g.setColor(Color.black);
		g.drawRect(0,0, width-1, height-1);
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
