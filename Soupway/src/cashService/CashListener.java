package cashService;

import orders.Order;

public class CashListener implements Listener {
	
	public CashListener() {
	}
	
	public void notifyForReciept(Order order) {
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
