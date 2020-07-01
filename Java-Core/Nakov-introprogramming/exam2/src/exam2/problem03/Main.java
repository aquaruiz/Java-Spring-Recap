package exam2.problem03;

import java.awt.image.RescaleOp;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Deque<Integer> numbersStack = new ArrayDeque<>();
	private static Deque<String> operations = new ArrayDeque<>();
	private static final List<String> ALLOWED_OPERATIONS = Arrays.asList("+", "-");
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = scanner.nextLine().split("");
		scanner.close();
		
		extractNumbersAndOperations(inputs);

		int result = calcExpression();
		System.out.println(result);
	}

	private static int calcExpression() {
		while (numbersStack.size() > 1) {
			int firstNum = numbersStack.pop();
			int seconNum = numbersStack.pop();
			String operation = operations.pop();
			int result = 0;
			
			switch (operation) {
			case "+":
				result = firstNum + seconNum;
				break;
			case "-":
				result = firstNum - seconNum;
				break;
			}
			
			numbersStack.push(result);
		}
		
		return numbersStack.pop();
	}

	private static void extractNumbersAndOperations(String[] inputs) {
		String num = "";
		for (int i = 0; i < inputs.length; i++) {
			String currentPosition = inputs[i];
			if (ALLOWED_OPERATIONS.contains(currentPosition)) {
				operations.add(currentPosition);
				numbersStack.add(Integer.parseInt(num));
				num = "";
			} else {
				num += currentPosition;
			}
		}
		
		if(!num.equals("")) {
			numbersStack.add(Integer.parseInt(num));
		}
	}
}
