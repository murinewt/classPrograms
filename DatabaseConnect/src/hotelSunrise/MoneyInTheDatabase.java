package hotelSunrise;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 *
 * @author user
 */
public class MoneyInTheDatabase extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel money;
    HotelConnect food = new HotelConnect();
    
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MoneyInTheDatabase().setVisible(true);
            }
        });
    }
    
    public MoneyInTheDatabase(){
        super("SUNRISE HOTELS : Money ");
        JPanel newPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(100,250,100,300);
        
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        double moneyMy = HotelConnect.moneyIHave();
        
        money = new JLabel("Money is: "+moneyMy);
       
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(money, constraints);
        add(newPanel);
        pack();
        setLocationRelativeTo(null);
    }
    
}
