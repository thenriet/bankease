package bankease;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fenetre extends JFrame {
	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 0));
		
		JButton testButton = new JButton("Sophie");
		getContentPane().add(testButton);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		JTextArea txtrJeSuisUn = new JTextArea();
		txtrJeSuisUn.setText("Je suis un titre");
		scrollPane.setColumnHeaderView(txtrJeSuisUn);
		pack();
		setVisible(true);
	}

}
