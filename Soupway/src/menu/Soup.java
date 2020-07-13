package menu;

import constants.SoupType;

public class Soup implements Soupable {

	private SoupType baseType;
	private String ingredients;
	private double price;

	public Soup() {
		this.baseType = SoupType.VEGETARIAN;
		this.ingredients = "Vegetables";
		this.price = 5;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getIngredients() {
		return this.ingredients;
	}

}
