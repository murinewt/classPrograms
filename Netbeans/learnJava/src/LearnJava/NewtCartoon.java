/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearnJava;

import java.applet.Applet;
import java.awt.*;
@SuppressWarnings("serial")
public class NewtCartoon extends Applet {
	public void paint(Graphics newt){
		Graphics2D newtm= (Graphics2D) newt;
		newtm.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//all comments are from my view not the persons body
		newt.drawOval(150, 70, 100, 100);//big face
		newt.setColor(Color.yellow);
		newt.fillOval(150, 70, 100, 100);//big face
		newt.setColor(Color.pink);
		newt.fillOval(165, 90, 20, 30);//left eye
		newt.setColor(Color.black);
		newt.fillOval(173, 103, 4, 4);
		newt.setColor(Color.pink);
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
		nosex[1]= 190;
		nosex[2]= 210;
		nosey[0]= 105;
		nosey[1]= 125;
		nosey[2]= 125;
		newt.drawPolygon(nosex, nosey, 3);
		newt.setColor(Color.blue);
		newt.drawOval(180, 140, 40, 15);//mouth
		newt.drawRect(190, 170, 20, 30);//neck
		newt.drawRect(150, 200, 100, 120);//stomach
		newt.drawRect(170, 320, 10, 60);//left leg
		newt.drawRect(220, 320, 10, 60);//right leg
		//right hand
		newt.drawLine(250, 220, 280, 220);
		newt.drawLine(250, 230, 270, 230);
		newt.drawLine(280, 220, 280, 260);
		newt.drawLine(270, 230, 270, 260);
		newt.drawLine(280, 260, 300, 270);
		newt.drawLine(270, 260, 290, 270);
		//left hand
		newt.drawLine(120, 220, 150, 220);
		newt.drawLine(130, 230, 150, 230);
		newt.drawLine(120, 220, 120, 260);
		newt.drawLine(130, 230, 130, 260);
		newt.drawLine(120, 260, 140, 270);
		newt.drawLine(130, 260, 150, 270);
		//stick
		newt.drawLine(115, 265, 295, 265);
		newt.drawLine(115, 266, 295, 266);
		newt.drawLine(115, 267, 295, 267);
		//circles
		int w=100;
		int z=100;
		for(int x=100;x<=500;){
			for(int y=500;y>100;){
				newt.drawOval(x, y, w, z);
				y=y-3;
				x=x+10;
				w=w-3;
				z=z-3;
			}
		}
		//flag
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