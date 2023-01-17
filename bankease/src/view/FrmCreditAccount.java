package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.AccountListController;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

import javax.swing.JTextPane;
import javax.swing.JLabel;

public class FrmCreditAccount extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSomme;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblTitulaire;
	private JLabel lblTypeCompte;
	private JLabel lblSolde;
	private JLabel lblMinSolde;
	private JLabel lblFraisTransfert;
	private JLabel lblTauxInteret;
	private JLabel lblPlafond;
	
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmCreditAccount frame = new FrmCreditAccount();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmCreditAccount(Account account, String action) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Affichage du libellé du compte en titre :
		JLabel txtTitle = new JLabel(action.substring(0,1).toUpperCase() + action.substring(1) + " le compte n°" + account.getAccountId());
		txtTitle.setBackground(new Color(200, 173, 167));
		txtTitle.setOpaque(true);
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setBounds(0, 0, 686, 77);
		contentPane.add(txtTitle);
		
		JLabel lblNewLabel = new JLabel("Informations sur le compte :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 130, 600, 30);
		contentPane.add(lblNewLabel);
		
		lblTitulaire = new JLabel("Titulaire : " + account.getOwnerDescription());
		lblTitulaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulaire.setBounds(30, 171, 600, 25);
		contentPane.add(lblTitulaire);
		
		lblTypeCompte = new JLabel("Type de compte : " + account.getAccountType());
		lblTypeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeCompte.setBounds(30, 207, 600, 25);
		contentPane.add(lblTypeCompte);
		
		if (account.getAccountType() == "épargne") {
		
			lblTauxInteret = new JLabel("Taux d'intrêt : " + ((SavingAccount) account).getInterestRate() + "%");
			lblTauxInteret.setHorizontalAlignment(SwingConstants.CENTER);
			lblTauxInteret.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTauxInteret.setBounds(30, 243, 600, 25);
			contentPane.add(lblTauxInteret);
			
			lblPlafond = new JLabel("Plafond : " + ((SavingAccount) account).getBalanceLimit() + " €");
			lblPlafond.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlafond.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPlafond.setBounds(30, 279, 600, 25);
			contentPane.add(lblPlafond);
			
		} else {
		
			lblFraisTransfert = new JLabel("Frais de transfert : " + ((CheckingAccount) account).getTransferFee() + "%");
			lblFraisTransfert.setHorizontalAlignment(SwingConstants.CENTER);
			lblFraisTransfert.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFraisTransfert.setBounds(30, 243, 600, 25);
			contentPane.add(lblFraisTransfert);
			
			lblMinSolde = new JLabel("Solde minimum : " + ((CheckingAccount) account).getMinBalance() + " €");
			lblMinSolde.setHorizontalAlignment(SwingConstants.CENTER);
			lblMinSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMinSolde.setBounds(30, 279, 600, 25);
			contentPane.add(lblMinSolde);
		}

		
		lblSolde = new JLabel("Solde actuel : " + account.getBalance());
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSolde.setBounds(30, 335, 600, 30);
		contentPane.add(lblSolde);
		
		txtSomme = new JTextField();
		txtSomme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSomme.setBounds(331, 417, 150, 30);
		contentPane.add(txtSomme);
		txtSomme.setColumns(10);
		
		JLabel lblCrediter = new JLabel("Somme à créditer :");
		lblCrediter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrediter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrediter.setBounds(30, 416, 291, 30);
		contentPane.add(lblCrediter);
		
		
		btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(128, 255, 128));
		btnValider.repaint();
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnValider.setBounds(172, 519, 100, 45);
		contentPane.add(btnValider);
		
		// Clic sur le bouton "Valider" :
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float amount = (float) Double.parseDouble(txtSomme.getText());
			}
		});
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 128, 128));
		btnAnnuler.repaint();
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnnuler.setBounds(381, 519, 100, 45);
		contentPane.add(btnAnnuler);
		
		// Clic sur le bouton "Annuler" :
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmAccountList(account.getClientId());
			}
		});
		
	}
}
