package menu;

import java.util.Arrays;
import java.util.List;

import constants.Price;

public class MeatSoup extends SoupDecorator implements Soup {
	private double price; 
	
	public MeatSoup(Soup soup, String meat) {
		super(soup);
		super.extraIngredients = Arrays.asList(meat);
	}
	
	public MeatSoup(Soup soup, List<String> meatNames) {
		super(soup);
		this.extraIngredients.addAll(meatNames);
	}

	public double getPrice() {
		price = super.soup.getPrice() + Price.MEAT_PRICE * super.extraIngredients.size(); 
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
		
		if (other instanceof MeatSoup) {
			MeatSoup anotherSoup = (MeatSoup) other;
			
			if (anotherSoup.getPrice() != this.getPrice()) {
				return false;
			}

			if (!anotherSoup.getPrintableIngredients().equals(this.getPrintableIngredients())) {
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
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Meat Soup.")
			.append(System.lineSeparator())
			.append("Ingredients: ")
			.append(getPrintableIngredients())
			.append(System.lineSeparator())
			.append("Price: ")
			.append(getPrice());
		return stringBuilder.toString();
	}
}
