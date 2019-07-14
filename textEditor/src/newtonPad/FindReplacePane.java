package newtonPad;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author user
 */
public class FindReplacePane extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String find = "";
    String replace = "";
    private static String OK = "ok";
    //final static String password = "sunrise";
    static JTextField pass = new JPasswordField(10);
    static JTextField users = new JTextField(10);
    boolean trym = false;
    public static String passwordS = "";
    public static void main(String [] args){
        new FindReplacePane();
    }
    public boolean logout(){
        trym = true;
        return trym;
    }
    
    public FindReplacePane(){
        trym = false;
        setResizable(false);
        setLocation(500,250);
        setLayout(new FlowLayout());
        setSize(350, 200);
        setTitle("Find and Replace");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DISPOSE_ON_CLOSE);
        users.setText("");
        add(new JLabel("Find What? "));
        add(users);
        add(new JLabel("Replace with: "));
        add(pass);
        pass.setActionCommand(OK);
        pass.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                   String cmd = e.getActionCommand();
                   if(OK.equals(cmd)){
                    char [] passWhich1 = pass.getPassword();
                    System.out.println(passWhich);
                    if(isPasswordCorrect(passWhich1)){
                       /* passwordS = "sunrise";
                        returnMe();
                        System.out.println(passwordS);
                        
                        trym = true;*/
                        //System.exit(Login());
                        dispose();
                        new HotelMain();
                    }
                    else{
                        pass.setText("");
                        HandleErrors.errorWrongPassword();
                    }
                   }
                    
                }
                
            });
        setVisible(true);
       // return trym;
    }
    public static String returnMe (){
        
        return passwordS;
    }
    
    public static boolean isPasswordCorrect(char [] input){
        boolean isCorrect = true; 
        char [] correctPassword = {'s','u','n','r','i','s','e'};
        /*if(input.length!=correctPassword.length){
            isCorrect = false;
        }else{
            isCorrect = Arrays.equals(input, correctPassword);
        }
        Arrays.fill(correctPassword, '0');*/
       
        // password check mine
        for(int x=0;x<correctPassword.length;x++){
        	if(input.length!=correctPassword.length)
        		return false;
        	else if(input[x] == correctPassword[x])
        		isCorrect = true;
        	else
        		return false;
        }
        
        return isCorrect;
    }
    
    public static String getNames(){
        userName = users.getText();
        return userName;
    }
    
}
