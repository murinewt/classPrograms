package houseChanger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class House extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Color color;
	int a = 100;
	int b = 250;
	int randLeng = a+(int)((b-a) * Math.random());
	int randWidth = a+(int)((b-a) * Math.random());
	int sizeLeng = a+(int)((b-a) * Math.random());
	int sizeWidth = a+(int)((b-a) * Math.random());
	Color house = randColor();
	Color roof = randColor();
	Color door = randColor();
	Color window = randColor();
	Color ring = randColor();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("House");
		House drawingArea = new House();
		drawingArea.setBackground(Color.black);
		window.setVisible(true);
		window.setPreferredSize(new Dimension(1000,650));
		window.add(drawingArea);
		window.pack();
		window.setLocation(50,50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		
	}
	
	public Color randColor(){
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue);
		return color;
	}
	
	public void drawFrame(Graphics g){
		
		
		
		
		//System.out.println(randLeng + " " + randWidth);
		//house
		
		g.setColor(house);
		g.fillRect( randLeng,  randWidth,  sizeLeng,  sizeWidth);
		System.out.println("Starting point = ("+randLeng+", "+randWidth+")");
		System.out.println("Length of House = "+sizeLeng + " and width = " + sizeWidth);
		System.out.println("Color of House = "+house);
		
		//door
		
		g.setColor(door);
		int length = sizeLeng;
		int width = sizeWidth;
		System.out.println("Size of door = "+length/5 + " and width = " + 5*width/12);
		g.fillRect( 2*length/5+randLeng,  7*width/12+randWidth ,  length/5,  5*width/12);
		System.out.println("Color of door = "+door);
		
		//roof
		
		g.setColor(roof);
		int []xstick=new int[3];
		int []ystick=new int[3];
		xstick[0]= randLeng ;
		ystick[0]= randWidth ;
		xstick[1]= randLeng+length;
		ystick[1]= randWidth;
		xstick[2]= randLeng+length/2;
		ystick[2]= randWidth-sizeWidth/2;
		g.fillPolygon(xstick, ystick, 3);
		System.out.println("Color of roof = "+roof);
		
		//lower window
		
		g.setColor(window);
		System.out.println("Size of Window = "+sizeLeng/5 + " and width = " + sizeLeng/5);
		g.fillRect( randLeng +(int)(0.1*length), 7*width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		g.fillRect( randLeng +(int)(0.7*length), 7*width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		g.setColor(Color.black);
		g.drawLine( randLeng +(int)(0.1*length)+(sizeLeng/5)/2,  7*width/12+randWidth, randLeng +(int)(0.1*length)+(sizeLeng/5)/2, 7*width/12+randWidth+sizeWidth/5);
		g.drawLine( randLeng +(int)(0.1*length),  7*width/12+randWidth+(sizeWidth/5)/2,  randLeng +(int)(0.1*length)+sizeLeng/5,   7*width/12+randWidth+(sizeWidth/5)/2);
		g.drawLine( randLeng +(int)(0.7*length)+(sizeLeng/5)/2,    7*width/12+randWidth,  randLeng +(int)(0.7*length)+(sizeLeng/5)/2, 7*width/12+randWidth+sizeWidth/5);
		g.drawLine(  randLeng +(int)(0.7*length),  7*width/12+randWidth+(sizeWidth/5)/2,  randLeng +(int)(0.7*length)+sizeLeng/5,  7*width/12+randWidth+(sizeWidth/5)/2);
		
		//upper window
		g.setColor(window);
		g.fillRect( randLeng +(int)(0.1*length), width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		g.fillRect( randLeng +(int)(0.7*length), width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		g.setColor(Color.black);
		g.drawLine( randLeng +(int)(0.1*length)+(sizeLeng/5)/2,  width/12+randWidth, randLeng +(int)(0.1*length)+(sizeLeng/5)/2, width/12+randWidth+sizeWidth/5);
		g.drawLine( randLeng +(int)(0.1*length), width/12+randWidth+(sizeWidth/5)/2,  randLeng +(int)(0.1*length)+sizeLeng/5,   width/12+randWidth+(sizeWidth/5)/2);
		g.drawLine( randLeng +(int)(0.7*length)+(sizeLeng/5)/2,    width/12+randWidth,  randLeng +(int)(0.7*length)+(sizeLeng/5)/2, width/12+randWidth+sizeWidth/5);
		g.drawLine(  randLeng +(int)(0.7*length), width/12+randWidth+(sizeWidth/5)/2,  randLeng +(int)(0.7*length)+sizeLeng/5,  width/12+randWidth+(sizeWidth/5)/2);
		System.out.println("Color of Window = "+window);
		
		//lower ring
		
		g.setColor(ring);
		g.fillRect( randLeng , 11*width/24+randWidth -1,  sizeLeng,  sizeWidth/8);
		
		
		//upper Ring
		g.fillRect( randLeng , randWidth,  sizeLeng,  sizeWidth/12);
		System.out.println("Color of Ring = "+ring);
		
		//flowers
		int add = randLeng;
		int flowerLength = sizeLeng/6; 
		int center = flowerLength/4;
		int circleL = flowerLength/2;
		int CHeight = circleL/3;
		for(int q=1;q<7;q++)
		{	
			
			Color pistil = randColor();
			Color stem = randColor();
			Color petal = randColor();
			Color leave = randColor();
			//stem
			g.setColor(stem);
			g.fillRect(add+8*flowerLength/20, randWidth+sizeWidth+10+6*flowerLength/10, 5*flowerLength/20, 30);
			System.out.println("Flower "+q+"\nColor of Stem of Flower is = "+stem);
			//leave
			int [] Xaxis = new int[4];
			int [] Yaxis = new int[4];
			g.setColor(leave);
			Xaxis[0] = add+8*flowerLength/20+5*flowerLength/20;
			Yaxis[0] = randWidth+sizeWidth+10+6*flowerLength/10+20;
			
			Xaxis[1] = add+8*flowerLength/20+8*flowerLength/20;
			Yaxis[1] = randWidth+sizeWidth+10+6*flowerLength/10+15;
					
			Xaxis[2] = add+8*flowerLength/20+11*flowerLength/20;
			Yaxis[2] = randWidth+sizeWidth+10+6*flowerLength/10+18;
	
			Xaxis[3] = add+8*flowerLength/20+8*flowerLength/20;
			Yaxis[3] = randWidth+sizeWidth+10+6*flowerLength/10+23;
			
			g.fillPolygon(Xaxis, Yaxis, 4);
			System.out.println("Color of leave of Flower is = "+leave);
			//petals
			g.setColor(petal);     
			g.fillOval(add+center, randWidth+sizeWidth+10, circleL, circleL);
			g.fillOval(add, randWidth+sizeWidth+10+CHeight, circleL, circleL);
			g.fillOval(add+2*center, randWidth+sizeWidth+10+CHeight, circleL, circleL);
			g.fillOval(add+CHeight/2, randWidth+sizeWidth+10+flowerLength/2, circleL, circleL);
			g.fillOval(add+22*flowerLength/50, randWidth+sizeWidth+10+flowerLength/2, circleL, circleL);
			System.out.println("Color of Petals of Flower is = "+petal);
			
			
			//g.setColor(Color.YELLOW);
			g.setColor(pistil);
			g.fillOval(add+5*flowerLength/20, randWidth+sizeWidth+10+3*flowerLength/10, circleL, circleL);
			System.out.println("Color of Pistil of Flower is = "+pistil);
			
			
			add+=flowerLength;
		}	
	}

	

	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
	
		drawFrame(g);
	}
	
	

}
