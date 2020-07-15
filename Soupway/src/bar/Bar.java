package bar;

import cashService.CashListener;
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
