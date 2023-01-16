package model;

public class CheckingAccount {
	
	private int account_id;
	private float balance;
	private float transfer_fee;
	private float min_balance;
	private int client_id;
	private String owner_description;
	
	public CheckingAccount() {
	}
	

	public CheckingAccount(int account_id,int client_id, String owner_description,float balance, float min_balance, float transfer_fee) {

		this.balance = balance;
		this.transfer_fee = transfer_fee;
		this.min_balance = min_balance;
		this.client_id = client_id;
		this.owner_description = owner_description;

	}


	public int getAccount_id() {
		return account_id;

	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getTransfer_fee() {
		return transfer_fee;
	}

	public void setTransfer_fee(float transfer_fee) {
		this.transfer_fee = transfer_fee;
	}

	public float getMin_balance() {
		return min_balance;
	}

	public void setMin_balance(float min_balance) {
		this.min_balance = min_balance;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getOwner_description() {
		return owner_description;
	}

	public void setOwner_description(String owner_description) {
		this.owner_description = owner_description;
	}

}
