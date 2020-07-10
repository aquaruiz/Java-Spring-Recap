package adapter;

public class RoundHole {
	private int radius; 
	
	public RoundHole(int radius) {

	}
	
	public int getRadius() {
		return radius;
	}
	
	public boolean fits(RoundPeg peg) {
		return peg.getRadius() >= this.radius;
	}
}
