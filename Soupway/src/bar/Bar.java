package bar;

import cashService.CashListener;
import cashService.Listener;
import exceptions.IllegalCloningException;
import exceptions.NoFreeSoupSellersException;
import orders.Order;
import orders.OrderBuilder;

public class Bar implements Runnable {
	private SoupSeller soupSeller;
	private Cashier cashier;

	public Bar() throws NoFreeSoupSellersException, IllegalCloningException {
		this.soupSeller = this.getNextFreeSoupSeller();
		this.cashier = Cashier.getInstance();
		Listener casheListener = new CashListener();
		cashier.registerListener(casheListener);
	}

	private SoupSeller getNextFreeSoupSeller() throws NoFreeSoupSellersException {
		SoupSellersPool soupSellersPool = SoupSellersPool.getInstance();
		return soupSellersPool.getFirstFreeSoupSeller();
	}

	public void run() {
		OrderBuilder orderBuilder = new OrderBuilder();
		Order order = soupSeller.processCustomerOrder(orderBuilder);

		cashier.collectCustomerPayment(order);
	}

}
