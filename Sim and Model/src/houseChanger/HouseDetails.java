package houseChanger;

import java.awt.Color; // import some standard GUI classes
import java.awt.Graphics;
	
public class HouseDetails {
	
	public int radius; // The radius of the circle.
	public int x,y; // The location of the center of the circle.
	public Color color; // The color of the circle.
	
	public HouseDetails() {
		/*x = centerX;
		y = centerY;
		radius = rad;
		*/
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue, 100);
	}
	public Color randColor(){
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue, 100);
		return color;
	}
	/**
	* Draw the disk in graphics context g, with a black outline.
	*/
	public void draw( Graphics g ) {
		
		//int a = 0;
		int b = 450;
		int rand = (int)(b * Math.random());
		//house
		g.setColor(randColor());
		g.fillRect(rand+200, rand+180, rand+100, rand+120);
		//door
		g.setColor(randColor());
		g.fillRect(rand+240, rand+250, rand+20, rand+50);
		//roof
		g.setColor(randColor());
		int []xstick=new int[3];
		int []ystick=new int[3];
		xstick[0]=rand+200;
		ystick[0]=rand+180;
		xstick[1]=rand+300;
		ystick[1]=rand+180;
		xstick[2]=rand+250;
		ystick[2]=rand+100;
		g.fillPolygon(xstick, ystick, 3);
		//lower window
		g.setColor(randColor());
		g.fillRect(rand+210, rand+250, rand+20, rand+20);
		g.fillRect(rand+270, rand+250, rand+20, rand+20);
		g.setColor(Color.black);
		g.drawLine(rand+220, rand+250, rand+220, rand+269);
		g.drawLine(rand+210, rand+260, rand+229, rand+260);
		g.drawLine(rand+280, rand+250, rand+280, rand+269);
		g.drawLine(rand+270, rand+260, rand+289, rand+260);
		//upper window
		g.setColor(randColor());
		g.fillRect(rand+210, rand+200, rand+20, rand+20);
		g.fillRect(rand+270, rand+200, rand+20, rand+20);
		g.setColor(Color.black);
		g.drawLine(rand+220, rand+200, rand+220, rand+219);
		g.drawLine(rand+210, rand+210, rand+229, rand+210);
		g.drawLine(rand+280, rand+200, rand+280, rand+219);
		g.drawLine(rand+270, rand+210, rand+289, rand+210);
		
		//ring
		g.setColor(randColor());
		g.fillRect(rand+200, rand+234, rand+100, rand+15);
	}
	
}
