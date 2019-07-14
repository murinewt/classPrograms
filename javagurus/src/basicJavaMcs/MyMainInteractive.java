package basicJavaMcs;
/*
 * Creation Of a Circle
 * Circle.java
 * @author murinewt
 */
import javax.swing.*;

public class MyMainInteractive {
	public static void main(String[] args) {
		JTextArea myArea=new JTextArea(10,10);
		myArea.setText("The Circle Details\n");
		Circle aCircle=new Circle();
		aCircle.x=aCircle.inputData("Enter the value of x: ");
		aCircle.y=aCircle.inputData("Enter the value of y: ");
		aCircle.r=aCircle.inputData("Enter the value of r: ");
		myArea.append("Radius: "+aCircle.r+" Circumference: "+aCircle.circumference()+"\n"+
				"Radius: "+aCircle.r+" Area: "+aCircle.area());
		JOptionPane.showMessageDialog(null, myArea,"Circle Computations",JOptionPane.PLAIN_MESSAGE);
	}
}