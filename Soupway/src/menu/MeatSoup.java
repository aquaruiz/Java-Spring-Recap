package menu;

import java.util.Arrays;

import constants.Price;
import constants.SoupType;

public class MeatSoup extends SoupDecorator implements Soupable {
	private SoupType baseType;
	private double price; 
	
	public MeatSoup(Soupable soup, String meat) {
		super(soup);
		baseType = SoupType.MEAT;
		super.extraIngredients = Arrays.asList(meat);
	}
	
	public double getPrice() {
		price = super.soup.getPrice() + Price.MEAT_PRICE * super.extraIngredients.size(); 
		return price;
	}
	
}
