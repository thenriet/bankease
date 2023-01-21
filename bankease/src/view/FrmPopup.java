package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;

public class FrmPopup extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrmPopup() {
		setTitle("Confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnVoulezvousVraimentSupprimer = new JTextPane();
		txtpnVoulezvousVraimentSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnVoulezvousVraimentSupprimer.setBounds(98, 37, 286, 125);
		txtpnVoulezvousVraimentSupprimer.setText("Voulez-vous vraiment supprimer le compte ?");
		contentPane.add(txtpnVoulezvousVraimentSupprimer);
	}

}
