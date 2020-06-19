package exam1.problem01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = null;
		String filePath = "src" + File.separator
						+ "exam1" + File.separator 
						+ "problem01" + File.separator 
						+ "Problem1.html";
		ArrayList<String> strippedLines = new ArrayList<>();
		
		try {
			bReader = new BufferedReader(new FileReader(filePath));
			String line = bReader.readLine();

			while (line != null) {
				String strippedLine = stripTags(line);
				
				if (strippedLine.length() > 0) {
					strippedLines.add(strippedLine);
				}

				line = bReader.readLine();
			}
			
			bReader.close();
			print(strippedLines);
		} catch (IOException e) {
			System.out.println("File cannot be read");
		} finally {
			bReader.close();
		}
	}

	private static String stripTags(String line) {
		char OPENING_BRACKET = '<';			
		char CLOSING_BRACKET = '>';			

		StringBuilder stringBuilder = new StringBuilder();
		boolean wasTagClosed = false;
		
		for (int i = 0; i < line.length(); i++) {
			char currentChar = line.charAt(i);

			if (wasTagClosed && currentChar != OPENING_BRACKET) {
				stringBuilder.append(currentChar);
			}

			if (currentChar == OPENING_BRACKET) {
				wasTagClosed = false;
			} else if (currentChar == CLOSING_BRACKET) {
				wasTagClosed = true;
			}
		}
		
		return stringBuilder.toString().trim();
	}

	private static void print(ArrayList<String> list) {
		System.out.println(list.stream().collect(Collectors.joining(System.lineSeparator())));
	}
}
