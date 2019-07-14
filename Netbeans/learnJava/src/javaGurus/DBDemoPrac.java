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
import static javax.swing.JOptionPane.*;
import static java.lang.System.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class DBDemoPrac extends JFrame implements ActionListener {
    JTextField firstName, surname, loginId;
    JButton writeBtn, displayBtn;
    Connection userDB;
    Statement myStatement;
    public static void main(String[] args) { 
        new DBDemoPrac(); 
    }
    public DBDemoPrac() {
        setLayout(new BorderLayout());
        firstName = new JTextField();
        surname = new JTextField();
        loginId = new JTextField();
        writeBtn = new JButton("Write to database");
        displayBtn = new JButton("Display database");
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(6, 1, 5, 5));
        middle.add(new JLabel("First name:"));
        middle.add(firstName);
        middle.add(new JLabel("Surname:"));
        middle.add(surname);
        middle.add(new JLabel("Login ID:"));
        middle.add(loginId);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.add(writeBtn);
        bottom.add(displayBtn);
        add("South", bottom);
        add("West", new JPanel());
        add("East", new JPanel());
        writeBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        setSize(300, 250);
        setTitle("Database demo 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection userDB = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\user\\Documents\\UserDB.accdb");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //String sourceURL ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=UserDB.mdb;";
            //userDB = DriverManager.getConnection(sourceURL);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == writeBtn) {
            String f = firstName.getText();
            String s = surname.getText();
            String id = loginId.getText();
            // if any field is blank, signal an error
            if (f.equals("") || s.equals("") || id.equals("")) {
                showMessageDialog(this, "One or more fields blank");
                return;
            }
            String writeString = "INSERT INTO Users(Firstname, Surname, Id) VALUES('"+ f + "', '" + s + "', '" + id + "')";
            try {
                myStatement.executeUpdate(writeString);
                firstName.setText("");
                surname.setText("");
            }
            catch (SQLException sqle) {
                showMessageDialog(this, "Duplicate key " + id);
            }
            loginId.setText("");
        }
        if (e.getSource() == displayBtn) {
            try {
                ResultSet results = myStatement.executeQuery
                ("SELECT Firstname, Surname, Id FROM Users ORDER BY Id");
                while (results.next()) {
                    out.print(results.getString(1) + " ");
                    out.print(results.getString(2) + " ");
                    out.println(results.getString(3));
                }
            results.close();
            }
            catch (SQLException sqle) {
                out.println(sqle);
            }
        }
    }
}