package javagurus;
import java.applet.Applet;
import java.awt.*;
//import java.lang.reflect.Field;

@SuppressWarnings("serial")
public class MichaelColor extends Applet{
	TextField s1,s2,s3,c1,c2,c3;
	public static Color getColorByString(String colorName){
		
		String nameColor = colorName.toUpperCase();
		switch(nameColor){
			case "BLACK":
				return Color.BLACK;
			case "CYAN":
				return Color.CYAN;
			case "GRAY":
				return Color.GRAY;
			case "MAGENTA":
				return Color.MAGENTA;
			case "WHITE":
				return Color.WHITE;
			case "YELLOW":
				return Color.YELLOW;
			case "ORANGE":
				return Color.ORANGE;
			case "RED":
				return Color.RED;
			case "GREEN":
				return Color.GREEN;
			case "PINK":
				return Color.pink;
			case "LIGHTGRAY":
				return Color.LIGHT_GRAY;
			case "BLUE":
				return Color.BLUE;
			case "DARKGRAY":
				return Color.DARK_GRAY;
			default:
				return Color.BLACK;
		}
		
		/*
		try{
			Field f1= Color.class.getField(colorName.toUpperCase());
			return (Color)f1.get(null);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}*/
	}
	
	public void init()
	{
		s1 = new TextField(10);
		s2 = new TextField(10);
		s3 = new TextField(10);
		c1 = new TextField(10);
		c2 = new TextField(10);
		c3 = new TextField(10);
		add(s1);add(s2);add(s3);add(c1);add(c2);add(c3);
		setLayout(null);
		s1.setBounds(120, 10, 150, 20);
		s2.setBounds(120, 40, 150, 20);
		s3.setBounds(120, 70, 150, 20);
		c1.setBounds(450, 10, 150, 20);
		c2.setBounds(450, 40, 150, 20);
		c3.setBounds(450, 70, 150, 20);
		
	}
	public static Color makeColor(TextField myField){
		String str = myField.getText();
		String newStr;
		try{
			newStr = str.toUpperCase();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			return null;
		}
		
		switch(newStr){
		case "GREEN":
			return Color.GREEN;
		default:
			return Color.BLUE;
		}	
	}

	public void paint(Graphics newt){
		int ss1=0,ss2=0,ss3=0;
		//int yCordinate = 600;
		//int nextYPos = 20;
		//int xCordinate = 50;
		String sStr1,sStr2,sStr3;
		String cStr1,cStr2,cStr3;
		newt.drawString("First Input: ",40,20);
		newt.drawString("Colour:", 400, 20);
		newt.drawString("Second Input: ",40,50);
		newt.drawString("Colour:", 400, 50);
		newt.drawString("Third Input: ",40,80);
		newt.drawString("Colour:", 400, 80);
		try{
			sStr1 = s1.getText();
			ss1 = Integer.parseInt(sStr1);
			sStr2 = s2.getText();
			ss2 = Integer.parseInt(sStr2);
			sStr3 = s3.getText();
			ss3 = Integer.parseInt(sStr3);	
		}
		catch(Exception e1)
		{ }
		cStr1 = c1.getText();
		cStr2 = c2.getText();
		cStr3 = c3.getText();
		
		Color mine = makeColor(c1);
		newt.setColor(mine);
		newt.setColor(getColorByString(cStr1));
		newt.fillRect(50, (600-ss1*20), 50, ss1*20);
		newt.setColor(getColorByString(cStr2));
		newt.fillRect(100, (600-ss2*20), 50, ss2*20);
		newt.setColor(getColorByString(cStr3));
		newt.fillRect(150, (600-ss3*20), 50, ss3*20);
		
	}
	
	public boolean action(Event ev, Object obj)
	{
		repaint();
		return true;
	}
	
}
