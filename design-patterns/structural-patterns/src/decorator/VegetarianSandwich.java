package decorator;

public class VegetarianSandwich implements Sandwich {
	private String ingredients;
	private int price; 
	
	public VegetarianSandwich() {
		this.ingredients = "bread, vegetables";
		this.price = 5;
	}

	@Override
	public String getIngredients() {
		return this.ingredients;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}
