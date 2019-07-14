/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Login extends JFrame{
    static String userName = "";
    String passWhich = "";
    private static String OK = "ok";
    final static String password = "sunrise";
    JPasswordField pass = new JPasswordField(10);
    static JTextField users = new JTextField(10);
    boolean trym = false;
    public static String passwordS = "";
    public static void main(String [] args){
        new Login();
    }
    public boolean logout(){
        trym = true;
        return trym;
    }
    
    public Login(){
        trym = false;
        setResizable(false);
        setLocation(500,250);
        setLayout(new FlowLayout());
        setSize(350, 200);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//DISPOSE_ON_CLOSE);
        add(new JLabel("Enter your Username: "));
        add(users);
        add(new JLabel("Enter your password: "));
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
        if(input.length!=correctPassword.length){
            isCorrect = false;
        }else{
            isCorrect = Arrays.equals(input, correctPassword);
        }
        Arrays.fill(correctPassword, '0');
        return isCorrect;
    }
    
    public static String getNames(){
        userName = users.getText();
        return userName;
    }
    
}
