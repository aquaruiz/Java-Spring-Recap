package exam1.problem01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
	/*
	 * Open a html file, 
	 * strip all html tags 
	 * and save text into txt file
	 */

	private static final char OPENING_BRACKET = '<';			
	private static final char CLOSING_BRACKET = '>';			

	public static void main(String[] args) throws IOException {
				
		BufferedReader bReader = null;
		final String inputFilePath = "src" + File.separator
						+ "exam1" + File.separator 
						+ "problem01" + File.separator 
						+ "Problem1.html";
		final String outputPath = "src" + File.separator
						+ "exam1" + File.separator 
						+ "problem01" + File.separator 
						+ "Problem1.txt";
		ArrayList<String> strippedLines = new ArrayList<>();
		
		try {
			bReader = new BufferedReader(new FileReader(inputFilePath));
			String line = bReader.readLine();

			while (line != null) {
				String strippedLine = stripTags(line);
				
				if (strippedLine.length() > 0) {
					strippedLines.add(strippedLine);
				}

				line = bReader.readLine();
			}
			
			System.out.println(convertToString(strippedLines));
			saveResult(strippedLines, outputPath);
		} catch (IOException e) {
			System.out.println("File cannot be read");
		} finally {
			if (bReader != null) {
				bReader.close();
			}
		}
	}

	private static String stripTags(String line) {
		
		StringBuilder stringBuilder = new StringBuilder();
		boolean wasTagClosed = true;
		
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

	private static String convertToString(ArrayList<String> list) {
		return list.stream().collect(Collectors.joining(System.lineSeparator()));
	}

	private static void saveResult(ArrayList<String> strippedLines, String outputPath) {
		PrintWriter pWriter = null;
		
		try {
			pWriter = new PrintWriter(outputPath);
			String output = convertToString(strippedLines);
			if (output.length() > 0) {
				pWriter.println(output);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pWriter != null) {
				pWriter.close();
			}
		}
	}
}
