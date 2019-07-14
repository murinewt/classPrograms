package houseChanger;
import java.awt.Graphics; import java.awt.Color; 

public class PanelFlower extends javax.swing.JPanel { 
	private int amount; 
	public PanelFlower() { 
		initComponents(); 
		repaint(); 
	} 
	public void paintComponent(Graphics g){ 
		super.paintComponent(g); int teller; g.setColor(Color.RED); //flowerpot 
		g.fillRect(300, 350, 500, 100); 
		for (teller=1; teller <= amount ;teller++) { 
			//Flower 1 
			g.setColor(Color.GREEN); 
			//stem 
			g.fillRect(320 * teller, 250, 10, 100); 
			g.setColor(Color.PINK); 
			//petals 
			g.fillOval(304 * teller, 190, 40, 40); 
			g.fillOval(330 * teller, 210, 40, 40); 
			g.fillOval(320 * teller, 240, 40, 40); 
			g.fillOval(290 * teller, 240, 40, 40); 
			g.fillOval(280 * teller, 210, 40, 40); 
			g.setColor(Color.YELLOW); 
			//pistil 
			g.fillOval(312 * teller, 225, 25, 25); 
		} 
	} 
	@SuppressWarnings("unchecked") 
	// <editor-fold defaultstate="collapsed" desc="Generated Code"> 
	private void initComponents() { 
		lblamount = new javax.swing.JLabel(); 
		txtamount = new javax.swing.JTextField(); 
		lblcolor = new javax.swing.JLabel(); 
		txtcolor = new javax.swing.JTextField(); 
		btngrow = new javax.swing.JButton(); 
		btnreset = new javax.swing.JButton(); 
		lblamount.setText("Amount: "); 
		txtamount.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent evt) { 
				txtamountActionPerformed(evt); 
				} 
			}
		); 
		lblcolor.setText("Color: "); 
		btngrow.setText("Grow!"); 
		btnreset.setText("Reset Size"); 
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this); 
		this.setLayout(layout); 
		layout.setHorizontalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
				.addGroup(layout.createSequentialGroup() .addContainerGap() .addComponent(lblamount) 
						.addGap(18, 18, 18) 
						.addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 57, 
								javax.swing.GroupLayout.PREFERRED_SIZE) 
						.addGap(41, 41, 41) .addComponent(lblcolor) 
						.addGap(18, 18, 18) .addComponent(txtcolor, 
								javax.swing.GroupLayout.PREFERRED_SIZE, 59, 
								javax.swing.GroupLayout.PREFERRED_SIZE) 
						.addGap(60, 60, 60) .addComponent(btngrow) 
						.addGap(18, 18, 18) .addComponent(btnreset) 
						.addContainerGap(230, Short.MAX_VALUE)) ); 
		layout.setVerticalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
				.addGroup(layout.createSequentialGroup() .addContainerGap() 
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
								.addComponent(lblamount) 
								.addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 
										javax.swing.GroupLayout.DEFAULT_SIZE, 
										javax.swing.GroupLayout.PREFERRED_SIZE) 
								.addComponent(lblcolor) 
								.addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 
										javax.swing.GroupLayout.DEFAULT_SIZE, 
										javax.swing.GroupLayout.PREFERRED_SIZE) 
								.addComponent(btngrow) .addComponent(btnreset)) 
						.addContainerGap(412, Short.MAX_VALUE)) ); 
		}
	// </editor-fold> 
	private void txtamountActionPerformed(java.awt.event.ActionEvent evt) { 
		amount = 2;//Integer.parseInt(txtamount.getText()); 
		repaint(); } 
	// Variables declaration - do not modify 
	private javax.swing.JButton btngrow; 
	private javax.swing.JButton btnreset; 
	private javax.swing.JLabel lblamount; 
	private javax.swing.JLabel lblcolor; 
	private javax.swing.JTextField txtamount; 
	
	private javax.swing.JTextField txtcolor; // End of variables declaration 
}




