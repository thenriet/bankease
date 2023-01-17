package model;

import java.sql.Date;

public class Client {
	private int clientId;
	private String clientDescription;
	private Date clientBirthdate;
	private String clientAddress;
	private String clientPhone;

	public Client(String clientDescription, Date clientBirthdate, String clientAddress, String clientPhone) {
		this.clientDescription = clientDescription;
		this.clientBirthdate = clientBirthdate;
		this.clientAddress = clientAddress;
		this.clientPhone = clientPhone;
	}
	
	public Client() {
	}

	public Client(Object clientDescription, Object clientBirthdate, Object clientAddress, Object clientPhone) {
		this.clientDescription = (String) clientDescription;
		this.clientBirthdate = (Date) clientBirthdate;
		this.clientAddress = (String) clientAddress;
		this.clientPhone = (String) clientPhone;
	}
	
	public String toString() {
		return this.clientDescription;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	public Date getClientBirthdate() {
		return clientBirthdate;
	}

	public void setClientBirthdate(Date clientBirthdate) {
		this.clientBirthdate = clientBirthdate;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

}
