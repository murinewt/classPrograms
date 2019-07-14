package tetris;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class GamePanel extends JPanel{
	
	
	public static int SQUARE = 1,
	ONE = 2,
	LET_E  = 3,
	LET_L = 4,
	LET_Z = 5,
	SQUARE_SIZE = 10,
	BOARD_SQUARES = 25;
	
	public boolean [][] boardState;
	public boolean [][] locked;
	
	public Shape shape , previousShape;
	
	public boolean gameInProgress, settled , moveLeft , moveRight,wait,waitForRotation;
	
	public int score;
	
	public String message;
	
	public Timer timer;
	
	public int myShape , currentShape;
	
	public EventHandler eventHandler;
	
	public GamePanel(){
		boardState = new boolean[BOARD_SQUARES][BOARD_SQUARES];
		locked = new boolean[BOARD_SQUARES][BOARD_SQUARES];
		doNewGame();
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(190,190));
		//BorderFactory.createLineBorder(Color.BLACK,3);
		
		
	}
	
	public void doNewGame(){
		
		for(int i = 0;i < BOARD_SQUARES ; i ++){
			for(int j = 0;j < BOARD_SQUARES; j ++){
				boardState[i][j] = false;
				locked[i][j] = false;
			}
		}
		
		ActionListener action = new ActionListener(){
			public void actionPerformed (ActionEvent evt){
				repaint();
			}	
		};
		
		timer = new Timer(200 , action);
		timer.start();
		
		/*timer = new Thread(){
			public void run() {
				while (true) {
					try {
						Thread.sleep(200);
						repaint();
					} 
					catch ( InterruptedException e ) {}
				}
			}
		};
			
		timer.start();*/
		
		
		
		score = 0;
		message = "Welcome to the Tetris Game";
		gameInProgress = moveLeft = moveRight =  true;	
		shape = new Shape();
		previousShape = new Shape();
		settled = wait = waitForRotation= false;
		//myShape = 1;// set the shape to be a square
		currentShape = 0;
		eventHandler = new EventHandler();
		eventHandler.panel = this;
		addKeyListener(eventHandler);
		setFocusable(true);
		myShape = 1;
		
	}
	
	public void updateBoardState(){
		for(int i  =  0;i < 4 ; i ++){
			Location loc = previousShape.getShapeItem(i);
			boardState[loc.row][loc.column] = false;
		}
		
		for(int i  =  0;i < 4 ; i ++){
			Location loc = shape.getShapeItem(i);
			boardState[loc.row][loc.column] = true;
		}
	}
	
	public void updateLocked(){
		for(int i  =  0;i < 4 ; i ++){
			Location loc = shape.getShapeItem(i);
			locked[loc.row][loc.column] = true;
		}	
	}
	
	public void updateShape(boolean wait , boolean waitForRotation){
		updatePShape();
		if(!wait && !waitForRotation){
			for(int i  =  0;i < 4 ; i ++){
				Location loc = shape.getShapeItem(i);
				if(loc.row < BOARD_SQUARES - 1 && !locked[loc.row + 1][loc.column])
				    shape.addShapeItem(i ,new Location(loc.row + 1  , loc.column));
				else{
					settled = true;
				}
			}
		}
		
		
		
	}
	public void allowHorMove(){
		for(int i = 0 ;i < 4; i ++){
			Location loc = shape.getShapeItem(i);
			if(loc.column < 1  ){
				moveLeft = false;
				moveRight = true;
				return;
			}
			else if(loc.column > BOARD_SQUARES - 2){
				moveLeft = true;
				moveRight = false;
				return;
			}
			else{
				moveLeft = true;
				moveRight = true;
			}
		}
		
	}
	public boolean allowChange(){
		int check = 1;
		allowHorMove();
		for(int i  =  0;i < 4 ; i ++){
			
			Location loc = shape.getShapeItem(i);
			
			
			if(loc.row < BOARD_SQUARES - 2 && (!locked[loc.row + 1][loc.column] && (moveLeft && moveRight &&!locked[loc.row ][loc.column + 1] )
					&& (moveRight &&moveLeft && !locked[loc.row ][loc.column - 1] ))){
				//if((moveLeft && !moveRight) || (moveRight && !moveLeft))
				check ++;
			}
			if((moveLeft && !moveRight) || (moveRight && !moveLeft))
				check ++;

			
			if(check  == 4){
				
				return true;
			}
		}
		return false;
		
	}
	
	public void updateShapeHor(int h){
		if(allowChange()){
			updatePShape();
			for(int i  =  0;i < 4 ; i ++){
				Location loc = shape.getShapeItem(i);
				if(!locked[loc.row][loc.column + h])
				    shape.addShapeItem(i, new Location(loc.row , loc.column+h));
				else{
					return;
				}
			}  
		}

		wait = true;
		updateBoardState();
	}
	
	public void updatePShape(){
		for(int i  =  0;i < 4 ; i ++){
			Location loc = shape.getShapeItem(i);
			previousShape.addShapeItem(i ,new Location(loc.row  , loc.column));
		}
		
	}
	
	public void newBoardState(){
		for(int i = 0;i < BOARD_SQUARES ; i ++){
			for(int j = 0;j < BOARD_SQUARES; j ++){
				boardState[i][j] = false;
			}
		}
		
	}

	
	public void move(){
		
		if(!settled){
			updateShape(wait , waitForRotation);
			updateBoardState();
		    for(int i  =  0;i < 4 ; i ++){
				Location loc = shape.getShapeItem(i);
				if(loc.row == BOARD_SQUARES - 1 || ((locked[loc.row+1][loc.column])&&loc.row < BOARD_SQUARES)){
					settled = true;
				     myShape = getShape();
				}
			}
		    wait = false;
		    waitForRotation = false;
			
		  
		}
		else{
			updateLocked();
			
			//myShape = 2;
			switch(myShape){
			case 1:
				currentShape = 0;
			shape.addShapeItem(0 , new Location(0,5));
			shape.addShapeItem(1 , new Location(0,6));
			shape.addShapeItem(2, new Location(1,5));
			shape.addShapeItem(3 , new Location(1,6));
			break;
			
			case 2:
				currentShape = 0;
			shape.addShapeItem(0 ,new Location(0,6));
			shape.addShapeItem(1 ,new Location(1,6));
			shape.addShapeItem(2 , new Location(2,6));
			shape.addShapeItem(3 ,new Location(3,6));
			break;
			
			case 3:
				currentShape = 0;
			shape.addShapeItem(0 , new Location(0,6));
			shape.addShapeItem(1 , new Location(1,6));
			shape.addShapeItem(2 , new Location(2,6));
			shape.addShapeItem(3 , new Location(1,5));
			break;
			
			case 4:
				currentShape = 0;
            shape.addShapeItem(0 , new Location(0,6));
			shape.addShapeItem(1 , new Location(1,6));
			shape.addShapeItem(2 , new Location(2,6));
			shape.addShapeItem(3 , new Location(2,7));
			break;
			
			case 5:
				currentShape = 0;
			shape.addShapeItem(0 , new Location(0,7));
			shape.addShapeItem(1 , new Location(0,6));
			shape.addShapeItem(2 , new Location(1,7));
			shape.addShapeItem(3 , new Location(1,8));
			break;	
		}
		settled = false;
		}
		
	}
	
	public boolean allowRotation(){
		
		for(int i = 0 ;i < 4 ; i ++){
			Location loc = shape.getShapeItem(i);
			if((loc.column > 2 && loc.column < BOARD_SQUARES -2) &&(loc.row < BOARD_SQUARES - 1) && !locked[loc.row + 2][loc.column]&& (moveLeft &&!locked[loc.row ][loc.column + 2] )
					&& (moveRight&& !locked[loc.row ][loc.column - 2] ) )
				waitForRotation = true;
				return true;
		}
		return false;
	}
	
	
	public void changeShape(){
		Location loc   = shape.getCenter();
		if(allowRotation()&& loc.row <  BOARD_SQUARES - 2 && loc.row > 2){
			updatePShape();
			switch(myShape){
			case 1:
				break;
			case 2:
				if(currentShape == 0){
					
					shape.addShapeItem(0, new Location(loc.row,loc.column-1));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row,loc.column+1));
					shape.addShapeItem(3, new Location(loc.row,loc.column+2));
					currentShape = 1;
					newBoardState();
					updateBoardState();
				}
				else if(currentShape == 1){
					
					shape.addShapeItem(0, new Location(loc.row-1,loc.column));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row+1,loc.column));
					shape.addShapeItem(3, new Location(loc.row+2,loc.column));
					currentShape  = 0;
					newBoardState();
					updateBoardState();	
				}
				
				break;
			case 3:
				if(currentShape== 0){
					
					shape.addShapeItem(0, new Location(loc.row -1,loc.column));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row,loc.column+1));
					shape.addShapeItem(3, new Location(loc.row+1,loc.column));
					currentShape = 1;
					newBoardState();
					updateBoardState();
				}
				else if(currentShape == 1){
					
					shape.addShapeItem(0, new Location(loc.row-1,loc.column));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row,loc.column - 1));
					shape.addShapeItem(3, new Location(loc.row + 1,loc.column));
					currentShape = 0;
					newBoardState();
					updateBoardState();
					
				}
				break;
			case 4:
				if(currentShape== 0){
					
					shape.addShapeItem(0, new Location(loc.row - 1,loc.column));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row + 1,loc.column));
					shape.addShapeItem(3, new Location(loc.row + 1,loc.column - 1));
					currentShape = 1;
					newBoardState();
					updateBoardState();
				}
				else if(currentShape == 1){
					
					shape.addShapeItem(0, new Location(loc.row - 1,loc.column));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row + 1,loc.column));
					shape.addShapeItem(3, new Location(loc.row + 1,loc.column + 1));
					currentShape = 0;
					newBoardState();
					updateBoardState();
					
				}
				break;
			case 5:
				if(currentShape== 0){
					
					shape.addShapeItem(0, new Location(loc.row ,loc.column ));
					shape.addShapeItem(1, new Location(loc.row,loc.column + 1));
					shape.addShapeItem(2, new Location(loc.row + 1,loc.column ));
					shape.addShapeItem(3, new Location(loc.row + 1,loc.column - 1));
					currentShape = 1;
					newBoardState();
					updateBoardState();
				}
				else if(currentShape == 1){
					
					shape.addShapeItem(0, new Location(loc.row,loc.column - 1));
					shape.addShapeItem(1, new Location(loc.row,loc.column));
					shape.addShapeItem(2, new Location(loc.row + 1,loc.column));
					shape.addShapeItem(3, new Location(loc.row + 1,loc.column + 1));
					currentShape = 0;
					newBoardState();
					updateBoardState();
					
				}
				break;
			}
		}
	}

	
	public void hasThePlayerScored(){
		int fill, current = 0;
		for(int j = 0; j < BOARD_SQUARES ;j ++ ){
			current = 0;
			fill = 0;
			for(int i = 0; i < BOARD_SQUARES ; i ++){
				if(locked[j][i]){
					fill ++;
				}
			}
			if(fill == BOARD_SQUARES){
				score += 10;
				message = "Great You Scored";
				
				for(int k = j - 1;k >= 0 ; k --){
					for(int m = 0;m < BOARD_SQUARES; m ++){
						if( current < 1){
							locked[j][m] = false;
							
						}
						
						if(locked[k][m]){
							locked[k][m] = false;
							locked[k + 1][m] = true;
						}
					}
					current ++;
			}
			}
		}

		
	}
	
	public void checkIfGameIsStillOn(){
		for(int i = 0 ;i < BOARD_SQUARES ; i ++){
			if(locked[1][i]){
				gameInProgress = false;
				message = "Game Over";
			}
		}
	}
	
	public int getShape(){
		return (int)(Math.random() * 6) + 1;
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(10,10,250,250);
		g.drawRect(5, 5, 260, 260);
		checkIfGameIsStillOn();
		if(gameInProgress){
		   move();
		   hasThePlayerScored();
		}
		
		for(int i = 0;i < BOARD_SQUARES ; i ++){
			for(int j = 0;j < BOARD_SQUARES; j ++){
				if(locked[i][j]){
					g.setColor(new Color(85,107,47));
					g.drawRect((j*SQUARE_SIZE)+10 ,(i*SQUARE_SIZE)+10, SQUARE_SIZE,SQUARE_SIZE);
					g.fillRect((j*SQUARE_SIZE)+SQUARE_SIZE + 2 ,(i*SQUARE_SIZE)+SQUARE_SIZE + 2, 6, 6);
				}
				else if(boardState[i][j]){
					g.setColor(Color.BLACK);
					g.drawRect((j*SQUARE_SIZE)+10 ,(i*SQUARE_SIZE)+10, SQUARE_SIZE,SQUARE_SIZE);
					g.fillRect((j*SQUARE_SIZE)+SQUARE_SIZE + 2 ,(i*SQUARE_SIZE)+SQUARE_SIZE + 2, 6, 6);
					
				}
				else if(boardState[i][j]&&locked[i][j]){
					g.setColor(Color.RED);
					g.drawRect((j*SQUARE_SIZE)+10 ,(i*SQUARE_SIZE)+10, SQUARE_SIZE,SQUARE_SIZE);
					g.fillRect((j*SQUARE_SIZE)+SQUARE_SIZE + 2 ,(i*SQUARE_SIZE)+SQUARE_SIZE + 2, 6, 6);
					
				}
			}
		}
		if(settled){
			newBoardState();
			
		}
	}// end of PaintComponent()
	
	
}