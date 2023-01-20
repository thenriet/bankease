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
import java.awt.FlowLayout;
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

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 27);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Création d'un nouveau client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 416, 660, 60);
		getContentPane().add(panelButtons);

		JButton btnValidate = new JButton("Valider");
		panelButtons.add(btnValidate);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientsList();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelButtons.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 39, 660, 37);
		getContentPane().add(panel_3);

		JTextField txtMylneDubois = new JTextField();
		txtMylneDubois.setBounds(200, 5, 251, 27);
		txtMylneDubois.setForeground(new Color(153, 153, 153));
		txtMylneDubois.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtMylneDubois.getText().equals("Entrer le nom du nouveau client")) {
					txtMylneDubois.setText("");
					txtMylneDubois.setForeground(new Color(153, 153, 153));
				}
			}
		});
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Identifiant Client");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 10, 106, 16);
		panel_3.add(lblNewLabel_2);
		panel_3.add(txtMylneDubois);
		txtMylneDubois.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtMylneDubois.setText("Mylène Dubois");
		txtMylneDubois.setHorizontalAlignment(SwingConstants.LEFT);
		txtMylneDubois.setColumns(30);

		JLabel ErrorDescription = new JLabel("Entre 2 et 100 caractères");
		ErrorDescription.setForeground(new Color(153, 43, 56));
		ErrorDescription.setBounds(463, 11, 161, 16);
		ErrorDescription.setVisible(false);
		panel_3.add(ErrorDescription);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 137, 660, 37);
		getContentPane().add(panel_3_1);

		JTextField txtAdresse = new JTextField();
		txtAdresse.setBounds(200, 5, 249, 27);
		txtAdresse.setForeground(new Color(153, 153, 153));
		txtAdresse.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtAdresse.getText().equals("Entrer une adresse")) {
					txtAdresse.setText("");
					txtAdresse.setForeground(new Color(153, 153, 153));
				}
			}
		});
		panel_3_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Adresse");
		lblNewLabel_4.setBounds(40, 10, 47, 17);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1.add(lblNewLabel_4);
		txtAdresse.setText("96 Rue de la Chaussée");
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtAdresse.setColumns(30);
		panel_3_1.add(txtAdresse);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(0, 87, 660, 37);
		getContentPane().add(panel_3_1_1);
		panel_3_1_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Date de naissance");
		lblNewLabel_3.setBounds(40, 10, 109, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_1.add(lblNewLabel_3);

		JTextField txtDateDeNaissance = new JTextField();
		txtDateDeNaissance.setBounds(200, 5, 93, 27);
		txtDateDeNaissance.setForeground(new Color(153, 153, 153));
		txtDateDeNaissance.setText("1986-03-12");
		txtDateDeNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateDeNaissance.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtDateDeNaissance.setColumns(20);
		panel_3_1_1.add(txtDateDeNaissance);

		JLabel ErrorDate = new JLabel("La date doit être au format YYYY-MM-DD");
		ErrorDate.setForeground(new Color(153, 43, 56));
		ErrorDate.setBounds(330, 11, 309, 16);
		ErrorDate.setVisible(false);
		panel_3_1_1.add(ErrorDate);

		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(0, 186, 660, 37);
		getContentPane().add(panel_3_1_2);

		JTextField txtTel = new JTextField();
		txtTel.setBounds(200, 5, 91, 27);
		txtTel.setForeground(new Color(153, 153, 153));
			

		panel_3_1_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Téléphone");
		lblNewLabel_5.setBounds(40, 10, 64, 17);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3_1_2.add(lblNewLabel_5);
		txtTel.setText("0771963255");
		txtTel.setHorizontalAlignment(SwingConstants.LEFT);
		txtTel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtTel.setColumns(30);
		panel_3_1_2.add(txtTel);

		JLabel ErrorPhone = new JLabel("Renseigner un numéro composé de 10 chiffres");
		ErrorPhone.setForeground(new Color(153, 43, 56));
		ErrorPhone.setBounds(330, 11, 298, 16);
		ErrorPhone.setVisible(false);
		panel_3_1_2.add(ErrorPhone);

		JLabel ErrorEmpty = new JLabel("Veuillez remplir TOUS les champs");
		ErrorEmpty.setForeground(new Color(153, 43, 56));
		ErrorEmpty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ErrorEmpty.setVisible(false);
		ErrorEmpty.setBounds(232, 258, 270, 16);
		getContentPane().add(ErrorEmpty);
		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String data1 = txtMylneDubois.getText();
				String data2 = txtDateDeNaissance.getText();
				String data3 = txtAdresse.getText();
				String data4 = txtTel.getText();

				List<String> datas = new ArrayList<>();
				datas.add(data1);
				datas.add(data2);
				datas.add(data3);
				datas.add(data4);

				List<String> trimmedData = new ArrayList<>();
				trimmedData = ClientHandler.checkEmptyAndDataTrim(datas);

				if (trimmedData.size() < 4) {
					ErrorEmpty.setVisible(true);
				} else if (ClientHandler.checkDate(trimmedData) == null && ClientHandler.checkPhone(trimmedData) == null
						&& ClientHandler.checkClientDescription(trimmedData) == null) {
					ErrorDate.setVisible(true);
					ErrorPhone.setVisible(true);
					ErrorDescription.setVisible(true);	
				} else if (ClientHandler.checkDate(trimmedData) == null) {
					ErrorDate.setVisible(true);
				} else if (ClientHandler.checkPhone(trimmedData) == null) {
					ErrorPhone.setVisible(true);
				} else if (ClientHandler.checkClientDescription(trimmedData) == null) {
					ErrorDescription.setVisible(true);
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
