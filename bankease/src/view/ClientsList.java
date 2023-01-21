package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ClientHandler;
import model.Client;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientsList extends JFrame {
	private static final long serialVersionUID = 1L;

	public ClientsList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 30);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Liste des clients");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(100, 60, 460, 300);
		getContentPane().add(scrollPane);

		Client[] clientsList = ClientHandler.listOfClients();
		JList<Client> list = new JList<Client>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setListData(clientsList);

		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 540, 660, 39);
		getContentPane().add(panel_1);

		JButton btnModifyClient = new JButton("Modifier Client");
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
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client selectedClient = list.getSelectedValue();
				if (selectedClient != null) {
					ClientHandler.deleteClient(selectedClient.getClientId());
					Client[] clientsList = ClientHandler.listOfClients();
					list.setListData(clientsList);
					scrollPane.setViewportView(list);
					selectedClient = null;
				}
			}
		});

		btnDeleteClient.setSize(100, 30);
		btnDeleteClient.setEnabled(false);
		panel_1.add(btnDeleteClient);

		JButton btnAddClient = new JButton("Ajouter Client");
		panel_1.add(btnAddClient);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 618, 660, 48);
		getContentPane().add(panel_2);

		JButton btnAccounts = new JButton("Voir comptes");
		btnAccounts.setEnabled(false);

		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Client selectedClient = list.getSelectedValue();
				int selectedClientId = selectedClient.getClientId();
				new FrmAccountList(selectedClientId, "");
			}
		});
		panel_2.add(btnAccounts);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(100, 370, 460, 143);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel clientBirth = new JLabel("New label");
		clientBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientBirth.setBounds(220, 10, 230, 24);
		panel_3.add(clientBirth);
		clientBirth.setVisible(false);

		JLabel clientAddress = new JLabel("New label");
		clientAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientAddress.setBounds(220, 44, 230, 24);
		panel_3.add(clientAddress);
		clientAddress.setVisible(false);

		JLabel clientPhone = new JLabel("New label");
		clientPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientPhone.setBounds(220, 78, 230, 24);
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
		clientPhoneLabel.setVisible(false);

		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientCreate();
			}
		});

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
