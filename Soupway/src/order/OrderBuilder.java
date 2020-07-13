package order;
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

	public OrderBuilder addDrink(String drink) {
		this.order.addDrink(drink); // may be use Enum
		return this;		
	}
	
	public OrderBuilder addBread(String bread) {
		this.order.addBread(bread); // may be use Enum
		return this;		
	}
	
	public Order buildOrder() {
		return this.order;
	}
}
