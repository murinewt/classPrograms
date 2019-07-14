package hotelSunrise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author user
 */
public class AddToDatabase extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static HotelMain Hotel; 
    
    static String food,cost,error="";
    static double cost2;
    //static String id;
    
    
    private static JTextField foodName = new JTextField(10), costFood = new JTextField(10);
    private JLabel  labelFood = new JLabel("Food Name: "), labelCost = new JLabel("Cost: ");
 
    private JButton okey = new JButton("Send to database");
    static HotelConnect connect = new HotelConnect();
    
    public static void main(String [] args){
        
            new AddToDatabase();
    }
    
    public AddToDatabase(){
        setResizable(false);
        setLocation(480,200);
        setLayout(new FlowLayout());
        setSize(400, 250);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(labelFood);
        add(foodName);
        add(labelCost);
        add(costFood);
        add(okey);
        okey.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    
                    food = foodName.getText();
                    cost = costFood.getText();
                    
                    if (food.equals(""))
                        error+="food Name is blank";
                    if(!cost.equals("")){
                        try{
                            cost2 = Double.parseDouble(cost);
                        }
                        catch(NumberFormatException ex){
                            error+="invalid cost";
                        }
                    }
                    else
                        error+="Cost is null";
                    if(error.equals("")){
                        connect.insertNew(food,cost);
                        HandleErrors.JOptionPaneMessages("Addition Successfull");
                        foodName.setText("");
                        costFood.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, error,"Add Records",JOptionPane.ERROR_MESSAGE);
                        error = "";
                    }
                }
            });
        setVisible(true);
                
    }
    
    
}
