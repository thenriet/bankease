package view;

import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Dimension;

import controller.CheckingAccountHandler;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

public class CheckingAccountView extends JFrame {
	private JTextField titulaire;
	private JTextField txtOuvrirUnCompte;
	private JRadioButton Compte_courant;
	private JRadioButton Compte_epargne;
	ActionListener actionListener;
	private JTextField transfer_fee;
	private JTextField min_balance;
	private JTextField balance;
	private JTextField num_compte;
	private JTextField solde_initial;
	float transfer;
	float min_bal;
	float bal;

	public CheckingAccountView() {
		
		getContentPane().setLayout(null);
		setSize(660,700);
		

//		
		JLabel monMessage = new JLabel("  ");
		monMessage.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage.setForeground(new Color(255, 0, 0));
		monMessage.setBounds(197, 240, 184, 14);
		getContentPane().add(monMessage);
		
		JLabel monMessage_2 = new JLabel("   ");
		monMessage_2.setForeground(new Color(255, 0, 0));
		monMessage_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_2.setBounds(197, 297, 108, 14);
		getContentPane().add(monMessage_2);
		
		JLabel monMessage_3 = new JLabel("  ");
		monMessage_3.setForeground(Color.RED);
		monMessage_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_3.setBounds(197, 367, 108, 14);
		getContentPane().add(monMessage_3);
		
		JLabel monMessage_4 = new JLabel("  ");
		monMessage_4.setForeground(Color.RED);
		monMessage_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_4.setBounds(197, 436, 108, 14);
		getContentPane().add(monMessage_4);
		
		JLabel monMessage_5 = new JLabel("  ");
		monMessage_5.setForeground(new Color(255, 0, 0));
		monMessage_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		monMessage_5.setBounds(72, 485, 406, 14);
		getContentPane().add(monMessage_5);
		
		
		// Choisir compte courant ou compte épargne
	
			
			titulaire = new JTextField();
			titulaire.setBounds(197, 222, 309, 20);
			getContentPane().add(titulaire);
			titulaire.setColumns(10);
			
			transfer_fee = new JTextField();
			transfer_fee.setColumns(10);
			transfer_fee.setBounds(197, 281, 309, 20);
			getContentPane().add(transfer_fee);
			
			min_balance = new JTextField();
			min_balance.setColumns(10);
			min_balance.setBounds(197, 347, 309, 20);
			getContentPane().add(min_balance);
			
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

					
					try {
						
						// TODO ajouter num compte et client id

						if (monMessage_2.getText()==null || monMessage_2.getText().isEmpty()) {
													
						//if (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_balance") {
							monMessage_2.setText("Entrer un chiffre valide");
							setVisible(true);
						}
						
						else {transfer= Float.parseFloat(transfer_fee.getText());}
						
						if (monMessage_3.getText()==null || monMessage_3.getText().isEmpty()) {
						//if (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_min_balance") {
							monMessage_3.setText("Entrer un chiffre valide");
							setVisible(true);
						}
						
						else {min_bal= Float.parseFloat(min_balance.getText());}
						
						if (monMessage_4.getText()==null || monMessage_4.getText().isEmpty()) {
						//if (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_transfer_fee") {
							monMessage_4.setText("Entrer un chiffre valide");
							setVisible(true);
						}
						
						else {bal=Float.parseFloat(balance.getText());}
													
						if (titu.length()>100) {
							monMessage.setText("100 caractères maximum");
							setVisible(true);
						}
													
						if(bal<min_bal) {
							monMessage_5.setText("Le solde initial doit être supérieur au solde minimum");
							setVisible(true);
						}
						
						else{
	
							CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal);}
						
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
