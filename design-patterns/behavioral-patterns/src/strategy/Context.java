package strategy;

public class Context {
	private Strategy strategy;
	
	public void setStrategy(Strategy concreteStrategy) {
		this.strategy = concreteStrategy;	
	}

	public int executeStrategy(int firstNumber, int secondNumber) {
		return this.strategy.executeStrategy(firstNumber, secondNumber);
	}

}
