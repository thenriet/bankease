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
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;

public class ClientCreate extends JFrame {
	private static final long serialVersionUID = 1L;

	public ClientCreate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setTitle("Bankease - Ajouter un nouveau client");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 173, 167));
		panel.setBounds(0, 0, 660, 77);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel btnReturn = new JPanel();
		btnReturn.setBounds(0, 504, 660, 60);
		getContentPane().add(btnReturn);

		JButton btnValidate = new JButton("Valider");
		btnValidate.setBackground(new Color(200, 173, 167));
		btnReturn.add(btnValidate);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(200, 173, 167));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientsList();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReturn.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 139, 660, 37);
		getContentPane().add(panel_3);

		JTextField clientDescription = new JTextField();
		clientDescription.setBounds(200, 5, 251, 27);
		clientDescription.setForeground(new Color(153, 153, 153));
		clientDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (clientDescription.getText().equals("Entrer le nom du nouveau client")) {
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
		clientDescription.setText("Mylène Dubois");
		clientDescription.setHorizontalAlignment(SwingConstants.LEFT);
		clientDescription.setColumns(30);

		JLabel errorDescription = new JLabel("Entre 2 et 100 caractères");
		errorDescription.setForeground(new Color(153, 43, 56));
		errorDescription.setBounds(463, 11, 161, 16);
		errorDescription.setVisible(false);
		panel_3.add(errorDescription);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 237, 660, 37);
		getContentPane().add(panel_3_1);

		JTextField clientAdress = new JTextField();
		clientAdress.setBounds(200, 5, 249, 27);
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
		adressLabel.setBounds(40, 10, 119, 17);
		adressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1.add(adressLabel);
		clientAdress.setText("96 Rue de la Chaussée");
		clientAdress.setHorizontalAlignment(SwingConstants.LEFT);
		clientAdress.setFont(new Font("Tahoma", Font.ITALIC, 14));
		clientAdress.setColumns(30);
		panel_3_1.add(clientAdress);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(0, 187, 660, 37);
		getContentPane().add(panel_3_1_1);
		panel_3_1_1.setLayout(null);

		JLabel birthLabel = new JLabel("Date de naissance");
		birthLabel.setBounds(40, 10, 150, 17);
		birthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_1.add(birthLabel);

		JTextField birthClient = new JTextField();
		birthClient.setBounds(200, 5, 93, 27);
		birthClient.setForeground(new Color(153, 153, 153));
		birthClient.setText("1986-03-12");
		birthClient.setHorizontalAlignment(SwingConstants.LEFT);
		birthClient.setFont(new Font("Tahoma", Font.ITALIC, 14));
		birthClient.setColumns(20);
		panel_3_1_1.add(birthClient);

		JLabel errorBirth = new JLabel("La date doit être au format YYYY-MM-DD");
		errorBirth.setForeground(new Color(153, 43, 56));
		errorBirth.setBounds(330, 11, 309, 16);
		errorBirth.setVisible(false);
		panel_3_1_1.add(errorBirth);

		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(0, 286, 660, 37);
		getContentPane().add(panel_3_1_2);

		JTextField phoneClient = new JTextField();
		phoneClient.setBounds(200, 5, 91, 27);
		phoneClient.setForeground(new Color(153, 153, 153));
			

		panel_3_1_2.setLayout(null);

		JLabel phoneLabel = new JLabel("Téléphone");
		phoneLabel.setBounds(40, 10, 126, 17);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_2.add(phoneLabel);
		phoneClient.setText("0771963255");
		phoneClient.setHorizontalAlignment(SwingConstants.LEFT);
		phoneClient.setFont(new Font("Tahoma", Font.ITALIC, 14));
		phoneClient.setColumns(30);
		panel_3_1_2.add(phoneClient);

		JLabel errorPhone = new JLabel("Renseigner un numéro composé de 10 chiffres");
		errorPhone.setForeground(new Color(153, 43, 56));
		errorPhone.setBounds(330, 11, 298, 16);
		errorPhone.setVisible(false);
		panel_3_1_2.add(errorPhone);

		JLabel errorEmpty = new JLabel("Veuillez remplir TOUS les champs");
		errorEmpty.setForeground(new Color(153, 43, 56));
		errorEmpty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		errorEmpty.setVisible(false);
		errorEmpty.setBounds(232, 358, 270, 16);
		getContentPane().add(errorEmpty);
		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// J'enregistre les données entrées dans les champs par le banquier
				String data1 = clientDescription.getText();
				String data2 = birthClient.getText();
				String data3 = clientAdress.getText();
				String data4 = phoneClient.getText();
				// Je les stocke dans une liste
				List<String> datas = new ArrayList<>();
				datas.add(data1);
				datas.add(data2);
				datas.add(data3);
				datas.add(data4);
				// Je crée une nouvelle liste de type String qui accueillera les données après qu'elles soient trimées et not empty
				List<String> trimmedData = new ArrayList<>();
				trimmedData = ClientHandler.checkEmptyAndDataTrim(datas);
				// Je vérifie si la liste contient bien 4 données
				if (trimmedData.size() < 4) {
					errorEmpty.setVisible(true);
				// Je vérifie si la liste contient une date invalide, un numéro de téléphone invalide et une description invalide
				} else if (ClientHandler.checkDate(trimmedData) == null && ClientHandler.checkPhone(trimmedData) == null
						&& ClientHandler.checkClientDescription(trimmedData) == null) {
					errorBirth.setVisible(true);
					errorPhone.setVisible(true);
					errorDescription.setVisible(true);	
				// Je vérifie si la liste contient une date invalide
				} else if (ClientHandler.checkDate(trimmedData) == null) {
					errorBirth.setVisible(true);
				// Je vérifie si la liste contient un numéro de téléphone invalide
				} else if (ClientHandler.checkPhone(trimmedData) == null) {
					errorPhone.setVisible(true);
				// Je vérifie si la liste contient une description de client invalide
				} else if (ClientHandler.checkClientDescription(trimmedData) == null) {
					errorDescription.setVisible(true);
				// Si tout est OK niveau vérif des données, utilise la liste que retourne ClientHandler.checkDate(trimmedData)
				// pour créer un nouveau client
				} else if ((ClientHandler.checkPhone(trimmedData) != null)
						&& (ClientHandler.checkDate(trimmedData) != null)
						&& (ClientHandler.checkClientDescription(trimmedData) != null)) {
					List<Object> checkedData = ClientHandler.checkDate(trimmedData);
					ClientHandler.createClient(checkedData);
					setVisible(false);
					new ClientsList();
				}
			}
		});

		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override 
			public void windowClosing(java.awt.event.WindowEvent e) {
				JOptionPane.showConfirmDialog(ClientCreate.this, "Etes-vous certain de vouloir quitter ?");
			}
		});

	}
}
