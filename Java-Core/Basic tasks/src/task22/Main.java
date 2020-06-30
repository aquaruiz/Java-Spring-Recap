package task22;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String[] words;
		words = WordManager.generateRandomWordsWithLength(2, 5);
		System.out.println(String.join(", ", words));
		
		/*
		 * Check the generated words if they contain the letter 'g' 
		 * ignoring case sensitivity and output the result for N = 5.
		 */
		words = WordManager.generateRandomWordsWithLength(2, 5);
		System.out.println(String.join(", ", words) + " - Have g inside: " + WordManager.hasLetterInWords(words, 'g'));

		/*
		 * Compares the two words and return the characters that appear 
		 * in both of the them for N = 20 honoring case sensitivity.
		 */
		words = WordManager.generateRandomWordsWithLength(2, 20);
		
		String bothChars = Arrays.stream(WordManager.getSameChars(words))
				.map(x -> String.valueOf(x))
				.collect(Collectors.joining(", "));
		System.out.println(String.join(", ", words) + System.lineSeparator() + "Charactes in both: " + bothChars);

		/*
		 * Identify the longest matching equal sequence of characters contained 
		 * in both words irregardless of position for N = 50 000 and output it.
		 */
	
		words = WordManager.generateRandomWordsWithLength(2, 21000);
		System.out.println(words[0].length());
		
		WordManager.getLongestMatchingSequence(words);
	}
}
