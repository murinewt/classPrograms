/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;
//import static hotelSunrise.Login.isPasswordCorrect;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.*;
/**
 *
 * @author user
 */
public class UserLogin extends JFrame {
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter Password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");
    
    public UserLogin(){
        super("Login");
        JPanel newPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelUsername, constraints);
        
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelPassword, constraints);
        
        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
        buttonLogin.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    char [] passWhich1 = fieldPassword.getPassword();
                    if(Login.isPasswordCorrect(passWhich1)){
                        dispose();
                        new HotelDetails();
                    }
                    else{
                        HandleErrors.errorWrongPassword();
                    }
                    
                }
                });
        
       // newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()."Login Panel"));
        add(newPanel);
        pack();
        setLocationRelativeTo(null);
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
                new UserLogin().setVisible(true);
            }
        });
    }
    public void paintComponent(Graphics g){
        
    }
    
}
