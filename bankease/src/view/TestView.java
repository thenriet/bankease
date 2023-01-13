package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TestView extends JFrame {
	private JTextField txtTest;
	public TestView() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(132, 115, 10, 10);
		getContentPane().add(panel);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		txtTest.setBounds(0, 0, 130, 26);
		getContentPane().add(txtTest);
		txtTest.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(159, 6, 122, 29);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}
}
