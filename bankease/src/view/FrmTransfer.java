package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;

import controller.AccountListController;
import controller.TransferController;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;


/**
 * Frame for the money transfer page
 * @author S. Lebrun
 *
 */
public class FrmTransfer extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMontant;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblSolde;
	private JLabel lblSource2;
	private JLabel lblSource1;
	private JLabel lblDestination1;
	private JLabel lblDestination2;
	private String[] infosSource;
	private String[] infosDestination;
	private JLabel lblErrorMessage;
	private Account selectedAccount;
	private JLabel lblSlectionnezUnCompte;
	private JSeparator separator;
	

	/**
	 * Create the frame.
	 */
	public FrmTransfer(Account sourceAccount) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Affichage du libellé du compte en titre :
		JLabel txtTitle = new JLabel("Transférer depuis le compte " + sourceAccount.getAccountType() + " n°" + sourceAccount.getAccountId());
		txtTitle.setBackground(new Color(200, 173, 167));
		txtTitle.setOpaque(true);
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setBounds(0, 0, 686, 77);
		contentPane.add(txtTitle);

		lblSolde = new JLabel("Solde actuel du compte source : " + String.format("%,.2f", sourceAccount.getBalance()) + " €");
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSolde.setBounds(20, 88, 650, 30);
		contentPane.add(lblSolde);
		
		lblSlectionnezUnCompte = new JLabel("Sélectionnez un compte de destination :");
		lblSlectionnezUnCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSlectionnezUnCompte.setBounds(20, 120, 650, 30);
		contentPane.add(lblSlectionnezUnCompte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 150, 650, 150);
		contentPane.add(scrollPane);

		// Récupération de la liste des comptes du client sans le compte source :
		List<Account> accountList = AccountListController.getAccountList(sourceAccount.getClientId());
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getAccountId() == sourceAccount.getAccountId()) {
				accountList.remove(i);
			}
		}
		
		// Affichage de la liste :
		JList<Account> list = new JList<Account>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setListData(accountList.toArray(new Account[0]));
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Sélection du compte dans la liste :
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedAccount = list.getSelectedValue();

				// Affichage des infos du compte de destination :
				infosDestination = showInfos(selectedAccount);
				lblDestination1.setText(infosDestination[0]);
				lblDestination2.setText(infosDestination[1]);
			}
		});
		
		JLabel lblInfosSource = new JLabel("Informations compte source :");
		lblInfosSource.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosSource.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInfosSource.setBounds(41, 311, 300, 25);
		contentPane.add(lblInfosSource);

		lblSource1 = new JLabel();
		lblSource1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSource1.setBounds(41, 347, 300, 25);
		contentPane.add(lblSource1);
		
		lblSource2 = new JLabel();
		lblSource2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSource2.setBounds(41, 383, 300, 25);
		contentPane.add(lblSource2);
		
		// Affichage des infos du compte source :
		infosSource = showInfos(sourceAccount);
		lblSource1.setText(infosSource[0]);
		lblSource2.setText(infosSource[1]);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(341, 311, 27, 98);
		contentPane.add(separator);
		
		JLabel lblInfosDestination = new JLabel("Informations compte de destination :");
		lblInfosDestination.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosDestination.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInfosDestination.setBounds(341, 311, 300, 25);
		contentPane.add(lblInfosDestination);
		
		lblDestination1 = new JLabel();
		lblDestination1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestination1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestination1.setBounds(341, 347, 300, 25);
		contentPane.add(lblDestination1);
		
		lblDestination2 = new JLabel();
		lblDestination2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestination2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestination2.setBounds(341, 383, 300, 25);
		contentPane.add(lblDestination2);
			
		txtMontant = new JTextField();
		txtMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMontant.setBounds(342, 420, 150, 30);
		contentPane.add(txtMontant);
		txtMontant.setColumns(10);
		
		JLabel lblMontant = new JLabel("Somme à transférer :");
		lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontant.setBounds(41, 419, 291, 30);
		contentPane.add(lblMontant);
		
		// Affichage du message d'erreur :
		lblErrorMessage = new JLabel();
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorMessage.setForeground(new Color(128, 0, 0));;
		lblErrorMessage.setBounds(41, 461, 600, 50);
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
				String errorMsg = TransferController.creditDebitAccount(sourceAccount, selectedAccount, amount);
				if (errorMsg == "") {
					String message = TransferController.applyChange(sourceAccount, "débit", amount) + "\n";
					message += TransferController.applyChange(selectedAccount, "crédit", amount);
					setVisible(false);
					new FrmAccountList(sourceAccount.getClientId(), convertToMultiline(message));
				} else {
					lblErrorMessage.setText(convertToMultiline(errorMsg));
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
				new FrmAccountList(sourceAccount.getClientId(), "");
			}
		});
		
		this.setVisible(true);
	}
	
	/**
	 * Gets the account specific infos to display on the frame
	 * @param Account object
	 * @return 2 infos in String array
	 */
	public static String[] showInfos(Account account) {
		String lbl1 = null;
		String lbl2 = null;
		
		if (account instanceof SavingAccount) {
			lbl1 = "Taux d'intrêt : " + ((SavingAccount) account).getInterestRate() + "%";
			lbl2 = "Plafond : " + String.format("%,.2f", ((SavingAccount) account).getBalanceLimit()) + " €";
		} else {
			lbl1 = "Frais de transfert : " + ((CheckingAccount) account).getTransferFee() + "%";
			lbl2 = "Solde minimum : " + String.format("%,.2f", ((CheckingAccount) account).getMinBalance()) + " €";
		}
	
		return new String[] {lbl1, lbl2};
	}
	
	/**
	 * Converts Strings with \n to HTML multiline do display in labels
	 * @param string to convert
	 * @return HTML formated String
	 */
	public static String convertToMultiline(String string) {
		return "<html>" + string.replaceAll("\n", "<br>");
	}
}
