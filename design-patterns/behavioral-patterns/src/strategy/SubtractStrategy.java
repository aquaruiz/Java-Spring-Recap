package strategy;

public class SubtractStrategy implements MathStrategy {

	@Override
	public int execute(int a, int b) {
		return a - b;
	}

}
