package model;

/**
 * @author S. Lebrun
 * 
 */
public abstract class Account {

	protected String accountType;
	protected int accountId;
	protected int clientId;
	protected String ownerDescription;
	protected float balance;
	
	public String toString() {
		return "Compte " + accountType + " n°" + accountId + " - " + ownerDescription + " - Solde : " + balance;
	}

	public Account() {}
	
	public Account(String accountType, int accountId, int clientId, String ownerDescription, float balance) {
		this.accountType = accountType;
		this.accountId = accountId;
		this.clientId = clientId;
		this.ownerDescription = ownerDescription;
		this.balance = balance;
	}


	// Getters Setters
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getOwnerDescription() {
		return ownerDescription;
	}
	public void setOwnerDescription(String ownerDescription) {
		this.ownerDescription = ownerDescription;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
