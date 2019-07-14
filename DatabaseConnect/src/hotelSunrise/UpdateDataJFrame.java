package hotelSunrise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author user
 */
public class UpdateDataJFrame extends JFrame{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static HotelMain Hotel; 
    static String id,food,cost,error="";
    static double cost2;
    //static String id;
    
    
    private static JTextField idFood = new JTextField(10), foodName = new JTextField(10), costFood = new JTextField(10);
    private JLabel labelID = new JLabel("Food ID: "), labelFood = new JLabel("Food Name: "), labelCost = new JLabel("Cost: ");
    private JTextArea details = new JTextArea(20,30);
    private JButton display = new JButton("view"), okey = new JButton("Send to database");
    static HotelConnect connect = new HotelConnect();
    
    public static void main(String [] args){
        
            //new UpdateDataJFrame();
    }
    
    public UpdateDataJFrame(){
        setResizable(false);
        setLocation(400,150);
        setLayout(new FlowLayout());
        setSize(600, 400);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(labelID);
        add(idFood);
        add(display);
        display.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        String [][] xyz = new String[1][3];
                        id = idFood.getText();
                        xyz=HotelConnect.getItem(id);
                        details.append("\t   Food \nID\tFood\tPrice\n");
                        for(int x=0;x<1;x++){
                            details.append(xyz[x][0]);
                            details.append(xyz[x][1]);
                            details.append(xyz[x][2]);
                        }
                        
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                   
                    
                }
            });
        add(labelFood);
        add(foodName);
        add(labelCost);
        add(costFood);
        add(details);
        add(okey);
        okey.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    
                    id = idFood.getText();
                    food = foodName.getText();
                    cost = costFood.getText();
                    if(id.equals(""))
                        error+="id is null\n";
                    if (!food.equals(""))
                        food = foodName.getText();
                    if(food.equals("")){
                        if (id!=null)
                            food = connect.foodType(id);
                        else
                            error+="food Name is blank";
                    }
                    
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
                        connect.updateItems(id,food,cost);
                        HandleErrors.JOptionPaneMessages("Update Successfull");
                        String [][] xyz = new String[1][3];
                        id = idFood.getText();
                        xyz=HotelConnect.getItem(id);
                        details.append("\n\n\tUpdated Food \nID\tFood\tPrice\n");
                        for(int x=0;x<1;x++){
                            details.append(xyz[x][0]);
                            details.append(xyz[x][1]);
                            details.append(xyz[x][2]);
                        }
                        idFood.setText("");
                        foodName.setText("");
                        costFood.setText("");
                        
                        //details.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, error,"Update Records",JOptionPane.ERROR_MESSAGE);
                        error = "";
                    }
                }
            });
        setVisible(true);
                
    }
    
}
