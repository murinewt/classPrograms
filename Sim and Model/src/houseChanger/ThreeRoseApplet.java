package houseChanger;
import java.awt.*; import java.applet.Applet; 
public class ThreeRoseApplet extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* declare three variables with which to instantiate      three Rose object in the init() method */   
	Roses Rose1, Rose2, Rose3;
	public void init() {     
		Rose1 = new Roses(); // create first RedRose object 
		Rose2 = new Roses(); // create second RedRose object 
		Rose3 = new Roses(); // create second RedRose object }
	}
	public void paint( Graphics g ) { 
		Rose1.paintRose(g,10,10); // draw first RedRose
		Rose2.backGroundColor = Color.blue; // use a blue background color 
		Rose2.petalColor = Color.yellow; // use a yellow petal color 
		Rose2.paintRose(g,200,10); // draw another RedRose
		Rose3.backGroundColor = Color.orange; // use a orange background color 
		Rose3.petalColor = Color.pink; // use a pink petal color 
		Rose3.paintRose(g,400,10); // draw another RedRose 
	} 
}