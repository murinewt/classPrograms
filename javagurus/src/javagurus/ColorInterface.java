package javagurus;
import java.applet.Applet;
import java.awt.*;
import java.lang.reflect.Field;

@SuppressWarnings("serial")
public class ColorInterface extends Applet{
	TextField textBoxInt1,textBoxInt2,textBoxInt3,textBoxColor1,textBoxColor2,textBoxColor3;
	
	public static Color getColorByString(String colorName){
		
		try{
			Field f1= Color.class.getField(colorName.toUpperCase());
			return (Color)f1.get(null);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void init()
	{
		textBoxInt1 = new TextField(10);
		textBoxInt2 = new TextField(10);
		textBoxInt3 = new TextField(10);
		textBoxColor1 = new TextField(10);
		textBoxColor2 = new TextField(10);
		textBoxColor3 = new TextField(10);
		add(textBoxInt1);add(textBoxInt2);add(textBoxInt3);
		add(textBoxColor1);add(textBoxColor2);add(textBoxColor3);
		setLayout(null);
		textBoxInt1.setBounds(120, 10, 150, 20);
		textBoxInt2.setBounds(120, 40, 150, 20);
		textBoxInt3.setBounds(120, 70, 150, 20);
		textBoxColor1.setBounds(450, 10, 150, 20);
		textBoxColor2.setBounds(450, 40, 150, 20);
		textBoxColor3.setBounds(450, 70, 150, 20);
	}

	public void paint(Graphics newt){
		int stringToInt1=0,stringToInt2=0,stringToInt3=0;
		String getStringInt1,getStringInt2,getStringInt3;
		String getStringColor1,getStringColor2,getStringColor3;
		newt.drawString("First Input: ",40,20);
		newt.drawString("Colour:", 400, 20);
		newt.drawString("Second Input: ",40,50);
		newt.drawString("Colour:", 400, 50);
		newt.drawString("Third Input: ",40,80);
		newt.drawString("Colour:", 400, 80);
		
		try{
			getStringInt1 = textBoxInt1.getText();
			stringToInt1 = Integer.parseInt(getStringInt1);
			getStringInt2 = textBoxInt2.getText();
			stringToInt2 = Integer.parseInt(getStringInt2);
			getStringInt3 = textBoxInt3.getText();
			stringToInt3 = Integer.parseInt(getStringInt3);	
		}
		catch(Exception e1)
		{ }
		getStringColor1 = textBoxColor1.getText();
		getStringColor2 = textBoxColor2.getText();
		getStringColor3 = textBoxColor3.getText();
		
		newt.drawLine(49, 600, 49, 190);
		newt.drawLine(50, 600, 295, 600);
		int yCord=20;
		for(int x=10;x<=30;x++){	
			newt.drawString(""+yCord, 29, x*20+5);
			newt.drawString("_", 43, x*20-1);
			yCord=yCord-1;
		}
		newt.setColor(getColorByString(getStringColor1));
		newt.fillRect(50, (600-stringToInt1*20), 80, stringToInt1*20);
		newt.drawString(""+getStringColor1, 52, 610);
		newt.setColor(getColorByString(getStringColor2));
		newt.fillRect(130, (600-stringToInt2*20), 80, stringToInt2*20);
		newt.drawString(""+getStringColor2, 132, 610);
		newt.setColor(getColorByString(getStringColor3));
		newt.fillRect(210, (600-stringToInt3*20), 80, stringToInt3*20);
		newt.drawString(""+getStringColor3, 212, 610);
		
	}
	
	public boolean action(Event ev, Object obj)
	{
		repaint();
		return true;
	}
	
}
