package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ClientHandler;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;

public class ClientCreate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtAdresse_1;
	private JTextField txtDateDeNaissance;
	private JTextField txtAdresse;

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 416, 660, 60);
		getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Valider");
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 39, 660, 37);
		getContentPane().add(panel_3);
		
		JTextField textField = new JTextField();
		panel_3.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setText("Entrer le nom du nouveau client");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(30);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 137, 660, 37);
		getContentPane().add(panel_3_1);
		
		JTextField txtAdresse = new JTextField();
		txtAdresse.setText("Adresse");
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdresse.setColumns(30);
		panel_3_1.add(txtAdresse);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(0, 87, 660, 37);
		getContentPane().add(panel_3_1_1);
		
		JTextField txtDateDeNaissance = new JTextField();
		txtDateDeNaissance.setText("2020-12-12");
		txtDateDeNaissance.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDateDeNaissance.setColumns(30);
		panel_3_1_1.add(txtDateDeNaissance);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(0, 186, 660, 37);
		getContentPane().add(panel_3_1_2);
		
		JTextField txtTel = new JTextField();
		txtTel.setText("tel");
		txtTel.setHorizontalAlignment(SwingConstants.LEFT);
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTel.setColumns(30);
		panel_3_1_2.add(txtTel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(147, 251, 172, 26);
		getContentPane().add(formattedTextField);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String data1 = textField.getText();
				String data2 = txtDateDeNaissance.getText();
				String data3 = txtAdresse.getText();
				String data4 = txtTel.getText();
				if (data1=="") {
					
				} else {
					
					List<String> datas = new ArrayList<>();
					datas.add(data1);
					datas.add(data2);
					datas.add(data3);
					datas.add(data4);
					List<Object> checkedData = ClientHandler.checkData(datas);
					ClientHandler.createClient(checkedData);
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

