package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicTreeUI.KeyHandler;
import javax.swing.*;;

//import mouseEvents.SimpleTrackMouse.MouseHandler;

//@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{

	 
	private static final long serialVersionUID = 1L;
	//private Board snakeDirection;
	private static Snake snake;
	private static Snake snakePark;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Snake Game");
		Board drawingArea = new Board();
		drawingArea.setBackground(Color.white);
		window.setContentPane(drawingArea);
		drawingArea.setPreferredSize(new Dimension(500,500));
		window.pack();
		window.setLocation(500,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		Timer frameTime = new Timer(250,drawingArea);
		window.setVisible(true);
		frameTime.start();
		

	}
	public Board(){
		//MouseHandler listener = new MouseHandler();
       // addMouseListener(listener);        // Register mouse listener.
        //addMouseMotionListener(listener);  // Register mouse motion listener.
       // KeyHandler listener = null;// = new KeyHandler();
       // KeyAdapter listener = new KeyAdapter();
       // KeyEvent listener =  new KeyEvent();
        //addKeyListener(listener);
	}
	
	public void drawFrame(Graphics g,int frameNumber,int width, int height){
		//int centerX;
		//int centerY;
		int leng = 10;
		g.drawLine(50,50,50,getHeight()-50);
		g.drawLine(50, 50, getWidth()-50, 50);
		g.drawLine(getWidth()-50, 50, getWidth()-50, getHeight()-50);
		g.drawLine(50, getHeight()-50, getWidth()-50, getHeight()-50);
		if(snakePark == null ){
			snakePark = new Snake(100,200,leng);
			//snake.draw(g);
			}
		if(snakePark.x<getWidth()-50&&snakePark.x>50&&snakePark.y<getHeight()-50&&snakePark.y>50){
		snakePark.x= snakePark.x+10;
			/*if(snakePark.xIncreasing==true){
				
				snakePark.draw(g);
			}
			else if(snakePark.yIncreasing==true){
				snakePark.y= snakePark.y+10;
				snakePark.draw(g);
			}*/
		}
		else if(snakePark.x>getWidth()-(50+leng)){
			snakePark.x=50;
			snakePark.x= snakePark.x+10;
			snakePark.draw(g);
		}
		else if(snakePark.x<50){
			snakePark.x=getWidth()-50;
			snakePark.x= snakePark.x+10;
		}
		else if(snakePark.y>getHeight()-(50+leng)){
			
			snakePark.y=50;
			snakePark.y= snakePark.y+10;
		}
		else if(snakePark.y<50){
			snakePark.y=getHeight()-50;
			snakePark.y= snakePark.y+10;
		}
		snakePark.draw(g);
}
		

	/*public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		int code = evt.getKeyCode();
		if(code == 87 || code == KeyEvent.VK_UP){
			
			if(snake.down == false){
				snake.up = true;
				System.out.println(" moving up");
				snake.down = snake.left = snake.right = false;
			}
			    
		}
		else if(code == 83|| code == KeyEvent.VK_DOWN){
			if(snake.up == false){
				snake.down = true;
				System.out.println("moving down");
				snake.up = snake.left = snake.right = false;
			}
			
		}
		else if(code == 68|| code == KeyEvent.VK_RIGHT){
			if(snake.left == false){
				snake.right = true;
				System.out.println("moving right");
				snake.down = snake.left = snake.up = false;
			}
		}
		else if(code == 65|| code == KeyEvent.VK_LEFT){
			if(snake.right == false){
				snake.left = true;
				System.out.println("moving left");
				snake.down = snake.up = snake.right = false;
			}
			
		}	
		
	}*/

		
		public void keyReleased(KeyEvent e){
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
			
			/*if(key == KeyEvent.VK_ENTER&&(inGame == false)){
				inGame = true;
				snake.setMovingDown(false);
				snake.setMovingLeft(false);
				snake.setMovingRight(false);
				snake.setMovingUp(false);
				
				initializeGame();*/
			}

		
	
	
	private int frameNum = 0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*// TODO Auto-generated method stub
		if (snakeDirection != null) {
            snakeDirection.updateForNewFrame();
            
        }
		addKeyListener( new KeyAdapter() {
            // The key listener responds to keyPressed events on the panel. Only
            // the left-, right-, and down-arrow keys have any effect.  The left- and
            // right-arrow keys move the boat while down-arrow releases the bomb.
        public void keyPressed(KeyEvent evt) {
            int code = evt.getKeyCode();  // Which key was pressed?
            if (code == KeyEvent.VK_LEFT) {
                    // Move the boat left.  (If this moves the boat out of the frame, its
                    // position will be adjusted in the boat.updateForNewFrame() method.)
            	
                //boat.centerX -= 15;
            }
            else if (code == KeyEvent.VK_RIGHT) {  
                    // Move the boat right.  (If this moves boat out of the frame, its
                    // position will be adjusted in the boat.updateForNewFrame() method.)
                //boat.centerX += 15;
            }
            else if (code == KeyEvent.VK_DOWN) {
            	snakePark.yIncreasing=true;
            	
                    // Start the bomb falling, if it is not already falling.
                //if ( bomb.isFalling == false )
                  //  bomb.isFalling = true;
            }
        }
		} );
		*/
		frameNum++;
		repaint();
	}
	

	private void updateForNewFrame() {
		// TODO Auto-generated method stub
		
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		drawFrame(g,frameNum,getWidth(),getHeight());
	}

}
