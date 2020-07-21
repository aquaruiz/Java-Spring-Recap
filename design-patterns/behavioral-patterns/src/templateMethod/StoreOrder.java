package templateMethod;

public class StoreOrder extends OrderTemplate {

	@Override
	public void checkout() {
		System.out.println("Ring up items from cart.");
	}

	@Override
	public void pay() {
		System.out.println("Process payment with Card present");
	}

	public void printReceipt() {
		System.out.println("Print receipt");
	}

	public void deliver() {
		System.out.println("Bag items at counter");
	}
}
