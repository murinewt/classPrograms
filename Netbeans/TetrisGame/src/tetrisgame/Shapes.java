/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import static tetrisgame.Board.rand;

public class Shapes {
	static Shape shapes;
	static Graphics g;
	public int xPoint,yPoint;
	public final static int SIZE = 20;
	//boolean left,right,down;
	static int direction = 10;
	int x=2;
	static boolean left, right; 
	static boolean down = true;
        public static boolean downAgain = false;
	Board Board;
	int rand = (int)(Math.random() * 19)+1;
	
	public Shapes(int xOnly , int y){
		xPoint = xOnly;
		yPoint = y;
		
	}
	
	public Shapes(){
		shapes  = new Shape(210,30);
		left=right=false;
		down=true;
	}
        public static void moveDownFaster(){
            Shape.yPoint = Shape.yPoint+40;
        }
	
	public static void moveLeft(){
		Shape.xPoint = Shape.xPoint - direction;
		//Shape.draw(g, 1);
		left=true;
	}
	
	public static void moveRight(){
		Shape.xPoint = Shape.xPoint + direction;
		//Shape.draw(g, 1);
		right=true;
	}
	
	public void move(){
		if(left==true){
			moveLeft();
		}
		else if(right==true){
			moveRight();
		}	
	}// end of move*/

	@SuppressWarnings("static-access")
	public int rotate(){
		if(Board.rand==1||Board.rand==2 || Board.rand==3 || Board.rand==4){
                   // g.setColor(Color.red);
			if(Board.rand==1)
				return 2;
			else if(Board.rand==2)
				return 3;
			else if(Board.rand==3)
				return 4;
			else if(Board.rand==4)
				return 1;
		}
		else if(Board.rand==5||Board.rand==6||Board.rand==7||Board.rand==8){
                   // g.setColor(Color.blue);
			if(Board.rand==5)
				return 6;
			else if(Board.rand==6)
				return 7;
			else if(Board.rand==7)
				return 8;
			else if(Board.rand==8)
				return 5;
		}
		else if(Board.rand==10||Board.rand==11){
                  //  g.setColor(Color.yellow);
			if(Board.rand==10)
				return 11;
			else if(Board.rand==11)
				return 10;
		}
		else if(Board.rand==12||Board.rand==13){
                    //g.setColor(Color.PINK);
			if(Board.rand==12)
				return 13;
			else if(Board.rand==13)
				return 12;
		}
		else if(Board.rand==14||Board.rand==15){
//                    g.setColor(Color.LIGHT_GRAY);
			if(Board.rand==14)
				return 15;
			else if(Board.rand==15)
				return 14;
		}
		else if(Board.rand==16||Board.rand==17||Board.rand==18||Board.rand==19){
                   // g.setColor(Color.cyan);
			if(Board.rand==16)
				return 17;
			else if(Board.rand==17)
				return 18;
			else if(Board.rand==18)
				return  19;
			else if(Board.rand==19)
				return 16;
		}
		else 
			 Board.rand = (int)(Math.random() * 19)+1;
		return Board.rand;
	}
	
	public void stoplength(){
            int xplus =410;
           // if(Shape.xPoint>=xplus){
                if(Board.rand==11){
                    if(Shape.xPoint+SIZE>=xplus)
                        Shape.xPoint = xplus-SIZE;
                        
                }
                if(Board.rand==1||Board.rand==3||Board.rand==5||Board.rand==7||Board.rand==9||Board.rand==13||Board.rand==15||Board.rand==17||Board.rand==19){
                    if(Shape.xPoint+SIZE+SIZE>=xplus)
                        Shape.xPoint = xplus-SIZE-SIZE;
                }
                if(Board.rand==2||Board.rand==4||Board.rand==6||Board.rand==8||Board.rand==12||Board.rand==14||Board.rand==16||Board.rand==18){
                    if(Shape.xPoint+SIZE+SIZE+SIZE>=xplus)
                        Shape.xPoint = xplus-SIZE-SIZE-SIZE;
                    
                }
                if(Board.rand==10){
                    if(Shape.xPoint+SIZE+SIZE+SIZE>=xplus)
                        Shape.xPoint = xplus-SIZE-SIZE-SIZE-SIZE;
                }
           // }
            int yminus = 450;
                if(Board.rand==5||Board.rand==10||Board.rand==13||Board.rand==14||Board.rand==18){
                    if (Shape.yPoint+SIZE>=yminus){
                        Shape.yPoint = yminus-SIZE-SIZE;
                        Board.isFalling=true;
                        downAgain = true;
                        //Board.drawDrop(g);
                       // shapes.draw(g,rand);
                        //new Shape(210,30);
                    }
                }
                if(Board.rand==2||Board.rand==4||Board.rand==6||Board.rand==8||Board.rand==9||Board.rand==12||Board.rand==16||Board.rand==17){
                    if (Shape.yPoint+SIZE+SIZE>=yminus){
                        Shape.yPoint = yminus-SIZE-SIZE-SIZE;
                        Board.isFalling=true;
                        downAgain = true;
                       // Board.drawDrop(g);
                       // shapes.draw(g,rand);
                        //new Shape(210,30);
                    }
                }
                    
                if(Board.rand==1||Board.rand==3||Board.rand==7||Board.rand==15||Board.rand==19){
                    if (Shape.yPoint+SIZE+SIZE+SIZE>=yminus){
                        Shape.yPoint = yminus-SIZE-SIZE-SIZE-SIZE;
                        Board.isFalling=true;
                        downAgain = true;
                        //Board.drawDrop(g);
                        //shapes.draw(g,rand);
                       // new Shape(210,30);
                    }
                }
                if(Board.rand==11){
                    if (Shape.yPoint+SIZE+SIZE+SIZE+SIZE>=yminus){
                        Shape.yPoint = yminus-SIZE-SIZE-SIZE-SIZE-SIZE;
                        Board.isFalling=true;
                        downAgain = true;
                        //Board.drawDrop(g);
                        //shapes.draw(g,rand);
                        //new Shape(210,30);
                    }
                }
            if (Shape.xPoint<=50){
		Shape.xPoint = 50;
            }
           /* if(Shape.yPoint>=450){
		Shape.yPoint=450;
//                Board.paintComponent(g);
            }*/
            
    }
        public void fallAgain(){
            //Graphics g = new Graphics();
            if(downAgain){
                
                    rand = (int)(Math.random() * 19)+1 ;
                    if(rand==4||rand==14||rand==17||rand==18)
                        shapes  = new Shape(210,30);
                    else if(rand==13)
                        shapes  = new Shape(210,10);
                    else
			shapes  = new Shape(210,50);
            }
            Shape.yPoint = Shape.yPoint+20;//number of steps to fall
           // shapes.draw(g,rand);
        }

    
}