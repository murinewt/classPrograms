package dec;
/****
 * unable to do with jframe
 * aki its hard
 */


//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
* This program simply demonstrates using a JTextArea in a JScrollPane.
*/
@SuppressWarnings("serial")
public class TimeDateJframe extends JFrame implements ActionListener {

	JLabel field;
	Timer time;
	static Date date = new Date();
	String now=""+date;
	
	TimeDateJframe(){
		getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());
        setResizable(true);
        setLocation(200,50);
        setSize(1050, 650);
        setTitle("Time");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        field = new JLabel(now);
        add(field);
        //}
        time = new Timer(100,(ActionListener) this);
		time.start();
        //field.setEditable(false);
        setVisible(true);repaint();
	}
	
	public static void main(String[] args){
		
		new TimeDateJframe();
		//getContentPane().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
        
	}
}
