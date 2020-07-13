package soupBar;
import exception.IllegalCloningOfSoupSellerException;
import order.Order;
import order.OrderBuilder;

public class SoupSeller {
	private static volatile SoupSeller instance;
	
	private SoupSeller() throws IllegalCloningOfSoupSellerException {
		if (instance != null) {
			throw new IllegalCloningOfSoupSellerException("Cannot have the Soup Seller for you only");
		}
	}

	public static SoupSeller getInstance() throws IllegalCloningOfSoupSellerException {
		if (instance == null) {
			synchronized (SoupSeller.class) {
				if (instance == null)
					instance = new SoupSeller();
				return instance;
			}
		}

		return instance;
	}

	public OrderBuilder makeOrder() {
		return new OrderBuilder();
	}

	public String cashPayment(Order ordered, double price) {
		if (Math.abs(ordered.getPrice() - price) <= 0.000001) {
			ordered.pay();
			return "All set";
		}

		return "You won't eat here";
	}
}
