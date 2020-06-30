package task22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WordManager {
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int LETTER_COUNT = LETTERS.length();
	private static long startTime;
	
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
	
	public static Character[] getSameChars(String[] randomWords) {
		Set<Character> letters = new HashSet<>();
		String firstWord = randomWords[0];
		
		Set<Character> secondLetters = new HashSet<>();

		String secondWord = randomWords[1];
		
		for (int i = 0; i < firstWord.length(); i++) {
			letters.add(firstWord.charAt(i));
		}
		
		for (int i = 0; i < secondWord.length(); i++) {
			secondLetters.add(secondWord.charAt(i));
		}
		
		Character[] result = letters.stream()
				.filter(x -> secondLetters.contains(x))
				.toArray(Character[]::new);
		
		return result;
	}

	public static void getLongestMatchingSequence(String[] words) {
		startTime = System.currentTimeMillis();
		int[][] matrix = calcLCSMatrix(words);
		List<String> subseq = restoreSubsequences(matrix, words);
		System.out.println(matrix[matrix.length-1][matrix[0].length-1]);
		System.out.println("The subsequence is: " + subseq.get(0));
		System.out.println("The start index for first word is: " + subseq.get(1));
		System.out.println("The start index for second word is: " + subseq.get(2));
		System.out.println("Time diff in seconds is: " + (System.currentTimeMillis() - startTime)/100);
	}

	private static List<String> restoreSubsequences(int[][] matrix, String[] words) {
		char[] firstWord = words[0].toCharArray();
		char[] secondWord = words[1].toCharArray();

		StringBuilder stringBuilder = new StringBuilder();
		
		int i = firstWord.length;
		int j = secondWord.length;
		
		int lastUsedIndexInFirstWord = -1;
		int lastUsedIndexInSecondWord = -1;
		
		while (i > 0 && j > 0) {
			if (firstWord[i-1] == secondWord[j-1]) {
				stringBuilder.append(firstWord[i-1]);
				i--;
				j--;
				lastUsedIndexInFirstWord = i;
				lastUsedIndexInSecondWord = j;
			} else if (matrix[i-1][j] > matrix[i][j-1]) {
				i--;
			} else {
				j--;
			}
		}
		
		List<String> result = new ArrayList<>();
		result.add(stringBuilder.reverse().toString());
		result.add(String.valueOf(lastUsedIndexInFirstWord));
		result.add(String.valueOf(lastUsedIndexInSecondWord));
		return result;
	}

	private static int[][] calcLCSMatrix(String[] words) {
		char[] firstWord = words[0].toCharArray();
		char[] secondWord = words[1].toCharArray();
		
		int[][] matrix = new int[firstWord.length + 1][secondWord.length + 1];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 
					|| j == 0) {
				
					matrix[i][j] = 0;
				} else if (firstWord[i-1] == secondWord[j-1]) {
					matrix[i][j] = matrix[i-1][j-1] + 1;					
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
					
				}
			}
		}

		return matrix;
	}
}
