package soupBar;

import exception.IllegalCloningOfSoupSellerException;
import logging.Logger;
import menu.CheeseSoup;
import menu.MeatSoup;
import menu.Soup;
import order.Order;
import order.OrderBuilder;

public class Bar implements Runnable {

	public Bar() {
		// add observer
	}
	
	@Override
	public void run() {
		SoupSeller soupSeller = callSoupSeller();
		
		if (soupSeller != null) {
			Order ordered = placeOrderTo(soupSeller);
			pay(ordered, soupSeller);
		} else {
			Logger.logThis("Come back later");
		}
	}

	private void pay(Order ordered, SoupSeller soupSeller) {
		// pay
		double price = ordered.calcPrice();
		// eat and go home
		soupSeller.cashPayment(ordered, price);
	}

	private Order placeOrderTo(SoupSeller mySeller) {
		// call waiter, or cook
		OrderBuilder myOrder = mySeller.makeOrder();
		// build soup
		Soup mySoup = new Soup();
		MeatSoup mySoupWithChicken = new MeatSoup(mySoup, "Chicken");
		
		CheeseSoup mySoupWithChickenAndCheese = new CheeseSoup(mySoupWithChicken, "Parmesan");
		
		// place order for soup, place order for bread

		myOrder.addSoup(mySoup)
//			.addSoup(mySoup)
			.addSoup(mySoupWithChicken)
			.addSoup(mySoupWithChickenAndCheese)
			.addDrink("Cola")
			.addBread("plain");
		
		// get price, send event to print recipe
		Order ordered = myOrder.buildOrder();
		return ordered;
	}

	private SoupSeller callSoupSeller() {
		try {
			return SoupSeller.getInstance();
		} catch (IllegalCloningOfSoupSellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

}
