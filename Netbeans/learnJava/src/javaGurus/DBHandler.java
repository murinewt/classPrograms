/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGurus;

/**
 *
 * @author user
 */
import static java.lang.System.*;
import java.io.*;
import java.sql.*;
class DBHandler {
    private Statement myStatement;
    public DBHandler() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection userDB = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\user\\Documents\\UserDB.accdb");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //String sourceURL ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=UserDB.mdb;";
            //Connection userDB = DriverManager.getConnection(sourceURL, "admin", "");
            myStatement = userDB.createStatement();
        }
        // The following exceptions must be caught
        catch (ClassNotFoundException cnfe) {
            out.println(cnfe);
        }
        catch (SQLException sqle) {
            out.println(sqle);
        }
    }
    public boolean write(String f, String s, String id) {
        String writeString =
        "INSERT INTO Users(Firstname, Surname, Id) VALUES('"
        + f + "', '" + s + "', '" + id + "')";
        try {
            myStatement.executeUpdate(writeString);
        }
        catch (SQLException sqle) {
            return false; // duplicate key
        }
        return true; // inserted OK
    }
    public void displayUsers(PrintStream outS) {
        try {
            ResultSet results = myStatement.executeQuery
            ("SELECT Firstname, Surname, Id FROM Users ORDER BY Id");
            while (results.next()) {
                outS.print(results.getString(1) + " ");
                outS.print(results.getString(2) + " ");
                outS.println(results.getString(3));
            }
            results.close();
        }
        catch (SQLException sqle) {
            out.println(sqle);
        }
    }
}