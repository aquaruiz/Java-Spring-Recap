package exam2.problem01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static final String ALL_CAPITALS_PATTERN = "^[^a-zа-я0-9]*$";
	private static final String LOWERCASE_PATTERN = "^[^A-ZА-Я0-9']*$";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.nextLine();
		String[] input = Arrays.stream(text.split("[^a-zA-Zа-яА-Я0-9']"))
				.filter(x -> x.trim().length() != 0)
				.toArray(String[]::new);
		scanner.close();

		System.out.println(Arrays.toString(input));

		int capitalWords = capitalWords(input);
		int lowercaseWords = countLowerCaseWords(input);
		System.out.println("Total words: " + input.length);
		System.out.println("ALL CAPITALS words: " + capitalWords);
		System.out.println("lowercase words: " + lowercaseWords);

	}

	private static int countLowerCaseWords(String[] input) {
		Pattern regx = Pattern.compile(LOWERCASE_PATTERN);
		
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			String word = input[i];
			Matcher match = regx.matcher(word);
			if (match.find()) {
				count++;
			}
		}
		
		return count;
	}

	private static int capitalWords(String[] input) {
		Pattern regx = Pattern.compile(ALL_CAPITALS_PATTERN);
		
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			String word = input[i];
			Matcher match = regx.matcher(word);
			if (match.find()) {
				count++;
			}
		}
		
		return count;
	}

}
