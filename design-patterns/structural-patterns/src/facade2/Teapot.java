package facade2;

public class Teapot implements TeapotFacade {

	@Override
	public Tea serveTee() {
		TeaMaker brewer = new BigTeapot();
		Tea cup = new Tea();

		brewer.placeCup(cup);
		brewer.pourWater(new Water());
		brewer.startBrewing();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		// wait for the brewing process

		return brewer.finishBrewing();
	}

}
