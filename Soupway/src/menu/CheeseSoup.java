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
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this == other) {
			return true;
		}
		
		if (other instanceof CheeseSoup) {
			CheeseSoup anotherSoup = (CheeseSoup) other;
			
			if (anotherSoup.getPrice() != this.getPrice()) {
				return false;
			}

			if (!anotherSoup.getPrintableIngredients().equals(this.getPrintableIngredients().toString())) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return 33 + (int)this.getPrice() + this.getPrintableIngredients().hashCode();
	}
}
