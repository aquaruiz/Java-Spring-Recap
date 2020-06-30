package task22;

import java.util.Random;

public class WordManager {
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int LETTER_COUNT = LETTERS.length();
	
	public static String[] generateRandomWordsWithLength(int count, int length) {
		String[] result = new String[count];
		
		for (int i = 0; i < count; i++) {
			result[i] = randomWordWithLength(length);
		}

		return result;
	}

	private static String randomWordWithLength(int length) {
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(length); // pass SB length
        
        for (int i = 0; i < length; i++) {
        	int nextRandomInt = random.nextInt(LETTER_COUNT);
			sBuilder.append(LETTERS.charAt(nextRandomInt));
		}
        
		return sBuilder.toString();
	}

	public static boolean hasLetterInWords(String[] words, char c) {
		for (String w : words) {
			if (w.toLowerCase().indexOf(c) > -1) {
				return true;
			}
		}
		
		return false;
	}
}
