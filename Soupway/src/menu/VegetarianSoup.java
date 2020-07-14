package menu;

import java.util.Arrays;
import java.util.List;

import constants.Price;

public class VegetarianSoup implements Soup {

	private List<String> ingredients;
	private double price;

	public VegetarianSoup() {
		this.ingredients = Arrays.asList("Vegetables");
		this.price = Price.VEGERATIAN_SOUP_PRICE;
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
