package facade2;

public interface TeeMaker {
	
	public void pourWater(Water water);

	public void placeCup(Tee cup);

	public void startBrewing();

	public Tee finishBrewing();
}
