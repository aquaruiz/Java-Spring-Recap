package cashService;

import orders.Order;

public interface Listener {
	public void notifyForReciept(Order order);

	public void notify(Order order);
}
