package strategy;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Context context = new Context();

		Scanner scanner = new Scanner(System.in);
		int firstNumber = Integer.parseInt(scanner.nextLine());
		int secondNumber = Integer.parseInt(scanner.nextLine());

		String operation = scanner.nextLine();

		switch (operation) {
			case "+":
				context.setStrategy(new AddStrategy());
				break;
			case "-":
				context.setStrategy(new SubtractStrategy());
	
				break;
			case "*":
				context.setStrategy(new MultiplyStrategy());
	
				break;
	
			default:
				break;
		}

		int result = context.executeStrategy(firstNumber, secondNumber);

		System.out.println(result);
	}
}
