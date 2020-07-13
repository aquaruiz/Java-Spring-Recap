package menu;

import java.util.Arrays;

import constants.Price;

public class CheeseSoup extends SoupDecorator implements Soupable {
	
	public CheeseSoup(Soupable soup, String cheese) {
		super(soup);
		super.extraIngredients = Arrays.asList(cheese);
	}
	
	public double getPrice() {
		return this.soup.getPrice() + Price.CHEESE_PRICE * super.extraIngredients.size();
	}
}
