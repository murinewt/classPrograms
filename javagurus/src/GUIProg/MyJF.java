package GUIProg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyJF extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyJF();

	}

	public MyJF() {
		setLayout(new BorderLayout());
		setSize(400, 300);
		setTitle("Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		// add you event handling code here
	}
}
