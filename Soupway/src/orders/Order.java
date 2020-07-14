package orders;

import java.util.ArrayList;
import java.util.List;

import constants.Bread;
import constants.Drinks;
import constants.IceCream;
import constants.Price;
import menu.Soup;

public class Order {
	private List<Soup> soups;
	private List<Enum<Bread>> bread;
	private List<Enum<Drinks>> drinks;
	private List<Enum<IceCream>> icecreams;
	
	private double price;
	private boolean isPaid;
	
	public Order() {
		this.soups = new ArrayList<>();
		this.bread = new ArrayList<>();
		this.drinks = new ArrayList<>();
		this.icecreams = new ArrayList<>();
		this.price = 0;
		this.isPaid = false;
	}
	
	public void addSoup(Soup soup) {
		this.soups.add(soup); 
	}
	
	public void addBread(Enum<Bread> bread) {
		this.bread.add(bread); // check if already added
	}
	
	public void addDrink(Enum<Drinks> drink) {
		this.drinks.add(drink); // check if already added
	}
	
	public void addIcecream(Enum<IceCream> icecream) {
		this.icecreams.add(icecream); // check if already added
	}
	
	public double calcPrice() {
		double totalPrice = 0;
		// calc soups price
		for (Soup soup : this.soups) {
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
