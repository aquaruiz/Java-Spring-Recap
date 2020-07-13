package menu;

import java.util.Arrays;

import constants.Price;
import constants.SoupType;

public class CheeseSoup extends SoupDecorator implements Soupable {
	private SoupType baseType;
	private double price;
	
	public CheeseSoup(Soupable soup, String cheese) {
		super(soup);
		baseType = SoupType.CHEESE;
		super.extraIngredients = Arrays.asList(cheese);
	}
	
	public double getPrice() {
		price = this.soup.getPrice() + Price.CHEESE_PRICE * super.extraIngredients.size(); 
		return price;
	}
}
