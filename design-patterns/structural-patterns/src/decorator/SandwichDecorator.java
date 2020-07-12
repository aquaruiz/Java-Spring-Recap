package decorator;

public abstract class SandwichDecorator implements Sandwich{
	private Sandwich sandwich;
	
	public abstract String getIngredients();

	public abstract int getPrice();

	public abstract void makeWith(String sauce);
}
