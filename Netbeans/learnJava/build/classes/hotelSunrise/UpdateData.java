/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelSunrise;

import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UpdateData {
    
    static UpdatePrice updatefood ;
    static UpdatePrice foodBeingUpdated;
    static HotelConnect connect = new HotelConnect() ;
    
    public static void main(String [] args){
            addToDatabase();
     }
    
    public static void addToDatabase(){
        foodBeingUpdated = new UpdatePrice();
        foodBeingUpdated.setPreferredSize(new Dimension(1000,600));
        JOptionPane.showMessageDialog(null, foodBeingUpdated,"Update Records",JOptionPane.OK_OPTION);
        updatefood.updateToDatabase();
        
        String id,food,cost,error="";
        double cost2;
        id = updatefood.getIDUpdate();
        food = updatefood.getFoodUpdate();
        cost = updatefood.getCostUpdate();
        if(id==null)
            error+="id is null\n";
        
        if(cost!= null){
            try{
                cost2 = Double.parseDouble(cost);
            }
            catch(NumberFormatException ex){
                error+="invalid cost";
            }
        }
        else
            error+="Cost is null";
        if(error.equals(""))
            connect.updateItems(id,food,cost);
        else
            JOptionPane.showMessageDialog(null, error,"Update Records",JOptionPane.ERROR_MESSAGE);
            
        
    }
    
    
}
