package model;

/**
 * Brouillon Checking
 * @author S. Lebrun
 */
public class CheckingAccount extends Account {
	private float minBalance;
	private float transferFee;


	/**
	 * Empty constructor
	 */
	public CheckingAccount() {}

	/**
	 * Fields constructor
	 */
	public CheckingAccount(String accountType, int accountId, int clientId, String ownerDescription, float balance,
			float minBalance, float transferFee) {
		super(accountType, accountId, clientId, ownerDescription, balance);
		this.minBalance = minBalance;
		this.transferFee = transferFee;
	}
	
	// Getters Setters

	public float getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}
	public float getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(float transferFee) {
		this.transferFee = transferFee;
	}
}