package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.CheckingAccountHandler;
import controller.SavingAccountHandler;

public class OpenAccountView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField titulaire;
	private int global_id;
	private JRadioButton Compte_courant;
	private JRadioButton Compte_epargne;
	ActionListener actionListener;
	private JTextField transfer_fee;
	private JTextField min_balance;
	private JTextField balance;
	private JTextField interest_rate;
	private JTextField balance_limit;
	float transfer;
	float min_bal;
	float bal;
	float int_rate;
	float bal_lim;
	JFrame frame = new JFrame("Checking account");

	public OpenAccountView(int id) {

		global_id = id;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(660, 700);
		setLocationRelativeTo(null);

		new JPanel();

		JLabel lblNewLabel_2 = new JLabel("Type de compte");
		lblNewLabel_2.setBounds(72, 124, 96, 23);
		getContentPane().add(lblNewLabel_2);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(102, 436, 1, 1);
		getContentPane().add(horizontalBox_1);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(0, 0, 646, 68);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

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

		if (Compte_courant.isSelected()) {

			getContentPane().removeAll();

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

			JLabel monMessage = new JLabel("  ");
			monMessage.setFont(new Font("Tahoma", Font.PLAIN, 8));
			monMessage.setForeground(new Color(255, 0, 0));
			monMessage.setBounds(197, 240, 184, 14);
			getContentPane().add(monMessage);

			JLabel monMessage_5 = new JLabel("  ");
			monMessage_5.setForeground(new Color(255, 0, 0));
			monMessage_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
			monMessage_5.setBounds(72, 485, 406, 14);
			getContentPane().add(monMessage_5);

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

			// Récupérer ce qui est rentré dans les zones de texte

			JButton btnNewButton = new JButton("Valider");
			btnNewButton.setBackground(new Color(255, 128, 192));
			btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String titu = titulaire.getText();

					try {

						if (transfer_fee.getText() == null || transfer_fee.getText().isEmpty()) {

							monMessage_2.setText("Entrer un chiffre valide");
							setVisible(true);
						}

						if (min_balance.getText() == null || min_balance.getText().isEmpty()) {
							monMessage_3.setText("Entrer un chiffre valide");
							setVisible(true);
						}

						if (balance.getText() == null || balance.getText().isEmpty()) {
							monMessage_4.setText("Entrer un chiffre valide");
							setVisible(true);

						}

						if (titu.length() > 100) {
							monMessage.setText("100 caractères maximum");
							setVisible(true);
						}

						if ((transfer_fee.getText().length() != 0) && (min_balance.getText().length() != 0)
								&& (balance.getText().length() != 0) && (titu.length() < 100)) {

							transfer = Float.parseFloat(transfer_fee.getText());
							min_bal = Float.parseFloat(min_balance.getText());
							bal = Float.parseFloat(balance.getText());

							if (bal < min_bal) {
								monMessage_5.setText("Le solde initial doit être supérieur au solde minimum");
								setVisible(true);
							}

							if (bal > min_bal) {
								CheckingAccountHandler.createCheckingAccount(0, global_id, titu, bal, transfer,
										min_bal);
								setVisible(false);
								new FrmAccountList(global_id, " ");
							}

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			});
			btnNewButton.setBounds(142, 545, 89, 23);
			getContentPane().add(btnNewButton);

			// Affichage des titres

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

			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FrmAccountList(global_id, " ");
					setVisible(false);
				}

			});

			JLabel lblNewLabel_4 = new JLabel("Solde initial");
			lblNewLabel_4.setBounds(72, 420, 92, 14);
			getContentPane().add(lblNewLabel_4);

		}

		if (Compte_epargne.isSelected()) {

			getContentPane().removeAll();

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

						if (interest_rate.getText() == null || interest_rate.getText().isEmpty()) {

							monMessage_2S.setText("Entrer un chiffre valide");
							setVisible(true);
						}

						if (balance_limit.getText() == null || balance_limit.getText().isEmpty()) {
							monMessage_3S.setText("Entrer un chiffre valide");
							setVisible(true);
						}

						if (balance.getText() == null || balance.getText().isEmpty()) {
							monMessage_4S.setText("Entrer un chiffre valide");
							setVisible(true);

						}

						if (titu.length() > 100) {
							monMessageS.setText("100 caractères maximum");
							setVisible(true);
						}

						if (bal > bal_lim) {
							monMessage_5S.setText("Le solde initial doit être inférieur au plafond");
							setVisible(true);
						}

						if ((interest_rate.getText().length() != 0) && (balance_limit.getText().length() != 0)
								&& (balance.getText().length() != 0) && (titu.length() < 100)) {

							int_rate = Float.parseFloat(interest_rate.getText());
							bal_lim = Float.parseFloat(balance_limit.getText());
							bal = Float.parseFloat(balance.getText());

							if (bal < bal_lim) {
								SavingAccountHandler.createSavingAccount(0, global_id, titu, bal, int_rate, bal_lim);
								setVisible(false);
								new FrmAccountList(global_id, " ");
							}

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

			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new FrmAccountList(global_id, " ");
					setVisible(false);
				}

			});

			JLabel lblNewLabel_4 = new JLabel("Solde initial");
			lblNewLabel_4.setBounds(72, 420, 92, 14);
			getContentPane().add(lblNewLabel_4);

		}
		setVisible(true);

		pack();
		setSize(660, 700);

	}

}