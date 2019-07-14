package javagurus;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.AffineTransform;

@SuppressWarnings("serial")
public class OvalRotate extends Applet{
	public void paint(Graphics newt){
		super.paintComponents(newt);
		Graphics2D newtm= (Graphics2D) newt;
		AffineTransform rotator = new AffineTransform();
		rotator.rotate(Math.toRadians(30),45,45);
		newtm.setPaint(Color.blue);
		//newtm.setTransform(rotator);
		newtm.fillOval(400, 100, 50, 10);
		
	}

}
