package bar;

import cashService.CashListener;
import exceptions.IllegalCloningException;
import orders.CustomerInteractor;
import orders.Order;

public class Cashier {
	private static volatile Cashier instance;
	private CashListener cashListener;
	private CustomerInteractor customerInteractor;

	private Cashier() throws IllegalCloningException {
		this.cashListener = new CashListener();
		this.customerInteractor = CustomerInteractor.getInstance();

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
		order.calcPrice();
		this.cashListener.notifyForRecipe(order);
		
		System.out.println("Are you paying for all this? (Y/n)");
		boolean wannaPay = customerInteractor.getCustomerBoolenInput();
		
		if (wannaPay) {
			order.pay();
			System.out.println("All set.");
		}
		
		this.cashListener.notify(order);
		System.out.println("Bye!");

	}

}
