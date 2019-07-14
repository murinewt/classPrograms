package examples;

import javax.swing.*;
//import java.awt.*;

public class RandomStrings {
	public static void main(String[] args) {
		//JPanel panel = new JPanel();
		RepaintOnClick listener = new RepaintOnClick(); // Create MouseListener object.
		//panel // Register MouseListener with the panel.
		
		JFrame window = new JFrame("Java!");
		RandomStringsPanel content = new RandomStringsPanel();
		content.addMouseListener(listener);
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120,70);
		window.setSize(350,250);
		window.setVisible(true);
	}
}