package michaels;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SnakeBoard extends JPanel implements ActionListener,KeyListener {
	
	Snake snake;
	Point crashPoint , foodPoint;
	boolean eating;
	ActionListener action;
	Timer timer;
	int redraw;
	String message = "";
	public JButton newGame , pauseGame , exitGame ,contGame;
	
	public SnakeBoard(){
		snake = new Snake();
		setBackground(new Color(0,153,0));
		setLayout(new BorderLayout());
		eating = true;
		foodPoint = points();
		snake.height = 500;
		snake.width = 500;
		redraw = 100;
				
		addKeyListener(this);
		
		newGame = new JButton("New Game");
		pauseGame = new JButton("Pause");
		exitGame = new JButton("Exit");
		contGame = new JButton("Continue");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(newGame);
		buttonPanel.add(pauseGame);
		buttonPanel.add(contGame);
		buttonPanel.add(exitGame);
		
        newGame.addActionListener(this);
        pauseGame.addActionListener(this);
        exitGame.addActionListener(this);
        contGame.addActionListener(this);
        
		
		add(buttonPanel , BorderLayout.SOUTH);
		
		
		action = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				snake.move();
				
				if(snake.snakeArray.isEmpty() == false){
					crashPoint = snake.crash();
					checkFood();
					
				}
				repaint();
			}
		};
		
		timer = new Timer(redraw , action);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent evt){
				if(evt.isMetaDown()){
					requestFocus();
					timer.start();
				}
				else{
					timer.stop();
				}
			}
		});
		
	}// end of constructor
	
	public void actionPerformed(ActionEvent evt) {
		
		// TODO Auto-generated method stub
		String str = evt.getActionCommand();
		if( str.equals( "New Game") ){
			if(snake.snakeArray!= null){
				JOptionPane.showMessageDialog(null, " There is a game in progress./nDo you want to "
						+ "start a new Game");
				if(!eating)
					eating = true;
				snake = new Snake();
				snake.height = 500;
				snake.width = 500;
				requestFocus();
			}
		}
		else if(str.equals("Pause"))
			timer.stop();
		else if(str.equals("Exit"))
			System.exit(0);
		else if(str.equals("Continue")){
			timer.start();
			requestFocus();
		}
		
	}
	
	public void keyReleased(KeyEvent evt) {
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
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public Point points(){
		int x = (int)(Math.random() * 400)+ 30;
		int y = (int)(Math.random() * 400)+ 30;
		return new Point(x , y);
		
	}
	
	public void generateFood(Graphics g){
		
		g.setColor(Color.RED);
		//SnakePortion p = new SnakePortion(foodPoint.x, foodPoint.y);
		//p.drawPortion(g);
		g.fillOval(foodPoint.x, foodPoint.y, 14, 14);
		g.drawLine(foodPoint.x +6 , foodPoint.y ,foodPoint.x, foodPoint.y - 4);
		
		
		
	}
	
	public void checkFood(){
		if(snake.snakeArray.isEmpty() == false){
		   SnakePortion head = snake.snakeArray.get(0);
		
			//Rectangle food = new Rectangle(foodPoint.x , foodPoint.y ,10,10);
			
			
			if((Math.abs(head.xPoint-foodPoint.x) < 15) && Math.abs(head.yPoint-foodPoint.y) < 15){
				snake.eat();
				System.out.println("Food eaten");
				eating = true;
				
			}
		}
		
	}
	

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(eating){
			
			g.setColor(Color.GRAY);
			g.fillRect(foodPoint.x+3, foodPoint.y+3, 5, 5); 
			foodPoint = points();
			eating = false;
			
		}
		if(snake.snakeArray.isEmpty() == false)
		     generateFood(g);
		
		if(snake.snakeArray.isEmpty() == false){
			for(SnakePortion portion : snake.snakeArray){
				if(snake.snakeArray.indexOf(portion)== 0)
					portion.drawHead(g);
				else
				    portion.drawPortion(g);
			}
		}
		
		else{
			g.setColor(Color.WHITE);
			g.fillRect(0 , 0 , 500 , 300);
			g.setColor(Color.BLACK);
			message = "GAME OVER";
			g.setFont(new Font("Consolas" , Font.PLAIN , 40));
			g.drawString(message,150, 150);
			timer.stop();
		}
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Snake Game");
        SnakeBoard content = new SnakeBoard();
        window.setContentPane(content);
        window.setSize(500  , 500); 
        window.setResizable(false); 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screenSize.width - window.getWidth())/2,
                (screenSize.height - window.getHeight())/2 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
