/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;
//import static hotelSunrise.Login.users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.*;

/**
 *
 * @author user
 */
public class LoginJPanel extends JPanel {//implements ActionListener{
    private JFrame controllingFrame; 
    static String userName = "";
    String passWhich = "";
    private static String OK = "ok";
    final static String password = "sunrise";
    private static JPasswordField pass = new JPasswordField(10);
    static JTextField users = new JTextField(10);
    private JPanel p;
    private static JLabel usernameLabel= new JLabel("Enter your Username: ");
    private static JLabel passLabel = new JLabel("Enter your password: ");
    private static JFrame close = new JFrame();
    private static String passwordS = "sunrise";
    private static LoginJPanel log;
    
    public static void main(String [] args){
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                //UIManager.put("swing.boldMetal",Boolean.FALSE);
                
                CreateAndShow();
            }
        });
        
    }

    private JComponent createButtonPane() {
        JPanel p = new JPanel(new GridLayout(0,1));
        
        return p;
    }
    
    //@Override
    private static class ButtonHandler implements ActionListener {
                 @Override
                public void actionPerformed(ActionEvent e) {
                   
                    String cmd = e.getActionCommand();
                    if(OK.equals(cmd)){
                    char [] passWhich1 = pass.getPassword();
                    //System.out.println(passWhich);
                    if(Login.isPasswordCorrect(passWhich1)){
                        //returnMe();
                        close.dispose();
                        new HotelDetails();
                        //System.exit(0);
                        //new MainHotel();
                    }
                    else{
                        HandleErrors.errorWrongPassword();
                    }
                   }
                    
                }
            
    }
    public static void CreateAndShow(){
        
        JFrame window = new JFrame("Login");
        //window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LoginJPanel newPane = new LoginJPanel();
        
        newPane.setOpaque(true);
        //window.setContentPane(newPane);
        //window.pack();
        //window.setLocation(400,250);
	//window.setVisible(true);
        JOptionPane.showMessageDialog(null, newPane,"LOGIN",JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    public static String returnMe(){
        
        return passwordS;
    }
    public LoginJPanel(){
        ButtonHandler listener = new ButtonHandler();
        //controllingFrame = f;
        pass.setActionCommand(OK);
        pass.addActionListener(listener);
        passLabel.setLabelFor(pass);
        usernameLabel.setLabelFor(users);
        JComponent buttonPane = createButtonPane();
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textPane.add(usernameLabel);
        textPane.add(users);
        textPane.add(passLabel);
        textPane.add(pass);
        add(textPane);
        //add(buttonPane);
             
        //super("Login");
        setBackground(Color.blue);
       // 
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawString("Newton do something", 50, 50);
    }
    
    public static String getNames(){
        userName = users.getText();
        return userName;
    }
}

