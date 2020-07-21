package adapter;

public class SquareHole {
	public int width;
	
	public SquareHole(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean fits(SquarePeg peg) {
		return peg.getWidth() >= this.width;
	}
}
