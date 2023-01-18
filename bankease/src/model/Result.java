package model;

/**
 * Class used in CreditAccountController to return custom error messages
 * @author S. Lebrun
 * 
 */
public class Result {
	private boolean validated;
	private String errorMsg;
	
	
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
