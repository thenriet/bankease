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
	private JLabel lblMinSolde;
	private JLabel lblFraisTransfert;
	private JLabel lblTauxInteret;
	private JLabel lblPlafond;
	private JLabel lblErrorMessage;


	/**
	 * Create the frame.
	 */
	public FrmCreditDebit(Account account, String action) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 660);
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
		
		if (account instanceof SavingAccount) {
		
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
		
		txtMontant = new JTextField();
		txtMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMontant.setBounds(331, 417, 150, 30);
		contentPane.add(txtMontant);
		txtMontant.setColumns(10);
		
		JLabel lblMontant = new JLabel("Somme à " + action + "er :");
		lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontant.setBounds(30, 416, 291, 30);
		contentPane.add(lblMontant);
		
		// Affichage du message d'erreur :
		lblErrorMessage = new JLabel();
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMessage.setForeground(new Color(128, 0, 0));;
		lblErrorMessage.setBounds(40, 460, 600, 50);
		contentPane.add(lblErrorMessage);
		
		btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(128, 255, 128));
		btnValider.repaint();
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnValider.setBounds(172, 530, 100, 45);
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
		btnAnnuler.setBounds(381, 530, 100, 45);
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