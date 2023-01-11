package bankease;

/**
 * @author S. Lebrun
 * 
 */
public abstract class Account {

	protected int accountId;
	protected float balance;
	protected int bankId;
	protected int clientId;
	
	// Brouillon méthodes; à revoir ou override
	public void creditAccount(float amount) {
		this.balance += amount;
	}
	
	public void debitAccount(float amount) {
		this.balance -= amount;
	}
	
	
	// Getters Setters

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int account_id) {
		this.accountId = account_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int client_id) {
		this.clientId = client_id;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bank_id) {
		this.bankId = bank_id;
	}
}
