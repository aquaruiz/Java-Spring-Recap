package exam3.problem02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	private static final String wordsFilePath = "src" + File.separator
			+ "exam3" + File.separator 
			+ "problem02" + File.separator 
			+ "words.txt";
	private static final String sampleFilePath = "src" + File.separator
			+ "exam3" + File.separator 
			+ "problem02" + File.separator 
			+ "sample.txt";
	private static final String outputFilePath = "src" + File.separator
			+ "exam3" + File.separator 
			+ "problem02" + File.separator 
			+ "result.txt";
	private static List<String> words = new ArrayList<>();
	private static List<String> sentances = new ArrayList<>();
	
	public static void main(String[] args) {
		readWords();
		readSampleSentances();
		Map<String, Integer> count = arrangeSentancesInWords();
		Map<String, Integer> result = checkWhatContains(count);
		putInFile(result);
	}

	private static void putInFile(Map<String, Integer> result) {
		try (PrintWriter printWriter = new PrintWriter(outputFilePath);) {
			StringBuilder stringBuilder = new StringBuilder();
			
			for (Entry<String, Integer> input : result.entrySet()) {
				stringBuilder
					.append(input.getKey())
					.append(" - ")
					.append(input.getValue())
					.append(System.lineSeparator());
			}
			
			printWriter.print(stringBuilder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}

	private static Map<String, Integer> checkWhatContains(Map<String, Integer> countWords) {
		Map<String, Integer> wordsCount = new HashMap<>();

		for (String w : words) {
			if (countWords.containsKey(w)) {
				wordsCount.put(w, countWords.get(w));
			}
		}
		
		return wordsCount;
	}

	private static Map<String, Integer> arrangeSentancesInWords() {
		Map<String, Integer> wordsCount = new HashMap<>();
		for (String string : sentances) {
			String[] inputs = string.split("\\s+");
			for (String word : inputs) {
				wordsCount.putIfAbsent(word.toLowerCase(), 1);
				wordsCount.put(word.toLowerCase(), wordsCount.get(word.toLowerCase())+1);
			}
		}
		
		return wordsCount;
	}

	private static void readSampleSentances() {
		try (BufferedReader bReader = new BufferedReader(new FileReader(sampleFilePath));) {
			String line = bReader.readLine();
			while (line != null) {
				sentances.add(line.trim());

				line = bReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("File cannot be read");
		}
	}

	private static void readWords() {
		try (BufferedReader bReader = new BufferedReader(new FileReader(wordsFilePath));) {
			String line = bReader.readLine();
			while (line != null) {
				words.add(line.trim());

				line = bReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("File cannot be read");
		}
	}

}
