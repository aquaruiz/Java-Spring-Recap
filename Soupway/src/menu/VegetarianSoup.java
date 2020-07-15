package menu;

import java.util.Arrays;
import java.util.List;

import constants.Price;

public class VegetarianSoup implements Soup {

	private List<String> ingredients;
	private double price;

	public VegetarianSoup() {
		this.ingredients = Arrays.asList("vegetables");
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
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Vegeratian Soup.")
			.append(System.lineSeparator())
			.append("Ingredients: ")
			.append("vegetables")
			.append(System.lineSeparator())
			.append("Price: ")
			.append(getPrice());
		return stringBuilder.toString();
	}
}
