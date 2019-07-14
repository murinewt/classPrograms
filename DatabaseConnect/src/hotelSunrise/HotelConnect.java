package hotelSunrise;

import static java.lang.System.out;
import java.sql.*;

/**
 *
 * @author murinewt
 */ 

public class HotelConnect {
    double costMoney=0.0;
    private static Statement myStatement;
    private Connection userDB;
    static ResultSet results;
    
    public static void main(String[] args) {
        new HotelConnect();
    }
    
    public HotelConnect(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            userDB = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\user\\Documents\\hotelMenu.accdb");
            
            myStatement = userDB.createStatement();
            //System.out.println("Connection Good");
        }
        catch (ClassNotFoundException cnfe) {
            out.println(cnfe);
        }
        catch (SQLException sqle) {
            out.println(sqle);
        }
        //foodType("10");
        //costOfEachFood("10");
        //foodOffered();
        //listnum();
        //moneyIHave();
        //updateItems("1","chapati","10");
        //insertNew("ugaliBeans","40");
        
        /*String [][] xyz = new String[1][3];
        xyz=getItem("1");
        for(int x=0;x<1;x++){
            System.out.print(xyz[x][0]);
            System.out.print(xyz[x][1]);
            System.out.print(xyz[x][2]);
        }*/
        //deleteRecordFromDatabase("30");
        
    }
    
    public String foodType(String number){
        String getFood=" ";
         try {
                ResultSet results = myStatement.executeQuery
                ("SELECT food FROM menuHotel WHERE ID="+number);
                while (results.next()) {
                    getFood=results.getString(1);
                   //System.out.print(getFood);
                }
            results.close();
            }
            catch (SQLException sqle) {
                out.println(sqle);
            }
        return getFood;
    }
    public String checkAvailability(String number){
        String getFood;
        String error= "";
        try{
            ResultSet results = myStatement.executeQuery
            ("SELECT food FROM menuHotel WHERE ID="+number);
            while (results.next()) {
                   
                    getFood=results.getString(1);
                   System.out.print(getFood);
            }
            results.close();
        }
        catch (SQLException sqle) {
            error="No such Food";
            out.println(sqle);
        }
        
        return error;
    }
    
    public double costOfEachFood(String autoNum){
        String smoney="";
        double money=0;
        try{
                ResultSet results = myStatement.executeQuery
                ("SELECT Cost FROM menuHotel WHERE ID="+autoNum);
                while (results.next()) {
                    smoney=results.getString(1);
                    //out.print(money);
                }
            money =Double.parseDouble(smoney);
            results.close();
            }
            catch (SQLException sqle) {
                out.println(sqle);
            }
        return money;
    }
    
    public int listnum(){
        int num=0;
        try{
            ResultSet count = myStatement.executeQuery("SELECT ID, Food, Cost FROM menuHotel");
            while(count.next()) {
                num++;
            }
            //out.print(num);
        }
        catch(SQLException sql){
            out.print(sql);
        }
        return num;
    }
    
    public String[][] foodOffered(){      
        int x=0;
        String[][]  food= new String[listnum()][3];
        try{
            ResultSet results = myStatement.executeQuery("SELECT ID, Food, Cost FROM menuHotel");
            while (results.next()) {
                food[x][0]=(results.getString(1) + "\t");
                food[x][1]=(results.getString(2));
                food[x][2]=("\t"+results.getString(3)+"\n");
                x++;
            }
            results.close();
        }
        catch (SQLException sqle) {
            out.println(sqle);
        }
        return food;
    }
   
    public double totalCostOfFoodC(double cost){
        costMoney+=cost;
        return costMoney;
    }
   
   
    public void insertInto(String Quantity, String Food, String Price){
       
        String writeString = "INSERT INTO customers(quantity, food, price) VALUES('"+ Quantity + "', '" + Food + "', '" + Price + "')";
        try {
                myStatement.executeUpdate(writeString);
        }
        catch(SQLException sql){
           System.out.println(sql);
        }
    }
   
    public static double moneyIHave(){
        double myMoney = 0;
        ResultSet result;
        String writeString = "SELECT price FROM Customers";
        try{
            result = myStatement.executeQuery(writeString);

            while(result.next()){
                myMoney += Double.parseDouble(result.getString(1)); 
          }
        }
        catch(SQLException sql){
            System.out.println(sql);
        }
        System.out.print(myMoney);
        return myMoney;  
    }
    public void updateItems(String Id, String nameOfFood, String newCost){

        String writeString = "UPDATE menuHotel SET Cost ='" + newCost + "'WHERE ID ='"+ Id + "'";
        String anotherWrite = "UPDATE menuHotel SET Food ='"+nameOfFood+"'WHERE ID ='"+ Id + "'";
        try{
            myStatement.executeUpdate(writeString);
            myStatement.executeUpdate(anotherWrite);

        }
        catch(SQLException sql){
            System.out.println(sql);
        }

    }
    public void insertNew(String foodType, String Cost){

        String writeString = "INSERT INTO menuHotel(Food, Cost) VALUES('" + foodType + "', '" + Cost + "')";
        try{
            myStatement.executeUpdate(writeString);
        }
        catch(SQLException sql){
            System.out.println(sql);
        }

    }
    public static String[][] getItem(String foodId){
        int x=0;
        String[][]  food= new String[1][3];
        String getfood = "SELECT ID, Food, Cost FROM menuHotel WHERE ID ='" + foodId + "'";
        try{
           results = myStatement.executeQuery(getfood);
           while (results.next()) {
                food[x][0]=(results.getString(1) + "\t");
                food[x][1]=(results.getString(2));
                food[x][2]=("\t"+results.getString(3)+"\n");
                x++;
            }
            results.close();
        }
        catch(SQLException sql){
            System.out.println(sql);
        }
        return food;
    
    }
    
    
    public void deleteRecordFromDatabase(String foodId){
        String getfood = "DELETE * FROM menuHotel WHERE ID ='" + foodId + "'";
        try{
           myStatement.executeUpdate(getfood);
        }
        catch(SQLException sql){
            System.out.println(sql);
        }   
    }
    
}
