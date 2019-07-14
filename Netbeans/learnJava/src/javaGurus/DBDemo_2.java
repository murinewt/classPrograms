/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGurus;

import java.sql.*;
/**
 *
 * @author user
 */
public class DBDemo_2 {
     public static void main(String [] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDBmySQL","root","1828");
            Statement myStatement = con.createStatement();
            String writeString = "INSERT INTO userss(ID, firstName, secondName, department, position) VALUES('7','Fred','Bloggs','coetec','Lecturer')";
           // myStatement.executeUpdate(writeString);
            ResultSet results = myStatement.executeQuery("SELECT ID, firstName, secondName, department, Position FROM Userss ORDER BY ID");
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
