package model;

public class SavingAccount extends Account {
	
	private float interestRate;
	private float balanceLimit;

	

	public SavingAccount(int accountId, int clientId, String ownerDescription, float balance, float interestRate, float balanceLimit) {
		super(accountId, clientId, ownerDescription, balance);
		this.interestRate = interestRate;
		this.balanceLimit = balanceLimit;
	}


	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return this.accountId;
	}
	
	public float getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getBalanceLimit() {
		return this.balanceLimit;
	}

	public void setBalanceLimit(float balanceLimit) {
		this.balanceLimit = balanceLimit;
	}

}