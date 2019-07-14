package game;

import java.awt.Color; // import some standard GUI classes
import java.awt.Graphics;
	
public class SnakeDraw {

	public int length; // The radius of the circle.
	public int x,y; // The location of the center of the circle.
	public Color color; // The color of the circle.
	public boolean xIncreasing=false;
	public boolean yIncreasing=true;

	public SnakeDraw (int centerX, int centerY, int len ) {
		if(centerX>x)
			xIncreasing=true;
		if(centerY>y)
			yIncreasing=true;
		x = centerX;
		y = centerY;
		length = len;
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue, 100);
	}
	/**
	* Draw the disk in graphics context g, with a black outline.
	*/
	public void draw( Graphics g ) {
		//int x=100;
		g.setColor(Color.BLACK);
		if(xIncreasing==true)
			g.drawLine(x, y, x+length, y);
		
	}
	
}

