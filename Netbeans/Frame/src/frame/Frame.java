package frame;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame();

	}

	public Frame() {
		setLayout(new FlowLayout());
		setSize(600, 500);
		setTitle("Just A Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
