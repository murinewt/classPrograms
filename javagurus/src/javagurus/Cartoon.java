package javagurus;
import java.applet.Applet;
import java.awt.*;
import java.util.Random;
@SuppressWarnings("serial")
public class Cartoon extends Applet {
	public void paint(Graphics newt){
		Graphics2D newtm= (Graphics2D) newt;
		newtm.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	
		//all comments are from my view not the persons body
		//hair
		newt.drawLine(189, 70, 191, 60);
		newt.drawLine(191, 60, 193, 69);
		newt.drawLine(193, 69, 195, 60);
		newt.drawLine(195, 60, 197, 69);
		newt.drawLine(197, 69, 199, 60);
		newt.drawLine(199, 60, 201, 69);
		newt.drawLine(201, 68, 203, 60);
		newt.drawLine(203, 60, 205, 69);
		newt.drawOval(149, 69, 101, 101);//big face
		newt.setColor(Color.yellow);
		newt.fillOval(150, 70, 100, 100);//big face
		newt.setColor(Color.white);
		newt.fillOval(165, 90, 20, 30);//left eye
		newt.setColor(Color.black);
		newt.fillOval(173, 103, 4, 4);
		newt.setColor(Color.white);
		newt.fillOval(215, 90, 20, 30);//right eye
		newt.setColor(Color.black);
		newt.fillOval(223, 103, 4, 4);
		//right ear
		newt.drawLine(250, 108, 270, 90);
		newt.drawLine(250, 130, 270, 90);
		//left ear
		newt.drawLine(150, 108, 130, 90);
		newt.drawLine(150, 130, 130, 90);
		//nose
		int []nosex= new int[3];
		int []nosey= new int[3];
		nosex[0]= 200;
		nosey[0]= 105;
		nosex[1]= 190;
		nosey[1]= 125;
		nosex[2]= 210;
		nosey[2]= 125;
		newt.setColor(Color.darkGray);
		newt.fillPolygon(nosex, nosey, 3);
		//mouth
		//newt.drawLine(180, 148, 220, 148);
		newt.setColor(Color.darkGray);
		newt.fillOval(180, 140, 40, 15);
		newt.setColor(Color.yellow);//change color according to the color of the face
		newt.fillOval(180, 140, 40, 10);
		newt.fillRect(180, 140, 41, 7);
		newt.setColor(Color.magenta);
		newt.fillRect(190, 170, 20, 30);//neck
		newt.setColor(Color.CYAN);
		newt.fillRect(150, 200, 100, 120);//stomach
		//left leg
		newt.setColor(Color.LIGHT_GRAY);
		newt.fillRect(170, 320, 10, 60);//left leg
		newt.setColor(Color.yellow);
		newt.fillRect(167, 380, 28, 7);
		//right leg
		newt.setColor(Color.LIGHT_GRAY);
		newt.fillRect(220, 320, 10, 60);//right leg
		newt.setColor(Color.yellow);
		newt.fillRect(217, 380, 28, 7);
		newt.setColor(Color.black);
		//right hand
		newt.drawLine(250, 220, 280, 250);newt.drawLine(249, 219, 279, 249);
		newt.drawLine(310, 230, 280, 250);newt.drawLine(309, 229, 279, 249);
		newt.drawLine(250, 230, 280, 260);newt.drawLine(249, 229, 279, 259);
		newt.drawLine(310, 240, 280, 260);newt.drawLine(309, 239, 279, 259);
		//left hand
		newt.drawLine(150, 220, 130, 250);newt.drawLine(149, 219, 129, 249);
		newt.drawLine(150, 230, 130, 260);newt.drawLine(149, 229, 129, 259);
		newt.drawLine(130, 250, 100, 220);newt.drawLine(129, 249, 99, 219);
		newt.drawLine(130, 260, 100, 230);newt.drawLine(129, 259, 99, 229);
		//curve
		newt.drawArc(249, 150, 100, 200, 90, -180);
		newt.drawArc(250, 150, 100, 200, 90, -180);
		newt.drawLine(310, 140, 310, 360);
		newt.drawLine(311, 140, 311, 360);
		//stick
		newt.drawLine(100, 150, 100, 390);
		newt.drawLine(99, 150, 99, 390);
		int []xstick=new int[3];
		int []ystick=new int[3];
		xstick[0]=100;
		ystick[0]=100;
		xstick[1]=90;
		ystick[1]=150;
		xstick[2]=110;
		ystick[2]=150;
		newt.fillPolygon(xstick, ystick, 3);
		//circles
		int w=100;
		int z=100;
		for(int x=100;x<=500;){
			for(int y=500;y>100;){
				Random generator = new Random();
				int red =generator.nextInt(256);
				int green =generator.nextInt(256);
				int blue =generator.nextInt(256);
				Color randomColor = new Color(red,green,blue);
				newt.setColor(randomColor);
				newt.drawOval(x, y, w, z);
				y=y-3;
				x=x+10;
				w=w-3;
				z=z-3;
			}
		}
		newt.drawString("by Newton Murithi Mwirigi",40, 60);
		//flag
		newt.setColor(Color.BLACK);
		newt.drawRect(749, 199, 401, 301);
		//black color
		newt.setColor(Color.BLACK);
		newt.fillRect(750, 200, 400, 80);
		//white color
		newt.setColor(Color.WHITE);
		newt.fillRect(750, 280, 400, 30);
		//red color
		newt.setColor(Color.red);
		newt.fillRect(750, 310, 400, 80);
		//white color
		newt.setColor(Color.white);
		newt.fillRect(750, 390, 400, 30);
		//green color
		newt.setColor(new Color(51,153,0));
		newt.fillRect(750, 420, 400, 80);
		//spears
		newt.setColor(Color.white);
		int []xcord= new int[7];
		int []ycord=new int[7];
		xcord[0] = 880;
		ycord[0] = 220;
		xcord[1] = 901;
		ycord[1] = 249;
		xcord[2] = 915;
		ycord[2] = 280;
		xcord[3] = 1010;
		ycord[3] = 458;
		xcord[4] = 1007;
		ycord[4] = 460;
		xcord[5] = 911;
		ycord[5] = 280;
		xcord[6] = 894;
		ycord[6] = 255;
		newt.fillPolygon(xcord , ycord ,7);
		newt.setColor(Color.BLACK);
		newt.drawPolygon(xcord, ycord, 7);
		//spear 2
		newt.setColor(Color.WHITE);
		int []x1cord= new int[7];
		int []y1cord=new int[7];
		x1cord[0] = 1020;
		y1cord[0] = 220;
		x1cord[1] = 999;
		y1cord[1] = 249;
		x1cord[2] = 985;
		y1cord[2] = 280;
		x1cord[3] = 890;
		y1cord[3] = 458;
		x1cord[4] = 893;
		y1cord[4] = 460;
		x1cord[5] = 990;
		y1cord[5] = 280;
		x1cord[6] = 1006;
		y1cord[6] = 255;
		newt.fillPolygon(x1cord , y1cord ,7);
		newt.setColor(Color.BLACK);
		newt.drawPolygon(x1cord, y1cord, 7);
		//shield
		newt.setColor(Color.red);
		newt.fillOval(910, 240, 80, 220);
		newt.setColor(Color.black);
		newt.fillOval(910, 310, 10, 80);
		newt.fillOval(980, 310, 10, 80);
		newt.setColor(Color.WHITE);
		newt.fillOval(940, 340, 20, 20);
		newt.fillOval(940, 240, 20, 100);
		newt.fillOval(940, 360, 20, 100);
		newt.setColor(Color.red);
		newt.fillRect(947, 240, 6, 100);
		newt.fillRect(947, 360, 6, 100);
	}
}