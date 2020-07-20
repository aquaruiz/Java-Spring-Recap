package bar;

import cashService.CashListener;
import cashService.Listener;
import exceptions.IllegalCloningException;
import exceptions.NoFreeSoupSellersException;
import orders.Order;
import orders.OrderBuilder;

public class Bar {
	private SoupSeller soupSeller;
	private Cashier cashier;

	public Bar() throws NoFreeSoupSellersException, IllegalCloningException {
		this.soupSeller = this.getNextFreeSoupSeller();
		this.cashier = Cashier.getInstance();
		Listener casheListener = new CashListener();
		cashier.registerListener(casheListener);
	}

	private SoupSeller getNextFreeSoupSeller() {
		SoupSellersPool soupSellersPool = SoupSellersPool.getInstance();
		return soupSellersPool.getFirstFreeSoupSeller();
	}

	public void open() {
		Order order = soupSeller.processCustomerOrder();
		order.calcPrice();
		cashier.collectCustomerPayment(order);
	}
}
