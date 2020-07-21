package decorator;

public class SauceSandwich implements Sandwich {
	private Sandwich sandwich;
	private Sauce sauce;
	
	public SauceSandwich(Sandwich sandwich, Sauce sauce) {
		this.sandwich = sandwich;
		this.sauce = sauce;
	}
	
	@Override
	public String getIngredients() {
		return this.sandwich.getIngredients() + ", " + sauce.name().toLowerCase();
	}

	@Override
	public int getPrice() {
		return this.sandwich.getPrice() + 1;
	}
}
