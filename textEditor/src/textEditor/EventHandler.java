package textEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
/*
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;*/

public class EventHandler
  implements KeyListener, ActionListener
{
	TextEditorPanel panel;
	TextEditor editor;
  
  public void keyPressed(KeyEvent evt){}
  {
	  /*
  
    int code = evt.getKeyCode();
    if ((code == 37) && (!this.panel.movingRight))
    {
      this.panel.movingLeft = true;
      this.panel.movingRight = (this.panel.movingUp = this.panel.movingDown = false);////converted here to false.. it was zero
    }
    else if ((code == 39) && (!this.panel.movingLeft))
    {
      this.panel.movingRight = true;
      this.panel.movingLeft = (this.panel.movingUp = this.panel.movingDown = false);////converted here to false.. it was zero
    }
    else if ((code == 40) && (!this.panel.movingUp))
    {
      this.panel.movingDown = true;
      this.panel.movingRight = (this.panel.movingUp = this.panel.movingLeft = false);////converted here to false.. it was zero
    }
    else if ((code == 38) && (!this.panel.movingDown))
    {
      this.panel.movingUp = true;
      this.panel.movingRight = (this.panel.movingLeft = this.panel.movingDown = false);////converted here to false.. it was zero
    }*/
  }
  
  boolean openFile(File temp)
  {
	 /* FileInputStream fin=null;
	  BufferedReader din=null;
	
	  try
	  {
	  fin=new FileInputStream(temp);
	  din=new BufferedReader(new InputStreamReader(fin));
	  String str=" ";
	  while(str!=null)
	  {
	  str=din.readLine();
	  if(str==null)
	  break;
	  editor.textArea.append(str+"\n");
	  }
	
	  }
	  catch(IOException ioe){updateStatus(temp,false);return false;}
	  finally
	  {try{din.close();fin.close();}catch(IOException excp){}}
	  updateStatus(temp,true);
	  editor.textArea.setCaretPosition(0);*/
	  return true;
  }
  
  void openFile()
  {/*
  if(!confirmSave()) return;
  chooser.setDialogTitle("Open File...");
  chooser.setApproveButtonText("Open this"); 
  chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
  chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

  File temp=null;
  do
  {
  if(chooser.showOpenDialog(this.npd.f)!=JFileChooser.APPROVE_OPTION)
  	return;
  temp=chooser.getSelectedFile();

  if(temp.exists())	break;

  JOptionPane.showMessageDialog(this.npd.f,
  	"<html>"+temp.getName()+"<br>file not found.<br>"+
  	"Please verify the correct file name was given.<html>",
  	"Open",	JOptionPane.INFORMATION_MESSAGE);

  } while(true);

  editor.textArea.setText("");

  if(!openFile(temp))
  	{
  	fileName="Untitled"; saved=true; 
  	this.npd.f.setTitle(fileName+" - "+applicationTitle);
  	}
  if(!temp.canWrite())
  	newFileFlag=true;*/

  }
  
  
  
  
  public void keyReleased(KeyEvent evt) {}
  
  public void keyTyped(KeyEvent evt) {}
  
  public void actionPerformed(ActionEvent evt)
  {
    String str = evt.getActionCommand();
    if (str.equals("New"))
    {
      new TextEditor();
    }

    else if (str.equals("Open"))
    {
    	openFile();
    	/*JFileChooser open = new JFileChooser();
    	int option = open.showOpenDialog(null);
    	if(option==JFileChooser.APPROVE_OPTION)
    	{
    		//editor.textArea.setText("");
    		String data = "";
    		try{
    			Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
    			while(scan.hasNext())
    				data = scan.next()+ " ";
    				//editor.textArea.append(scan.nextLine()+"\n");
    			scan.close();
    		}
    		catch(Exception e){
    			System.out.println(e.getMessage());
    		}
    		data += "nothing";
    		editor.textArea.setText(data);
    	}*/
      
    }
    else if (str.equals("Save")) 
    {
    	if(editor.saved == false)
    	{
    		JFileChooser save = new JFileChooser();
        	int option = save.showSaveDialog(null);
        	if(option == JFileChooser.APPROVE_OPTION)
        	{
        		try{
        			BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
        			
        			
        			out.write(editor.textArea.getText());//, arg1, arg2);//
        			//out.flush();
        			out.close();
        		}
        		catch(Exception e)
        		{
        			System.out.println(e.getMessage());
        		}
        	}
    	}
    	else
    	{
    		
    	}
    }
    else if (str.equals("Save As"))
    {
    	JFileChooser save = new JFileChooser();
    	int option = save.showSaveDialog(null);
    	if(option == JFileChooser.APPROVE_OPTION)
    	{
    		try{
    			BufferedWriter out = new BufferedWriter(new FileWriter(new File("F:\\newt.txt")));
    			out.write(editor.textArea.getText());//, arg1, arg2);//
    			out.close();
    		}
    		catch(Exception e)
    		{
    			System.out.println(e.getMessage());
    		}
    	}
    }
    else if (str.equals("Print"))
    {
    	
    }
    else if (str.equals("Exit"))
    {
    	System.exit(1);
    }
    else  if (str.equals("undo")) 
    {
    	
    }
    else  if (str.equals("copy")) 
    {
    	
    }
    else  if (str.equals("cut")) 
    {
    	
    }
    else  if (str.equals("paste")) 
    {
    	
    }else  if (str.equals("find")) 
    {
    	
    }
    else  if (str.equals("find next")) 
    {
    	
    }
    else  if (str.equals("replace")) 
    {
    	
    }
    else if(str.equals("Ariel"))
    {
    	//editor.textArea.setFont(new Font(jcbFont.getSelectedItem().toString,Font.PLAIN, 
    		//	Integer.parseInt(jcbSelectSize.getSelectedItem().toString())));
    }
    else if(str.equals("Comic Sans MS"))
    {
    	editor.fontName="Comic Sans MS";
    }
    else if(str.equals("Georgia"))
    {
    	editor.fontName="Georgia";
    }
    else if(str.equals("Lucida Bright"))
    {
    	editor.fontName="Lucida Bright";
    }
    else  if (str.equals("time")) 
    {
    	
    }
    else if (str.equals("Developer"))
    {
       JOptionPane.showMessageDialog(panel, "<html><h3>murinewt@hotmail.com support through Mpesa 0716192803</h3></html>");
    }
      
    else if (str.equals("About"))
    {
        JOptionPane.showMessageDialog(panel, "<html> <h2 color= red>THE SNAKE GAME </h2> </br><h3 color = red>CONTROLS</h> <br><div color = green>Use Arrow Keys to move the snake.<br>On launching the game select the level you want to play<br>on the Level menu then,  Click play<br><br>Once you have crushed :<br>1. Click the new game(New Game) menu on the game(Game) menu.<br>2. Select the level.<br>3. Then play<br></div></html>");
    }
    
  }
}
