package javagurus;
import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class MathSecond extends Applet{
	int intOne=10;
	
	/*public void init(){
		
		intOne = Integer.parseInt(getParameter("oneInt"));
		
	}*/
	public void paint(Graphics newt){
		int cordX= 50;
		int xCordOne = 10, xCordTwo = 10, xCordThree = 10;
		int yCord = 12;
		
		for(int y=1;y<=intOne;y++){
			if(y<=3){
				for (int i=1; i<10;i++){
					newt.drawString(i+".  "+(y)+" * "+i+" = "+(i*y),cordX+xCordOne , (10+yCord*i));
				}xCordOne= xCordOne+150;	
			}
			else if(y>3 && y<=6){
				for (int i=1; i<10;i++){
					newt.drawString(i+".  "+(y)+" * "+i+" = "+(i*y),cordX+xCordTwo ,(140+ (yCord*i)));
				}xCordTwo = xCordTwo+150;
			}
			else if(y>6 && y<=9){
				for (int i=1; i<10;i++){
					newt.drawString(i+".  "+(y)+" * "+i+" = "+(i*y),cordX+xCordThree , (270+(yCord*i)));
				}xCordThree = xCordThree+150;
			}
			else{
				newt.drawString("END!!!",10,450);
			}
		}
		
		newt.drawLine(cordX+2, 2, cordX+2, 390);
		newt.drawLine(cordX+121, 2, cordX+121, 390);
		newt.drawLine(cordX+125, 2, cordX+125, 390);
		newt.drawLine(cordX+271, 2, cordX+271, 390);
		newt.drawLine(cordX+275, 2,cordX+275, 390);
		newt.drawLine(cordX+400, 2, cordX+400, 390);
		
		//horizontal
		newt.drawLine(cordX+2, 2, cordX+400, 2);
		newt.drawLine(cordX+2, 128, cordX+400, 128);
		newt.drawLine(cordX+2, 132, cordX+400, 132);
		newt.drawLine(cordX+2, 258, cordX+400, 258);
		newt.drawLine(cordX+2, 262, cordX+400, 262);
		newt.drawLine(cordX+2, 390, cordX+400, 390);
	}
}
