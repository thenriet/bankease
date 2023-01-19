package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.AccountListController;
import model.Account;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmAccountList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnOuvrir;
	private JButton btnModifier;
	private JButton btnCloturer;
	private JButton btnCrediter;
	private JButton btnTransferer;
	private JButton btnDebiter;
	private JButton btnRetour;
	private Account selectedAccount;
	private JLabel lblMessage;


	/**
	 * Create the frame.
	 */
	// TODO modifier clientId par client ?
	public FrmAccountList(int clientId, String message) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Affichage du libellé du client en titre :
		// TODO si récupération du client, supprimer l'appel BDD
		JTextField txtTitle = new JTextField(AccountListController.getAccountOwner(clientId));
		txtTitle.setBackground(new Color(200, 173, 167));
		txtTitle.setOpaque(true);
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setBounds(0, 0, 686, 77);
		contentPane.add(txtTitle);

		// Affichage du message après transfert d'argent :
		lblMessage = new JLabel(message);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		if (message.contains("Erreur")) {
			lblMessage.setForeground(new Color(128, 0, 0));
		} else {
			lblMessage.setForeground(new Color(0, 128, 0));
		}
		lblMessage.setBounds(20, 98, 650, 30);
		contentPane.add(lblMessage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 150, 650, 300);
		contentPane.add(scrollPane);

		// Récupération de la liste des comptes du client 
		// TODO modifier avec l'ID dynamique
		List<Account> accountList = AccountListController.getAccountList(clientId);
		
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
				btnModifier.setEnabled(true);
				btnCloturer.setEnabled(true);
				btnCrediter.setEnabled(true);
				btnDebiter.setEnabled(true);
				btnTransferer.setEnabled(true);
				
				selectedAccount = list.getSelectedValue();
			}
		});
		
		btnOuvrir = new JButton("Ouvrir");
		btnOuvrir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOuvrir.setBounds(127, 506, 100, 30);
		contentPane.add(btnOuvrir);
		
		// Clic sur le bouton "Ouvrir" :
		btnOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModifier.setBounds(237, 506, 100, 30);
		contentPane.add(btnModifier);
		
		// Clic sur le bouton "Modifier" :
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCloturer = new JButton("Clôturer");
		btnCloturer.setEnabled(false);
		btnCloturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCloturer.setBounds(347, 506, 100, 30);
		contentPane.add(btnCloturer);
		
		// Clic sur le bouton "Clôturer" :
		btnCloturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCrediter = new JButton("Créditer");
		btnCrediter.setEnabled(false);
		btnCrediter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrediter.setBounds(127, 547, 100, 30);
		contentPane.add(btnCrediter);
		
		// Clic sur le bouton "Créditer" :
		btnCrediter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmCreditDebit(selectedAccount, "crédit");
			}
		});
		
		btnTransferer = new JButton("Transférer");
		btnTransferer.setEnabled(false);
		btnTransferer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransferer.setBounds(237, 547, 100, 30);
		contentPane.add(btnTransferer);
		
		// Clic sur le bouton "Transférer" :
		btnTransferer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmTransfer(selectedAccount);
			}
		});
		
		btnDebiter = new JButton("Débiter");
		btnDebiter.setEnabled(false);
		btnDebiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDebiter.setBounds(347, 547, 100, 30);
		contentPane.add(btnDebiter);
		
		// Clic sur le bouton "Débiter" :
		btnDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmCreditDebit(selectedAccount, "débit");
			}
		});
		
		btnRetour = new JButton("Retour");
		btnRetour.setBackground(new Color(200, 173, 167));
		btnRetour.repaint();
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRetour.setBounds(490, 519, 100, 45);
		contentPane.add(btnRetour);
		
		// Clic sur le bouton "Retour" :
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		this.setVisible(true);
	}
}
