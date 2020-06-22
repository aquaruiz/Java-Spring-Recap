package exam1.problem02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	private static final String INPUT_FILE_PATH = "src" + File.separator 
			+ "exam1" + File.separator
			+ "problem02" + File.separator 
			+ "Problem2.in";
	
	private static final String RESULT_FILE_PATH = "src" + File.separator 
			+ "exam1" + File.separator
			+ "problem02" + File.separator 
			+ "Problem2.out";
	
	private static final String BLOCK_LETTER = "x";
	private static final String WALK_LETTER = "0";
	private static final String START_POINT_LETTER = "*";
	
	public static void main(String[] args) throws IOException {
		String[][] matrix = null;
		try {
			matrix = readMatrix(matrix, INPUT_FILE_PATH);
		} catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
			saveOutputResult(-1, RESULT_FILE_PATH);
			return;
		}

		int steps = countStepsToExit(matrix);
		saveOutputResult(steps, RESULT_FILE_PATH);
	}

	private static String[][] readMatrix(String[][] matrix, String inputFilePath) throws IOException, NumberFormatException, ArrayIndexOutOfBoundsException {
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(inputFilePath));
			String line = bReader.readLine();
			matrix = new String[Integer.parseInt(line)][];

			int index = 0;
			line = bReader.readLine();
			while (line != null) {
				matrix[index++] = line.split("");
				line = bReader.readLine();
			}
		} catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw e;
		} finally {
			if (bReader != null) {
				bReader.close();
			}
		}

		return matrix;
	}

	private static int countStepsToExit(String[][] matrix) {
		int[] startPoint = findStart(matrix);
		
		if (startPoint[0] == -1 || startPoint[1] == -1) {
			return -1;
		}
		
		LinkedList<String> visitedPoints = new LinkedList<>();
		checkPoint(startPoint[0], startPoint[1], visitedPoints, matrix, 0);
		
		while (!visitedPoints.isEmpty()) {
			int[] entry = Arrays.stream(visitedPoints.remove().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int pointX = entry[0];
			int pointY = entry[1];
			int steps = entry[2];
			steps++;
			if (pointX == 0 || pointX == matrix.length-1
				|| pointY == 0 || pointY == matrix.length-1) {
				return steps;
			}
			
			checkPoint(pointX+1, pointY, visitedPoints, matrix, steps);
			checkPoint(pointX-1, pointY, visitedPoints, matrix, steps);
			checkPoint(pointX, pointY+1, visitedPoints, matrix, steps);
			checkPoint(pointX, pointY-1, visitedPoints, matrix, steps);
		}
		
		int minSteps = 0;
		return minSteps;
	}

	private static void checkPoint(int pointX, int pointY, LinkedList<String> visitedPoints, String[][] matrix, int steps) {
		if (!matrix[pointX][pointY].equals(BLOCK_LETTER)) {
			visitedPoints.add(String.format("%s %s %S", pointX, pointY, steps));
		}
	}

	private static int[] findStart(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j].equals(START_POINT_LETTER)) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {-1, -1};
	}

	private static void saveOutputResult(int output, String filePath) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(RESULT_FILE_PATH);
			printWriter.println(output);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
