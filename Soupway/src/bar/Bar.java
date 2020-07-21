package bar;

import cashService.CashListener;
import cashService.Listener;
import orders.Order;

public class Bar {
	private SoupSeller soupSeller;
	private Cashier cashier;

	public Bar() {
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
