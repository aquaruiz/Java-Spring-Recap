package decorator;

public class SauceSandwich extends SandwichDecorator {
	private Sandwich sandwich;
	private String sauce;
	
	public SauceSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
		this.sauce = "ketchup";
	}
	
	@Override
	public String getIngredients() {
		return this.sandwich.getIngredients() + ", " + sauce;
	}

	@Override
	public int getPrice() {
		return this.sandwich.getPrice() + 1;
	}

	@Override
	public void makeWith(String sauce) {
		this.sauce = sauce;
	}

}
