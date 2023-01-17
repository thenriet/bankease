package model;

public class CheckingAccount extends Account {
	
	private float transferFee;
	private float minBalance;
	
	public CheckingAccount() {
	}
	

	public CheckingAccount(int accountId, int clientId, String ownerDescription, float balance, float transferFee, float minBalance) {
		super(accountId, clientId, ownerDescription, balance);
		this.transferFee = transferFee;
		this.minBalance = minBalance;
	}

	public float getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(float transfer_fee) {
		this.transferFee = transfer_fee;
	}

	public float getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(float min_balance) {
		this.minBalance = min_balance;
	}


}
