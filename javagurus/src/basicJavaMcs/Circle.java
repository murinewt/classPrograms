package basicJavaMcs;

import javax.swing.JOptionPane;

/*
 * Creation Of a Circle
 * Circle.java
 * @author murinewt
 */
public class Circle {
	//we declare instance Variables
	public double x,y;//this is the centre of the circle
	public double r;//radius
	//we create the methods
	public double circumference(){
		return (2.0*Math.PI*r);
	}
	public double area(){
		return (Math.PI*Math.pow(r, 2));
	}
	public double inputData(String inputMessage){
		return Double.parseDouble(JOptionPane.showInputDialog(inputMessage));
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}*/

}
