package bar;

import java.util.ArrayList;
import java.util.List;

import cashService.CashListener;
import cashService.Listener;
import exceptions.IllegalCloningException;
import orders.CustomerInteractor;
import orders.Order;

public class Cashier {
	private static volatile Cashier instance;
	private List<Listener> listeners;
	private CustomerInteractor customerInteractor;

	private Cashier() throws IllegalCloningException {
		this.listeners = new ArrayList<>();
		this.customerInteractor = CustomerInteractor.getInstance();
	}

	public static Cashier getInstance() throws IllegalCloningException {
		if (instance == null) {
			synchronized (SoupSeller.class) {
				if (instance == null)
					instance = new Cashier();
			}
		}

		return instance;
	}

	public void registerListener(Listener listener) {
		this.listeners.add(listener);
	}
	
	public void collectCustomerPayment(Order order) {
		order.calcPrice();
		
		for (Listener listener : listeners) {
			listener.notifyForReciept(order);
		}
		
		System.out.println("Are you paying for all this? (Y/n)");
		boolean wannaPay = customerInteractor.getCustomerBoolenInput();
		
		if (wannaPay) {
			order.pay();
			System.out.println("All set.");
		}
		

		for (Listener listener : listeners) {
			listener.notify();
		}
		
		System.out.println("Bye!");
	}

}
