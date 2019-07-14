package tetrisNet2;

import java.awt.*;
import java.applet.Applet;
import java.awt.image.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.net.*;

public class Tetris extends Applet implements Runnable, KeyListener
{
   Image im;//The image created and saved to the memory for the blocks
   AudioClip landBlock;//sound that plays each time you land a block
   AudioClip explosion;//sound that plays when you get a full row of blocks
   AudioClip flipSound;//sound that plays when you flip a piece
   byte[][] xy = new byte[16][20];//the array of blocks x and y positions - if 1 there is a block there that's stopped, if their is a 2 there is a block there that is still moving, if 0 there is no block there
   boolean gameOver;//this variable will determine whether or not the game is over
   boolean pickNextPiece;//determines if the computer should pick the next piece (random)
   int currentPiece;//can range from 1 to 5 based on the shape of the block
   int flipNum;//the current flip that the piece is on starting with 0
   float levelMult[] = {.6F,.5F,.45F,.4F,.35F,.3F,.25F,.22F,.18F,.16F};//the current level that you are on starting with .6 and going to .16 - multiply this number by the ammount of time the timer should sleep to speed up the game with each level
   int level;//level, for output purposes only
   int timeTillNextLevel;//time or number of blocks that fall until you go onto the next level
   boolean ableToFlipOrMove;//if the piece has landed, do not allow the user to flip it
   boolean holdingDownKey;//whether or not the user is holding the down key
   int curScore;//the players current score
   int cb1x;//current block 1 x position 
   int cb1y;//current block 1 y position
   int cb2x; 
   int cb2y;
   int cb3x;                  //These 8 variables keep track of the current position of the moving blocks
   int cb3y;
   int cb4x;
   int cb4y;
   
   Thread runner;//the thread that will start the game by calling the run() method
   
   public void init ()
   { 
      addKeyListener(this);//give this applet a key listener to detect key strokes
      Color c = new Color(0,255,255);
      this.setBackground(c);//set the background color to light blue
      landBlock = getAudioClip(getDocumentBase(),"LandBlock.WAV");//load the sound file
      explosion = getAudioClip(getDocumentBase(),"Explosion.WAV");//load the sound file
      flipSound = getAudioClip(getDocumentBase(),"FlipSound.WAV");//load the sound file
      
      createBlockBackground();//make the block color
      gameOver = true;//start off with the game stopped
   }//end init
   
   public void createBlockBackground()//creates the multi-color blocks
   {
      int width = 25; //the width of one block
      int height = 25;//the height of one block
      int [] pixels = new int [width * height]; //total number of pixels is width multiplied by height
        
      int index = 0;

      for (int y = 0; y < height; y++)//loop through this for next statement setting the background pixels -- y coordinates
      {
           int numerator = y * 255;
           int b = numerator / height;
           int r = 255 - numerator / height;

           for (int x = 0; x < width; x++) //set x coordinates for pixels
           {
                int g = x * 255 / width;
                pixels [index++] = (255 << 24) | (r << 16) | (g << 8) | b;//all colors
           }
      }

      im = createImage (new MemoryImageSource (width, height, pixels,0, width));//now save the image to the memory
   }
   
    public void resetGame()
    {
      //first reset the score to 0
      curScore = 0;
      timeTillNextLevel = 25;//number of blocks until the next level
      level = 1;//first level
      holdingDownKey = false;
      //now set the entire array of xy bytes to 0 and the entire array of fourCurrentBlocks to 0
      for(int x=0; x<16; x++)
          for(int y=0; y<20; y++)
              xy[x][y] = 0;
      
      gameOver = false;//start off with a new game
      pickNextPiece = true;//start off with the computer picking the next piece
      
      //now start a thread that will run the game
      if(runner==null)//only start the thread if it is null, otherwise, if it is not null, it is already referenced to an object
          runner = new Thread(this);
      runner.start();
    }//end reset game
   
    public void paint(Graphics g)
    {

         //repaint the black background
         
         //g.fillRect(0,0,400,500);
         
          for(int x=0; x<16; x++)//the screen is a 16X20 block grid, you determine if there is a piece in a certain position of that grid
             for(int y=0; y<20; y++){//...if there is a 1 in that place (must loop through x and y coordinates to check if there is a piece in
                 if(xy[x][y] == 1 || xy[x][y] == 2)//...that position) a 1 means there is a piece there stopped, a 2 means that the piece is still moving while a 0 means there is no piece there
                     g.drawImage(im,x*25,y*25,25,25,this);
                 if(xy[x][y] == 0)//clear the old positions except for the bottom row(19)
                    g.clearRect(x*25,y*25,25,25);
                  }
          //now draw the boundary lines
          g.setColor(Color.blue);
          g.drawRect(0,50,399,475);
          g.drawRect(0,475,400,499);
          g.drawString("   Score: " + curScore,0,20*25-12);//draw score at the bottom of the screen (19th row)
          g.drawString("Level: " + level,200,20*25-12);
          if(gameOver == true)
	  {
               g.drawString("Click on the applet and press Enter key to start a game.",40,200);
	       g.drawString("Use the arrow keys to move the pieces back an forth",40,250);
	       g.drawString("Use the spacebar to flip the pieces",40,300);
	  }
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }
    
    public void stop()
    {
        //stop the program by setting the thread = null
        runner = null;//the thread that runs the program
    }
    
    public void run()//this is all the work is donw by calling the methods the run the game
    {
        Thread current = Thread.currentThread();
        while(runner == current)
        {
            if(pickNextPiece == true)//the current piece has landed so pick another
            {
                Color c = new Color(0,255,255);
                setBackground(c);
                flipNum = 0;//reset since a new piece is being picked
                pickRandomPiece();//call this method to generate another block
		    ableToFlipOrMove = true;//the player is able to flip the new piece
		    repaint();//paint the new piece
                pickNextPiece = false;
            }
            else if(pickNextPiece == false)//move the playing piece downward
            {
                movePieceDown();
                repaint();
                if(holdingDownKey == false)
                {
                    try{
                        runner.sleep((int)(levelMult[level] * 800));//regular speed
                    }catch(InterruptedException e){}
                }
                else if(holdingDownKey == true)//if the user is holding down the down arrow
                {
                    try{
                        runner.sleep((int)(levelMult[level] * 100));//speed up the movement of the block by eight times the original speed
                    }catch(InterruptedException e){}
                }
                
            }
            
        }
    }
    
    public void movePieceDown()
    {

        //now call the method to check to make sure that the blocks are not covering another block
        //if they are covering another block, don't set the actual xy byte array = to the cb1x... and pick a new piece
        //if they are not covering another block, set it equal to the xy byte array and continue to increase the y coordinate of the current moving blocks
        //----------This checks for blocks below and stops them if necessary-----------------
        boolean move = true;//should we continue to move the block down and set it equal to xy array
        if(cb1y+1 >18)//the boundary for the bottom of the screen
            move = false;
        if(cb2y+1 >18)//the boundary for the bottom of the screen
            move = false;
        if(cb3y+1 >18)//the boundary for the bottom of the screen
            move = false;
        if(cb4y+1 >18)//the boundary for the bottom of the screen
            move = false;
        if(xy[cb1x][cb1y+1] == 1)//there is a stopped block beneath
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
        if(xy[cb2x][cb2y+1] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
        if(xy[cb3x][cb3y+1] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
        if(xy[cb4x][cb4y+1] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
        if(move == true)//none of the blocks are equal
        {
            //now increase each y coordinate of each current piece
            cb1y++;
            cb2y++;
            cb3y++;
            cb4y++;
            //erase all the old pieces,      y - 1 is where they are located
            xy[cb1x][cb1y-1] = 0;
            xy[cb2x][cb2y-1] = 0;
            xy[cb3x][cb3y-1] = 0;
            xy[cb4x][cb4y-1] = 0;
            //now move the actual blocks
            xy[cb1x][cb1y] = 2;//they are still moving so keep them a 2 ( 1 if they are stopped)
            xy[cb2x][cb2y] = 2;
            xy[cb3x][cb3y] = 2;
            xy[cb4x][cb4y] = 2;
            repaint();
        }
        else if(move == false)
        {
            //first, since none of the blocks are not moving, set all the blocks that were moving to 1's instead of 2's
	    xy[cb1x][cb1y] = 1;
            xy[cb2x][cb2y] = 1;
            xy[cb3x][cb3y] = 1;
            xy[cb4x][cb4y] = 1;
            
            ableToFlipOrMove = false;//do not allow the user to flip the blocks or move them
            //play the land block sound
            landBlock.play();
            curScore += 10;//player given 10 points for landing the block
            checkForFullLine();//check to see if there is a full line of horizontal blocks
            checkToSeeIfPlayerLost();
            repaint();
            try{
                runner.sleep(5);//wait to pick another piece
            }catch(InterruptedException e){}
            pickNextPiece = true;
        }
        
        
    }
    
    public void pickRandomPiece()
    {
        //deduct the time until the next level
        timeTillNextLevel--;
        if(timeTillNextLevel <=0 && level <= 10)
        {
            level++;//increment the level for output purposes only
            timeTillNextLevel = 25;//wait until another 25 pieces comes down to go to the next level
        }
        currentPiece = (int)(Math.random() * 5 + 1); //generates a number between 1 and 5
        pickNextPiece = false;//tell the computer not to pick another
        setPieceInPosition();//put the piece into position
    }
    
    public void setPieceInPosition()//sets the piece into starting position
    {
        if(currentPiece == 1)
        {
            // XXXX piece
            xy[6][1] = 2;
            xy[7][1] = 2;
            xy[8][1] = 2;
            xy[9][1] = 2;
            
            //the x and y coordinates of each moving block
            cb1x = 6;
            cb1y = 1;
            cb2x = 7; 
            cb2y = 1;
            cb3x = 8;                  
            cb3y = 1;
            cb4x = 9;
            cb4y = 1;
        }
        else if(currentPiece == 2)
        {
            //  XX
            //   XX  piece
            xy[7][0] = 2;
            xy[8][0] = 2;
            xy[8][1] = 2;
            xy[9][1] = 2;
            
            //the x and y coordinates of each moving block
            cb1x = 7;
            cb1y = 0;
            cb2x = 8; 
            cb2y = 0;
            cb3x = 8;                  
            cb3y = 1;
            cb4x = 9;
            cb4y = 1;
        }
        else if (currentPiece == 3)
        {
            // XX
            // XX piece
            xy[7][0] = 2;
            xy[8][0] = 2;
            xy[7][1] = 2;
            xy[8][1] = 2;
            
            //the x and y coordinates of each moving block
            cb1x = 7;
            cb1y = 0;
            cb2x = 8; 
            cb2y = 0;
            cb3x = 7;                  
            cb3y = 1;
            cb4x = 8;
            cb4y = 1;
        }
        else if(currentPiece == 4)
        {
            // XXX
            //   X piece
            xy[6][0] = 2;
            xy[7][0] = 2;
            xy[8][0] = 2;
            xy[8][1] = 2;
            
            //the x and y coordinates of each moving block
            cb1x = 6;
            cb1y = 0;
            cb2x = 7; 
            cb2y = 0;
            cb3x = 8;                  
            cb3y = 0;
            cb4x = 8;
            cb4y = 1;
        }
        else if(currentPiece == 5)
        {
            //  X
            // XXX piece
            xy[6][1] = 2;
            xy[7][1] = 2;
            xy[8][1] = 2;
            xy[7][0] = 2;
            
            //the x and y coordinates of each moving block
            cb1x = 6;
            cb1y = 1;
            cb2x = 7; 
            cb2y = 1;
            cb3x = 8;                  
            cb3y = 1;
            cb4x = 7;
            cb4y = 0;
        }
    }
    
    public void checkForFullLine()
    {
        //this function checks all the lines to see if there is a full horizontal line of blocks
        //if there are 16 blocks horizontally (0-15) in a row, there is a full line
        int blocksInRow;//variable determining the ammount of blocks in each single row
        int xCord;//the x cordinate for the loop
        int yCord;//the y coordinate for the loop
        for(yCord = 0; yCord < 19; yCord++)
        {
            blocksInRow = 0;
            for(xCord = 0; xCord < 16; xCord++)
            {
                if(xy[xCord][yCord] == 1){//meaning that there is a block there
                 blocksInRow++;
                }
                if(blocksInRow == 16)//meaning that there are a full line
                {
                    //now loop through and get rid of this row
                    for(xCord = 0; xCord < 16; xCord++)
                    {
                        xy[xCord][yCord] = 0;
                    }
                    explosion.play();//play explosion sound
                    setBackground(Color.red);
		    curScore += 100;//give the player 100 points for each full horizontal line of blocks they obtain
                    moveUpperBlocksDown(yCord);//call the function to move all the upper blocks downward
                }
            }
        }
    }
    public void moveUpperBlocksDown(int yCord)
    {
        //move blocks above yCord down
        for(int y = yCord-1; y >=0; y--)
        {
            for(int x = 0; x < 16; x++)
            {
                if(xy[x][y] == 1)//if there is a piece there, move it down 1
                {
                    xy[x][y] = 0;//erase the old one
                    xy[x][y+1] = 1;//draw the new one
                }
            }   
        }
    }
    
    public void checkToSeeIfPlayerLost()
    {
        for(int x=0; x<16; x++)
        {
            if(xy[x][1] == 1)//if there is a block that landed above the top boundary line (stacked to top)
            {
                runner = null;//nullify the thread to stop the game
                showStatus("G A M E   O V E R ! ! !       G A M E   O V E R ! ! !       G A M E   O V E R ! ! !       G A M E   O V E R ! ! !       G A M E   O V E R ! ! !");
                gameOver = true;
            }
        }
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    public void keyPressed(KeyEvent e)
    {
       if(e.getKeyCode() == KeyEvent.VK_ENTER )//starts a new game
           resetGame();
       if(e.getKeyCode() == KeyEvent.VK_LEFT && ableToFlipOrMove == true)
       {
            //move the blocks to the left
            boolean move = true;//the blocks can move unless told otherwise
            if(cb1x-1 < 0)//the boundary for the left side of the screen
            move = false;
            if(cb2x-1 < 0)//the boundary for the left side of the screen
            move = false;
            if(cb3x-1 < 0)//the boundary for the left side of the screen
            move = false;
            if(cb4x-1 < 0)//the boundary for the left side of the screen
            move = false;
            if(xy[cb1x-1][cb1y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb2x-1][cb2y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb3x-1][cb3y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb4x-1][cb4y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(move == true)//none of the blocks are equal
            {    //now decrease each x coordinate of each current piece
                cb1x--;
                cb2x--;
                cb3x--;
                cb4x--;
                //erase all the old pieces,      x + 1 is where they are located
                xy[cb1x+1][cb1y] = 0;
                xy[cb2x+1][cb2y] = 0;
                xy[cb3x+1][cb3y] = 0;
                xy[cb4x+1][cb4y] = 0;
                //now move the actual blocks
                xy[cb1x][cb1y] = 2;
                xy[cb2x][cb2y] = 2;
                xy[cb3x][cb3y] = 2;
                xy[cb4x][cb4y] = 2;
                repaint();
            }
       }
       else if(e.getKeyCode() == KeyEvent.VK_RIGHT && ableToFlipOrMove == true)
       {
           //move the blocks to the right
            boolean move = true;//the blocks can move unless told otherwise
            if(cb1x+1 > 15)//the boundary for the left side of the screen
            move = false;
            if(cb2x+1 > 15)//the boundary for the left side of the screen
            move = false;
            if(cb3x+1 > 15)//the boundary for the left side of the screen
            move = false;
            if(cb4x+1 > 15)//the boundary for the left side of the screen
            move = false;
            if(xy[cb1x+1][cb1y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb2x+1][cb2y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb3x+1][cb3y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(xy[cb4x+1][cb4y] == 1)
            move = false;//do not continue to move and set the temporary cb1x... = to the xy array
            if(move == true)//none of the blocks are equal
            {    //now increase each x coordinate of each current piece
                cb1x++;
                cb2x++;
                cb3x++;
                cb4x++;
                //erase all the old pieces,      x - 1 is where they are located
                xy[cb1x-1][cb1y] = 0;
                xy[cb2x-1][cb2y] = 0;
                xy[cb3x-1][cb3y] = 0;
                xy[cb4x-1][cb4y] = 0;
                //now move the actual blocks
                xy[cb1x][cb1y] = 2;
                xy[cb2x][cb2y] = 2;
                xy[cb3x][cb3y] = 2;
                xy[cb4x][cb4y] = 2;
                repaint();
            }
       }
       else if(e.getKeyCode() == KeyEvent.VK_SPACE && ableToFlipOrMove == true)
       {
           //use the spacebar to flip the piece
           //first play the sound - note, the sound will play whether or not the block is able to be flipped
           flipSound.play();
           //determine the piece type and the curent flip it is on with the currentPiece and flipNum variables
           if(currentPiece == 1)
           {
               if(flipNum == 0 && xy[cb2x-1][cb2y+1] != 1 && xy[cb3x-2][cb3y+2] != 1 && xy[cb4x-3][cb4y+3] != 1 && cb1y <= 15)
               {
                   flipNum++;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x;
                   cb1y = cb1y;
                   cb2x = cb2x-1;
                   cb2y = cb2y+1;
                   cb3x = cb3x-2;
                   cb3y = cb3y+2;
                   cb4x = cb4x-3;
                   cb4y = cb4y+3;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 1 && xy[cb2x+1][cb2y-1] != 1 && xy[cb3x+2][cb3y-2] != 1 && xy[cb4x+3][cb4y-3] != 1 && cb1x <= 13)
               {
                    flipNum = 0;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x;
                   cb1y = cb1y;
                   cb2x = cb2x+1;
                   cb2y = cb2y-1;
                   cb3x = cb3x+2;
                   cb3y = cb3y-2;
                   cb4x = cb4x+3;
                   cb4y = cb4y-3;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
           }
           else if(currentPiece == 2)
           {
               if(flipNum == 0 && xy[cb1x+1][cb1y] != 1 && xy[cb2x][cb2y+1] != 1 && xy[cb3x-1][cb3y] != 1 && xy[cb4x-2][cb4y+1] != 1 && cb3y <= 15)
               {
                   flipNum = 1;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x+1;
                   cb1y = cb1y;
                   cb2x = cb2x;
                   cb2y = cb2y+1;
                   cb3x = cb3x-1;
                   cb3y = cb3y;
                   cb4x = cb4x-2;
                   cb4y = cb4y+1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 1 && xy[cb1x-1][cb1y] != 1 && xy[cb2x][cb2y-1] != 1 && xy[cb3x+1][cb3y] != 1 && xy[cb4x+2][cb4y-1] != 1 && cb1x <= 15)
               {
                   flipNum = 0;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x-1;
                   cb1y = cb1y;
                   cb2x = cb2x;
                   cb2y = cb2y-1;
                   cb3x = cb3x+1;
                   cb3y = cb3y;
                   cb4x = cb4x+2;
                   cb4y = cb4y-1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
           }
           else if(currentPiece == 3)
           {
               //no code needed for the 2X2 block
           }
           else if(currentPiece == 4)
           {
               if(flipNum == 0 && xy[cb1x+1][cb1y] != 1 && xy[cb2x][cb2y+1] != 1 && xy[cb3x-1][cb3y+2] != 1 && xy[cb4x-2][cb4y+1] != 1 && cb4y <= 17)
               {
                    flipNum = 1;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x+1;
                   cb1y = cb1y;
                   cb2x = cb2x;
                   cb2y = cb2y+1;
                   cb3x = cb3x-1;
                   cb3y = cb3y+2;
                   cb4x = cb4x-2;
                   cb4y = cb4y+1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 1  && xy[cb1x+1][cb1y+2] != 1 && xy[cb2x][cb2y+1] != 1 && xy[cb3x-1][cb3y] != 1 && xy[cb4x][cb4y-1] != 1 && cb3x <= 14)
               {
                    flipNum = 2;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x+1;
                   cb1y = cb1y+2;
                   cb2x = cb2x;
                   cb2y = cb2y+1;
                   cb3x = cb3x-1;
                   cb3y = cb3y;
                   cb4x = cb4x;
                   cb4y = cb4y-1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 2 && xy[cb1x-1][cb1y+1] != 1 && xy[cb2x][cb2y] != 1 && xy[cb3x+1][cb3y-1] != 1 && xy[cb4x+2][cb4y] != 1 && cb3y <= 17)
               {
                    flipNum = 3;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x-1;
                   cb1y = cb1y+1;
                   cb2x = cb2x;
                   cb2y = cb2y;
                   cb3x = cb3x+1;
                   cb3y = cb3y-1;
                   cb4x = cb4x+2;
                   cb4y = cb4y;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 3 && xy[cb1x-1][cb1y-2] != 1 && xy[cb2x][cb2y-1] != 1 && xy[cb3x+1][cb3y] != 1 && xy[cb4x][cb4y+1] != 1 && cb3x >= 1)
               {
                    flipNum = 0;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x-1;
                   cb1y = cb1y-2;
                   cb2x = cb2x;
                   cb2y = cb2y-1;
                   cb3x = cb3x+1;
                   cb3y = cb3y;
                   cb4x = cb4x;
                   cb4y = cb4y+1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
           }
           else if(currentPiece == 5)
           {
               if(flipNum == 0 && xy[cb1x+1][cb1y-1] != 1 && xy[cb2x][cb2y] != 1 && xy[cb3x-1][cb3y+1] != 1 && xy[cb4x+1][cb4y+1] != 1 && cb2y <= 17)
               {
                   flipNum = 1;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x+1;
                   cb1y = cb1y-1;
                   cb2x = cb2x;
                   cb2y = cb2y;
                   cb3x = cb3x-1;
                   cb3y = cb3y+1;
                   cb4x = cb4x+1;
                   cb4y = cb4y+1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 1 && xy[cb1x+1][cb1y] != 1 && xy[cb2x][cb2y-1] != 1 && xy[cb3x-1][cb3y-2] != 1 && xy[cb4x-1][cb4y] != 1 && cb2x >=1)
               {
                   flipNum = 2;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x+1;
                   cb1y = cb1y;
                   cb2x = cb2x;
                   cb2y = cb2y-1;
                   cb3x = cb3x-1;
                   cb3y = cb3y-2;
                   cb4x = cb4x-1;
                   cb4y = cb4y;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 2 && xy[cb1x-1][cb1y+2] != 1 && xy[cb2x][cb2y+1] != 1 && xy[cb3x+1][cb3y] != 1 && xy[cb4x-1][cb4y] != 1 && cb4y <=17)
               {
                   flipNum = 3;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x-1;
                   cb1y = cb1y+2;
                   cb2x = cb2x;
                   cb2y = cb2y+1;
                   cb3x = cb3x+1;
                   cb3y = cb3y;
                   cb4x = cb4x-1;
                   cb4y = cb4y;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
               else if(flipNum == 3 && xy[cb1x-1][cb1y-1] != 1 && xy[cb2x][cb2y] != 1 && xy[cb3x+1][cb3y+1] != 1 && xy[cb4x+1][cb4y-1] != 1 && cb2x <=14)
               {
                   flipNum = 0;
                   //erase all the old positions
                   xy[cb1x][cb1y] = 0;
                   xy[cb2x][cb2y] = 0;
                   xy[cb3x][cb3y] = 0;
                   xy[cb4x][cb4y] = 0;
                   //now reset the cb variables
                   cb1x = cb1x-1;
                   cb1y = cb1y-1;
                   cb2x = cb2x;
                   cb2y = cb2y;
                   cb3x = cb3x+1;
                   cb3y = cb3y+1;
                   cb4x = cb4x+1;
                   cb4y = cb4y-1;
                   //redraw them
                   xy[cb1x][cb1y] = 2;
                   xy[cb2x][cb2y] = 2;
                   xy[cb3x][cb3y] = 2;
                   xy[cb4x][cb4y] = 2;
                   repaint();
               }
           }
       }
       if(e.getKeyCode() == KeyEvent.VK_DOWN)
           holdingDownKey = true;//speed up the block movement
    }
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            holdingDownKey = false;//when the user releases the down key, slow down the blocks again
    }
} 
