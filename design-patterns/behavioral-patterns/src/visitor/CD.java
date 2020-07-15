package visitor;

public class CD implements Visitable {
	private String genre;
	private double price;
	
	public CD(String genre, double price) {
		super();
		this.genre = genre;
		this.price = price;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getGenre() {
		return genre;
	}
	
	public double getPrice() {
		return price;
	}
}
