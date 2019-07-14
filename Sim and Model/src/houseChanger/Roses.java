package houseChanger;
import java.awt.*; public class Roses {
	  //declare a constant field for green sepal   
	final Color SEPAL_COLOR = Color.green;
	  //declare instance variables that are attributes of Rose   //default color is red rose on white background   
	public Color backGroundColor = Color.white;   public Color petalColor = Color.red;
	  public void paintBackGround(Graphics g,int x,int y ) {
	    g.setColor(backGroundColor);     g.fillRect(x+10,y+10, 150, 450);   }
	  public void paintGreenSepal(Graphics g,int x,int y ) {     
		  g.setColor(SEPAL_COLOR);     
		  g.fillOval(x+38,y+138,40,40);     
		  g.fillOval(x+68,y+138,40,40);     
		  g.fillOval(x+38,y+168,40,40);     
		  g.fillOval(x+68,y+168,40,40);   
	  }
	  public void paintPetal(Graphics g,int x,int y ) {
	    //draw petal     
		  g.setColor(petalColor);     g.fillOval(x+28,y+148,90,50);     g.fillOval(x+48,y+128,50,90);
	    //petal outline     
		  g.setColor(Color.black);
	    g.drawArc(x+50,y+180,25,30,345,150);     g.drawArc(x+75,y+180,25,30,160,-105);     
	    g.drawArc(x+88,y+163,30,20,230,-105);     g.drawArc(x+70,y+150,30,20,290,-120);     
	    g.drawArc(x+45,y+140,25,30,345,-120);     g.drawArc(x+30,y+168,30,20,50,-70);   }
	  public void paintPedicel( Graphics g,int x,int y ) {
	    //draw pedicel     
		  g.setColor(Color.green);     g.fillRect(x+71,y+218,3,100);   }
	  public void paintLeave(Graphics  g,int x,int y) {     int[] rightX = {x+73,x+94,x+131,x+104,x+73},           rightY = {y+246,y+216,y+218,y+250,y+246};
	    int[] leftX = {x+71,x+55,x+27,x+47,x+71},           leftY= {y+268,y+241,y+245,y+269,y+268};
	    //draw right leaf     
	    g.fillPolygon(rightX,rightY,5);
	    //draw left leaf     
	    g.fillPolygon(leftX,leftY,5);   }
	  public void paintRose( Graphics g,int x,int y ) {
	    paintBackGround(g,x,y);     paintGreenSepal(g,x,y);     
	    paintPetal(g,x,y);     
	    paintPedicel(g,x,y);     paintLeave(g,x,y);   
	    } 
	  }