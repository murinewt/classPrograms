package cirlesGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CreateCircle extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//static CreateCircle [] circle = new CreateCircle[50];
	//CreateCircle ci;// = new CreateCircle;
	int xCord, yCord, radii,red,green,blue;
	Random generator = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Circlea");
		CreateCircle drawingArea = new CreateCircle();
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
		//int colorChoice;
		//int count;
		radii = 100;
		red = generator.nextInt(256)+1;
		green = generator.nextInt(256)+1;
		blue = generator.nextInt(256)+1;
		CreateCircle drawingArea = new CreateCircle();
		Timer frameTime = new Timer(3000,drawingArea);
		for(int x = 0; x<100;x++){
			centerX = (int)(width*Math.random());
			centerY = (int)(height*Math.random());
			//for(int x= 0;x<500;x++){
			//g.fillOval(centerX-50, centerY-50, 100, 100);
			g.setColor(new Color(red,green,blue,200));
			g.fillOval(centerX-50, centerY-50, radii, radii);
			frameTime.start();
			radii++;
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
