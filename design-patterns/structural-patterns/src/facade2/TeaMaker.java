package facade2;

public interface TeaMaker {
	
	public void pourWater(Water water);

	public void placeCup(Tea cup);

	public void startBrewing();

	public Tea finishBrewing();
}
