package michaels;


import java.awt.Color;
import java.awt.Graphics;

public class SnakePortion {
	
	public int xPoint , yPoint ;
	//public int xDirection , yDirection;
	public static int size = 10;
	
	public SnakePortion(int x , int y){
		this.xPoint = x;
		this.yPoint = y;
		//xDirection  = yDirection = 3;
		//size = 10;
	}
	
	/*public void move(int direction){
		/**
		 * 1 = moving up
		 * 2 = moving down
		 * 3 = moving right
		 * 4 = moving left
		 
		if(direction == 1)
			yPoint -= yDirection;
		else if(direction == 2){
			/yPoint += yDirection;	
		}
		else if(direction == 3){
			xPoint += xDirection;
		}
		else if(direction == 4){
			xPoint -= xDirection;
		}
	}// end of move*/
	
	public void drawPortion(Graphics g){
		g.setColor(Color.BLACK);
		
		g.drawRect(xPoint , yPoint , size , size);
		g.setColor(Color.BLACK);
		g.fillRect(xPoint+2 , yPoint+2 , size-4 , size-4);
	}
	public void drawHead(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(xPoint , yPoint ,size , size);
		
		
		
	}
	

}
