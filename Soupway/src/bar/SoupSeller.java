package bar;

import cashService.RecipeListener;
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

	public Order processCustomerOrder(OrderBuilder orderBuilder) {
		System.out.println(String.format("Hello, My name is %s. Are you vegetarian? (Y/n)", name));
		
		boolean isVegetarian = customerInteractor.getCustomerBoolenInput();
		
		AbstractCookFactory abstractFactory = CookFactoryManager.getFactory(isVegetarian);

		Soup orderedSoup = abstractFactory.cookSoup();
		Enum<Bread> orderedBread = abstractFactory.bakeBread();
		Enum<IceCream> orderedIcecream = abstractFactory.makeIcecream();
		
		orderBuilder.addSoup(orderedSoup)
			.addBread(orderedBread)
			.addIcrecream(orderedIcecream);
		
		return orderBuilder.build();
	}
}
