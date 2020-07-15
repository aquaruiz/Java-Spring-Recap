package templateMethod;

public class WebOrder extends OrderTemplate {

	@Override
	public void checkout() {
		System.out.println("Get items from cart,");
		System.out.println("Set gift preferences,");
		System.out.println("Set delivery address,");
		System.out.println("Set billing address.");		
	}

	@Override
	public void pay() {
		System.out.println("Process payment without Card present");		
	}

	public void printReceipt() {
		System.out.println("Email receipt");		
	}

	@Override
	public void deliver() {
		System.out.println("Ship the item to address");		
	}
}
