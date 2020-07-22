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
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this == other) {
			return true;
		}
		
		if (other instanceof VegetarianSoup) {
			VegetarianSoup anotherSoup = (VegetarianSoup) other;
			
			if (anotherSoup.getPrice() != this.getPrice()) {
				return false;
			}

			if (!anotherSoup.getIngredients().toString().equals(this.getIngredients().toString())) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return 33 + (int)this.getPrice() + this.getIngredients().toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Vegeratian Soup.").append(System.lineSeparator()).append("Ingredients: ")
				.append("vegetables").append(System.lineSeparator()).append("Price: ").append(getPrice());
		return stringBuilder.toString();
	}
}
