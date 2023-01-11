package bankease;

public class Main {

	public static void main(String[] args) {
//		Account account = new CheckingAccount();
//		account.setAccountId(123456);
//		account.setBalance(100);
//		account.setBankId(0);
//		account.setClientId(0);
//
//		System.out.println(account);
//		System.out.println(account.accountId);
		
		Bank b = new Bank();
		
		b.getAccounts();
		
		for (Account element : b.accountList) {
			System.out.println(element.accountId);
		}
	}

}
