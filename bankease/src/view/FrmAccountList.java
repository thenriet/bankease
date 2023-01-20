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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

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
	public FrmAccountList(int id) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txtTitle = new JTextField();
		txtTitle.setForeground(new Color(0, 0, 0));
		txtTitle.setBackground(new Color(200, 173, 167));
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		// Affichage du libellé client en titre :
		String accountOwner = AccountListController.getAccountOwner(id);
		txtTitle.setText(accountOwner);
		txtTitle.setBounds(0, 0, 686, 77);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 100, 650, 350);
		contentPane.add(scrollPane);

		// Récupération de la liste des comptes du client (à modifier avec l'ID dynamique)
		List<Account> accountList = AccountListController.getAccountList(id);
		
		// Affichage de la liste :
		JList<Account> list = new JList<Account>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setListData(accountList.toArray(new Account[0]));
		scrollPane.setViewportView(list);
		
		// Sélection du compte dans la liste :
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnModifier.setEnabled(true);
				btnCloturer.setEnabled(true);
				btnCrediter.setEnabled(true);
				btnDebiter.setEnabled(true);
				btnTransferer.setEnabled(true);
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
			}
		});
		
		btnRetour = new JButton("Retour");
		btnRetour.setBackground(new Color(200, 173, 167));
		btnRetour.repaint();
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRetour.setBounds(490, 519, 100, 45);
		contentPane.add(btnRetour);
		
		// Clic sur le bouton "Retour" :
		btnDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		this.setVisible(true);
	}
}