package exam3.problem01;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		generateMartix(n);
		printMatrix();
	}

	private static void printMatrix() {
		// TODO Auto-generated method stub
		
	}

	private static void generateMartix(int size) {
		matrix = new int[size][size];
		int x = size / 2;
		int y = size / 2;
		boolean layerChanged = false; 
		boolean directionChanged = true; 
		int maxSteps = 1;
		
		Queue<String> directions = new ArrayDeque<>();
		directions.add("D");
		directions.add("L");
		directions.add("U");
		directions.add("R");
		
		int total = (int) (Math.pow(size, 2) - 1);
		int counter = 0;
		
		while (counter <= total) {
			matrix[x][y] = counter++;
			
			String currentDirection;
			
			if (layerChanged) {
				currentDirection = directions.poll();
				directions.offer(currentDirection);
				directionChanged = true;
				if (currentDirection.equals("D")) {
					maxSteps++;
				}
			} else {
				directionChanged = false;
				currentDirection = directions.peek();
			}
			
			switch (currentDirection) {
				case "D":
					x++;
					break;
				case "L":
					y--;
					break;
				case "U":
					x--;
					break;
				case "R":
					y++;
					break;
			}
		}
	}

}
