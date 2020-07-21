package templateMethod;

public abstract class OrderTemplate {
	
	public boolean isGift;

	public abstract void checkout();

	public abstract void pay();

	public abstract void printReceipt();

	public abstract void deliver();

	public final void wrapGift() {
		System.out.println("Gift wrapped.");
	}

	public final void processOrder() {
		checkout();
	
		pay();

    if (isGift) {
			wrapGift();
		} else {
			printReceipt();
		}

		deliver();
	}
}
