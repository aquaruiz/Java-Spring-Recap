package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static Map<Integer, List<String>> words = new HashMap<>();
	
	public static void main(String[] args) {
		List<String> all = loadWords();
		List<String> realWords = extractWordWithNoSpecialChars(all);
		orderWordsByLenght(realWords);
		
		String[] randomWords = getNRandomWordsWithTLetters(2, 20);
		System.out.println(String.join(", ", randomWords));
		
		if (containsLetter(randomWords, 'g')) {
			randomWords = getNRandomWordsWithTLetters(2, 5);
			System.out.println(String.join(", ", randomWords));	
		}
		
		randomWords = getNRandomWordsWithTLetters(2, 20);
		System.out.println(String.join(", ", randomWords));	
		Character[] charsInBoth = getSameChars(randomWords);
		
		System.out.println(Arrays.stream(charsInBoth)
				.map(x -> String.valueOf(x))
				.collect(Collectors.joining(", ")));
	}

	private static Character[] getSameChars(String[] randomWords) {
		Set<Character> letters = new HashSet<>();
		String firstWord = randomWords[0];
		
		Set<Character> secondeLetters = new HashSet<>();

		String secondWord = randomWords[1];
		
		for (int i = 0; i < firstWord.length(); i++) {
			letters.add(firstWord.charAt(i));
		}
		
		for (int i = 0; i < secondWord.length(); i++) {
			secondeLetters.add(secondWord.charAt(i));
		}
		
		Character[] result = letters.stream()
				.filter(x -> secondeLetters.contains(x))
				.toArray(Character[]::new);
		return result;
	}

	private static boolean containsLetter(String[] randomWords, char c) {
		for (String word : randomWords) {
			for (int i = 0; i < word.length(); i++) {
				if (word.toLowerCase().charAt(i) == 'g') {
					return true;
				}
			}

		}
		return false;
	}

	private static String[] getNRandomWordsWithTLetters(int count, int length) {
		String[] result = new String[count];

		Random random = new Random();
		List<String> availableWords = words.getOrDefault(length, null);
		
		if (availableWords == null) {
			return result;
		}
		
		int totalWordsCount = availableWords.size();

		for (int i = 0; i < count; i++) {
			String randomWord = availableWords.get((int) (random.nextDouble() * totalWordsCount));
			result[i] = randomWord;
		}
		
		return result;
	}

	private static void orderWordsByLenght(List<String> realWords) {
		for (String word : realWords) {
			int wordLength = word.length();
			words.putIfAbsent(wordLength, new ArrayList<>());
			words.get(wordLength).add(word);
		}
		
	}

	private static List<String> extractWordWithNoSpecialChars(List<String> all) {
		List<String> words = new ArrayList<>();
		for (String word : all) {
			if (!hasSpecialChar(word))
				words.add(word);
		}

		return words;
	}

	private static boolean hasSpecialChar(String word) {
		for (int i = 0; i < word.length(); i++) {
			int currentCharInt = (int) word.charAt(i);
			if (!(currentCharInt >= 65 && currentCharInt <= 90) 
					&& !(currentCharInt >= 97 && currentCharInt <= 122)) {
				return true;
			}
		}
		
		return false;
	}

	private static List<String> loadWords() {
		final String inputFilePath = "src" + File.separator + "task1" + File.separator + "words.txt";
		ArrayList<String> words = new ArrayList<>();

		try (BufferedReader bReader = new BufferedReader(new FileReader(inputFilePath))) {
			String line = bReader.readLine();

			while (line != null) {
				words.add(line);
				line = bReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("File cannot be read");
		}

		return words;
	}
}
