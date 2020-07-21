package adapter;

public class SquarePegAdapter extends RoundPeg {
	private SquarePeg peg;
	
	public SquarePegAdapter(SquarePeg peg) {
		super();
		this.peg = peg;
	}
	
	@Override
	public int getRadius() {
		return (int) (this.peg.getWidth() * Math.sqrt(2) / 2);
	}
}
