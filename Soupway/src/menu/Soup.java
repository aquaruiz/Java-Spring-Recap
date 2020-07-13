package menu;

import java.util.Arrays;
import java.util.List;

import constants.SoupType;

public class Soup implements Soupable {

	private SoupType baseType;
	private List<String> ingredients;
	private double price;

	public Soup() {
		this.baseType = SoupType.VEGETARIAN;
		this.ingredients = Arrays.asList("Vegetables");
		this.price = 5;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public List<String> getIngredients() {
		return this.ingredients;
	}

}
