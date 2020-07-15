package facade2;

public class BigTeepot implements TeeMaker {

	@Override
	public void pourWater(Water water) {
		System.out.println("Pouring water...");		
	}

	@Override
	public void placeCup(Tee cup) {
		System.out.println("Placing tee bag...");		
	}

	@Override
	public void startBrewing() {
		System.out.println("Brewing...");		
	}

	@Override
	public Tee finishBrewing() {
		System.out.println("Done brewing. Enjoy!");
		return new Tee();
	}

}
