package view;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

import controller.CheckingAccountHandler;
import controller.DataCheck;
import controller.SavingAccountHandler;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModifyAccount extends JFrame {
	private static final long serialVersionUID = 1L;

	public ModifyAccount(Account account) {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Bankease - Modifier un compte");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 173, 167));
		panel.setBounds(0, 0, 660, 77);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel modifClientLabel = new JLabel("Modification d'un compte");
		modifClientLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifClientLabel.setBounds(203, 23, 265, 31);
		modifClientLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(modifClientLabel);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 335, 660, 60);
		getContentPane().add(panelButtons);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 87, 660, 74);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Libellé Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 28, 109, 25);
		panel_3.add(lblNewLabel);

		JTextField clientLabelText = new JTextField();
		clientLabelText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientLabelText.setBounds(202, 28, 235, 27);
		clientLabelText.setText(account.getOwnerDescription());
		panel_3.add(clientLabelText);

		JLabel errorDescription = new JLabel("Entre 2 et 100 caractères");
		errorDescription.setForeground(new Color(157, 18, 24));
		errorDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorDescription.setBounds(447, 28, 161, 25);
		errorDescription.setVisible(false);
		panel_3.add(errorDescription);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 171, 660, 74);
		getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel interestRate = new JLabel("Taux d'intérêt");
		interestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		interestRate.setBounds(46, 27, 109, 25);
		panel_3_1.add(interestRate);

		JTextField interestRateOrTransferFeeText = new JTextField();
		interestRateOrTransferFeeText.setText((String) null);
		interestRateOrTransferFeeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		interestRateOrTransferFeeText.setBounds(204, 27, 184, 25);
		JButton btnValidate = new JButton("Valider");
		btnValidate.setBounds(194, 21, 107, 29);
		btnValidate.setBackground(new Color(200, 173, 167));
		btnValidate.setForeground(new Color(0, 0, 0));

		panel_3_1.add(interestRateOrTransferFeeText);

		JLabel errorEmpty = new JLabel("Veillez remplir TOUS les champs");
		errorEmpty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		errorEmpty.setForeground(new Color(143, 36, 29));
		errorEmpty.setBounds(196, 280, 267, 16);
		errorEmpty.setVisible(false);
		getContentPane().add(errorEmpty);

		JLabel errorInterestRate = new JLabel("Entre 0 et 90");
		errorInterestRate.setForeground(new Color(157, 18, 24));
		errorInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorInterestRate.setBounds(447, 27, 161, 25);
		errorInterestRate.setVisible(false);
		panel_3_1.add(errorInterestRate);
		panelButtons.setLayout(null);

		panelButtons.add(btnValidate);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 16));

		if (account instanceof SavingAccount) {
			interestRateOrTransferFeeText.setText(Float.toString(((SavingAccount) account).getInterestRate()));
			btnValidate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String data1 = clientLabelText.getText();
					String data2 = interestRateOrTransferFeeText.getText();

					List<String> datas = new ArrayList<>();
					datas.add(data1);
					datas.add(data2);

					List<String> trimmedData = new ArrayList<>();
					trimmedData = DataCheck.checkEmptyAndDataTrim(datas);

					if (trimmedData.size() < 2) {
						errorEmpty.setVisible(true);
					} else if (DataCheck.checkClientDescription(trimmedData) == null
							&& DataCheck.checkInterestRateOrTransferFee(trimmedData) == null) {
						errorDescription.setVisible(true);
						errorInterestRate.setVisible(true);
					} else if (DataCheck.checkClientDescription(trimmedData) == null) {
						errorDescription.setVisible(true);
					} else if (DataCheck.checkInterestRateOrTransferFee(trimmedData) == null) {
						errorInterestRate.setVisible(true);
					} else if ((DataCheck.checkClientDescription(trimmedData) != null)
							&& (DataCheck.checkInterestRateOrTransferFee(trimmedData) != null)) {
						List<Object> checkedData = DataCheck.checkInterestRateOrTransferFee(trimmedData);
						SavingAccountHandler.updateSavingAccount(checkedData, (SavingAccount) account);
						setVisible(false);
						new FrmAccountList(account.getClientId(), "");
					}
				}
			});
		}

		if (account instanceof CheckingAccount) {

			interestRate.setText("Frais de transfert");
			interestRateOrTransferFeeText.setText(Float.toString(((CheckingAccount) account).getTransferFee()));
			btnValidate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String data1 = clientLabelText.getText();
					String data2 = interestRateOrTransferFeeText.getText();

					List<String> datas = new ArrayList<>();
					datas.add(data1);
					datas.add(data2);

					List<String> trimmedData = new ArrayList<>();
					trimmedData = DataCheck.checkEmptyAndDataTrim(datas);

					if (trimmedData.size() < 2) {
						errorEmpty.setVisible(true);
					} else if (DataCheck.checkClientDescription(trimmedData) == null
							&& DataCheck.checkInterestRateOrTransferFee(trimmedData) == null) {
						errorDescription.setVisible(true);
						errorInterestRate.setVisible(true);
					} else if (DataCheck.checkClientDescription(trimmedData) == null) {
						errorDescription.setVisible(true);
					} else if (DataCheck.checkInterestRateOrTransferFee(trimmedData) == null) {
						errorInterestRate.setVisible(true);
					} else if ((DataCheck.checkClientDescription(trimmedData) != null)
							&& (DataCheck.checkInterestRateOrTransferFee(trimmedData) != null)) {
						List<Object> checkedData = DataCheck.checkInterestRateOrTransferFee(trimmedData);
						CheckingAccountHandler.updateCheckingAccount(checkedData, (CheckingAccount) account);
						setVisible(false);
						new FrmAccountList(account.getClientId(), "");
					}
				}
			});
		}

		setVisible(true);

		JButton btnReturn = new JButton("Retour");
		btnReturn.setBounds(349, 21, 115, 29);
		btnReturn.setBackground(new Color(200, 173, 167));
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelButtons.add(btnReturn);

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FrmAccountList(account.getClientId(), "");
			}
		});
		setVisible(true);
	}
}
