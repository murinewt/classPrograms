package hotelSunrise;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Date;
import java.util.*;

/**
 *
 * @author murinewt
 */

public class HotelMain extends JFrame{// implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static double foodQuantity;
    static boolean tryme = false;
    static String IDforFood="";
    double tot=0;
    //static String []  = new String[20];
    double changeToBe= 0.0;
    ArrayList<String>storeFood;
    
    //ActionListenerSubmit listen = new ActionListenerSubmit();
    public static HotelMain Hotel;
    HotelConnect food = new HotelConnect();
    Login login;// = new Login();
    //LoginJPanel loginout;
    //Login log = new Login();
    //HandleErrors error = new HandleErrors();
    
    JLabel totalprice = new JLabel();;
    JTextField numOfFood = new JTextField(10);
    JTextField IDFood = new JTextField(10);
    JTextField quantity = new JTextField(10);
    public JButton submit = new JButton("Next Customer"); 
    JButton display = new JButton("Display");
    JButton Total = new JButton("Total");
    JButton HotelDetails = new JButton("Details");
    JTextArea output = new JTextArea(20,30);
    JTextArea outputFood = new JTextArea(25,40);
    JTextField change = new JTextField(10);
    JLabel label = new JLabel();
    //JButton myMoney = new JButton("my Money");
    JButton delete = new JButton("Delete Record");
    JMenu menu = new JMenu("File");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem addJMenu = new JMenuItem("Add");
    JMenuItem deleteJMenu = new JMenuItem("Delete");
    JMenuBar barMenu = new JMenuBar();
    JMenu myMenu = new JMenu("Employer");
    JMenuItem myMoney = new JMenuItem("Money");
    boolean empty = true;
    
    
    public static void main(String [] args){
                    new HotelMain();
    }

    public HotelMain(){
        
        //updatefood = new UpdatePrice();
        //foodBeingUpdated = new UpdatePrice();
        this.storeFood = new ArrayList<String>();
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setResizable(true);
        setLocation(200,50);
        setSize(1050, 650);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(HotelDetails);
        HotelDetails.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        SwingUtilities.invokeLater(new Runnable(){
                            @Override
                            public void run(){
                                new UserLogin().setVisible(true);
                            }
                        });
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                }
        });
        add(new Label("Food ID"));
        add(IDFood);
        add(new Label("Quantity"));
        add(quantity);
        add(new Label("Amount"));
        add(change);
        change.setText("0");
        add(display);
        display.addActionListener(new ActionListener()
            {
        		
                @Override
                public void actionPerformed(ActionEvent e) {
                    String stringQuantity="";
                    double numQuantity = 0.0;
                    try{
                        //getting text from IDFood textbox then checking it in the database then converting it to a double
                    	totalprice.setText("");
                    	IDforFood = IDFood.getText();
                        String error = "";
                        
                        //getting the text from quantity textbox and then converting it to double
                        stringQuantity = quantity.getText();
                        empty = false;
                        String errorCheck = food.checkAvailability(IDforFood);
                       // String error = "";
                        if(IDforFood.equals(""))
                            error=error+"No ID is input";
                        else if(stringQuantity.equals(""))
                            error=error+"\nQuantity is not inputted";
                        else if(errorCheck.equals("No such Food"))
                            error=error+"No such Food";
                        
                        if(error.equals("")){
                            String eat = food.foodType(IDforFood);
                            double priceForEach = food.costOfEachFood(IDforFood);
                            
                            numQuantity = Double.parseDouble(stringQuantity);
                        foodQuantity = Double.parseDouble(quantity.getText());
                        
                            //getting the total of the quantity * price
                            double stFoodPrice = priceForEach*numQuantity;
                            String str=""+stFoodPrice;
                            storeFood.add(numQuantity+"\t"+eat+"\t"+stFoodPrice+"\n");
                            output.append("      "+numQuantity+"\t"+eat+"\t"+stFoodPrice+"\n");
                            tot = food.totalCostOfFoodC(stFoodPrice);
                            totalprice = new JLabel("Total: "+tot);
                            add(totalprice);
                            //System.out.println(" "+tot+"\n"+"count: "+food.listnum());
                            food.insertInto(stringQuantity,eat,str);
                            IDFood.setText("");
                            quantity.setText("");
                            getContentPane().repaint();}
                        else
                            HandleErrors.JOptionPaneMessages(error);
                    }
                    catch(Exception ex){
                    	HandleErrors.JOptionPaneMessages("Wrong Input");
                        System.out.println(ex);
                    }
                    
                }
            });
        add(Total);
        Total.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    //System.out.println(" "+tot+"\n");
                	double price=0.0;
                	if(empty == true)
                		HandleErrors.JOptionPaneMessages("Nothing is input");
                	else{
                	try{
	                    price = Double.parseDouble(change.getText());
	
	                    changeToBe = price-tot;
	                    if(changeToBe<0){
	                        HandleErrors.errorLessMoney();
	                         //new HandleErrors();
	                    }else
	                    {
	                        output.append("\n\tTotal: "+tot+"\n");
	                        String cashier = Login.getNames();
	                        output.append("     Thank you, You were served by: "+cashier+"\nNEXT CUSTOMER PLEASE\n");
	                        label = new JLabel("CHANGE: "+changeToBe);
	                        add(label);
	                    }
                    }
                	catch(Exception ex){
                		HandleErrors.JOptionPaneMessages("Wrong Input");
                		System.out.print(ex);
                	}
                }
                }
            });
        add(delete);
        delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                output.setText("");
                output();
                
            }
        });
        add(outputFood);
            ouputFood();
            output();            
        output.setEditable(false);
        add(submit);
        submit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //new Customer
                	totalprice.setText("");
                    label.setText("");
                    IDFood.setText("");
                    quantity.setText("");
                    change.setText("0");
                    outputFood.setText("");
                    ouputFood();
                    output.setText("");
                    
                    output();
                    
                    
                    //label = new JLabel("");
                    add(label);
                    //new MainHotel();
                    
                }
            }
        );    
        add(output);
        output.setEditable(false);
        
        setVisible(true);
    }
    public void output(){
        Date date= new Date();
        output.append("\t"+date+"\n");
        output.append("\t"+"You Ordered: \n\n");
        output.append("      "+"Quantity\tFood\tPrice\n"); 
    }
    public void ouputFood(){
        output.setText("");
        String [][] xyz = new String[food.listnum()][3];
        xyz=food.foodOffered();
        outputFood.append("Food  Offered  At  Sunrise\nID\tFood\tPrice\n");
        for(int x=0;x<food.listnum();x++){
            outputFood.append(xyz[x][0]);
            outputFood.append(xyz[x][1]);
            outputFood.append(xyz[x][2]);
        }
        
    }
}