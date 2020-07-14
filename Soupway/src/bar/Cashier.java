package bar;

import exceptions.IllegalCloningException;
import orders.Order;

public class Cashier {
	private static volatile Cashier instance;

	private Cashier() throws IllegalCloningException {
		if (instance != null) {
			throw new IllegalCloningException("Cannot have two Cashiers");
		}
	}

	public static Cashier getInstance() throws IllegalCloningException {
		if (instance == null) {
			synchronized (SoupSeller.class) {
				if (instance == null)
					instance = new Cashier();
				return instance;
			}
		}

		return instance;
	}

	public void collectCustomerPayment(Order order) {
		// TODO Auto-generated method stub

	}

}
