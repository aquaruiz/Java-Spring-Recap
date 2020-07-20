package bar;

import java.util.Objects;

import constants.Bread;
import constants.IceCream;
import cookFactory.AbstractCookFactory;
import cookFactory.CookFactoryManager;
import menu.Soup;
import orders.CustomerInteractor;
import orders.Order;
import orders.OrderBuilder;

public class SoupSeller {
	private String name;
	private CustomerInteractor customerInteractor;

	public SoupSeller(String name) {
		this.name = name;
		this.customerInteractor = CustomerInteractor.getInstance();
	}

	public Order processCustomerOrder() {
		System.out.println(String.format("Hello, My name is %s. Are you vegetarian? (Y/n)", name));

		boolean isVegetarian = customerInteractor.getCustomerBoolenInput();

		AbstractCookFactory abstractFactory = CookFactoryManager.getFactory(isVegetarian);

		OrderBuilder orderBuilder = placeOrder(abstractFactory);

		return orderBuilder.build();
	}

	private OrderBuilder placeOrder(AbstractCookFactory abstractFactory) {
		OrderBuilder orderBuilder = new OrderBuilder();
		
		System.out.println("I am preparing your soup...");
		Soup orderedSoup = abstractFactory.cookSoup();

		System.out.println("Do you want bread? (Y/n)");
		Enum<Bread> orderedBread = null;
		boolean wannaBread = customerInteractor.getCustomerBoolenInput();
		if (wannaBread) {
			orderedBread = abstractFactory.serveBread();
		}

		System.out.println("Do you want icecream? (Y/n)");
		Enum<IceCream> orderedIcecream = null;
		boolean wannaIcecream = customerInteractor.getCustomerBoolenInput();
		if (wannaIcecream) {
			orderedIcecream = abstractFactory.serveIcecream();
		}

		orderBuilder
			.addSoup(orderedSoup)
			.addBread(orderedBread)
			.addIcrecream(orderedIcecream);

		System.out.println("Do you want to order another soupSet?");

		boolean wannaOrderMore = customerInteractor.getCustomerBoolenInput();

		if (wannaOrderMore) {
			placeOrder(abstractFactory);
		}
		
		return orderBuilder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SoupSeller)) {
			return false;
		}
		
		SoupSeller other = (SoupSeller) obj;
		return Objects.equals(name, other.name);
	}
	
}
