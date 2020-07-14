package strategy;

public class ConcreteStrategyMultiply implements Strategy {

	@Override
	public int executeStrategy(int a, int b) {
		return a * b;
	}

}
