package orders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import constants.Bread;
import constants.Drinks;
import constants.IceCream;
import constants.Price;
import menu.Soup;

public class Order {
	private Map<Soup, Integer> soups;
	private Map<Enum<Bread>, Integer> bread;
	private Map<Enum<Drinks>, Integer> drinks;
	private Map<Enum<IceCream>, Integer> icecreams;
	
	private double price;
	private boolean isPaid;
	
	public Order() {
		this.soups = new HashMap<>();
		this.bread = new HashMap<>();
		this.drinks = new HashMap<>();
		this.icecreams = new HashMap<>();
		this.price = 0;
		this.isPaid = false;
	}
	
	public void addSoup(Soup soup) {
		this.soups.putIfAbsent(soup, 0); 
		this.soups.put(soup, this.	soups.get(soup)+1);
	}
	
	public void addBread(Enum<Bread> bread) {
		this.bread.putIfAbsent(bread, 0);
		this.bread.put(bread, this.bread.get(bread)+1);
	}
	
	public void addDrink(Enum<Drinks> drink) {
		this.drinks.putIfAbsent(drink, 0);
		this.drinks.put(drink, this.drinks.get(drink)+1);
	}
	
	public void addIcecream(Enum<IceCream> icecream) {
		this.icecreams.putIfAbsent(icecream, 0); 
		this.icecreams.put(icecream, this.icecreams.get(icecream)+1);
	}
	
	public void calcPrice() {
		double totalPrice = 0;
		// calc soups price
		for (Entry<Soup, Integer> soupSet : this.soups.entrySet()) {
			double currentPrice = soupSet.getKey().getPrice();
			totalPrice += currentPrice * soupSet.getValue();
		}
		
		totalPrice += this.bread.size() * Price.BREAD_PRICE
				+ this.drinks.size() * Price.DRINK_PRICE;
		
		this.price = totalPrice;
	}
	
	public void pay() {
		this.isPaid = true;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isPaid() {
		return isPaid;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Your order:")
			.append(System.lineSeparator())
			.append("Soups: ")
			.append(getAllItems(soups.values()))
			.append(" soups");
		
		if (soups.size() > 0) {
			stringBuilder.append(System.lineSeparator());
			
			for (Entry<Soup, Integer> soupSet : soups.entrySet()) {
				stringBuilder
					.append("=====")
					.append(soupSet.getKey().getIngredients())
					.append(" - ")
					.append(soupSet.getValue()).append(" soups")
					.append(System.lineSeparator());
			}
		}
			
		stringBuilder
			.append("Bread: ")
			.append(getAllItems(bread.values()))
			.append(" breads");
			
		if (bread.size() > 0) {
			stringBuilder.append(" === ");
			for (Enum<Bread> bread: bread.keySet()) {
				stringBuilder.append(bread.toString().toLowerCase())
					.append(", ");
			}
		}
		
		stringBuilder
			.append(System.lineSeparator())
			.append("Icecreams: ")
			.append(getAllItems(icecreams.values()))
			.append(" icecreams");
		
		if (icecreams.size() > 0) {
			stringBuilder.append(" === ");
			for (Enum<IceCream> icecream : icecreams.keySet()) {
				stringBuilder.append(icecream.toString().toLowerCase())
					.append(", ");
			}
		}
	
		stringBuilder.append(System.lineSeparator())
			.append("Total Price: ")
			.append(getPrice());
		
		return stringBuilder.toString();
	}

	private int getAllItems (Collection<Integer> mapValueSet) {
		return mapValueSet.stream().mapToInt(Number::intValue).sum();
	}
}
