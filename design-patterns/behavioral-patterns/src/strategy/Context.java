package strategy;

public class Context {
	private MathStrategy strategy;
	
	public void setStrategy(MathStrategy concreteStrategy) {
		this.strategy = concreteStrategy;	
	}

	public int executeStrategy(int firstNumber, int secondNumber) {
		return this.strategy.execute(firstNumber, secondNumber);
	}

}
