package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

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

public class ClientCreate extends JFrame {
	private JTextField textField;

	public ClientCreate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(356, 205, 87, 29);
		panel.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 44, 800, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setLocation(215, 5);
		textField.setSize(new Dimension(370, 26));
		textField.setText("Entrer le nom du nouveau client");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(30);
		panel_1.add(textField);
		
		JLabel lblNewLabel = new JLabel("Création d'un nouveau client");
		lblNewLabel.setBounds(309, 6, 185, 16);
		panel.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String data = textField.getText();
				ClientHandler.createClient(data);
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

