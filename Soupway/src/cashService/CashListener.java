package cashService;

import orders.Order;

public class CashListener {
	
	public CashListener() {
	}
	
	public void notifyForRecipe(Order order) {
		System.out.println(order.toString());
	}

	public void notify(Order order) {
		if (order.isPaid()) {
			System.out.println("You just paid " + order.getPrice());
		} else {
			System.out.println("Your order was been canceled");
		}
	}
}
