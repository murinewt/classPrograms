package dec;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimeDate extends JPanel implements ActionListener{
	Date date;
	Timer time;
	String text=" ";
	static TimeDate drawingArea = new TimeDate();
	public TimeDate(){
		Timer frameTime = new Timer(100,this);
		frameTime.start();
		repaint();
	}

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	JFrame window = new JFrame("Time");
   		drawingArea.setBackground(Color.white);
   		window.setContentPane(drawingArea);
   		drawingArea.setPreferredSize(new Dimension(500,500));
   		window.pack();
   		window.setLocation(500,100);
   		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		window.setResizable(true);
   		window.setVisible(true);
    }
    
    protected void paintComponent(Graphics g){
		super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.setFont( new Font("Serif", Font.PLAIN, 36  ));
        g.drawString(text, 10, 200);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
    
    @Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        date= new Date();
        text = " "+date;
	}
}
