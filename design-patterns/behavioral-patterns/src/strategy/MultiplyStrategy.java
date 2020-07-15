package strategy;

public class MultiplyStrategy implements MathStrategy {

	@Override
	public int execute(int a, int b) {
		return a * b;
	}

}
