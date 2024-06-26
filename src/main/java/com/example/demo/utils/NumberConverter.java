package com.example.demo.utils;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		// BRL 10,25 but US 10.25
		String number = numberGlobal(strNumber);
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	public static String numberGlobal(String strNumber) {
		return strNumber.replaceAll(",", ".");

	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		String number = numberGlobal(strNumber);
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
