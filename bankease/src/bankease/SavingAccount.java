package bankease;

/**
 * Brouillon Saving
 * @author S. Lebrun
 */
public class SavingAccount extends Account{
	private float balanceLimit;
	private float interestRate;
	
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