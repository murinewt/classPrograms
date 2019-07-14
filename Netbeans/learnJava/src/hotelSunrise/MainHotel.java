/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class MainHotel extends JFrame{// implements ActionListener {
    static double foodQuantity;
    static boolean tryme = false;
    static String IDforFood;
    double tot=0;
    //static String []  = new String[20];
    double changeToBe= 0.0;
    ArrayList<String>storeFood;
    
    //ActionListenerSubmit listen = new ActionListenerSubmit();
    HotelConnect food = new HotelConnect();
    Login login;// = new Login();
    LoginJPanel loginout;
    //Login log = new Login();
    //HandleErrors error = new HandleErrors();
    
    JTextField numOfFood = new JTextField(10);
    JTextField IDFood = new JTextField(10);
    JTextField quantity = new JTextField(10);
    JButton submit = new JButton("Next Customer"); 
    JButton display = new JButton("Display");
    JButton Total = new JButton("Total");
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
    
    
    public static void main(String [] args){
       // 
        /*new Login();
        if(tryme==false){
            HandleErrors.errorWrongPassword();
        }
        else
            
        */
       /* do{
             
        }while(new Login().equals(true));*/
        new MainHotel();
        /*new Login();
        String syy = Login.returnMe();
             
        switch(syy){
                case "sunrise":
                    new MainHotel();
                    break;
                case "":
                    new MainHotel();
                default:
                    HandleErrors.JOptionPaneMessages("Wrong");
        }     */       
    }

    public MainHotel(){
        
        //updatefood = new UpdatePrice();
        //foodBeingUpdated = new UpdatePrice();
        this.storeFood = new ArrayList<String>();
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setResizable(false);
        setLocation(200,50);
        setSize(950, 550);
        setTitle("SUNRISE HOTELS JUJA");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        menu.add(addJMenu);
        addJMenu.addActionListener(new ActionListener(){
                
                boolean loginTrue=false; 
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    LoginJPanel.CreateAndShow();
                    String xy = LoginJPanel.returnMe();
                    if(xy.equals("sunrise"))
                        new AddToDatabase();
                    else if(!xy.equals("sunrise"))
                        HandleErrors.JOptionPaneMessages("Wrong");
                    
                        
                    
                }
        });
        
        menu.add(update);
        update.addActionListener(new ActionListener(){
                
                boolean loginTrue=false; 
                @Override
                public void actionPerformed(ActionEvent e) {
                    do{
                        new UpdateDataJFrame();
                    }
                    while(new Login().equals(true));
                    //loginTrue = true;
                }
                
            });
        
        menu.add(deleteJMenu);
        deleteJMenu.addActionListener(new ActionListener(){
                
                boolean loginTrue=false; 
                @Override
                public void actionPerformed(ActionEvent e) {
                    do{
                        new DeleteRecord();
                    }
                    while(new Login().equals(true));
                    
                }
        });
        myMenu.add(myMoney);
        myMoney.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    do{
                        SwingUtilities.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                            new MoneyIntheDatabase().setVisible(true);
                        }
                        });
                    }
                    while(new Login().equals(true));
                    
                }
        });
                
        
        barMenu.add(menu);
        barMenu.add(myMenu);
        barMenu.setBounds(0, 0, 950, 50);
        add(barMenu);
        
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
                    try{
                        //getting text from IDFood textbox then checking it in the database then converting it to a double
                        IDforFood = IDFood.getText();
                        String eat = food.foodType(IDforFood);
                        double priceForEach = food.costOfEachFood(IDforFood);
                        //getting the text from quantity textbox and then converting it to double
                        String stringQuantity = quantity.getText();
                        double numQuantity = Double.parseDouble(stringQuantity);
                        foodQuantity = Double.parseDouble(quantity.getText());
                        //getting the total of the quantity * price
                        double stFoodPrice = priceForEach*numQuantity;
                        String str=""+stFoodPrice;
                        storeFood.add(numQuantity+"\t"+eat+"\t"+stFoodPrice+"\n");
                        output.append("      "+numQuantity+"\t"+eat+"\t"+stFoodPrice+"\n");
                        tot = food.totalCostOfFoodC(stFoodPrice);
                        //System.out.println(" "+tot+"\n"+"count: "+food.listnum());
                        food.insertInto(stringQuantity,eat,str);
                        IDFood.setText("");
                        quantity.setText("");
                        getContentPane().repaint();
                    }catch(Exception ex){
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
                    double price = Double.parseDouble(change.getText());
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
            });
        add(delete);
        delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                //getContentPane().repaint();
                //error.removeItems(storeFood, yy);
                //error.removeMine();
                output.setText("");
                output();
                /*outputFood.append("Food  Offered  At  Sunrise\nID\tFood\tPrice\n");
                Date date= new Date();
                output.append(date+"\n");
                output.append("You Ordered: \n\n");
                output.append("Quantity\tFood\tPrice\n");*/
                
            }
        });
        add(outputFood);
            String [][] xyz = new String[food.listnum()][3];
            xyz=food.foodOffered();
            outputFood.append("Food  Offered  At  Sunrise\nID\tFood\tPrice\n");
            for(int x=0;x<food.listnum();x++){
                outputFood.append(xyz[x][0]);
                outputFood.append(xyz[x][1]);
                outputFood.append(xyz[x][2]);
            }
            output();            
        output.setEditable(false);
        add(submit);
        submit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //new Customer
                    label.setText("");
                    IDFood.setText("");
                    quantity.setText("");
                    change.setText("0");
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
        /*add(myMoney);
        myMoney.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel moneyLabel = new JLabel();
                    moneyLabel.removeAll();
                    moneyLabel = new JLabel(""+food.moneyIHave());
                    add(moneyLabel);
                    
                }
        });*/
        
        setVisible(true);
    }
    public void output(){
        Date date= new Date();
        output.append("\t"+date+"\n");
        output.append("\t"+"You Ordered: \n\n");
        output.append("      "+"Quantity\tFood\tPrice\n"); 
    }
}