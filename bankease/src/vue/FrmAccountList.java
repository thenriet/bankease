package vue;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AccountListController;
import model.Account;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class FrmAccountList extends JFrame {

	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmAccountList frame = new FrmAccountList();
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
	public FrmAccountList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textLabel = new JTextField();
		textLabel.setForeground(new Color(255, 255, 255));
		textLabel.setBackground(new Color(128, 64, 64));
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		textLabel.setText("Liste des comptes");
		textLabel.setBounds(0, 0, 686, 76);
		contentPane.add(textLabel);
		textLabel.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 109, 579, 315);
		contentPane.add(scrollPane);

		AccountListController accountList = new AccountListController(2);
		Account[] data = accountList.getAccountList().toArray(new Account[0]);
		JList<Account> list = new JList<Account>(data);
		scrollPane.setViewportView(list);
		
		JButton btnNewAccount = new JButton("Ouvrir un compte");
		btnNewAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewAccount.setBounds(53, 460, 160, 25);
		contentPane.add(btnNewAccount);
		
		JButton btnCloseAccount = new JButton("Clôturer un compte");
		btnCloseAccount.setEnabled(false);
		btnCloseAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCloseAccount.setBounds(472, 460, 160, 25);
		contentPane.add(btnCloseAccount);
		
		JButton btnEditAccount = new JButton("Modifier un compte");
		btnEditAccount.setEnabled(false);
		btnEditAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditAccount.setBounds(263, 460, 160, 25);
		contentPane.add(btnEditAccount);
		
		JButton btnCreditAccount = new JButton("Créditer");
		btnCreditAccount.setEnabled(false);
		btnCreditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreditAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreditAccount.setBounds(53, 534, 160, 25);
		contentPane.add(btnCreditAccount);
		
		JButton btnDebitAccount = new JButton("Débiter");
		btnDebitAccount.setEnabled(false);
		btnDebitAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDebitAccount.setBounds(472, 534, 160, 25);
		contentPane.add(btnDebitAccount);
		
		JButton btnTransfrerFrom = new JButton("Transférer");
		btnTransfrerFrom.setEnabled(false);
		btnTransfrerFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransfrerFrom.setBounds(263, 534, 160, 25);
		contentPane.add(btnTransfrerFrom);
		
		JButton btnSeeClientsFrame = new JButton("Gestion des clients");
		btnSeeClientsFrame.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeeClientsFrame.setBounds(263, 583, 160, 25);
		contentPane.add(btnSeeClientsFrame);
		
		JLabel lblNewLabel = new JLabel("Gestion des comptes :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 435, 500, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGestionDesComptes = new JLabel("Mouvements d'argent :");
		lblGestionDesComptes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesComptes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionDesComptes.setBounds(95, 509, 500, 14);
		contentPane.add(lblGestionDesComptes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(79, 570, 532, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(79, 496, 532, 2);
		contentPane.add(separator_1);
		

		this.setVisible(true);
	}
}
