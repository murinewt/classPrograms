package tetris;


import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel gamePanel;
	ScorePanel scorePanel;
	GameShapeDisplay display;
	MessagePanel messagePanel;
	
	JMenuBar menuBar;
	EventHandler evtHandler;
	
	public GameBoard(){
		setBackground(new Color(245,245,245));
		gamePanel = new GamePanel();
		scorePanel = new ScorePanel();
		scorePanel.panel = gamePanel;
		menuBar = new JMenuBar();
		evtHandler = new EventHandler();
		
		evtHandler.panel = gamePanel;
		
		JMenu game = new JMenu("Game");
		
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(evtHandler);
		game.add(newGame);
		
		JMenuItem pauseGame = new JMenuItem("Pause");
		pauseGame.addActionListener(evtHandler);
		game.add(pauseGame);
		
		JMenuItem continueGame = new JMenuItem("Continue");
		continueGame.addActionListener(evtHandler);
		game.add(continueGame);
		
		JMenuItem quitGame = new JMenuItem("Quit");
		quitGame.addActionListener(evtHandler);
		game.add(quitGame);
		
		JMenu gameMode = new JMenu("Mode");
		
		JMenuItem normalMovement = new JMenuItem("Normal");
		normalMovement.addActionListener(evtHandler);
		gameMode.add(normalMovement);
		
		JMenuItem horMovement = new JMenuItem("Across");
		horMovement.addActionListener(evtHandler);
		gameMode.add(horMovement);
		
		JMenuItem upMovement = new JMenuItem("Up");
		upMovement.addActionListener(evtHandler);
		gameMode.add(upMovement);
		
		JMenu about = new JMenu("About");
		
		JMenuItem controls = new JMenuItem("Controls");
		controls.addActionListener(evtHandler);
		about.add(controls);
		
		JMenuItem developer = new JMenuItem("Developer");
		developer.addActionListener(evtHandler);
		about.add(developer);
		
		
		menuBar.add(game);
		menuBar.add(gameMode);
		menuBar.add(about);
		
		menuBar.setBounds(0,0 ,500 , 20);
		this.add(menuBar);
		
		display = new GameShapeDisplay();
		display.panel = gamePanel;
		
		messagePanel = new MessagePanel();
		messagePanel.panel = gamePanel;
		
		setLayout(null);
		
		gamePanel.setBounds(10,30,270 , 270);
		this.add(gamePanel);
		
		scorePanel.setBounds(310 ,250, 150,50 );
		this.add(scorePanel);
		
		display.setBounds(310, 30 ,150, 150);
		this.add(display);
		
		messagePanel.setBounds(10,350,300,50);
		this.add(messagePanel);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	
	public static void main(String [] args){
		JFrame window = new JFrame("Tetris Game");
		GameBoard content = new GameBoard();
		window.setContentPane(content);
		window.setSize(new Dimension(500,450));
		window.setResizable(false);
		window.setLocation(150,100);
		window.setVisible(true);
		
	}

}
