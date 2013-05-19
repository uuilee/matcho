package util;

import java.util.Random;

public class StringUtilities {
	
	private static Random random = new Random();
	private static char[] characters = new char[26];
	
	static {
		for (int i = 0; i < 26; ++i) {
			characters[i] = (char) ('a' + i);
		}
	}
	
	public static String cutAndFillString(String string, int length) {
		int difference = length - string.length();
		if (difference < 0) {
			return string.substring(0, length);
		} else {
			StringBuilder result = new StringBuilder(string);
			for (int i = 0; i < difference; ++i) {
				result.append(" ");
			}
			return result.toString();
		}
	}
	
	public static String generateRandomString(int length) {
		char[] result = new char[length];
		for (int i = 0; i < length; ++i) {
			result[i] = characters[random.nextInt(characters.length)];
		}
		return new String(result);
	}
	
}
