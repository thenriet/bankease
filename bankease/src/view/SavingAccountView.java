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
	float int_rate;
	float bal_lim;
	float bal;

	public SavingAccountView() {

		getContentPane().setLayout(null);
		setSize(660, 700);

		JLabel monMessageS = new JLabel("  ");
		monMessageS.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessageS.setForeground(new Color(255, 0, 0));
		monMessageS.setBounds(197, 240, 184, 14);
		getContentPane().add(monMessageS);

		JLabel monMessage_2S = new JLabel("   ");
		monMessage_2S.setForeground(new Color(255, 0, 0));
		monMessage_2S.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_2S.setBounds(197, 297, 108, 14);
		getContentPane().add(monMessage_2S);

		JLabel monMessage_3S = new JLabel("  ");
		monMessage_3S.setForeground(Color.RED);
		monMessage_3S.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_3S.setBounds(197, 367, 108, 14);
		getContentPane().add(monMessage_3S);

		JLabel monMessage_4S = new JLabel("  ");
		monMessage_4S.setForeground(Color.RED);
		monMessage_4S.setFont(new Font("Tahoma", Font.PLAIN, 8));
		monMessage_4S.setBounds(197, 436, 108, 14);
		getContentPane().add(monMessage_4S);

		JLabel monMessage_5S = new JLabel("  ");
		monMessage_5S.setForeground(new Color(255, 0, 0));
		monMessage_5S.setFont(new Font("Tahoma", Font.PLAIN, 11));
		monMessage_5S.setBounds(72, 485, 406, 14);
		getContentPane().add(monMessage_5S);

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

				try {

					// TODO ajouter num compte et client id

					if (monMessage_2S.getText() == null || monMessage_2S.getText().isEmpty()) {

						// if
						// (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_balance")
						// {
						monMessage_2S.setText("Entrer un chiffre valide");
						setVisible(true);
					}

					else {
						int_rate = Float.parseFloat(interest_rate.getText());
					}

					if (monMessage_3S.getText() == null || monMessage_3S.getText().isEmpty()) {
						// if
						// (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_min_balance")
						// {
						monMessage_3S.setText("Entrer un chiffre valide");
						setVisible(true);
					}

					else {
						bal_lim = Float.parseFloat(balance_limit.getText());
					}

					if (monMessage_4S.getText() == null || monMessage_4S.getText().isEmpty()) {
						// if
						// (CheckingAccountHandler.createCheckingAccount(44,444444,titu,bal,transfer,min_bal)=="type_transfer_fee")
						// {
						monMessage_4S.setText("Entrer un chiffre valide");
						setVisible(true);
					}

					else {
						bal = Float.parseFloat(balance.getText());
					}

					if (titu.length() > 100) {
						monMessageS.setText("100 caractères maximum");
						setVisible(true);
					}

					if (bal > bal_lim) {
						monMessage_5S.setText("Le solde initial doit être inférieur au plafond");
						setVisible(true);
					}

					else {

						SavingAccountHandler.createSavingAccount(44, 444444, titu, bal, int_rate, bal_lim);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(142, 545, 89, 23);
		getContentPane().add(btnNewButton);

		// Affichage des titres

		JLabel lblNewLabel = new JLabel("Plafond");
		lblNewLabel.setBounds(72, 350, 92, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Libellé Client");
		lblNewLabel_1.setBounds(72, 225, 82, 14);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Type de compte");
		lblNewLabel_2.setBounds(72, 124, 96, 23);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Taux d'intérêt");
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
