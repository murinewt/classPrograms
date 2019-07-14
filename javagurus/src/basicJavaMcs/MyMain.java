package basicJavaMcs;

/**
 * this is the user class
 * @author user
 *
 */
import javax.swing.*;
public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create an object of JTextArea
		JTextArea myArea=new JTextArea(10,10);
		myArea.setText("The Circle Details\n");
		Circle aCircle;
		aCircle = new Circle();// object creation or instantiation
		//Circle bCircle = new Circle();
		aCircle.x=10;
		aCircle.y=20;
		aCircle.r=5;
		myArea.append("Radius: "+aCircle.r+" Circumference: "+aCircle.circumference()+"\n"+
				"Radius: "+aCircle.r+" Area: "+aCircle.area());
		//myArea.append("\n\t\t\tEND\t\t\t");
		JOptionPane.showMessageDialog(null, myArea,"Circle Computations",JOptionPane.PLAIN_MESSAGE);
		
		/*String output="Radius: "+aCircle.r+" Circumference: "+aCircle.circumference()+"\n"+
				"Radius: "+aCircle.r+" Area: "+aCircle.area();
		JOptionPane.showMessageDialog(null, output,"Circle Computations",JOptionPane.PLAIN_MESSAGE);*/
		
		//System.out.println();
		//System.out.println(");
	}

}
