package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ClientHandler;
import model.Client;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ClientsList extends JFrame {
	private static final long serialVersionUID = 1L;

	public ClientsList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Bankease - Liste de clients");
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(100, 150, 460, 240);
		getContentPane().add(scrollPane);

		Client[] clientsList = ClientHandler.listOfClients();
		JList<Client> list = new JList<Client>();
		list.setBackground(new Color(255, 255, 255));
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setListData(clientsList);

		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 535, 660, 39);
		getContentPane().add(panel_1);

		JButton btnModifyClient = new JButton("Modifier Client");
		btnModifyClient.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifyClient.setBackground(new Color(200, 173, 167));
		btnModifyClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client selectedClient = list.getSelectedValue();
				if (selectedClient != null) {
					setVisible(false);
					new ModifyClient(selectedClient);
				}
			}
		});

		btnModifyClient.setSize(100, 30);
		btnModifyClient.setEnabled(false);
		panel_1.add(btnModifyClient);

		JButton btnDeleteClient = new JButton("Supprimer Client");
		btnDeleteClient.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteClient.setBackground(new Color(200, 173, 167));
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client selectedClient = list.getSelectedValue();
				int result = JOptionPane.showConfirmDialog(ClientsList.this,
						"Retirer " + selectedClient.getClientDescription() + " des clients ?",
						"Confirmation avant suppression", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (selectedClient != null) {
						ClientHandler.deleteClient(selectedClient.getClientId());
						Client[] clientsList = ClientHandler.listOfClients();
						list.setListData(clientsList);
						scrollPane.setViewportView(list);
						selectedClient = null;
					}
				}
			}
		});

		JButton btnAccounts = new JButton("Voir comptes");
		panel_1.add(btnAccounts);
		btnAccounts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAccounts.setBackground(new Color(200, 173, 167));
		btnAccounts.setEnabled(false);

		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Client selectedClient = list.getSelectedValue();
				int selectedClientId = selectedClient.getClientId();
				new FrmAccountList(selectedClientId, "");
			}
		});

		btnDeleteClient.setSize(100, 30);
		btnDeleteClient.setEnabled(false);
		panel_1.add(btnDeleteClient);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 605, 660, 48);
		getContentPane().add(panel_2);

		JButton btnAddClient = new JButton("Ajouter Client");
		panel_2.add(btnAddClient);
		btnAddClient.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddClient.setBackground(new Color(200, 173, 167));

		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientCreate();
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(100, 400, 460, 110);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel clientBirth = new JLabel("New label");
		clientBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientBirth.setBounds(257, 10, 193, 24);
		panel_3.add(clientBirth);
		clientBirth.setVisible(false);

		JLabel clientAddress = new JLabel("New label");
		clientAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientAddress.setBounds(257, 44, 193, 24);
		panel_3.add(clientAddress);
		clientAddress.setVisible(false);

		JLabel clientPhone = new JLabel("New label");
		clientPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientPhone.setBounds(257, 78, 193, 24);
		panel_3.add(clientPhone);
		clientPhone.setVisible(false);

		JLabel clientBirthLabel = new JLabel("Date de naissance :");
		clientBirthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientBirthLabel.setBounds(10, 10, 186, 24);
		panel_3.add(clientBirthLabel);
		clientBirthLabel.setVisible(false);

		JLabel clientAddressLabel = new JLabel("Adresse :");
		clientAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientAddressLabel.setBounds(10, 44, 186, 24);
		panel_3.add(clientAddressLabel);
		clientAddressLabel.setVisible(false);

		JLabel clientPhoneLabel = new JLabel("Téléphone :");
		clientPhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientPhoneLabel.setBounds(10, 78, 186, 24);
		panel_3.add(clientPhoneLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 173, 167));
		panel.setBounds(0, 0, 660, 77);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel welcomeLabel = new JLabel("Bienvenue sur Bankease");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		welcomeLabel.setBounds(101, 23, 460, 30);
		panel.add(welcomeLabel);

		JLabel clientSelect = new JLabel("Sélectionnez un client");
		clientSelect.setHorizontalAlignment(SwingConstants.CENTER);
		clientSelect.setFont(new Font("Tahoma", Font.BOLD, 14));
		clientSelect.setBounds(236, 109, 189, 13);
		getContentPane().add(clientSelect);
		clientPhoneLabel.setVisible(false);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent client) {
				if (!client.getValueIsAdjusting()) {
					Client selectedClient = list.getSelectedValue();
					if (selectedClient != null) {
						btnModifyClient.setEnabled(true);
						btnDeleteClient.setEnabled(true);
						btnAccounts.setEnabled(true);
						clientBirthLabel.setVisible(true);
						clientBirth.setVisible(true);
						clientBirth.setText(selectedClient.getClientBirthdate().toString());
						clientAddressLabel.setVisible(true);
						clientAddress.setVisible(true);
						clientAddress.setText(selectedClient.getClientAddress());
						clientPhoneLabel.setVisible(true);
						clientPhone.setVisible(true);
						clientPhone.setText(selectedClient.getClientPhone().toString());
					} else {
						btnModifyClient.setEnabled(false);
						btnDeleteClient.setEnabled(false);
						btnAccounts.setEnabled(false);
						clientBirthLabel.setVisible(false);
						clientBirth.setVisible(false);
						clientAddressLabel.setVisible(false);
						clientAddress.setVisible(false);
						clientPhoneLabel.setVisible(false);
						clientPhone.setVisible(false);
					}

				}
			}
		});

		setVisible(true);
	}
}
