package soupBar;

import exception.IllegalCloningOfSoupSellerException;
import menu.Soup;
import order.Order;
import order.OrderBuilder;

public class Bar implements Runnable {

	private SoupSeller mySeller = null;

	public Bar() {}
	
	@Override
	public void run() {
		callSoupSeller();
		
		Order ordered = placeOrder();
		
		pay(ordered);
	}

	private void pay(Order ordered) {
		// pay
		double price = ordered.calcPrice();
		// eat and go home
		mySeller.payBill(ordered, price);
		
		System.out.println();			
	}

	private Order placeOrder() {
		// call waiter, or cook
		OrderBuilder myOrder = mySeller.makeOrder();
		// build soup
		Soup mySoup = new Soup();
		myOrder.addSoup(mySoup)
			.addSoup(mySoup);
		
		myOrder.addDrink("Cola");
		// choose bread
		myOrder.addBread("plain");
		
		// place order for soup, place order for bread
		// get price, send event to print recipe
		Order ordered = myOrder.buildOrder();
		return ordered;
	}

	private void callSoupSeller() {
		SoupSeller mySeller = null;
		try {
			mySeller = SoupSeller.getInstance();
		} catch (IllegalCloningOfSoupSellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
