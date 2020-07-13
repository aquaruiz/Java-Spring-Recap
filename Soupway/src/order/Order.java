package order;
import java.util.ArrayList;
import java.util.List;

import menu.Soup;

public class Order {
	private List<Soup> soups;
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
	
	public void addSoup(Soup soup) {
		this.soups.add(soup); // check if already added
	}
	
	public void addBread(String bread) {
		this.bread.add(bread); // check if already added
	}
	
	public void addDrink(String drink) {
		this.drinks.add(drink); // check if already added
	}
	
	public double calcPrice() {
		double totalPrice = this.soups.size() * 5 
				+ this.bread.size() * 2 
				+ this.drinks.size() * 3;
		
		this.price = totalPrice;
		return this.price;
	}
	
	public void pay() {
		this.isPaid = true;
		// Empty table from items
	}
	
	public double getPrice() {
		return price;
	}
}
