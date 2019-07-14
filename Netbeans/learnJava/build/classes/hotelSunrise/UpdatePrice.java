/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */
public class UpdatePrice extends JFrame{
    private JTextField idFood, foodName, costFood;
    private JLabel labelID, labelFood, labelCost;
    private JTextArea details;
    private JButton button;
    private static String OK = "ok";
    static HotelConnect connect = new HotelConnect();
    //private static String on1="",tw2="",th3="",fo4="";
    
    
    public static void main(String [] args){
        //new UpdatePrice();
    }
    
    
    public UpdatePrice(){
        
        setLayout(null);
        setPreferredSize(500,400);
        setVisible(true);
        labelID = new JLabel("Food ID: ");
        idFood = new JTextField(10); 
        labelFood = new JLabel("Food Name: ");
        foodName = new JTextField(10);
        labelCost = new JLabel("Cost");
        costFood = new JTextField(10);
        details = new JTextArea(20,30);
        button = new JButton("Details");
        
        labelID.setBounds(10,10,100,30);
        idFood.setBounds(120,10,100,30);
        labelFood.setBounds(10,60,100,30);
        foodName.setBounds(120,60,100,30);
        labelCost.setBounds(10,110,100,30);
        costFood.setBounds(120,110,100,30);
        button.setBounds(250,40,100,30);
        details.setBounds(250,100,200,200);
        
        
        add(labelID);
        add(idFood);
        add(labelFood);
        add(foodName);
        add(labelCost);
        add(costFood);
        add(details);
        add(button);
        //idFood.setActionCommand(OK);
        button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        String [][] xyz = new String[1][3];
                        String id = idFood.getText();
                        xyz=connect.getItem(id);
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
        
        //details.setBounds(200,25,100,10);
        
        
        
    }
    public String getIDUpdate(){
        return idFood.getText();
    }
    
    public String getFoodUpdate(){
       return  foodName.getText();
    }
    
    public String getCostUpdate(){
        return costFood.getText();
    }
    private void setPreferredSize(int x, int y){
        
    }
    
    public boolean updateToDatabase(){
        boolean ifDone = false;
        String ID = idFood.getText();
        String food = foodName.getText();
        String Cost = costFood.getText();
        connect.updateItems(ID, food, Cost);
        ifDone = true;
        //details.setText();
        return ifDone;
    }
    
}
