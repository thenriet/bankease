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
		// TODO Auto-generated constructor stub
	}

	public Client(Object object, Object clientBirthdate, Object object3, Object object4) {
		// TODO Auto-generated constructor stub
		this.clientDescription = (String) object;
		this.clientBirthdate = (Date) clientBirthdate;
		this.clientAddress = (String) object3;
		this.clientPhone = (String) object4;
	}
	
	public String toString() {
		return this.clientDescription + " - " + clientAddress;
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
