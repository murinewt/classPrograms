/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class DeleteRecord extends JFrame {
    static HotelMain Hotel; 
    
     static String id,food,cost,error="";
    static double cost2;
    //static String id;
    
    
    private static JTextField idFood = new JTextField(10);
    private JLabel labelID = new JLabel("Food ID: ");
    private JTextArea details = new JTextArea(10,20);
    private JButton display = new JButton("view"), okey = new JButton("Delete from database");
    static HotelConnect connect = new HotelConnect();
    
    public static void main(String [] args){
        
            new DeleteRecord();
    }
    
    public DeleteRecord(){
        setResizable(false);
        setLocation(480,200);
        setLayout(new FlowLayout());
        setSize(400, 300);
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
        add(details);
        add(okey);
        okey.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    
                    id = idFood.getText();
                    if(id.equals(""))
                        error+="id is null\n";
                    
                    if(error.equals("")){
                        connect.deleteRecordFromDatabase(id);
                        HandleErrors.JOptionPaneMessages("Deletion Successfull");
                        String [][] xyz = new String[1][3];
                        
                        idFood.setText("");
                       
                       
                    }
                    else{
                        JOptionPane.showMessageDialog(null, error,"Delete Records",JOptionPane.ERROR_MESSAGE);
                        error = "";
                    }
                }
            });
        setVisible(true);
                
    }
    
    
}
