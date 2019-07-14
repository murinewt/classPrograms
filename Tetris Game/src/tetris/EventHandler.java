package tetris;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class EventHandler implements KeyListener ,ActionListener{
	
	public GamePanel panel;
	
	public void keyPressed(KeyEvent evt){
		
	}
	public void keyReleased(KeyEvent evt){
		int code = evt.getKeyCode();
		if(panel.gameInProgress){
			panel.allowHorMove();
			if((code == KeyEvent.VK_LEFT) && panel.moveLeft){
				panel.updateShapeHor(-1);
				panel.message = "You are moving right";
				//panel.moveRight = true;
				//panel.moveLeft = true;
				//panel.allowHorMove();
			}
			else if((code == KeyEvent.VK_RIGHT) && panel.moveRight){
				panel.updateShapeHor(1);
				panel.message = "You are moving left";
				//panel.moveRight = true;
				//panel.moveLeft = true;
				//panel.allowHorMove();
			}
			else if(code == KeyEvent.VK_UP){
				panel.changeShape();
				panel.message = "You are rotating";
			}
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void actionPerformed(ActionEvent evt){
		String command = evt.getActionCommand();
		if(command.equals("New Game")){
			if(panel.gameInProgress){
				panel.message = "Stop cheating";
			}
			else{
				panel.doNewGame();
			}
			
		}
		else if(command.equals("Pause")){
			if(panel.gameInProgress){
				//panel.timer.stop();
				panel.timer.stop();
			
			}
			
		}
		else if(command.equals("Continue")){
			if(panel.gameInProgress){
				panel.timer.start();
			
			}
			
		}
		else if(command.equals("Quit")){
			if(panel.gameInProgress){
				panel.timer.stop();
			    panel.doNewGame();
			}
		}
		
		else if(command.equals("Controls")){
			if(panel.gameInProgress){
				panel.timer.stop();
				
				JOptionPane.showMessageDialog( null , "To :\n"
						+ " 1 : Rotate      Arrow Key Up \n"
						+ " 2 : Move Right  Arrow Key Right \n"
						+ " 3 : Move Left   Arrow Key Left \n\n"
						+ "@Michael Kuria2017");
					
				}

			
			else{
				JOptionPane.showMessageDialog( null , "To :\n"
						+ " 1 : Rotate      Arrow Key Up \n"
						+ " 2 : Move Right  Arrow Key Right \n"
						+ " 3 : Move Left   Arrow Key Left \n\n"
						+ "@Michael Kuria2017");
				
			}
	}
			

		else if(command.equals("Developer")){
			if(panel.gameInProgress){
				panel.timer.stop();
				
				JOptionPane.showMessageDialog( null ,"Name : Michael Kuria \n"
						+ "School : JKUAT\n\n"
						+ "@Michael Kuria2017");
		    }
			else{
				JOptionPane.showMessageDialog( null ,"Name : Michael Kuria \n"
						+ "School : JKUAT");
			}
	}
	}
	


}