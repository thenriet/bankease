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

		scrollPane.setBounds(0, 60, 660, 400);
		getContentPane().add(scrollPane);

		Client[] clientsList = ClientHandler.listOfClients();
		JList<Client> list = new JList<Client>();
		list.setListData(clientsList);

		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 472, 660, 120);
		getContentPane().add(panel_1);

		JButton btnDetailsClient = new JButton("Détails Client");
		btnDetailsClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnDetailsClient.setBounds(0, 0, 100, 30);
		btnDetailsClient.setEnabled(false);
		panel_1.add(btnDetailsClient);

		JButton btnModifyClient = new JButton("Modifier Client");
		btnModifyClient.setSize(100, 30);
		btnModifyClient.setEnabled(false);
		panel_1.add(btnModifyClient);

		JButton btnDeleteClient = new JButton("Supprimer Client");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client selectedClient = list.getSelectedValue();
				if(selectedClient !=null) {
				ClientHandler.deleteClient(selectedClient.getClientId());
				Client[] clientsList = ClientHandler.listOfClients();
				list.setListData(clientsList); 
				scrollPane.setViewportView(list);
				//list.setSelectedValue(null, );
				}
			}
		});
		
		btnDeleteClient.setSize(100, 30);
		btnDeleteClient.setEnabled(false);
		panel_1.add(btnDeleteClient);

		JButton btnAddClient = new JButton("Ajouter Client");
		btnDetailsClient.setSize(100, 30);
		panel_1.add(btnAddClient);
		
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new ClientCreate();
			}
		});
		
		Client test = list.getSelectedValue();
		System.out.println(test);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent client) {
				if (!client.getValueIsAdjusting()) {
					btnDetailsClient.setEnabled(true);
					btnModifyClient.setEnabled(true);
					btnDeleteClient.setEnabled(true);
					// Client selectedClient = list.getSelectedValue(); // Ici je chope l'objet Client sélectionné
					// System.out.println(selectedClient.getClientId()); // Ici je chope son Id (est-ce que c'est utile ?)
				}
			}
		});

		setVisible(true);
	}
}