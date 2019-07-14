package snakes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BoardGame
  extends JPanel
{
  private static final long serialVersionUID = 1L;
  public PanelGame gamePanel;
  /*public ScorePanel scorePanel;
  public EventHandler evtHandler;*/
  public ImageIcon icon;
  public JMenuBar menuBar;
  public JMenuItem play;
  
  public BoardGame()
  {
    setBackground(new Color(0, 0, 139, 110));
    this.gamePanel = new PanelGame();
    /*this.gamePanel.board = this;
    this.scorePanel = new ScorePanel();
    this.scorePanel.gamePanel = this.gamePanel;
    this.evtHandler = new EventHandler();
    this.evtHandler.panel = this.gamePanel;
    this.evtHandler.board = this;
    this.evtHandler.sPanel = this.scorePanel;*/
    
    this.menuBar = new JMenuBar();
    this.menuBar.setBackground(new Color(220, 220, 220, 200));
    
    this.menuBar.setFont(new Font("optima", 2, 12));
    
    JMenu menu = new JMenu("Game");
    
    JMenuItem newGame = new JMenuItem("New Game");
   // newGame.addActionListener(this.evtHandler);
    this.play = new JMenuItem("Play");
    //this.play.addActionListener(this.evtHandler);
    JMenuItem highScore = new JMenuItem("High Scores");
    //highScore.addActionListener(this.evtHandler);
    
    JMenuItem quit = new JMenuItem("Quit");
    //quit.addActionListener(this.evtHandler);
    
    menu.add(newGame);
    menu.add(this.play);
    menu.add(highScore);
    menu.add(quit);
    
    JMenu level = new JMenu("Level");
    
    JMenuItem level1 = new JMenuItem("Level 1");
    //level1.addActionListener(this.evtHandler);
    JMenuItem level2 = new JMenuItem("Level 2");
    //level2.addActionListener(this.evtHandler);
    JMenuItem level3 = new JMenuItem("Level 3");
    //level3.addActionListener(this.evtHandler);
    JMenuItem level4 = new JMenuItem("Level 4");
    //level4.addActionListener(this.evtHandler);
    JMenuItem level5 = new JMenuItem("Level 5");
    //level5.addActionListener(this.evtHandler);
    
    level.add(level1);
    level.add(level2);
    level.add(level3);
    level.add(level4);
    level.add(level5);
    
    JMenu about = new JMenu("About");
    
    JMenuItem developer = new JMenuItem("Developer");
    //developer.addActionListener(this.evtHandler);
    
    JMenuItem abt = new JMenuItem("About");
    //abt.addActionListener(this.evtHandler);
    
    about.add(developer);
    about.add(abt);
    
    this.menuBar.add(menu);
    this.menuBar.add(level);
    this.menuBar.add(about);
    
    setLayout(null);
    
    this.menuBar.setBounds(0, 0, 700, 18);
    //this.gamePanel.setBounds(20, 20, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 50, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 50);
    //this.scorePanel.setBounds(20, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 70, 424, 110);
    
    //add(this.gamePanel);
    ///add(this.scorePanel);
    add(this.menuBar);
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }
  
  public static void main(String[] args)
  {
    JFrame window = new JFrame("Snake Game");
    BoardGame content = new BoardGame();
    window.setContentPane(content);
    window.setLocation(10, 10);
    window.setDefaultCloseOperation(3);
    window.setSize(new Dimension(500, 600));
    window.setResizable(false);
    window.setVisible(true);
  }
}
