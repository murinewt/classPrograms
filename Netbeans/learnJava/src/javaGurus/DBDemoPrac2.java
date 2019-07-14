package javaGurus;
/**
 * @author user
 */
import static javax.swing.JOptionPane.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DBDemoPrac2 extends JFrame implements ActionListener {
    JTextField firstName, surName, loginId;
    JButton writeBtn, displayBtn;
    DBHandler db = new DBHandler();
    
    public static void main(String[] args) {
        new DBDemoPrac2();
    }
    
    public DBDemoPrac2() {
        setLayout(new BorderLayout());
        firstName = new JTextField();
        surName = new JTextField();
        loginId = new JTextField();
        writeBtn = new JButton("Write to database");
        displayBtn = new JButton("Display database");
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(6, 1, 5, 5));
        middle.add(new JLabel("First name:"));
        middle.add(firstName);
        middle.add(new JLabel("Surname:"));
        middle.add(surName);
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
        setTitle("Database demo 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == writeBtn) {
            String f = firstName.getText();
            String s = surName.getText();
            String id = loginId.getText();
            // if any field is blank, signal an error
            if (f.equals("") || s.equals("") || id.equals("")) {
                showMessageDialog(this, "One or more fields blank");
                return;
            }
            boolean ok = db.write(f, s, id);
            loginId.setText("");
            if (!ok)
                showMessageDialog(this, "Duplicate key " + id);
            else {
                firstName.setText("");
                surName.setText("");
            }
        }
        if (e.getSource() == displayBtn) 
            db.displayUsers(System.out);
    }
}