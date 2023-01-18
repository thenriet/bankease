package dao;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import java.awt.Color;

public class ModificationAccount extends JFrame {
	private final JPanel panel = new JPanel();
	private JTextField txtModifierUnCompte;
	private JTextField textField;
	private JTextField textField_1;
	public ModificationAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(0, 0, 500, 42);
		getContentPane().add(panel);
		
		txtModifierUnCompte = new JTextField();
		txtModifierUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		txtModifierUnCompte.setText("Modifier un compte");
		panel.add(txtModifierUnCompte);
		txtModifierUnCompte.setColumns(12);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setBounds(0, 60, 500, 36);
		getContentPane().add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(30);
		
		JLabel lblNewLabel = new JLabel("Libellé du titulaire");
		lblNewLabel.setBounds(6, 47, 182, 16);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1_1.setBounds(0, 123, 500, 36);
		getContentPane().add(panel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(30);
		panel_1_1.add(textField_1);
		
		JLabel lblFraisDeTransfert = new JLabel("Frais de transfert");
		lblFraisDeTransfert.setBounds(6, 110, 182, 16);
		getContentPane().add(lblFraisDeTransfert);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 377, 228, 36);
		getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Valider");
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(266, 377, 228, 36);
		getContentPane().add(panel_2_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2_1.add(btnAnnuler);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 171, 500, 185);
		getContentPane().add(panel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 95, 488, 12);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 34, 488, 12);
		getContentPane().add(separator_1);
		setVisible(true);
	}
}
