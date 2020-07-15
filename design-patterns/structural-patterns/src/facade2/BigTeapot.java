package facade2;

public class BigTeapot implements TeaMaker {

	@Override
	public void pourWater(Water water) {
		System.out.println("Pouring water...");		
	}

	@Override
	public void placeCup(Tea cup) {
		System.out.println("Placing tea bag...");		
	}

	@Override
	public void startBrewing() {
		System.out.println("Brewing...");		
	}

	@Override
	public Tea finishBrewing() {
		System.out.println("Done brewing. Enjoy!");
		return new Tea();
	}

}
