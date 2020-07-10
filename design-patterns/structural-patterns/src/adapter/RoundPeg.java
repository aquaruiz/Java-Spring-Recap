package adapter;

public class RoundPeg {
	private int radius;
	
	public RoundPeg(int radius) {
		this.radius = radius;
	}
	
	protected RoundPeg() {}
	
	public int getRadius() {
		return radius;
	}
}
