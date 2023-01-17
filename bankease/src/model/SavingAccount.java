package model;

public class SavingAccount extends Account {
	
	private float interestRate;
	private float balanceLimit;

	
	public int getAccountId() {
		return accountId;
	}

	public SavingAccount(int accountId, int clientId, String ownerDescription, float balance, float interestRate, float balanceLimit) {
		super(accountId, clientId, ownerDescription, balance);
		this.interestRate = interestRate;
		this.balanceLimit = balanceLimit;
	}


	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interest_rate) {
		this.interestRate = interest_rate;
	}

	public float getBalanceLimit() {
		return balanceLimit;
	}

	public void setBalanceLimit(float balance_limit) {
		this.balanceLimit = balance_limit;
	}

}