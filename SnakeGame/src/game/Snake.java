package game;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	public SnakeDraw realSnake[];
	
	public int length; // The radius of the circle.
	public int x,y; // The location of the center of the circle.
	public Color color; // The color of the circle.
	public boolean xIncreasing=false;
	public boolean yIncreasing=true;
	int lenh = 0;
	boolean up , left , down , right; 

	public Snake (int centerX, int centerY, int len ) {
		if(centerX>x)
			xIncreasing=true;
		if(centerY>y)
			yIncreasing=true;
		x = centerX;
		y = centerY;
		length = len;
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		color = new Color(red,green,blue, 100);
		

		up = right  = down = false;
		left = true;
	}
	public boolean isMovingLeft(){
		return left;
	}
	public void setMovingLeft(boolean movingLeft){
		this.left = movingLeft;
	}
	
	public boolean isMovingRight(){
		return right;
	}
	public void setMovingRight(boolean movingRight){
		this.right = movingRight;
	}
	public boolean isMovingUp(){
		return up;
	}
	public void setMovingUp(boolean movingUp){
		this.up = movingUp;
	}
	
	public boolean isMovingDown(){
		return down;
	}
	public void setMovingDown(boolean movingDown){
		this.down = movingDown;
	}
	
	public void move(){
		
		if(up){
			updateSnakeY(-length);
			}
		else if(down){
			updateSnakeY(length);
		}
		else if(left){
			updateSnakeX(-length);
		}
		else if(right){
			updateSnakeX(length);
		}	
	}// end of move
	
	public void updateSnakeX(int direction){
		
	}
	public void updateSnakeY(int direction){
		
	}
	
	public void draw( Graphics g ) {
		realSnake = new SnakeDraw[100];
		g.drawLine( x+lenh, y, x+length, y);
		/*for(int z=0;z<=4;z++){
			
			lenh= lenh+10;
		}*/
		
	}

}
