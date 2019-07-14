
package javaGurus;
import java.sql.*;

public class ddemo_2 {
    public static void main(String [] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDBmySQL","root","1828");
            Statement myStatement = con.createStatement();
            String writeString = "INSERT INTO Users(ID, Surname, First_name, Department, Position_) VALUES('cf01','Fred','Bloggs','1968-01-26','Lecturer')";
            //myStatement.executeUpdate(writeString);
            ResultSet results = myStatement.executeQuery("SELECT ID, Surname, First_name, Department, Position_  FROM Users ORDER BY Id");
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
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
         catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
}
