/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Board extends JPanel implements ActionListener,KeyListener {
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Shape Shape;// = new Shapes();
	private static Shapes abcdef; 
	int speed = 1000;
	Graphics g;
	public JButton newGame , pauseGame , exitGame ,contGame;
	ActionListener action;
	//int redraw;
	Timer timer;
	String newGam = "New Game";
	String pause = "Pause";
	String exit = "Exit";
	String contin = "Continue";
	public static int rand = (int)(Math.random() * 19)+1 ;

    public static boolean isFalling = false;
		
        @SuppressWarnings("LeakingThisInConstructor")
	public Board(){
		abcdef = new Shapes();
		//setBackground(new Color(0,153,0));
		setLayout(new BorderLayout());
		//eating = true;
		//foodPoint = points();
		//snake.height = 500;
		//snake.width = 500;
		speed= 1000;
				
		addKeyListener(this);
		
		newGame = new JButton(newGam);
		pauseGame = new JButton(pause);
		exitGame = new JButton(exit);
		contGame = new JButton(contin);
		
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
                        @Override
			public void actionPerformed(ActionEvent evt){
				///abcdef.move();
				
				
				repaint();
			}
		};
		
		timer = new Timer(speed , action);
		addMouseListener(new MouseAdapter(){
                        @Override
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
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Tetris Game");
        Board content = new Board();
        content.setBackground(Color.white);
        window.setContentPane(content);
        window.setSize(800  , 700); 
        window.setResizable(false); 
       // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*window.setLocation( (screenSize.width - window.getWidth())/2,
                (screenSize.height - window.getHeight())/2 );*/
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       // Timer frameTime = new Timer(1000,content);
	window.setVisible(true);
		//frameTime.start();
        //window.setVisible(true);
	}
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@SuppressWarnings("static-access")
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		int code = evt.getKeyCode();
		if(code == 87 || code == KeyEvent.VK_UP){
			rand = abcdef.rotate();
			    
		}
		else if(code == 83|| code == KeyEvent.VK_DOWN){
                    abcdef.moveDownFaster();
			/*if(abcdef.up == false){
				abcdef.down = true;
				System.out.println("moving down");
				abcdef.up = abcdef.left = abcdef.right = false;
			}*/
			
		}
		if(code == 68|| code == KeyEvent.VK_RIGHT){
			//if(abcdef.left == false){
				//abcdef.right = true;
				//Shape.xPoint = Shape.xPoint+10;
				//Shape.draw(g, rand);
				abcdef.moveRight();
				//System.out.println("moving right");
				
				//abcdef.left = false;
				abcdef.down = true;
			//}
		}
		else if(code == 65|| code == KeyEvent.VK_LEFT){
			//if(abcdef.right == false){
				//abcdef.left = true;
				//Shape.xPoint = Shape.xPoint-10;
				//Shape.draw(g, rand);
				//drawFrame(g,frameNum,getWidth(),getHeight());
				//System.out.println("moving left");
				//drawDrop(g);
				abcdef.moveLeft();
				//abcdef.right = false;
				abcdef.down = true;
			//}
			
		}	
		//drawFrame(g,frameNum,getWidth(),getHeight());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//private int frameNum = 0;
	@Override
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String str = evt.getActionCommand();
		if( str.equals(newGam)) {
			if(Shape!= null){
				/*JOptionPane.showMessageDialog(null, " There is a game in progress. Do you want to "
						+ "start a new Game");*/
				rand = (int)(Math.random() * 19)+1;
				/*if(!eating)
					eating = true;
				
				abcdef.height = 500;
				abcdef.width = 500;*/
				new Board();
				requestFocus();
			}
		}
		if(str.equals(pause)){
			timer.stop();
			//requestFocus();
		}
		else if(str.equals(exit)){
			System.exit(0);
			//requestFocus();
		}
		else if(str.equals(contin)){
			timer.start();
			
		//requestFocus();
		}
		
		//frameNum++;
		//repaint();
	}
	
	public void drawFrame(Graphics g,int frameNumber,int width, int height){
		//for (int z=0;z<19;z++){
		
		//if(abcdef.down == true){
			
			
		//}
		/*while(abcdef.left==true)
		{
			
			Shape.draw(g, 1);
		}
		while(abcdef.right=true){
			Shape.xPoint = Shape.xPoint+10;
		}*/
		
		//for (int e=0;e<19;e++)
			
		
	}

        @Override
	protected void paintComponent(Graphics g){
		//Shape.draw(g);
		super.paintComponent(g);
		g.drawLine(50, 10, 50, 450);
		g.drawLine(410, 10, 410, 450);
		g.drawLine(50, 450, 410, 450);
		//if(abcdef.down){
		//new Board();
		drawDrop(g);
		abcdef.stoplength();
                //abcdef.fallAgain();
			
		/*while(abcdef.left=true)
		{
			Shape.xPoint = Shape.xPoint-10;
			Shape.draw(g, 1);
		}
		while(abcdef.right=true){
			Shape.xPoint = Shape.xPoint+10;
		}*/
		//drawFrame(g,frameNum,getWidth(),getHeight());//,frameNum);//getWidth(),getHeight());
		//}
		//else{
			
		//}
		
		
		
		
		
	}
	
	public void drawDrop(Graphics g){

		if (Shape==null){
                    
                    System.out.println("shape is null");
                    if(rand==4||rand==14||rand==17||rand==18)
                        Shape  = new Shape(210,30);
                    else if(rand==13)
                        Shape  = new Shape(210,10);
                    else
                    	Shape  = new Shape(210,50);
                   // isFalling = true;
                }
                /*else if(Shapes.downAgain){
                    //new Shape(210,30);
                   // System.out.println("out shape is not null");
                   // if (isFalling){
                    rand = (int)(Math.random() * 19)+1 ;
                    if(rand==4||rand==14||rand==17||rand==18)
                        Shape  = new Shape(210,30);
                    else if(rand==13)
                        Shape  = new Shape(210,10);
                    else
			Shape  = new Shape(210,50);
                   // }
                }*/
		//System.out.println(rand+" ");
		Shape.yPoint = Shape.yPoint+20;//number of steps to fall
		Shape.draw(g,rand);
               
	}
        

}
