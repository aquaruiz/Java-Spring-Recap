package adapter;

public class Application {
	public static void main(String[] args) {
		RoundHole hole = new RoundHole(5);
		RoundPeg roundPeg = new RoundPeg(5);
		System.out.println(hole.fits(roundPeg));
		
		SquarePeg squarePeg = new SquarePeg(5);
		hole.fits(new SquarePegAdapter(squarePeg));
		
	}
}
