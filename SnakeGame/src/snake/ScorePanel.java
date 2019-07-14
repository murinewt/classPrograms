package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScorePanel
  extends JPanel
{
  private static final long serialVersionUID = 1L;
  GamePanel gamePanel;
  public JLabel labelScore;
  public JLabel labelMessage;
  public Timer timer;
  
  public ScorePanel()
  {
    setBackground(new Color(255, 255, 255));
    setPreferredSize(new Dimension(400, 100));
    setForeground(Color.BLACK);
    setFont(new Font("optima", 0, 14));
    
    setLayout(null);
    this.labelScore = new JLabel();
    this.labelMessage = new JLabel();
    this.labelScore.setBorder(BorderFactory.createTitledBorder("Your Score"));
    this.labelMessage.setBorder(BorderFactory.createTitledBorder("Important message"));
    this.labelScore.setBounds(10, 5, 400, 50);
    
    this.labelMessage.setBounds(10, 55, 400, 50);
    
    add(this.labelMessage);
    add(this.labelScore);
    
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        ScorePanel.this.repaint();
      }
    };
    this.timer = new Timer(400, action);
    this.timer.start();
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setFont(new Font("optima", 0, 12));
    this.labelMessage.setText(this.gamePanel.message);
    this.labelScore.setText(" " + this.gamePanel.score);
  }
}
