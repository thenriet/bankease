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

public class OuvrirCompte extends JFrame implements ActionListener {

	private JTextField num_compte;
	private JTextField solde_initial;
	private JTextField titulaire;
	private JTextField txtOuvrirUnCompte;
	private JRadioButton Compte_courant;
	private JRadioButton Compte_epargne;
	ActionListener actionListener;

	public OuvrirCompte() {
		
		getContentPane().setLayout(null);
		setSize(660,700);
		
		num_compte = new JTextField();
		
		// Choisir compte courant ou compte épargne
		
		Compte_courant = new JRadioButton("Courant");
		Compte_courant.setBounds(217, 104, 111, 23);
		getContentPane().add(Compte_courant);
		
		Compte_epargne = new JRadioButton("Epargne");
		Compte_epargne.setBounds(217, 144, 111, 23);
		getContentPane().add(Compte_epargne);
		
		ButtonGroup group = new ButtonGroup();
		group.add(Compte_courant);
		group.add(Compte_epargne);
		
	    Compte_epargne.addActionListener(this);
	    Compte_courant.addActionListener(this);
		
		setVisible(true); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Compte_courant.isSelected()){  
			num_compte.setBounds(320, 230, 186, 20);
			getContentPane().add(num_compte);
			num_compte.setColumns(10);
			
			solde_initial = new JTextField();
			solde_initial.setBounds(58, 311, 448, 20);
			getContentPane().add(solde_initial);
			solde_initial.setColumns(10);
			
			titulaire = new JTextField();
			titulaire.setBounds(58, 230, 173, 20);
			getContentPane().add(titulaire);
			titulaire.setColumns(10);
			
			Panel panel_1 = new Panel();
			panel_1.setBackground(new Color(255, 128, 128));
			panel_1.setBounds(-25, 0, 734, 68);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			txtOuvrirUnCompte = new JTextField();
			txtOuvrirUnCompte.setBounds(247, 5, 96, 20);
			txtOuvrirUnCompte.setText("Ouvrir un compte");
			panel_1.add(txtOuvrirUnCompte);
			txtOuvrirUnCompte.setColumns(10);
			
			
			// Récupérer ce qui est rentré dans les zones de texte

			
			JButton btnNewButton = new JButton("Valider");
			btnNewButton.setBackground(new Color(255, 128, 192));
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int n_compte = Integer.parseInt(num_compte.getText());
					int solde = Integer.parseInt(solde_initial.getText());
					int titu = Integer.parseInt(titulaire.getText());

					try {
						CheckingAccountHandler.createCheckingAccount(n_compte,0,0,solde,titu,0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});
			btnNewButton.setBounds(102, 493, 89, 23);
			getContentPane().add(btnNewButton);

			
			//Affichage des titres
			
			JLabel lblNewLabel = new JLabel("solde initial");
			lblNewLabel.setBounds(320, 205, 73, 14);
			getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("n° de compte");
			lblNewLabel_1.setBounds(58, 205, 82, 14);
			getContentPane().add(lblNewLabel_1);
			JLabel lblNewLabel_2 = new JLabel("Type de compte");
			lblNewLabel_2.setBounds(58, 104, 96, 23);
			getContentPane().add(lblNewLabel_2);
 		
			JLabel lblNewLabel_3 = new JLabel("Titulaire");
			lblNewLabel_3.setBounds(59, 286, 49, 14);
			getContentPane().add(lblNewLabel_3);
	
			Box horizontalBox_1 = Box.createHorizontalBox();
			horizontalBox_1.setBounds(102, 436, 1, 1);
			getContentPane().add(horizontalBox_1);

			
			JButton btnNewButton_1 = new JButton("Annuler");
			btnNewButton_1.setBackground(new Color(255, 128, 192));
			btnNewButton_1.setBounds(336, 493, 89, 23);
			getContentPane().add(btnNewButton_1);
		

		}
		if(Compte_epargne.isSelected()){    
			

			
		}   
		setVisible(true);

		pack();
		setSize(660,700);
	}

}
