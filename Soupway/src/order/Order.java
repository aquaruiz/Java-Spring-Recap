package order;
import java.util.ArrayList;
import java.util.List;

import constants.Price;
import menu.Soup;
import menu.Soupable;

public class Order {
	private List<Soupable> soups;
	private List<String> bread;
	private List<String> drinks;
	// or may be Maps
	
	private double price;
	private boolean isPaid;
	
	public Order() {
		this.soups = new ArrayList<>();
		this.bread = new ArrayList<>();
		this.drinks = new ArrayList<>();
		this.price = 0;
		this.isPaid = false;
	}
	
	public void addSoup(Soupable soup) {
		this.soups.add(soup); // check if already added
	}
	
	public void addBread(String bread) {
		this.bread.add(bread); // check if already added
	}
	
	public void addDrink(String drink) {
		this.drinks.add(drink); // check if already added
	}
	
	public double calcPrice() {
		double totalPrice = 0;
		// calc soups price
		for (Soupable soup : this.soups) {
			double currentPrice = soup.getPrice();
			totalPrice += currentPrice;
		}
		
		totalPrice += this.bread.size() * Price.BREAD_PRICE
				+ this.drinks.size() * Price.DRINK_PRICE;
		
		this.price = totalPrice;
		return this.price;
	}
	
	public void pay() {
		this.isPaid = true;
		// Empty table from items
		// notify observer
	}
	
	public double getPrice() {
		return price;
	}
}
