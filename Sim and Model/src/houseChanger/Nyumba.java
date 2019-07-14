package houseChanger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Nyumba extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Color color;
	int start = 100;
	int end = 250;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Building");
		Nyumba drawArea = new Nyumba();
		drawArea.setBackground(Color.white);
		window.setVisible(true);
		window.setPreferredSize(new Dimension(1000,650));
		window.add(drawArea);
		window.pack();
		window.setLocation(50,50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
		
	}
	
	public Color colorRand(){
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue);
		return color;
	}
	
	public void draw(Graphics g){
		
		int randLeng = start+(int)((end-start) * Math.random());
		int randWidth = start+(int)((end-start) * Math.random());
		int sizeLeng = start+(int)((end-start) * Math.random());
		int sizeWidth = start+(int)((end-start) * Math.random());
		Color house = colorRand();
		Color roof = colorRand();
		Color door = colorRand();
		Color window = colorRand();
		Color ring = colorRand();
	
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, 1000, 350);
		
		g.setColor(new Color(240,196,32));
		g.fillOval(600, 70, 50, 50);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 350, 1000, 500);
		
		
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
		System.out.println("Length of door = "+length/5 + " and width = " + 5*width/12);
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
		
		//upper window
		g.setColor(window);
		g.fillRect( randLeng +(int)(0.1*length), width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		g.fillRect( randLeng +(int)(0.7*length), width/12+randWidth ,  sizeLeng/5,  sizeWidth/5);
		System.out.println("Color of Window = "+window);
		
		g.setColor(ring);
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
			Color stem = colorRand();
			Color petal = colorRand();
			//stem
			g.setColor(stem);
			g.fillRect(add+8*flowerLength/20, randWidth+sizeWidth+10+6*flowerLength/10, 5*flowerLength/20, 30);
			System.out.println("Color of Stem of Flower "+q+" is = "+stem);
			
			//petals
			g.setColor(petal);     
			g.fillOval(add+center, randWidth+sizeWidth+10, circleL, circleL);
			g.fillOval(add, randWidth+sizeWidth+10+CHeight, circleL, circleL);
			g.fillOval(add+2*center, randWidth+sizeWidth+10+CHeight, circleL, circleL);
			g.fillOval(add+CHeight/2, randWidth+sizeWidth+10+flowerLength/2, circleL, circleL);
			g.fillOval(add+22*flowerLength/50, randWidth+sizeWidth+10+flowerLength/2, circleL, circleL);
			System.out.println("Color of Petals of Flower "+q+" is = "+petal);
			
			g.setColor(Color.YELLOW);
			g.fillOval(add+5*flowerLength/20, randWidth+sizeWidth+10+3*flowerLength/10, circleL, circleL);
			
			
			add+=flowerLength;
		}	
	}

	

	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
	
		draw(g);
	}
	
	

}
