package menu;

import java.util.Arrays;

import constants.Price;

public class MeatSoup extends SoupDecorator implements Soup {
	private double price; 
	
	public MeatSoup(Soup soup, String meat) {
		super(soup);
		super.extraIngredients = Arrays.asList(meat);
	}
	
	public double getPrice() {
		price = super.soup.getPrice() + Price.MEAT_PRICE * super.extraIngredients.size(); 
		return price;
	}
}
