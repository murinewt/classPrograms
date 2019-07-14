package houseChanger;
/*and add red, yellow, orange and a few other colours. With each modification of the colour, the flowers change colour.A listbox would be even better.

Make a button where the flower bud doubles in size and another button returning the flower to its initial size.

Minimum of one or more text boxes where the size of an object can be given as well as a total.The distance between the objects depend on the given size. These objects can be anything ex. watering can, glass of water, mini-farmer...Let your fantasy work.

Add a comment to each drawn object. With this you say what exactly is being drawn.

Also make use of an image.

So far I've managed to draw one flower and I've gotten my loop to work more or less...but the positions get messed up. I'm using Netbeans. Here is the code from my panel:

package Versie4;*/
import java.awt.Graphics; 
import java.awt.Color; 
/*public class PanelFlowers extends javax.swing.JPanel { private int amount; public PanelFlowers() { initComponents(); repaint(); } public void paintComponent(Graphics g){ super.paintComponent(g); int teller; g.setColor(Color.RED); //flowerpot g.fillRect(300, 350, 500, 100); for (teller=1; teller <= amount ;teller++) { //Flower 1 g.setColor(Color.GREEN); //stem g.fillRect(320 * teller, 250, 10, 100); g.setColor(Color.PINK); //petals g.fillOval(304 * teller, 190, 40, 40); g.fillOval(330 * teller, 210, 40, 40); g.fillOval(320 * teller, 240, 40, 40); g.fillOval(290 * teller, 240, 40, 40); g.fillOval(280 * teller, 210, 40, 40); g.setColor(Color.YELLOW); //pistil g.fillOval(312 * teller, 225, 25, 25); } } @SuppressWarnings("unchecked") // <editor-fold defaultstate="collapsed" desc="Generated Code"> private void initComponents() { lblamount = new javax.swing.JLabel(); txtamount = new javax.swing.JTextField(); lblcolor = new javax.swing.JLabel(); txtcolor = new javax.swing.JTextField(); btngrow = new javax.swing.JButton(); btnreset = new javax.swing.JButton(); lblamount.setText("Amount: "); txtamount.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) { txtamountActionPerformed(evt); } }); lblcolor.setText("Color: "); btngrow.setText("Grow!"); btnreset.setText("Reset Size"); javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this); this.setLayout(layout); layout.setHorizontalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(layout.createSequentialGroup() .addContainerGap() .addComponent(lblamount) .addGap(18, 18, 18) .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(41, 41, 41) .addComponent(lblcolor) .addGap(18, 18, 18) .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(60, 60, 60) .addComponent(btngrow) .addGap(18, 18, 18) .addComponent(btnreset) .addContainerGap(230, Short.MAX_VALUE)) ); layout.setVerticalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(layout.createSequentialGroup() .addContainerGap() .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) .addComponent(lblamount) .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(lblcolor) .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(btngrow) .addComponent(btnreset)) .addContainerGap(412, Short.MAX_VALUE)) ); }// </editor-fold> private void txtamountActionPerformed(java.awt.event.ActionEvent evt) { amount = Integer.parseInt(txtamount.getText()); repaint(); } // Variables declaration - do not modify private javax.swing.JButton btngrow; private javax.swing.JButton btnreset; private javax.swing.JLabel lblamount; private javax.swing.JLabel lblcolor; private javax.swing.JTextField txtamount; private javax.swing.JTextField txtcolor; // End of variables declaration }

And here is the frame:
 */
public class FrameFlowers extends javax.swing.JFrame { 
	public FrameFlowers() { 
		initComponents(); 
		setSize(900, 600); 
		setContentPane(new PanelFlower()); 
		} 
	@SuppressWarnings("unchecked") 
	// <editor-fold defaultstate="collapsed" desc="Generated Code"> 
	private void initComponents() { 
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); 
		getContentPane().setLayout(layout); 
		layout.setHorizontalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
				.addGap(0, 400, Short.MAX_VALUE) ); 
		layout.setVerticalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
				.addGap(0, 300, Short.MAX_VALUE) ); pack(); 
	}
	// </editor-fold> /** * @param args the command line arguments */ 
	public static void main(String args[]) { 
		/* Set the Nimbus look and feel */ 
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> 
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. 
		 * * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */ 
		try { for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { 
			if ("Nimbus".equals(info.getName())) { 
				javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; 
				} 
			} 
		} catch (ClassNotFoundException ex) { 
			java.util.logging.Logger.getLogger(FrameFlowers.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex); 
		} catch (InstantiationException ex) { 
			java.util.logging.Logger.getLogger(FrameFlowers.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex); 
		} catch (IllegalAccessException ex) { 
			java.util.logging.Logger.getLogger(FrameFlowers.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex); 
		} catch (javax.swing.UnsupportedLookAndFeelException ex) { 
			java.util.logging.Logger.getLogger(FrameFlowers.class.getName())
			.log(java.util.logging.Level.SEVERE, null, ex); 
		} 
		//</editor-fold> /* Create and display the form */ 
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() { 
			new FrameFlowers().setVisible(true); 
			} 
			}); 
		} 
	// Variables declaration - do not modify // End of variables declaration }
}
