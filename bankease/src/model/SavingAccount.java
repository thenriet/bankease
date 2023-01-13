package model;

/**
 * Brouillon Saving
 * @author S. Lebrun
 */
public class SavingAccount extends Account{
	private float balanceLimit;
	private float interestRate;
	

	/**
	 * Empty constructor
	 */
	public SavingAccount() {}
	
	/**
	 * Fields constructor
	 */
	public SavingAccount(float balanceLimit, float interestRate) {
		super();
		this.balanceLimit = balanceLimit;
		this.interestRate = interestRate;
	}


	// Getters Setters

	public void setBalanceLimit(float balanceLimit) {
		this.balanceLimit = balanceLimit;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getBalanceLimit() {
		return balanceLimit;
	}
	

}