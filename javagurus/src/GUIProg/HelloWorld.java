package GUIProg;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class HelloWorld extends JFrame
					implements ActionListener
{
	JTextField anotherField = new JTextField(30);
	JTextField helloText = new JTextField(10);
	JButton helloButton = new JButton("Press Me!");
	JButton anotherButton = new JButton("don't press me");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		HelloWorld jf = new HelloWorld();

	}
	public HelloWorld(){
		setLayout(new FlowLayout());
		setSize(400,300);
		setTitle("Hello");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(helloText);
		add(helloButton);
		add(anotherField);
		add(anotherButton);
		helloButton.addActionListener(this);
		anotherField.addActionListener(this);
		anotherField.addActionListener(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		//add you event handling code here
		helloText.setText("Hello World");
		anotherField.setText("am feeling very hungry!!!!!!");
	}
}
