package javagurus;


	//applet displaying Hello World 
	//awt -abstract window toolkit
	//HelloWorld.java
	import java.applet.Applet;
	import java.awt.*;
	@SuppressWarnings("serial")
	public class HelloWorld extends Applet{
		public void paint(Graphics g) {
			g.drawLine(20,10,50,10);
			g.drawLine(20,10,20,30);
			g.drawLine(50,10,20,30);
			g.drawString("Hello World!",40, 50);
			g.drawString("Newton",80, 70);
			
			int y=40;
			for(int row=1;row<=4;row++){
				int x=40;
				for(int col=1;col<=4;col++){
					if(col>=row)g.drawOval(x, y, 40, 40);
					else g.fillOval(x,y,40,40);
					x+=40;
				}
				y+=40;
			}
		}
	}
