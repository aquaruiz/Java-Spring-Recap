package menu;

import java.util.Arrays;

import constants.Price;

public class CheeseSoup extends SoupDecorator implements Soup {
	private double price;
	
	public CheeseSoup(Soup soup, String cheese) {
		super(soup);
		super.extraIngredients = Arrays.asList(cheese);
	}
	
	public double getPrice() {
		price = this.soup.getPrice() + Price.CHEESE_PRICE * super.extraIngredients.size(); 
		return price;
	}
}
