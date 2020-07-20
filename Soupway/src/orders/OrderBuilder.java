package orders;

import java.util.List;

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
		if (soup != null) {
			this.order.addSoup(soup);
		}
		
		return this;
	}

	public OrderBuilder addDrink(Enum<Drinks> drink) {
		if (drink != null) {
			this.order.addDrink(drink);
		}

		return this;
	}

	public OrderBuilder addBread(Enum<Bread> bread) {
		if (bread != null) {
			this.order.addBread(bread);
		}

		return this;
	}

	public OrderBuilder addIcrecream(Enum<IceCream> icecream) {
		if (icecream != null) {
			this.order.addIcecream(icecream);
		}

		return this;
	}

	public Order build() {
		return this.order;
	}

	@SuppressWarnings("unchecked")
	public void makeOrder(Soup orderedSoup, List<Enum> breadAndIcecream) {
		this.addSoup(orderedSoup)
			.addBread((Enum<Bread>) breadAndIcecream.get(0))
			.addIcrecream((Enum<IceCream>) breadAndIcecream.get(1));
	}
}
