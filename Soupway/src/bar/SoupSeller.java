package bar;

import java.util.ArrayList;
import java.util.List;
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

		OrderBuilder orderBuilder = new OrderBuilder();

		orderBuilder = placeOrder(abstractFactory, orderBuilder);

		return orderBuilder.build();
	}

	private OrderBuilder placeOrder(AbstractCookFactory abstractFactory, OrderBuilder orderBuilder) {
		
		System.out.println("I am preparing your soup...");
		Soup orderedSoup = abstractFactory.cookSoup();

		List<Enum> breadAndIcecream = new ArrayList<>();
		
		System.out.println("Do you want bread? (Y/n)");
		boolean wantBread = customerInteractor.getCustomerBoolenInput();
		if (wantBread) {
			breadAndIcecream.add(abstractFactory.serveBread());
		}
		
		System.out.println("Do you want icecream? (Y/n)");
		boolean wantIcecream = customerInteractor.getCustomerBoolenInput();
		if (wantIcecream) {
			breadAndIcecream.add(abstractFactory.serveIcecream());
		}

		orderBuilder.makeOrder(orderedSoup, breadAndIcecream);

		System.out.println("Do you want to order another soupSet?");
		boolean wannaOrderMore = customerInteractor.getCustomerBoolenInput();

		if (wannaOrderMore) {
			placeOrder(abstractFactory, orderBuilder);
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
