package copy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	private final static int BOARDWIDTH = 1000;
	private final static int BOARDHEIGHT = 700;
	
	private final static int PIXELSIZE = 25;
	
	private final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT)/(PIXELSIZE * PIXELSIZE);
	
	private boolean inGame = true;
	
	private Timer timer;
	
	private static int speed = 200;
	
	private Snake snake = new Snake();
	private Food food = new Food();
	
	public Board(){
		addKeyListener(new Keys());
		setBackground(Color.DARK_GRAY);
		setFocusable(true);
		
		setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
		initializeGame();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	
	void draw(Graphics g){
		if(inGame==true){
			g.setColor(Color.GREEN);
			g.fillRect(food.getFoodX(), food.getFoodY(), PIXELSIZE, PIXELSIZE);
			
			for(int i=0;i<snake.getJoints();i++){
				if(i==0){
					g.setColor(Color.RED);
					g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i), PIXELSIZE, PIXELSIZE);
				}
				else{
					g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i), PIXELSIZE, PIXELSIZE);
				}
			}
			
			Toolkit.getDefaultToolkit().sync();
		}
		else{
			endGame(g);
		}
		
	}
	
	void initializeGame(){
		snake.setJoints(3);
		
		for(int i=0;i<snake.getJoints();i++){
			snake.setSnakeX(BOARDWIDTH/2);
			snake.setSnakeY(BOARDHEIGHT/2);
		}
		snake.setMovingRight(true);
		
		food.createFood();
		timer = new Timer(speed,this);
		timer.start();
		
	}
	
	void checkFoodCollisions(){
		if((proximity(snake.getSnakeX(0),food.getFoodX(),20)) && 
				(proximity(snake.getSnakeY(0),food.getFoodY(),20))){
			//System.out.println("intersection");
			snake.setJoints(snake.getJoints()+1);
			food.createFood();
		}
	}
	
	void checkCollisions(){
		for(int i=snake.getJoints();i>0;i--){
			
			if((i>5)&&(snake.getSnakeX(0)==snake.getSnakeX(i)&&(snake.getSnakeY(0)==snake.getSnakeY(i)))){
				inGame=false;
			}
			
			if((snake.getSnakeX(0)>=BOARDWIDTH) && (snake.getSnakeY(0)>=BOARDHEIGHT))
				inGame = false;
			if((snake.getSnakeX(0)<0) && (snake.getSnakeY(0)<0))
				inGame = false;
			
			if (!inGame){
				timer.stop();
			}
		}
	}
	void endGame(Graphics g){
		String message = "Game";
		
		Font font = new Font("Times New Roman",Font.BOLD,14);
		FontMetrics metrics = getFontMetrics(font);
		
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString(message, (BOARDWIDTH - metrics.stringWidth(message))/2, BOARDHEIGHT/2);
		System.out.println("Game Ended");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(inGame==true){
			checkFoodCollisions();
			checkCollisions();
			snake.move();
			//System.out.println(snake.getSnakeX(0)+" "+
			//snake.getSnakeY(0)+" "+food.getFoodX()+", "+food.getFoodY());
		}
		repaint();
		
	}

	private class Keys extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_LEFT) &&(!snake.isMovingRight())){
				snake.setMovingLeft(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
				snake.setMovingRight(false);
			}
			
			if((key == KeyEvent.VK_RIGHT) &&(!snake.isMovingLeft())){
				snake.setMovingRight(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
				snake.setMovingLeft(false);
			}
			/*if( key == KeyEvent.VK_W){
				snake.setMovingUp(true);
				snake.setMovingLeft(false);
				snake.setMovingRight(false);
				snake.setMovingDown(false);
			}*/
			if((key == KeyEvent.VK_UP) &&(!snake.isMovingDown())){
				//snake.setDirection(Direction.UP);
				snake.setMovingUp(true);
				snake.setMovingLeft(false);
				snake.setMovingRight(false);
				snake.setMovingDown(false);
			}
			
			if((key == KeyEvent.VK_DOWN) &&(!snake.isMovingUp())){
				snake.setMovingDown(true);
				snake.setMovingLeft(false);
				snake.setMovingRight(false);
				snake.setMovingUp(false);
			}
			
			if(key == KeyEvent.VK_ENTER&&(inGame == false)){
				inGame = true;
				snake.setMovingDown(false);
				snake.setMovingLeft(false);
				snake.setMovingRight(false);
				snake.setMovingUp(false);
				
				initializeGame();
			}
			
		}
	}
	
	private boolean proximity(int a, int b, int closeness){
		return Math.abs((long)a-b)<=closeness;
	}
	
	public static int getAllDots(){
		return TOTALPIXELS;
	}
	
	public static int getDotSize(){
		return PIXELSIZE;
	}
	
}
