/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author user
 */
public class MoneyIntheDatabase extends JFrame {
    
    private JLabel money;
    HotelConnect food = new HotelConnect();
    
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MoneyIntheDatabase().setVisible(true);
            }
        });
    }
    
    public MoneyIntheDatabase(){
        super("SUNRISE HOTELS : Money ");
        JPanel newPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(100,250,100,300);
        
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        double moneyMy = food.moneyIHave();
        
        money = new JLabel("Money is: "+moneyMy);
       
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(money, constraints);
        add(newPanel);
        pack();
        setLocationRelativeTo(null);
    }
    
}
