package michaels;

import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public class Snake {
	
	public   ArrayList<SnakePortion> snakeArray ;
	int numberOfPortions , direction;
	int height;
	int width;
	boolean up , left , down , right; 
	
	public Snake(){
		int randomX =  300;//(int)(Math.random()*100)+1;
		int randomY = 300;//(int)(Math.random()*100)+1;
		snakeArray = new ArrayList<SnakePortion>();
		numberOfPortions = 4;
		direction = 10;
		for(int i = 0 ; i < numberOfPortions  ;i ++){
			snakeArray.add(i , new SnakePortion(randomX +(i * SnakePortion.size)  , randomY));
		}
		up = right  = down = false;
		left = true;
		
	}// end of constructor
	
	// a class that handles the key events
	
	public void updateSnakeX(int direction){
		int i = 0;
		int m = 0;
		SnakePortion[] clone = new SnakePortion[500];
		for(SnakePortion portion : snakeArray){
			clone[m] = portion;
			//System.out.println(clone[m].xPoint);
			m ++;
		}
		
		
		for(SnakePortion portion : snakeArray){
			
			if(snakeArray.indexOf(portion) == 0){
				snakeArray.set(0, new SnakePortion(portion.xPoint + direction , portion.yPoint));
				if(portion.xPoint <= 18 && left){
					snakeArray.set(0, new SnakePortion((width-2) , clone[i].yPoint)) ;
				}
				else if(portion.xPoint >= (width -20) && right)
					snakeArray.set(0, new SnakePortion(0 , clone[i].yPoint)); 
				
			}
			else{
				//System.out.println("current x " + portion.xPoint + " current y " + portion.yPoint );
				//System.out.println("next x " + clone[i].xPoint + " next y " +  clone[i].yPoint);
				SnakePortion newPortion = new SnakePortion(clone[i].xPoint , clone[i].yPoint);
				snakeArray.set(i+ 1, newPortion) ;
				i += 1;
			}
			
		}
	}
	
	public void updateSnakeY(int direction){
		int i = 0;
		int m = 0;
		SnakePortion[] clone = new SnakePortion[500];
		for(SnakePortion portion : snakeArray){
			clone[m] = portion;
			//System.out.print(clone[m].yPoint);
			m ++;
		}
		for(SnakePortion portion : snakeArray){
			if(snakeArray.indexOf(portion) == 0){
				snakeArray.set(0, new SnakePortion(portion.xPoint  , portion.yPoint + direction));
				
				
				if(portion.yPoint <= 18 && up)
					snakeArray.set(0, new SnakePortion(clone[i].xPoint, height-3));
					
				else if(portion.yPoint >= (height - 20) && down)
					snakeArray.set(0, new SnakePortion(clone[i].xPoint, 0));
			}
			else{
				//System.out.println("current x " + portion.xPoint + " current y " + portion.yPoint );
				//System.out.println("next x " + clone[i].xPoint + " next y " +  clone[i].yPoint);
				SnakePortion newPortion = new SnakePortion(clone[i].xPoint , clone[i].yPoint);
				snakeArray.set(i+ 1, newPortion) ;
				
				i += 1;
			}
			
		}
	}
	
	@SuppressWarnings("static-access")
	public Rectangle getBounds(SnakePortion portion){
		return new Rectangle(portion.xPoint , portion.yPoint , portion.size , portion.size);
	}
	
	public Point checkCrash(){
		Point point = null ;
		Rectangle head = getBounds(snakeArray.get(0));
		for(SnakePortion portion :  snakeArray){
			Rectangle portionToCheck  = getBounds(portion);
			if(portionToCheck.contains(head)&& (snakeArray.indexOf(portion) != 1 && snakeArray.indexOf(portion) != 0) ){
				point = new Point();
				point.x = portion.xPoint;
				point.y = portion.yPoint;	
			}	
		}
		return point;	
	}
	
	public Point crash(){
		Point point = null;
		if(checkCrash() != null){
			point = checkCrash();
			snakeArray = new ArrayList<SnakePortion>();
				
		}
		return point;
	}
	
	
	
	
	public void move(){
		
		if(up){
			updateSnakeY(-direction);
			}
		else if(down){
			updateSnakeY(direction);
		}
		else if(left){
			updateSnakeX(-direction);
		}
		else if(right){
			updateSnakeX(direction);
		}	
	}// end of move
	
	public void eat(){
		
		int x = snakeArray.get(numberOfPortions-1).xPoint;
		int y  = snakeArray.get(numberOfPortions -1).yPoint;
		SnakePortion addPortion = new SnakePortion(x , y);
		snakeArray.add(numberOfPortions , addPortion);
		numberOfPortions ++ ;
		
	}

}
