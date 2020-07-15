package orders;

import constants.Bread;
import constants.Drinks;
import constants.IceCream;
import menu.Soup;

public class OrderBuilder {
	private Order order;
	
	public OrderBuilder() {
		this.order = new Order();
	}

	public OrderBuilder addSoup(Soup soup) {
		this.order.addSoup(soup);
		return this;
	}

	public OrderBuilder addDrink(Enum<Drinks> drink) {
		this.order.addDrink(drink); 
		return this;		
	}
	
	public OrderBuilder addBread(Enum<Bread> bread) {
		this.order.addBread(bread); 
		return this;		
	}

	public OrderBuilder addIcrecream(Enum<IceCream> icecream) {
		this.order.addIcecream(icecream); 
		return this;		
	}
	public Order build() {
		return this.order;
	}
}
