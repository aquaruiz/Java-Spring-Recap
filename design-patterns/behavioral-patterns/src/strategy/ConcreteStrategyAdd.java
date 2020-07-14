package strategy;

public class ConcreteStrategyAdd implements Strategy {

	@Override
	public int executeStrategy(int a, int b) {
		return a + b;
	}

}
