package bankease;


/**
 * Brouillon Checking
 * @author S. Lebrun
 */
public class CheckingAccount extends Account {
	private float minBalance;
	private float transferFee;	
	
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