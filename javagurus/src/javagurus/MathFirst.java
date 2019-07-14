package javagurus;
//MathFirst.java
import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class MathFirst extends Applet{

	int lValue;
	
	public void init()
	{
		lValue = Integer.parseInt(getParameter("leftvalue"));
	}
	public void paint(Graphics g){
		//String leftVAlue= valueOf(lValue);
		for(int i=0;i<11;i++){
		g.drawString(i+".  "+i+" * "+lValue+" = "+(lValue*i), 10, 10*(i));}
	}
}

