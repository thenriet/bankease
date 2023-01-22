package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ClientHandler;
import model.Client;

import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ModifyClient extends JFrame {
	private static final long serialVersionUID = 1L;

	public ModifyClient(Client client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Bankease - Modifier un client");

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 416, 660, 60);
		getContentPane().add(panelButtons);

		JButton btnValidate = new JButton("Valider");
		btnValidate.setBackground(new Color(200, 173, 167));
		panelButtons.add(btnValidate);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnReturn = new JButton("Retour");
		btnReturn.setBackground(new Color(200, 173, 167));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientsList();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelButtons.add(btnReturn);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 134, 660, 37);
		getContentPane().add(panel_3);

		JTextField clientDescription = new JTextField();
		clientDescription.setBounds(200, 5, 205, 27);
		clientDescription.setForeground(new Color(153, 153, 153));
		clientDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (clientDescription.getText().equals("Entrer le nom désiré du client")) {
					clientDescription.setText("");
					clientDescription.setForeground(new Color(153, 153, 153));
				}
			}
		});
		panel_3.setLayout(null);

		JLabel clientLabel = new JLabel("Identifiant Client");
		clientLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientLabel.setBounds(40, 10, 150, 16);
		panel_3.add(clientLabel);
		panel_3.add(clientDescription);
		clientDescription.setFont(new Font("Tahoma", Font.ITALIC, 14));
		clientDescription.setText(client.getClientDescription());
		clientDescription.setHorizontalAlignment(SwingConstants.LEFT);
		clientDescription.setColumns(30);

		JLabel errorDescription = new JLabel("Entre 2 et 100 caractères");
		errorDescription.setForeground(new Color(153, 43, 56));
		errorDescription.setBounds(415, 12, 171, 16);
		errorDescription.setVisible(false);
		panel_3.add(errorDescription);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 232, 660, 37);
		getContentPane().add(panel_3_1);

		JTextField clientAdress = new JTextField();
		clientAdress.setBounds(200, 5, 215, 27);
		clientAdress.setForeground(new Color(153, 153, 153));
		clientAdress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (clientAdress.getText().equals("Entrer une adresse")) {
					clientAdress.setText("");
					clientAdress.setForeground(new Color(153, 153, 153));
				}
			}
		});
		panel_3_1.setLayout(null);

		JLabel adressLabel = new JLabel("Adresse");
		adressLabel.setBounds(40, 10, 150, 17);
		adressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1.add(adressLabel);
		clientAdress.setText(client.getClientAddress());
		clientAdress.setHorizontalAlignment(SwingConstants.LEFT);
		clientAdress.setFont(new Font("Tahoma", Font.ITALIC, 14));
		clientAdress.setColumns(30);
		panel_3_1.add(clientAdress);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(0, 182, 660, 37);
		getContentPane().add(panel_3_1_1);
		panel_3_1_1.setLayout(null);

		JLabel birthLabel = new JLabel("Date de naissance");
		birthLabel.setBounds(40, 10, 150, 17);
		birthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_1.add(birthLabel);

		JTextField birthClient = new JTextField();
		birthClient.setBounds(200, 5, 93, 27);
		birthClient.setForeground(new Color(153, 153, 153));
		birthClient.setText(client.getClientBirthdate().toString());
		birthClient.setHorizontalAlignment(SwingConstants.LEFT);
		birthClient.setFont(new Font("Tahoma", Font.ITALIC, 14));
		birthClient.setColumns(20);
		panel_3_1_1.add(birthClient);

		JLabel errorBirth = new JLabel("La date doit être au format YYYY-MM-DD");
		errorBirth.setForeground(new Color(153, 43, 56));
		errorBirth.setBounds(303, 12, 242, 16);
		errorBirth.setVisible(false);
		panel_3_1_1.add(errorBirth);

		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(0, 281, 660, 37);
		getContentPane().add(panel_3_1_2);

		JTextField phoneClient = new JTextField();
		phoneClient.setBounds(200, 5, 91, 27);
		phoneClient.setForeground(new Color(153, 153, 153));

		panel_3_1_2.setLayout(null);

		JLabel phoneLabel = new JLabel("Téléphone");
		phoneLabel.setBounds(40, 10, 150, 17);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_2.add(phoneLabel);
		phoneClient.setText(client.getClientPhone());
		phoneClient.setHorizontalAlignment(SwingConstants.LEFT);
		phoneClient.setFont(new Font("Tahoma", Font.ITALIC, 14));
		phoneClient.setColumns(30);
		panel_3_1_2.add(phoneClient);

		JLabel errorPhone = new JLabel("Renseigner un numéro composé de 10 chiffres");
		errorPhone.setForeground(new Color(153, 43, 56));
		errorPhone.setBounds(301, 12, 288, 16);
		errorPhone.setVisible(false);
		panel_3_1_2.add(errorPhone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 328, 660, 45);
		getContentPane().add(panel_1);
		
				JLabel errorEmpty = new JLabel("Veuillez remplir TOUS les champs");
				panel_1.add(errorEmpty);
				errorEmpty.setForeground(new Color(153, 43, 56));
				errorEmpty.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(200, 173, 167));
				panel_2.setBounds(0, 0, 646, 76);
				getContentPane().add(panel_2);
				errorEmpty.setVisible(false);

		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String data1 = clientDescription.getText();
				String data2 = birthClient.getText();
				String data3 = clientAdress.getText();
				String data4 = phoneClient.getText();

				List<String> datas = new ArrayList<>();
				datas.add(data1);
				datas.add(data2);
				datas.add(data3);
				datas.add(data4);

				List<String> trimmedData = new ArrayList<>();
				trimmedData = ClientHandler.checkEmptyAndDataTrim(datas);

				if (trimmedData.size() < 4) {
					errorEmpty.setVisible(true);
				} else if (ClientHandler.checkDate(trimmedData) == null && ClientHandler.checkPhone(trimmedData) == null
						&& ClientHandler.checkClientDescription(trimmedData) == null) {
					errorBirth.setVisible(true);
					errorPhone.setVisible(true);
					errorDescription.setVisible(true);
				} else if (ClientHandler.checkDate(trimmedData) == null) {
					errorBirth.setVisible(true);
				} else if (ClientHandler.checkPhone(trimmedData) == null) {
					errorPhone.setVisible(true);
				} else if (ClientHandler.checkClientDescription(trimmedData) == null) {
					errorDescription.setVisible(true);
				} else if ((ClientHandler.checkPhone(trimmedData) != null)
						&& (ClientHandler.checkDate(trimmedData) != null)
						&& (ClientHandler.checkClientDescription(trimmedData) != null)) {
					List<Object> checkedData = ClientHandler.checkDate(trimmedData);
					ClientHandler.updateClient(checkedData, client);
					setVisible(false);
					new ClientsList();
				}
			}
		});

		setVisible(true);

//		this.addWindowListener(new WindowAdapter() {
//			@Override 
//			public void windowClosing(java.awt.event.WindowEvent e) {
//				JOptionPane.showConfirmDialog(ClientCreate.this, "Etes-vous certain de vouloir quitter ?");
//			}
//		});

	}
}
