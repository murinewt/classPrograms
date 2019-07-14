/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class HandleErrors extends JFrame{
    //MainHotel mainH= new MainHotel();
    public static void main(String [] args){
        new HandleErrors();
    }
    /*public HandleErrors(){
        setLayout(new FlowLayout());
        setSize(400, 70);
        add(new JLabel("Customer cant buy: money is less"));
        setVisible(true);
    }*/
    public static void errorLessMoney(){
        JOptionPane.showMessageDialog(null,"Customer cant buy: money is less","Error Message", JOptionPane.ERROR_MESSAGE);
    }
    public static void errorWrongPassword(){
        JOptionPane.showMessageDialog(null,"Wrong Password","Error Message", JOptionPane.ERROR_MESSAGE);
        
    }
    public static void JOptionPaneMessages(String message){
        JOptionPane.showMessageDialog(null,message," ", JOptionPane.INFORMATION_MESSAGE);
    }
}
