package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;/*
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;*/

public class EventHandler
  implements KeyListener, ActionListener
{
  GamePanel panel;
  GameBoard board;
  ScorePanel sPanel;
  
  public void keyPressed(KeyEvent evt)
  {
    int code = evt.getKeyCode();
    if ((code == 37) && (!this.panel.movingRight))
    {
      this.panel.movingLeft = true;
      this.panel.movingRight = (this.panel.movingUp = this.panel.movingDown = false);////converted here to false.. it was zero
    }
    else if ((code == 39) && (!this.panel.movingLeft))
    {
      this.panel.movingRight = true;
      this.panel.movingLeft = (this.panel.movingUp = this.panel.movingDown = false);////converted here to false.. it was zero
    }
    else if ((code == 40) && (!this.panel.movingUp))
    {
      this.panel.movingDown = true;
      this.panel.movingRight = (this.panel.movingUp = this.panel.movingLeft = false);////converted here to false.. it was zero
    }
    else if ((code == 38) && (!this.panel.movingDown))
    {
      this.panel.movingUp = true;
      this.panel.movingRight = (this.panel.movingLeft = this.panel.movingDown = false);////converted here to false.. it was zero
    }
  }
  
  public void keyReleased(KeyEvent evt) {}
  
  public void keyTyped(KeyEvent evt) {}
  
  public void actionPerformed(ActionEvent evt)
  {
    String str = evt.getActionCommand();
    if (str.equals("New Game"))
    {
      if (this.panel.gameInProgress)
      {
        this.sPanel.labelMessage.setText("<html><h4 color= red>Stop cheating </h4></html>");
      }
      else
      {
        this.panel.doNewGame();
        
        this.board.play.setEnabled(true);
      }
    }
    else if (str.equals("Play"))
    {
      if (!this.panel.gameInProgress)
      {
        this.panel.gameInProgress = true;
        this.panel.timer.start();
      }
    }
    else if (!str.equals("High Scores")) {
      if (str.equals("Quit")) {
        System.exit(1);
      } else if (str.equals("Level 1"))
      {
        if (!this.panel.gameInProgress) {
          this.panel.block = null;
        }
      }
      else if (str.equals("Level 2"))
      {
        if (!this.panel.gameInProgress) {
          this.panel.block = new Block(1);
        }
      }
      else if (str.equals("Level 3"))
      {
        if (!this.panel.gameInProgress) {
          this.panel.block = new Block(2);
        }
      }
      else if (str.equals("Level 4"))
      {
        if (!this.panel.gameInProgress) {
          this.panel.block = new Block(3);
        }
      }
      else if (str.equals("Level 5"))
      {
        if (!this.panel.gameInProgress) {
          this.panel.block = new Block(4);
        }
      }
      else if (str.equals("Developer"))
      {
        if (!this.panel.gameInProgress) {
          JOptionPane.showMessageDialog(this.panel, "<html><h1 color = red>Welcome to the game</h1></html>");
        }
      }
      else if ((str.equals("About")) && 
        (!this.panel.gameInProgress)) {
        JOptionPane.showMessageDialog(this.panel, "<html> <h2 color= red>THE SNAKE GAME </h2> </br><h3 color = red>CONTROLS</h> <br><div color = green>Use Arrow Keys to move the snake.<br>On launching the game select the level you want to play<br>on the Level menu then,  Click play<br><br>Once you have crushed :<br>1. Click the new game(New Game) menu on the game(Game) menu.<br>2. Select the level.<br>3. Then play<br></div></html>");
      }
    }
  }
}
