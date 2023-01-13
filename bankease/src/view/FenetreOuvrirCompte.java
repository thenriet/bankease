package view;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.CheckingAccountHandler;

import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreOuvrirCompte extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtOuvrirUnCompte;
	
	public FenetreOuvrirCompte() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(320, 230, 186, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String chaine = textField.getText();
				CheckingAccountHandler.createCheckingAccount();
			}
		});
		btnNewButton.setBounds(102, 493, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("solde initial");
		lblNewLabel.setBounds(320, 205, 73, 14);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 311, 448, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("n° de compte");
		lblNewLabel_1.setBounds(58, 205, 82, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type de compte");
		lblNewLabel_2.setBounds(58, 104, 96, 23);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Titulaire");
		lblNewLabel_3.setBounds(59, 286, 49, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(58, 230, 173, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Sélectionnez un type de compte");
		comboBox.setBounds(58, 130, 448, 22);
		getContentPane().add(comboBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(102, 436, 1, 1);
		getContentPane().add(horizontalBox_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(-25, 0, 590, 68);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtOuvrirUnCompte = new JTextField();
		txtOuvrirUnCompte.setBounds(247, 5, 96, 20);
		txtOuvrirUnCompte.setText("Ouvrir un compte");
		panel_1.add(txtOuvrirUnCompte);
		txtOuvrirUnCompte.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.setBounds(336, 493, 89, 23);
		getContentPane().add(btnNewButton_1);


		setVisible(true); 
	}
}
