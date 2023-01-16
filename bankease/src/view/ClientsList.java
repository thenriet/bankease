package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ClientHandler;
import model.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ClientsList extends JFrame {
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
	scrollPane.setBounds(0, 60, 660, 500);
	getContentPane().add(scrollPane);
	
	
	Client[] clientsList = ClientHandler.listOfClients();
	JList<Client> list = new JList<Client>();
	list.setListData(clientsList);;
	scrollPane.setViewportView(list);
	setVisible(true);

	}
}
