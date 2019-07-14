package hotelSunrise;

import javax.swing.*;

/**
 *
 * @author user
 */
public class HandleErrors extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//MainHotel mainH= new MainHotel();
    public static void main(String [] args){
        new HandleErrors();
    }
    /*public HandleErrors(){
        setLayout(new FlowLayout());
        setSize(400, 70);
        add(new JLabel("Customer cant buy: money is less"));
        setVisible(true);
    }*/
    public static void errorLessMoney(){
        JOptionPane.showMessageDialog(null,"Customer cant buy: money is less","Error Message", JOptionPane.ERROR_MESSAGE);
    }
    public static void errorWrongPassword(){
        JOptionPane.showMessageDialog(null,"Wrong Password","Error Message", JOptionPane.ERROR_MESSAGE);
        
    }
    public static void JOptionPaneMessages(String message){
        JOptionPane.showMessageDialog(null,message," ", JOptionPane.INFORMATION_MESSAGE);
    }
}
