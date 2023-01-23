package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.Regex;

public class DataCheck {

	public static List<String> checkEmptyAndDataTrim(List<String> uncheckedData) {
		List<String> rawData = new ArrayList<>();
		for (String data : uncheckedData) {
			if (!data.isEmpty()) {
				data = data.trim();
				rawData.add(data);
			}
		}
		return rawData;
	}

	public static List<Object> checkClientDescription(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		String strClientDescription = (String) checkedData.get(0);
		if (strClientDescription.length() < 101 && strClientDescription.length() > 1) {
			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkPhone(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		Regex regex = new Regex();
		for (String data : uncheckedData) {
			checkedData.add(data);
		}
		String strPhone = (String) checkedData.get(3);
		if (regex.phoneMatches(strPhone)) {

			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkDate(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		Regex regex = new Regex();

		for (String data : uncheckedData) {
			checkedData.add(data);
		}

		String strDate = (String) checkedData.get(1);

		if (regex.dateMatches(strDate)) {
			Date date = Date.valueOf((String) strDate);
			checkedData.set(1, date);
			return checkedData;
		} else {
			return null;
		}
	}

	public static List<Object> checkInterestRateOrTransferFee(List<String> uncheckedData) {
		List<Object> checkedData = new ArrayList<>();
		Regex regex = new Regex();

		for (String data : uncheckedData) {
			checkedData.add(data);
		}

		String strInterest = (String) checkedData.get(1);

		if (regex.interestAndTransferFeeMatches(strInterest)) {
			Float interestRate = Float.parseFloat(strInterest);
			if (interestRate >= 0 && interestRate <= 90) {
				return checkedData;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

}
