package menu;

import java.util.Arrays;

import constants.Price;

public class CheeseSoup extends SoupDecorator implements Soupable {
	
	public CheeseSoup(Soupable soup, String cheese) {
		super(soup);
		super.ingredients = Arrays.asList(soup.getIngredients(), cheese);
	}
	
	public double getPrice() {
		return this.soup.getPrice() + Price.MEAT_PRICE * super.ingredients.size();
	}
}
