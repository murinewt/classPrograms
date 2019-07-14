package textEditor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author user
 */
public class FindNext extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelUsername = new JLabel("Word to search");
    private JLabel error;// = new JLabel("Enter Password: ");
    private JTextField nameFind = new JTextField(25);
    //private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton Find = new JButton("Find");
    private JButton cancel = new JButton("cancel");

    private File file;
	private String fileContent;
	private boolean isSaved;
	private FileManager fileManager;
    
    public FindNext(){
        super("Find");
        JPanel newPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelUsername, constraints);
        
        constraints.gridx = 1;
        newPanel.add(nameFind, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(Find, constraints);
        
        constraints.gridx = 1;
        newPanel.add(cancel, constraints);
        
        /*constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(, constraints);*/
        cancel.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	System.exit(0);
                }
                });
        Find.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	String findWhat = nameFind.getText();
                	if(nameFind.getText()==null)
                	{
                		error = new JLabel("No word");
                	}else{
                		findString(findWhat, 0);
                	}
                    /*char [] passWhich1 = fieldPassword.getPassword();
                    if(Login.isPasswordCorrect(passWhich1)){
                        dispose();
                        new HotelDetails();
                    }
                    else{
                        HandleErrors.errorWrongPassword();
                    }*/
                    
                }
                });
        
       // newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()."Login Panel"));
        add(newPanel);
        pack();
        setLocationRelativeTo(null);
    }

	public ArrayList<Integer>  findString(String str , int findPosition){
		
		fileContent = fileManager.readFile(file);
		
		ArrayList<Integer> stringPosition = new ArrayList<Integer>();
		
		if(fileContent.equals("") || fileContent == null|| fileContent.length() <= findPosition){
			return null;
		}
		
		else{
			
			
			
			int stringPos = fileContent.indexOf(str,findPosition);
			
			int stringEnd = str.length();
			
			stringPosition.add(stringPos);
			stringPosition.add(stringEnd + stringPos);
		}
		
		return stringPosition;	
	}
	
    public static void main(String [] args){
        /*try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch(Exception ex){
            ex.printStackTrace();
        }*/
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new FindNext().setVisible(true);
            }
        });
    }
    public void paintComponent(Graphics g){
        
    }
    
}
