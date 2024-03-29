package GUIProg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class HelloAge extends JFrame implements ActionListener {
	
	JTextField nameTxt = new JTextField(10);
	JTextField ageTxt = new JTextField(2);
	JCheckBox male=new JCheckBox("Male");
	JTextArea output = new JTextArea(2,30);
	JButton ok = new JButton("OK");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HelloAge();

	}

	public HelloAge() {
		setLayout(new FlowLayout());
		setSize(600, 120);
		setTitle("Hello Age");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new Label("Type your Name: "));
		add(nameTxt);
		add(new Label("  Type your Age: "));
		add(ageTxt);
		add(male);
		add(ok);
		ok.addActionListener(this);
		add(output);
		output.setEditable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		// add you event handling code here
		String name = nameTxt.getText();
		int age = Integer.parseInt(ageTxt.getText());
		
		String title;
		if(male.isSelected()&&age>=18) title = "Mr. ";
		else if(male.isSelected()&&age<18) title = "Master ";
		else if(!male.isSelected()&&age>=18) title = "Ms. ";
		else title = "miss ";
		String pass;
		if(age<=25)
			pass="\nYou are entitled to a young person railcard";
		else if(age>60)
			pass="\nYou are entitled to a freedom pass";
		else
			pass="\nYou are not entitled to any pass";
		String message="Hello "+age+" year old "+title +name +pass;
		output.setText(message);
	}
}
