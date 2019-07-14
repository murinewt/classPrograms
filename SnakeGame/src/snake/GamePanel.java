package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.net.URL;
import javax.swing.*;/*
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;*/

public class GamePanel
  extends JPanel
{
  private static final long serialVersionUID = 1L;
  public static int BOARD_SIZE = 25;
  public static int SQUARE_SIZE = 15;
  public Snake snake;
  public byte[][] boardState;
  public boolean gameInProgress;
  public int score;
  public String message;
  public Timer timer;
  public EventHandler eventHandler;
  public boolean movingDown;
  public boolean movingRight;
  public boolean movingLeft;
  public boolean movingUp;
  public boolean animation;
  public Location foodLocation;
  public Image im;
  public Image obstacle;
  public Block block;
  GameBoard board;
  public Image bgImage;
  public FileManager saveManager;
  public FileManager scoreManager;
  public File saveFile;
  public File highScoreFile;
  
  public GamePanel()
  {
    doNewGame();
  }
  
  public void doNewGame()
  {
    setBackground(new Color(224, 255, 255));
    this.snake = new Snake(4);
    this.gameInProgress = false;
    this.score = 0;
    this.message = "Welcome to the snake game";
    this.eventHandler = new EventHandler();
    this.eventHandler.panel = this;
    this.movingLeft = true;
    this.movingRight = (this.movingDown = this.movingUp = this.animation = false);////converted here to false.. it was zero
    this.foodLocation = new Location(3, 4);
    this.block = null;
    
    this.saveFile = new File("save.txt");
    
    this.highScoreFile = new File("C:\\Users\\user\\workspace\\Snake Game\\score.txt");
    
    this.scoreManager = new FileManager(this.highScoreFile, false);
    this.scoreManager.panel = this;
    
    addKeyListener(this.eventHandler);
    setFocusable(true);
    if (this.timer == null)
    {
      ActionListener action = new ActionListener()
      {
        public void actionPerformed(ActionEvent evt)
        {
          GamePanel.this.repaint();
        }
      };
      this.timer = new Timer(200, action);
      this.timer.start();
    }
    else if (!this.gameInProgress)
    {
      this.timer.restart();
    }
    this.boardState = new byte[BOARD_SIZE][BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        this.boardState[i][j] = 0;
      }
    }
    createBlockBackground();
    createObstacle();
    loadImage();
  }
  
  public void createBlockBackground()
  {
    int width = SQUARE_SIZE;
    int height = SQUARE_SIZE;
    int[] pixels = new int[width * height];
    
    int index = 0;
    for (int y = 0; y < height; y++)
    {
      int numerator = y * 255;
      int b = numerator / height;
      int r = 255 - numerator / height;
      for (int x = 0; x < width; x++)
      {
        int g = x * (255 / width);
        pixels[(index++)] = (0xFC000000 | r >> 11 | g >> 11 | b);
      }
    }
    this.im = createImage(new MemoryImageSource(width, height, pixels, 0, width));
  }
  
  public void createObstacle()
  {
    int width = SQUARE_SIZE;
    int height = SQUARE_SIZE;
    int[] pixels = new int[width * height];
    
    int index = 0;
    for (int i = 0; i < height; i++)
    {
      int numerator = i * 255;
      int b = numerator / height;
      for (int j = 0; j < width; j++)
      {
        int g = j * (255 / width);
        
        pixels[(index++)] = (b << 33 | g << 10 | 0xFF000000);
      }
    }
    this.obstacle = createImage(new MemoryImageSource(width, height, pixels, 0, width));
  }
  
  public void setBoardState()
  {
    for (int i = 0; i < this.snake.size(); i++)
    {
      Location loc = this.snake.get(i);
      
      this.boardState[loc.row][loc.column] = 2;
    }
  }
  
  public void clearBoardState()
  {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if ((i < 2) || (i >= BOARD_SIZE - 2) || (j < 2) || (j >= BOARD_SIZE - 2)) {
          this.boardState[i][j] = 3;
        } else {
          this.boardState[i][j] = 0;
        }
      }
    }
    if (this.block != null) {
      for (int k = 0; k < this.block.blockLocation.length; k++)
      {
        Location loc = this.block.blockLocation[k];
        this.boardState[loc.row][loc.column] = 3;
      }
    }
    this.boardState[this.foodLocation.row][this.foodLocation.column] = 1;
  }
  
  public void updateSnake()
  {
    Snake newSnake = new Snake(this.snake.size());
    for (int i = 0; i < this.snake.size(); i++)
    {
      Location loc = this.snake.get(i);
      newSnake.set(i, new Location(loc.row, loc.column));
    }
    for (int i = 1; i < this.snake.size(); i++)
    {
      Location loc = newSnake.get(i - 1);
      this.snake.set(i, new Location(loc.row, loc.column));
    }
  }
  
  public boolean canPlayerMakeMove()
  {
    Location loc = this.snake.get(0);
    this.message = "Welcome to the snake game";
    if ((this.movingLeft) && (this.boardState[loc.row][(loc.column - 1)] < 2))
    {
      if (this.boardState[loc.row][(loc.column - 1)] == 1) {
        eat();
      }
      return true;
    }
    if ((this.movingRight) && (this.boardState[loc.row][(loc.column + 1)] < 2))
    {
      if (this.boardState[loc.row][(loc.column + 1)] == 1) {
        eat();
      }
      return true;
    }
    if ((this.movingUp) && (this.boardState[(loc.row - 1)][loc.column] < 2))
    {
      if (this.boardState[(loc.row - 1)][loc.column] == 1) {
        eat();
      }
      return true;
    }
    if ((this.movingDown) && (this.boardState[(loc.row + 1)][loc.column] < 2))
    {
      if (this.boardState[(loc.row + 1)][loc.column] == 1) {
        eat();
      }
      return true;
    }
    this.message = "GAME OVER. For more info: go to the About menu";
    this.gameInProgress = false;
    if (this.scoreManager.checkIfAHighScore(this.score))
    {
      this.scoreManager.InsertScore(this.score);
      this.scoreManager.writeScore();
    }
    this.animation = true;
    this.board.play.setEnabled(false);
    
    return false;
  }
  
  public void generateFood()
  {
    int i = (int)(Math.random() * 20.0D) + 2;
    int j = (int)(Math.random() * 20.0D) + 2;
    for (;;)
    {
      if (this.boardState[i][j] == 0)
      {
        this.foodLocation = new Location(i, j);
        break;
      }
      if (this.boardState[j][i] == 0)
      {
        this.foodLocation = new Location(j, i);
        break;
      }
      if (this.boardState[i][i] == 0)
      {
        this.foodLocation = new Location(i, i);
        break;
      }
      if (this.boardState[j][j] == 0)
      {
        this.foodLocation = new Location(j, j);
        break;
      }
      i = (int)(Math.random() * 20.0D) + 2;
      j = (int)(Math.random() * 20.0D) + 2;
    }
  }
  
  public void eat()
  {
    this.snake.increament(new Location(this.foodLocation.row, this.foodLocation.column));
    this.score += 10;
    this.message = "You scored";
    generateFood();
  }
  
  public void move()
  {
    updateSnake();
    if (canPlayerMakeMove())
    {
      Location loc = this.snake.get(0);
      if (this.movingLeft) {
        this.snake.set(0, new Location(loc.row, loc.column - 1));
      } else if (this.movingRight) {
        this.snake.set(0, new Location(loc.row, loc.column + 1));
      } else if (this.movingUp) {
        this.snake.set(0, new Location(loc.row - 1, loc.column));
      } else if (this.movingDown) {
        this.snake.set(0, new Location(loc.row + 1, loc.column));
      }
    }
    clearBoardState();
    setBoardState();
  }
  
  private void loadImage()
  {
    ClassLoader cl = getClass().getClassLoader();
    URL imageURL = cl.getResource("snake/image/bgImage.jpg");
    if (imageURL != null) {
      this.bgImage = Toolkit.getDefaultToolkit().createImage(imageURL);
    }
  }
  
  public String displayHighScore()
  {
    this.scoreManager.readFile();
    
    String str = "<html> <h3 color = green> HIGH SCORES </h3> </br> <ol size= 15; color = red >";
    for (int i = 0; i < this.scoreManager.array.length; i++) {
      str = str + "<li>" + this.scoreManager.array[i];
    }
    str = str + "</ol> </html>";
    return str;
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawRect(20, 20, 25 * SQUARE_SIZE, 25 * SQUARE_SIZE);
    g.drawRect(18, 18, 25 * SQUARE_SIZE + 4, 25 * SQUARE_SIZE + 4);
    if (this.gameInProgress)
    {
      move();
      for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++)
        {
          Location loc = this.snake.get(0);
          if (this.boardState[i][j] == 0)
          {
            g.setColor(Color.YELLOW);
            g.drawRect(j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE);
          }
          else if (this.boardState[i][j] == 1)
          {
            g.setColor(new Color(139, 0, 0, (int)(Math.random() * 120.0D) + 135));
            g.fillOval(j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE);
          }
          else if (this.boardState[i][j] == 2)
          {
            if ((i == loc.row) && (j == loc.column))
            {
              g.setColor(new Color(0, 100, 0));
              g.fillRect(j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE);
              g.drawRect(j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE);
              g.setColor(Color.RED);
              if (this.movingLeft)
              {
                g.fillOval(j * SQUARE_SIZE + 18, i * SQUARE_SIZE + 21, 5, 5);
                g.fillOval(j * SQUARE_SIZE + 18, i * SQUARE_SIZE + 28, 5, 5);
              }
              else if (this.movingRight)
              {
                g.fillOval(j * SQUARE_SIZE + (16 + SQUARE_SIZE), i * SQUARE_SIZE + 21, 5, 5);
                g.fillOval(j * SQUARE_SIZE + (16 + SQUARE_SIZE), i * SQUARE_SIZE + 28, 5, 5);
              }
              else if (this.movingUp)
              {
                g.fillOval(j * SQUARE_SIZE + 21, i * SQUARE_SIZE + 18, 5, 5);
                g.fillOval(j * SQUARE_SIZE + 28, i * SQUARE_SIZE + 18, 5, 5);
              }
              else if (this.movingDown)
              {
                g.fillOval(j * SQUARE_SIZE + 21, i * SQUARE_SIZE + (16 + SQUARE_SIZE), 5, 5);
                g.fillOval(j * SQUARE_SIZE + 28, i * SQUARE_SIZE + (16 + SQUARE_SIZE), 5, 5);
              }
            }
            else
            {
              g.drawImage(this.im, j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE, this);
              g.setColor(Color.BLACK);
              g.drawRect(j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE);
            }
          }
          else if (this.boardState[i][j] == 3)
          {
            g.setColor(new Color(95, 158, 160, 200));
            
            g.drawImage(this.obstacle, j * SQUARE_SIZE + 20, i * SQUARE_SIZE + 20, SQUARE_SIZE, SQUARE_SIZE, this);
          }
        }
      }
    }
    else if (this.animation)
    {
      if (this.bgImage != null)
      {
        g.setColor(Color.BLACK);
        g.fillRect(20, 20, 25 * SQUARE_SIZE, 25 * SQUARE_SIZE);
        g.drawImage(this.bgImage, 70, 120, 19 * SQUARE_SIZE, 12 * SQUARE_SIZE, this);
      }
      this.timer.stop();
    }
  }
}
