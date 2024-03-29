package tetrisNewton;

//import java.awt.*;
import java.awt.Graphics;

public class Shape {

	
	public static int xPoint,yPoint;
	public final static int SIZE = 20;
	static int x;
	
	public Shape(int xOnly , int y){
		xPoint = xOnly;
		yPoint = y;
	}

 //@SuppressWarnings("static-access")
	public void draw( Graphics g, int xy ) {
		x=xy;
		if (x==1){
			/*
			 *    #
			 *    #
			 *    ##
			 *     
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		if (x==2){
			/*
			 * 	###
			 *  #
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==3){
			/*
			 *  ##
			 *   #
			 *   #
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==4){
			/*
			 * 	  #
			 * 	###
			 * 	  
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if (x==5){
			/*
			 * 	  #
			 *    #
			 *   ##
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE-SIZE, SIZE, SIZE);
		}
		
		else if (x==6){
			/*
			 *  #
			 *  ###
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==7){
			/*
			 *  ##
			 *  #
			 *  #
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==8){
			/*
			 * ###
			 *   #
			 *
			 */ 
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==9){
			/*
			 *  ##
			 *  ##
			 *
			 */  
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==10){
			/*
			 *  ####
			 *
			 *  
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE+SIZE, yPoint, SIZE, SIZE);
		}
		
		else if (x==11){
			/*
			 *  #
			 *  #
			 *  #
			 *  #
			 * 
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==12){
			/*
			 *  ##
			 *   ##
			 *  
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==13){
			/*
			 *    #
			 *   ##
			 *   #
			 *
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE-SIZE, SIZE, SIZE);
		}
		
		else if (x==14){
			/*
			 *   ##
			 *  ##
			 * 
			 */ 
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if (x==15){
			/*
			 *   #
			 *   ##
			 *    #
			 * 
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if(x==16){
			/*
			 *  ###
			 *   #
			 *  
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if(x==17){
			/*
			 *   #
			 *   ##
			 *   #
			 *  
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if(x==18){
			/*
			 *   #
			 *  ###  
			 *  
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if(x==19){
			/*
			 *   #
			 *  ##
			 *   #
			 *  
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
	}
}
