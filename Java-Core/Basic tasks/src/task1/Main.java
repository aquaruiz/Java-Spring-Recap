package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Integer> triangleNumbers = new ArrayList<>();
	
	public static void main(String[] args) {
		// load some triangle numbers first
		List<Integer> numbers = getNTriangleNumbers(1, 10);
		triangleNumbers.addAll(numbers);
		
		// get 2000 words
		List<String> wordList = readText().subList(1000, 3000);
		System.out.println(wordList.size());
		
		int trianglesCount = 0;
		for (String word : wordList) {
			int wordValue = calcWordValue(word);
			
			if (isTriangleNumber(wordValue)) {
				trianglesCount++;
			}
		}
		
		System.out.println(trianglesCount);
	}

	private static int calcWordValue(String string) {
		int result = 0;
		
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			result += getCharNumber(currentChar);
		}

		return result;
	}

	private static int getCharNumber(char c) {
		// return letter number position in alphabet
		// capitals and lowers should have same positions
		
		return String.valueOf(c).equals(String.valueOf(c).toUpperCase()) ? 
				// Check if it is a Capital letter
				(int) c - 64 :
				(int) c - 96;
	}

	private static List<Integer> getNTriangleNumbers(int start, int n) {
		List<Integer> numbers = new ArrayList<>();
		
		for (int i = start; i <= n; i++) {
			int currentTriangleNum = (int) (0.5*i*(i+1));
			numbers.add(currentTriangleNum);
		}
		
		return numbers;
	}
	
	private static boolean isTriangleNumber(int num) {
		if (triangleNumbers.contains((Integer)num)) {
			return true;
		}
		
		int lastKnownTriangleNum = triangleNumbers.get(triangleNumbers.size()-1);
		if (lastKnownTriangleNum > num) {
			return false;
		}
		
		// load more triangle numbers
		List<Integer> numbers = getNTriangleNumbers(triangleNumbers.size(), 25);
		triangleNumbers.addAll(numbers);
		
		// check if is triangle again
		return isTriangleNumber(num);
	}

	private static List<String> readText() {		
		final String inputFilePath =  "src" + File.separator
				+ "task1" + File.separator 
				+ "words.txt";
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
