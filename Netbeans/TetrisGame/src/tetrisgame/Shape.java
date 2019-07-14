/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

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
			/* +1
			 *    #
			 *    #
			 *    ##
			 * +2    
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		if (x==2){
			/* +2
			 *  ###
			 *  #
			 *+1
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==3){
			/* +1
			 *  ##
			 *   #
			 *   #
			 *+2
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==4){
			/* +2 -1
			 * 	  #
			 * 	###
			 * +1	  
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if (x==5){
			/* +1
			 *    #
			 *    #
			 *   ##
			 *+0
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE-SIZE, SIZE, SIZE);
		}
		
		else if (x==6){
			/* +2
			 *  #
			 *  ###
			 *+1
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==7){
			/* +1
			 *  ##
			 *  #
			 *  #
			 *+2
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==8){
			/*+2
			 * ###
			 *   #
			 *+1
			 */ 
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==9){
			/*+1
			 *  ##
			 *  ##
			 *+1
			 */  
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==10){
			/*+3
			 *  ####
			 *+0
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE+SIZE, yPoint, SIZE, SIZE);
		}
		
		else if (x==11){
			/*+0
			 *  #
			 *  #
			 *  #
			 *  #
			 * +3
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if (x==12){
			/*+2
			 *  ##
			 *   ##
			 *+1
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if (x==13){
			/*+1-2
			 *    #
			 *   ##
			 *   #
			 *+0
			 */
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE-SIZE, SIZE, SIZE);
		}
		
		else if (x==14){
			/*+2-1
			 *   ##
			 *  ##
			 *+0 
			 */ 
			 
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if (x==15){
			/*+1
			 *   #
			 *   ##
			 *    #
			 * +2
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE+SIZE, SIZE, SIZE);
		}
		
		else if(x==16){
			/*+2
			 *  ###
			 *   #
			 * +1 
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		else if(x==17){
			/*+1-1
			 *   #
			 *  ##
			 *   #
			 *+1  
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
		else if(x==18){
			/*+2-1
			 *   #
			 *  ###  
			 *  +0
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE+SIZE, yPoint, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint-SIZE, SIZE, SIZE);
		}
		
		else if(x==19){
			/*+1
			 *   #
			 *   ##
			 *   #
			 * +2 
			 */
			g.fillRect(xPoint, yPoint, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE, SIZE, SIZE);
			g.fillRect(xPoint, yPoint+SIZE+SIZE, SIZE, SIZE);
			g.fillRect(xPoint+SIZE, yPoint+SIZE, SIZE, SIZE);
		}
		
	}
}
