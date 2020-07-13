package menu;

import java.util.Arrays;

import constants.Price;

public class MeatSoup extends SoupDecorator implements Soupable {
	
	public MeatSoup(Soupable soup, String meat) {
		super(soup);
		super.ingredients = Arrays.asList(soup.getIngredients(), meat);
	}
	
	public String getIngredients() {
		return String.join(", ", super.ingredients);
	}
	
	public double getPrice() {
		return super.soup.getPrice() + Price.MEAT_PRICE * super.ingredients.size();
	}
	
}
