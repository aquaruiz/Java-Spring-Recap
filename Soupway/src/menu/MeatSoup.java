package menu;

import java.util.Arrays;

import constants.Price;

public class MeatSoup extends SoupDecorator implements Soupable {
	
	public MeatSoup(Soupable soup, String meat) {
		super(soup);
		super.extraIngredients = Arrays.asList(meat);
	}
	
	public double getPrice() {
		return super.soup.getPrice() + Price.MEAT_PRICE * super.extraIngredients.size();
	}
	
}
