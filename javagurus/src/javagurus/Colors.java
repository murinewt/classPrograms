package javagurus;
//a Java Applet that displays a color palette
//Colors.java
import java.applet.Applet;
import java.awt.*;
@SuppressWarnings("serial")
public class Colors extends Applet
{
	//private final int WIDTH = 768;
	private final int HEIGHT = 50;
	public void init (){
	}
	public void paint (Graphics page)
	{
		int loc = 0;
		// From Red to Green through Yellow
		for (int j=0; j<256; j+=2, loc++){
			Color c = new Color(255, j, 0);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
		for (int i=255; i>=0; i-=2, loc++){
			Color c = new Color(i, 255, 0);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
		// From Green to Blue through Cyan
		for (int k=0; k<256; k+=2, loc++){
			Color c = new Color(0, 255, k);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
		for (int j=255; j>=0; j-=2, loc++){
			Color c = new Color (0, j, 255);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
		// From Blue to Red through Magenta
		for (int i=0; i<256; i+=2, loc++){
			Color c = new Color(i, 0, 255);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
		for (int k=255; k>=0; k-=2, loc++){
			Color c = new Color (255, 0, k);
			page.setColor (c);
			page.drawLine (loc, 0, loc, HEIGHT);
		}
	}
}