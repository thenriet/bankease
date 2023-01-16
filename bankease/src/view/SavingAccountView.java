package view;

import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Dimension;

import controller.SavingAccountHandler;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

public class SavingAccountView extends JFrame {
	private JTextField titulaire;
	private JTextField txtOuvrirUnCompte;
	private JRadioButton Compte_courant;
	private JRadioButton Compte_epargne;
	ActionListener actionListener;
	private JTextField interest_rate;
	private JTextField balance_limit;
	private JTextField balance;
	private JTextField num_compte;
	private JTextField solde_initial;


	public SavingAccountView() {
		
		getContentPane().setLayout(null);
		setSize(660,700);
		JLabel monMessage = new JLabel("  ");
		monMessage.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage.setForeground(new Color(255, 0, 0));
		monMessage.setBounds(197, 240, 184, 14);
		getContentPane().add(monMessage);
		
		
		// Choisir compte courant ou compte épargne
	
			
			titulaire = new JTextField();
			titulaire.setBounds(197, 222, 309, 20);
			getContentPane().add(titulaire);
			titulaire.setColumns(10);
			
			interest_rate = new JTextField();
			interest_rate.setColumns(10);
			interest_rate.setBounds(197, 281, 309, 20);
			getContentPane().add(interest_rate);
			
			balance_limit = new JTextField();
			balance_limit.setColumns(10);
			balance_limit.setBounds(197, 347, 309, 20);
			getContentPane().add(balance_limit);
			
			balance = new JTextField();
			balance.setColumns(10);
			balance.setBounds(197, 417, 309, 20);
			getContentPane().add(balance);	
			
			Panel panel_1 = new Panel();
			panel_1.setBackground(new Color(255, 128, 128));
			panel_1.setBounds(0, 0, 646, 68);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			
			
			// Récupérer ce qui est rentré dans les zones de texte

			
			JButton btnNewButton = new JButton("Valider");
			btnNewButton.setBackground(new Color(255, 128, 192));
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String titu = titulaire.getText();
					float bal = Float.parseFloat(balance.getText());
					float bal_limit= Float.parseFloat(balance_limit.getText());
					float interest= Float.parseFloat(interest_rate.getText());
					
					try {
						
						// TODO ajouter num compte et client id
						
						if (SavingAccountHandler.createSavingAccount(44,444444,titu,bal,interest,bal_limit)==null) {
							
							monMessage.setText("100 caractères maximum");
							setVisible(true);
						}
						
						else{SavingAccountHandler.createSavingAccount(44,444444,titu,bal,interest,bal_limit);}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}
				
			});
			btnNewButton.setBounds(142, 545, 89, 23);
			getContentPane().add(btnNewButton);

			
			//Affichage des titres
			
			JLabel lblNewLabel = new JLabel("Solde minimum");
			lblNewLabel.setBounds(72, 350, 92, 14);
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Libellé Client");
			lblNewLabel_1.setBounds(72, 225, 82, 14);
			getContentPane().add(lblNewLabel_1);
			JLabel lblNewLabel_2 = new JLabel("Type de compte");
			lblNewLabel_2.setBounds(72, 124, 96, 23);
			getContentPane().add(lblNewLabel_2);
 		
			JLabel lblNewLabel_3 = new JLabel("Frais de transfert");
			lblNewLabel_3.setBounds(72, 284, 95, 14);
			getContentPane().add(lblNewLabel_3);
	
			Box horizontalBox_1 = Box.createHorizontalBox();
			horizontalBox_1.setBounds(102, 436, 1, 1);
			getContentPane().add(horizontalBox_1);

			
			JButton btnNewButton_1 = new JButton("Retour");
			btnNewButton_1.setBackground(new Color(255, 128, 192));
			btnNewButton_1.setBounds(392, 545, 89, 23);
			getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel_4 = new JLabel("Solde initial");
			lblNewLabel_4.setBounds(72, 420, 92, 14);
			getContentPane().add(lblNewLabel_4);
			



	}
}
