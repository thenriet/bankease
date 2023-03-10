package dao;

import java.util.regex.Pattern;

public class Regex {

	private static Pattern DATE_PATTERN = Pattern
			.compile("^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$"
					+ "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
					+ "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
					+ "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

	private static Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

	private static Pattern INTEREST_PATTERN = Pattern.compile("^[1-9]\\d*(\\.\\d+)?$");

	public boolean dateMatches(String date) {
		return DATE_PATTERN.matcher(date).matches();
	}

	public boolean phoneMatches(String phone) {

		return PHONE_PATTERN.matcher(phone).matches();
	}

	public boolean interestAndTransferFeeMatches(String interestRate) {

		return INTEREST_PATTERN.matcher(interestRate).matches();
	}

}
