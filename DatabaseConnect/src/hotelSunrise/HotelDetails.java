package hotelSunrise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import java.util.*;
/**
 *
 * @author user
 */
public class HotelDetails extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addDetails = new JButton("Add new Record") ;
    private JButton updateDetails = new JButton("Update Record");
    private JButton deleteDetails = new JButton("Delete Record");
    private JButton money = new JButton("My Money");
    
    public static void main(String[] args) { 
        new HotelDetails(); 
    }
    
    public HotelDetails(){
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setResizable(false);
        setLocation(500,250);
        setSize(400, 150);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(addDetails);
        addDetails.addActionListener(new ActionListener(){
                
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                        new AddToDatabase();
                    
                        
                    
                }
        });
        add(updateDetails);
        updateDetails.addActionListener(new ActionListener(){
                
                
                @Override
                public void actionPerformed(ActionEvent e) {
                        new UpdateDataJFrame();
                }
                
            });
        
        add(deleteDetails);
        deleteDetails.addActionListener(new ActionListener(){
                
              
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                        new DeleteRecord();
                   
                    
                }
        });
        add(money);
        money.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                        SwingUtilities.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                            new MoneyInTheDatabase().setVisible(true);
                        }
                        });
                }
        });
        setVisible(true);
    }
    
}
