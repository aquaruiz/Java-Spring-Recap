package exam1.problem02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

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
		try (BufferedReader bReader = new BufferedReader(new FileReader(inputFilePath));){
			String line = bReader.readLine();
			matrix = new String[Integer.parseInt(line)][];

			int index = 0;
			line = bReader.readLine();
			while (line != null) {
				matrix[index++] = line.split("");
				line = bReader.readLine();
			}
		} 

		return matrix;
	}

	private static int countStepsToExit(String[][] matrix) {
		Point startPoint = findStart(matrix);
		
		if (startPoint.row == -1 || startPoint.col == -1) {
			return -1;
		}
		
		Queue<Point> visitedPoints = new LinkedList<Point>();
		checkPoint(startPoint.row, startPoint.col, visitedPoints, matrix, 0);
		
		while (!visitedPoints.isEmpty()) {
			Point currentPoint = visitedPoints.remove();
			int pointX = currentPoint.row;
			int pointY = currentPoint.col;
			int steps = currentPoint.steps;

			if (pointX == 0 || pointX == matrix.length-1
				|| pointY == 0 || pointY == matrix.length-1) {
				return steps+1;
			}
			
			checkPoint(pointX+1, pointY, visitedPoints, matrix, steps+1);
			checkPoint(pointX-1, pointY, visitedPoints, matrix, steps+1);
			checkPoint(pointX, pointY+1, visitedPoints, matrix, steps+1);
			checkPoint(pointX, pointY-1, visitedPoints, matrix, steps+1);
		}
		
		return -1;
	}

	private static void checkPoint(int pointX, int pointY, Queue<Point> visitedPoints, String[][] matrix, int steps) {
		if (!matrix[pointX][pointY].equals(BLOCK_LETTER)) {
			matrix[pointX][pointY] = BLOCK_LETTER;
			Point point = new Point(pointX, pointY, steps);
			visitedPoints.add(point);
		}
	}

	private static Point findStart(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j].equals(START_POINT_LETTER)) {
					return new Point(i, j, 0);
				}
			}
		}
		
		return new Point(-1, -1, 0);
	}

	private static void saveOutputResult(int output, String filePath) {
		try (PrintWriter printWriter = new PrintWriter(RESULT_FILE_PATH);) {
			printWriter.println(output);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
	
