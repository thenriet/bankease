package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import controller.CreditDebitController;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

/**
 * Frame for credit and debit account page
 * @author S. Lebrun
 *
 */
public class FrmCreditDebit extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMontant;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblTitulaire;
	private JLabel lblTypeCompte;
	private JLabel lblSolde;
	private JLabel lblInfos1;
	private JLabel lblInfos2;
	private JLabel lblErrorMessage;


	/**
	 * Create the frame.
	 */
	public FrmCreditDebit(Account account, String action) {
		setTitle("BankEase - " + action.substring(0,1).toUpperCase() + action.substring(1) + "er un compte");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 660, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Affichage du libellé du compte en titre :
		JLabel txtTitle = new JLabel(action.substring(0,1).toUpperCase() + action.substring(1) + "er le compte n°" + account.getAccountId());
		txtTitle.setBackground(new Color(200, 173, 167));
		txtTitle.setOpaque(true);
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setBounds(0, 0, 646, 77);
		contentPane.add(txtTitle);
		
		JLabel lblNewLabel = new JLabel("Informations sur le compte :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 130, 610, 30);
		contentPane.add(lblNewLabel);

		// Affichage des informations du compte
		lblTitulaire = new JLabel("Titulaire : " + account.getOwnerDescription());
		lblTitulaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulaire.setBounds(20, 171, 610, 25);
		contentPane.add(lblTitulaire);
		
		lblTypeCompte = new JLabel("Type de compte : " + account.getAccountType());
		lblTypeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeCompte.setBounds(20, 207, 610, 25);
		contentPane.add(lblTypeCompte);
		
		lblInfos1 = new JLabel();
		lblInfos1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfos1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfos1.setBounds(20, 243, 610, 25);
		contentPane.add(lblInfos1);
		
		lblInfos2 = new JLabel();
		lblInfos2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfos2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfos2.setBounds(20, 279, 610, 25);
		contentPane.add(lblInfos2);
			
		// Affichage différent selon si compte épargne ou courant
		if (account instanceof SavingAccount) {
			lblInfos1.setText("Taux d'intérêt : " + ((SavingAccount) account).getInterestRate() + "%");
			lblInfos2.setText("Plafond : " + ((SavingAccount) account).getBalanceLimit() + " €");
		} else {
			lblInfos1.setText("Frais de transfert : " + ((CheckingAccount) account).getTransferFee() + "%");
			lblInfos2.setText("Solde minimum : " + ((CheckingAccount) account).getMinBalance() + " €");
		}
		
		// Champ à remplir
		lblSolde = new JLabel("Solde actuel : " + account.getBalance());
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSolde.setBounds(20, 335, 610, 30);
		contentPane.add(lblSolde);
		
		txtMontant = new JTextField();
		txtMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMontant.setBounds(331, 417, 150, 30);
		contentPane.add(txtMontant);
		txtMontant.setColumns(10);
		
		JLabel lblMontant = new JLabel("Somme à " + action + "er :");
		lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontant.setBounds(20, 416, 301, 30);
		contentPane.add(lblMontant);
		
		// Affichage du message d'erreur :
		lblErrorMessage = new JLabel();
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMessage.setForeground(new Color(128, 0, 0));;
		lblErrorMessage.setBounds(20, 460, 610, 50);
		contentPane.add(lblErrorMessage);
		
		btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(128, 255, 128));
		btnValider.repaint();
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnValider.setBounds(170, 550, 100, 45);
		contentPane.add(btnValider);
		
		// Clic sur le bouton "Valider" :
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = txtMontant.getText();
				String errorMsg = CreditDebitController.creditDebitAccount(action, account, amount);
				if (errorMsg == "") {
					String message = CreditDebitController.applyChange(account, action, amount);
					setVisible(false);
					new FrmAccountList(account.getClientId(), message);
				} else {
					lblErrorMessage.setText(errorMsg);
				}
			}
		});
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 128, 128));
		btnAnnuler.repaint();
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnnuler.setBounds(370, 550, 100, 45);
		contentPane.add(btnAnnuler);
		
		
		// Clic sur le bouton "Annuler" :
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmAccountList(account.getClientId(), "");
			}
		});
		
		this.setVisible(true);
	}
}