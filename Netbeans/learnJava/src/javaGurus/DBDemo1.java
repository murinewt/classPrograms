package javaGurus;
import java.sql.*;
/**
 *
 * @author murinewt
 */
public class DBDemo1 {
    public static void main(String [] args){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           Connection userDB = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\user\\Documents\\UserDB.accdb");//UcanAccess
            Statement myStatement = userDB.createStatement();
            String writeString = "INSERT INTO Users(Id, Surname, Firstname, Department, Position) VALUES('cf01','Fred','Bloggs','Computer Science','Lecturer')";
           // myStatement.executeUpdate(writeString);
            ResultSet results = myStatement.executeQuery("SELECT Id, Surname, Firstname, Department, Position  FROM Users ORDER BY Id");
            while(results.next()){
                System.out.print(results.getString(1)+" ");
                System.out.print(results.getString(2)+" ");
                System.out.print(results.getString(3)+" ");
                System.out.print(results.getString(4)+" "); 
                System.out.print(results.getString(5));
                System.out.println();
            }
            results.close();
        }
        catch(ClassNotFoundException cnfe){
            System.out.println(cnfe);
        }
        catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
    
}