package facade2;

public class Teepot implements TeePotFacade {

	@Override
	public Tee serveTee() {
		TeeMaker brewer = new BigTeepot();
		Tee cup = new Tee();

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
