import entity.Calculator;

public class Main {
	public static void main(String[] args) {
		Calculator calc= new Calculator(1.0, 0.0, "/");
		System.out.println(calc.calculateResult());
//		System.out.println(5/0);
	}
}
